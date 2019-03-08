package com.sqc.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sqc.bean.Categ2Index;
import com.sqc.bean.Categ2IndexWithDistrict;
import com.sqc.bean.Categ2IndexWithPharm;
import com.sqc.bean.Categ3Index;
import com.sqc.bean.Categ3IndexWithDistrict;
import com.sqc.bean.Categ3IndexWithPharm;
import com.sqc.bean.Category;
import com.sqc.service.Categ3IndexService;
import com.sqc.service.CategoryService;
import com.sqc.utils.Msg;

@Controller
@RequestMapping("/categ3index")
public class Categ3IndexController {
	
	@Resource
	private Categ3IndexService categ3IndexService;
	
	@Resource
	private CategoryService catgoryService;
	/**
	 * 查询整个宿迁市的价格指数 
	 */
	@RequestMapping(value="/getCateg3Indices",method=RequestMethod.POST)
	@ResponseBody
	public Msg getCateg4Indices(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value="categName",required=false) String categName,
			@RequestParam(value="indexSort",required=false) String indexSort,
			@RequestParam(value="statisYear",defaultValue="2017") Integer statisYear,
			@RequestParam(value="statisMonth", defaultValue="1") Integer statisMonth ) 
	{
		
		
		System.out.println("categName:"+categName);
		System.out.println("indexSort:"+indexSort);
		System.out.println("statisYear:"+statisYear);
		System.out.println("statisMonth:"+statisMonth);
		
		
		// 引入PageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 10);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<Categ3Index> categ3Indices = categ3IndexService.getCateg3Indices
				(categName,indexSort,statisYear,statisMonth);
		System.out.println(categ3Indices.size());
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(categ3Indices, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	/*
	 * 查询某个区域的价格指数
	 */
	@RequestMapping(value="/getCateg3IndicesWithDistrict",method=RequestMethod.POST)
	@ResponseBody
	public Msg getCateg3IndicesWithDistrict(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value="categName",required=false) String categName,
			@RequestParam(value="indexSort",required=false) String indexSort,
			@RequestParam(value="statisYear",defaultValue="2017") Integer statisYear,
			@RequestParam(value="statisMonth", defaultValue="1") Integer statisMonth,
			@RequestParam(value="districtId", required=false) String districtId	) 
	{
		
		
		System.out.println("categName:"+categName);
		System.out.println("indexSort:"+indexSort);
		System.out.println("statisYear:"+statisYear);
		System.out.println("statisMonth:"+statisMonth);
		System.out.println("districtId:"+districtId);
		
		
		// 引入PageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 10);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<Categ3IndexWithDistrict> categ3Indices = categ3IndexService.getCateg3IndicesWithDistrict
				(categName,indexSort,statisYear,statisMonth,districtId);
		System.out.println(categ3Indices.size());
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(categ3Indices, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	/*
	 * 查询某个地区某个具体药店的指数信息
	 */
	@RequestMapping(value="/getCateg3IndicesWithPharm",method=RequestMethod.POST)
	@ResponseBody
	public Msg getCateg3IndicesWithPharm(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value="categName",required=false) String categName,
			@RequestParam(value="indexSort",required=false) String indexSort,
			@RequestParam(value="statisYear",defaultValue="2017") Integer statisYear,
			@RequestParam(value="statisMonth", defaultValue="1") Integer statisMonth,
			@RequestParam(value="districtId", required=false) String districtId,
			@RequestParam(value="drugstoreId", required=false) String drugstoreId ) 
	{
		
		
		System.out.println("categName:"+categName);
		System.out.println("indexSort:"+indexSort);
		System.out.println("statisYear:"+statisYear);
		System.out.println("statisMonth:"+statisMonth);
		System.out.println("districtId:"+districtId);
		System.out.println("drugstoreId:"+drugstoreId);
		
		// 引入PageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 10);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<Categ3IndexWithPharm> categ3Indices = categ3IndexService.getCateg3IndicesWithPharm
				(categName,indexSort,statisYear,statisMonth,districtId,drugstoreId);
		System.out.println(categ3Indices.size());
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(categ3Indices, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	@RequestMapping("/toCateg3IndicesDetail")
	public ModelAndView toCateg3IndicesDetail(
			@RequestParam(value = "categId") String categId,
			@RequestParam(value = "pharmId",required=false,defaultValue="") String pharmId,
			@RequestParam(value = "districtId",required=false,defaultValue="") String districtId)
	{
		
		
		String viewName = "indices/categ3_indices_detail";
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("categId", categId);
		modelAndView.addObject("pharmId", pharmId);
		modelAndView.addObject("districtId", districtId);
		
		
		return modelAndView;
		
	}
	
	@RequestMapping("/toHorizCmpDetail")
	public ModelAndView toHorizCmpDetail(
			@RequestParam(value = "categId") String categId,
			@RequestParam(value = "year") Integer year,
			@RequestParam(value = "month") Integer month){
		
		System.out.println("categId"+categId);
		System.out.println("year"+year);
		System.out.println("month"+month);
		
		String viewName = "indices/categ3_indices_horizcmp";
		ModelAndView modelAndView = new ModelAndView(viewName);
		
		//添加模型数据到 ModelAndView 中.
		modelAndView.addObject("categId", categId);
		modelAndView.addObject("year", year);
		modelAndView.addObject("month", month);
		
		return modelAndView;
		
	}
	

	@RequestMapping(value="/horizCmpDrugIndex")
	@ResponseBody
	public Msg horizCmpDrugIndex(@RequestParam(value = "categId") String categId,
			@RequestParam(value = "year") Integer year,
			@RequestParam(value = "month") Integer month)
	{
		System.out.println("horizCmpDrugIndex,categId:"+categId);
		System.out.println("horizCmpDrugIndex,year:"+year);
		System.out.println("horizCmpDrugIndex,month:"+month);
		
		Category category=catgoryService.getCategDetailById(categId);
		List<Categ3Index> categIndex= 
				categ3IndexService.getIndexByIdAndStatisDate(categId,year,month);
		List<Categ3IndexWithDistrict> categIndexWithDis=
				categ3IndexService.getIndexWithDisByIdAndStatisDate(categId,year,month);
		List<Categ3IndexWithPharm> categIndexWithPharm=
				categ3IndexService.getIndexWithPharmByIdAndStatisDate(categId,year,month);
		
		return Msg.success().add("category", category)
				.add("categIndex", categIndex)
				.add("categIndexWithDis", categIndexWithDis)
				.add("categIndexWithPharm", categIndexWithPharm);
	
		
	}
	
	/*
	 * 从t_categ3index中查询整个市的某个4级分类的最近一年的指数信息
	 */
	@RequestMapping(value="/getRecentCateg3IndicesById")
	@ResponseBody
	public Msg getRecentCateg3IndicesById(String categId){
		System.out.println("getRecentCateg3IndicesById,categId:"+categId);
		Map<String, Object> map = categ3IndexService.getRecentCateg3IndicesById(categId);
		return Msg.success().add("recentIndices", map);
	
		
	}
	/*
	 * 从t_categ3index_with_district中查询某个区域的某个4级分类的最近一年的指数信息
	 */
	@RequestMapping(value="/getRecentCateg3IndicesWithDistrictById")
	@ResponseBody
	public Msg getRecentCateg3IndicesWithDistrictById(String categId,String districtId){
		System.out.println("getRecentCateg3IndicesById,categId:"+categId+"districtId:"+districtId);
		Map<String, Object> map = categ3IndexService.getRecentCateg3IndicesWithDistrictById(categId,districtId);
		return Msg.success().add("recentIndices", map);
	
		
	}
	/*
	 * 从t_categ3index_with_district中查询某个药店的某个4级分类的最近一年的指数信息
	 */
	@RequestMapping(value="/getRecentCateg3IndicesWithPharmById")
	@ResponseBody
	public Msg getRecentCateg3IndicesWithPharmById(String categId,String pharmId){
		System.out.println("getRecentCateg3IndicesById,categId:"+categId+"pharmId:"+pharmId);
		Map<String, Object> map = categ3IndexService.getRecentCateg3IndicesWithPharmById(categId,pharmId);
		return Msg.success().add("recentIndices", map);
	
		
	}
	

}

