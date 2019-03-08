package com.sqc.controller;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sqc.bean.Shortage;
import com.sqc.bean.Temp;
import com.sqc.dao.TempMapper;
import com.sqc.service.ExcelService;
import com.sqc.utils.Msg;




@Controller
@RequestMapping("/uploadExcel")
public class UploadExcelFileController {
	
	@Autowired
	SqlSession sqlSession;
	
	@Resource
	ExcelService excelService;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {    

		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	     dateFormat.setLenient(false);  
	     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));      

 

    }   
	
	
	@RequestMapping(value="/handleExcelFile",method=RequestMethod.POST)
	public void handleExcelFile(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("file") MultipartFile file) throws IOException
	{
		//上传的文件
		      
				String filename = file.getOriginalFilename();
				System.out.println("filename="+filename);
				System.out.println(file.getName());
				InputStream in = file.getInputStream();
				
				String path = request.getServletContext().getRealPath("/WEB-INF/uploadDir");
				System.out.println(path);
				File dirPath = new File(path);
				if(!dirPath.exists()){
					dirPath.mkdirs();
				}
				File outFile = new File(path,filename);
				OutputStream fout = new FileOutputStream(outFile);
				IOUtils.copy(in,fout);
				
				
				String jsonStr = excelService.parseExcel(outFile);
				
				response.setContentType("text/plain;charset=gbk");
				PrintWriter out = response.getWriter();
				out.println(jsonStr);
				out.flush();
				out.close();
				//return jsonStr;
				//return Msg.success().add("jsonStr", jsonStr);
			
	}
	
	@RequestMapping(value="/saveExcelData",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveExcelData(@RequestBody List<Temp> datas)
	{   
		String pharmId=datas.get(0).getPharmId();
		Date statisDate=datas.get(0).getStatisDate();
		
		List<Temp> temps=excelService.getTempSalesByPharmIdAndStatisDate(pharmId, statisDate);
		
		if(temps.size()>0)
		{
			System.out.println("数据已经上传过了~~");
			return Msg.fail();
		}
		else
		{
		System.out.println(datas.size());
		
		TempMapper mapper = sqlSession.getMapper(TempMapper.class);
		for(Temp item:datas){
			mapper.insertSelective(item);
		}
		return Msg.success();
		}
	
	}
	
	@RequestMapping("/toTempSales")
	public ModelAndView toTempSales(@RequestParam(value ="pharmId") String pharmId,
			@RequestParam(value ="statisDate",required=false) String statisDate){
		
	  //	Date date = new Date();    
	  //    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  	          
	  //    String formatDate = df.format(statisDate);  
		        
		
		System.out.println("toTempSales pharmId："+pharmId);
		System.out.println("toTempSales statisDate："+statisDate);
		
		String viewName = "pharm/sales_temp";
		ModelAndView modelAndView = new ModelAndView(viewName);	
		//添加模型数据到 ModelAndView 中.
		modelAndView.addObject("pharmId", pharmId);	
		if(statisDate!=null)
			modelAndView.addObject("statisDate", statisDate);	
		return modelAndView;
		
	}
	
	@RequestMapping("/getTempSalesByPharmIdAndStatisDate")
	@ResponseBody
	public Msg getTempSalesByPharmIdAndStatisDate(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value="pharmId") String pharmId,
			@RequestParam(value="statisDate",required=false) Date statisDate){
		
		
		System.out.println("getTempSalesByPharmIdAndStatisDate: pharmId："+pharmId);
		System.out.println("getTempSalesByPharmIdAndStatisDate: statisDate："+statisDate);
		
		
	//
        
		PageHelper.startPage(pn, 20);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<Temp> temps=excelService.getTempSalesByPharmIdAndStatisDate(pharmId,statisDate);
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		@SuppressWarnings("unchecked")
		PageInfo page = new PageInfo(temps, 5);
		return Msg.success().add("pageInfo", page);	
		
	}
	
	
	@RequestMapping("/maxIdFromTemp")
	@ResponseBody
	public Msg maxIdFromTemp(){
		
		//返回的是当前最大的id值+1，这样下一次插入时，自增的id就会变为maxId（当前最大的id+1）的值。
		Integer  maxId = excelService.maxIdFromTemp();
		System.out.println(maxId);
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
	
		return Msg.success().add("maxId", maxId);	
		
	}
	
	
	/**
	 * 根据id查询 temp中的销售数据
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getTempById/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getTempById(@PathVariable("id") Long id){
		
		System.out.println(id);
		
		Temp temp = excelService.getTempById(id);
		return Msg.success().add("temp", temp);
	}
	
	/**
	 * 如果直接发送ajax=PUT形式的请求
	 * 封装的数据
	 * Employee 
	 * [empId=1014, empName=null, gender=null, email=null, dId=null]
	 * 
	 * 问题：
	 * 请求体中有数据；
	 * 但是Employee对象封装不上；
	 * update tbl_emp  where emp_id = 1014;
	 * 
	 * 原因：
	 * Tomcat：
	 * 		1、将请求体中的数据，封装一个map。
	 * 		2、request.getParameter("empName")就会从这个map中取值。
	 * 		3、SpringMVC封装POJO对象的时候。
	 * 				会把POJO中每个属性的值，request.getParamter("email");
	 * AJAX发送PUT请求引发的血案：
	 * 		PUT请求，请求体中的数据，request.getParameter("empName")拿不到
	 * 		Tomcat一看是PUT不会封装请求体中的数据为map，只有POST形式的请求才封装请求体为map
	 * org.apache.catalina.connector.Request--parseParameters() (3111);
	 * 
	 * protected String parseBodyMethods = "POST";
	 * if( !getConnector().isParseBodyMethod(getMethod()) ) {
                success = true;
                return;
            }
	 * 
	 * 
	 * 解决方案；
	 * 我们要能支持直接发送PUT之类的请求还要封装请求体中的数据
	 * 1、配置上HttpPutFormContentFilter；
	 * 2、他的作用；将请求体中的数据解析包装成一个map。
	 * 3、request被重新包装，request.getParameter()被重写，就会从自己封装的map中取数据
	 * 员工更新方法
	 * @param employee
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateTempById/{id}",method=RequestMethod.PUT)
	public Msg saveTemp(Temp temp,HttpServletRequest request){
		System.out.println("请求体中的值："+request.getParameter("sale_price"));
		System.out.println("将要更新的销售数据："+temp);
		excelService.updateTemp(temp);
		
		return Msg.success()	;
	}
	
	/**
	 * 单个批量二合一
	 * 批量删除：1-2-3
	 * 单个删除：1
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deleteTempById/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){
		//批量删除
		if(ids.contains("-")){
			List<Long> del_ids = new ArrayList<>();
			String[] str_ids = ids.split("-");
			//组装id的集合
			for (String string : str_ids) {
				del_ids.add(Long.parseLong(string));
			}
			excelService.deleteTempBatch(del_ids);
		}else{
			Long id = Long.parseLong(ids);
			excelService.deleteTemp(id);
		}
		return Msg.success();
	}
	
	
	

}

