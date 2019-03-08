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
		//�ϴ����ļ�
		      
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
			System.out.println("�����Ѿ��ϴ�����~~");
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
		        
		
		System.out.println("toTempSales pharmId��"+pharmId);
		System.out.println("toTempSales statisDate��"+statisDate);
		
		String viewName = "pharm/sales_temp";
		ModelAndView modelAndView = new ModelAndView(viewName);	
		//���ģ�����ݵ� ModelAndView ��.
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
		
		
		System.out.println("getTempSalesByPharmIdAndStatisDate: pharmId��"+pharmId);
		System.out.println("getTempSalesByPharmIdAndStatisDate: statisDate��"+statisDate);
		
		
	//
        
		PageHelper.startPage(pn, 20);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Temp> temps=excelService.getTempSalesByPharmIdAndStatisDate(pharmId,statisDate);
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		@SuppressWarnings("unchecked")
		PageInfo page = new PageInfo(temps, 5);
		return Msg.success().add("pageInfo", page);	
		
	}
	
	
	@RequestMapping("/maxIdFromTemp")
	@ResponseBody
	public Msg maxIdFromTemp(){
		
		//���ص��ǵ�ǰ����idֵ+1��������һ�β���ʱ��������id�ͻ��ΪmaxId����ǰ����id+1����ֵ��
		Integer  maxId = excelService.maxIdFromTemp();
		System.out.println(maxId);
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
	
		return Msg.success().add("maxId", maxId);	
		
	}
	
	
	/**
	 * ����id��ѯ temp�е���������
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
	 * ���ֱ�ӷ���ajax=PUT��ʽ������
	 * ��װ������
	 * Employee 
	 * [empId=1014, empName=null, gender=null, email=null, dId=null]
	 * 
	 * ���⣺
	 * �������������ݣ�
	 * ����Employee�����װ���ϣ�
	 * update tbl_emp  where emp_id = 1014;
	 * 
	 * ԭ��
	 * Tomcat��
	 * 		1�����������е����ݣ���װһ��map��
	 * 		2��request.getParameter("empName")�ͻ�����map��ȡֵ��
	 * 		3��SpringMVC��װPOJO�����ʱ��
	 * 				���POJO��ÿ�����Ե�ֵ��request.getParamter("email");
	 * AJAX����PUT����������Ѫ����
	 * 		PUT�����������е����ݣ�request.getParameter("empName")�ò���
	 * 		Tomcatһ����PUT�����װ�������е�����Ϊmap��ֻ��POST��ʽ������ŷ�װ������Ϊmap
	 * org.apache.catalina.connector.Request--parseParameters() (3111);
	 * 
	 * protected String parseBodyMethods = "POST";
	 * if( !getConnector().isParseBodyMethod(getMethod()) ) {
                success = true;
                return;
            }
	 * 
	 * 
	 * ���������
	 * ����Ҫ��֧��ֱ�ӷ���PUT֮�������Ҫ��װ�������е�����
	 * 1��������HttpPutFormContentFilter��
	 * 2���������ã����������е����ݽ�����װ��һ��map��
	 * 3��request�����°�װ��request.getParameter()����д���ͻ���Լ���װ��map��ȡ����
	 * Ա�����·���
	 * @param employee
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateTempById/{id}",method=RequestMethod.PUT)
	public Msg saveTemp(Temp temp,HttpServletRequest request){
		System.out.println("�������е�ֵ��"+request.getParameter("sale_price"));
		System.out.println("��Ҫ���µ��������ݣ�"+temp);
		excelService.updateTemp(temp);
		
		return Msg.success()	;
	}
	
	/**
	 * ������������һ
	 * ����ɾ����1-2-3
	 * ����ɾ����1
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deleteTempById/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){
		//����ɾ��
		if(ids.contains("-")){
			List<Long> del_ids = new ArrayList<>();
			String[] str_ids = ids.split("-");
			//��װid�ļ���
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

