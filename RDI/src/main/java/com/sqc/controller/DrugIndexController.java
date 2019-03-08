package com.sqc.controller;

import java.sql.Date;
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
import com.sqc.bean.Drug;
import com.sqc.bean.DrugIndex;
import com.sqc.bean.DrugIndexWithDistrict;
import com.sqc.bean.DrugIndexWithPharm;
import com.sqc.service.DrugIndexService;
import com.sqc.service.DrugService;
import com.sqc.utils.Msg;

@Controller
@RequestMapping("/drugindex")
public class DrugIndexController {
	
	@Resource
	DrugIndexService drugIndexService;
	
	@Resource
	DrugService drugService;
	/*
	 * 统计整个市的药品指数信息
	 */
	@RequestMapping(value="/getDrugIndices",method=RequestMethod.POST)
	@ResponseBody
	public Msg getDrugIndices(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value="drugName",required=false) String drugName,
			@RequestParam(value="indexSort",required=false) String indexSort,
			@RequestParam(value="statisYear",defaultValue="2017") Integer statisYear,
			@RequestParam(value="statisMonth", defaultValue="1") Integer statisMonth) 
	{
		
		System.out.println("drugName:"+drugName);
		System.out.println("indexSort:"+indexSort);
		System.out.println("statisYear:"+statisYear);
		System.out.println("statisMonth:"+statisMonth);
		// 这不是一个分页查询
		// 引入PageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 10);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<DrugIndex> drugindices = drugIndexService.getDrugIndices
				(drugName,indexSort,statisYear,statisMonth);
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(drugindices, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	/*
	 * 统计某个区的药品指数信息
	 */
	@RequestMapping(value="/getDrugIndicesWithDistrict",method=RequestMethod.POST)
	@ResponseBody
	public Msg getDrugIndicesWithDistrict(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value="drugName",required=false) String drugName,
			@RequestParam(value="indexSort",required=false) String indexSort,
			@RequestParam(value="statisYear",defaultValue="2017") Integer statisYear,
			@RequestParam(value="statisMonth", defaultValue="1") Integer statisMonth,
			@RequestParam(value="districtId", required=false) String districtId) 
	{
		
		System.out.println("drugName:"+drugName);
		System.out.println("indexSort:"+indexSort);
		System.out.println("statisYear:"+statisYear);
		System.out.println("statisMonth:"+statisMonth);
		// 这不是一个分页查询
		// 引入PageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 10);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<DrugIndex> drugindices = drugIndexService.getDrugIndicesWithDistrict
				(drugName,indexSort,statisYear,statisMonth,districtId);
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(drugindices, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	/*
	 * 统计某个区某家药店的药品指数信息
	 */
	@RequestMapping(value="/getDrugIndicesWithPharm",method=RequestMethod.POST)
	@ResponseBody
	public Msg getDrugIndicesWithPharm(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value="drugName",required=false) String drugName,
			@RequestParam(value="indexSort",required=false) String indexSort,
			@RequestParam(value="statisYear",defaultValue="2017") Integer statisYear,
			@RequestParam(value="statisMonth", defaultValue="1") Integer statisMonth,
			@RequestParam(value="districtId", required=false) String districtId,
			@RequestParam(value="pharmId", required=false) String pharmId) 
	{
		
		System.out.println("drugName:"+drugName);
		System.out.println("indexSort:"+indexSort);
		System.out.println("statisYear:"+statisYear);
		System.out.println("statisMonth:"+statisMonth);
		// 这不是一个分页查询
		// 引入PageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 10);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<DrugIndex> drugindices = drugIndexService.getDrugIndicesWithPharm
				(drugName,indexSort,statisYear,statisMonth,districtId,pharmId);
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(drugindices, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	@RequestMapping("/toVerticCmpDetail")
	public ModelAndView toVerticCmpDetail(
			@RequestParam(value = "drugId") String drugId,
			@RequestParam(value = "pharmId",required=false,defaultValue="") String pharmId,
			@RequestParam(value = "districtId",required=false,defaultValue="") String districtId){
		
		
		String viewName = "indices/drug_indices_detail";
		ModelAndView modelAndView = new ModelAndView(viewName);
		
		//添加模型数据到 ModelAndView 中.
		modelAndView.addObject("drugId", drugId);
		modelAndView.addObject("pharmId", pharmId);
		modelAndView.addObject("districtId", districtId);
		
		return modelAndView;
		
	}
	
	@RequestMapping("/toHorizCmpDetail")
	public ModelAndView toHorizCmpDetail(
			@RequestParam(value = "drugId") String drugId,
			@RequestParam(value = "year") Integer year,
			@RequestParam(value = "month") Integer month){
		
		System.out.println("drugId"+drugId);
		System.out.println("year"+year);
		System.out.println("month"+month);
		
		String viewName = "indices/drug_indices_horizcmp";
		ModelAndView modelAndView = new ModelAndView(viewName);
		
		//添加模型数据到 ModelAndView 中.
		modelAndView.addObject("drugId", drugId);
		modelAndView.addObject("year", year);
		modelAndView.addObject("month", month);
		
		return modelAndView;
		
	}
	

	@RequestMapping(value="/horizCmpDrugIndex")
	@ResponseBody
	public Msg horizCmpDrugIndex(@RequestParam(value = "drugId") String drugId,
			@RequestParam(value = "year") Integer year,
			@RequestParam(value = "month") Integer month)
	{
		System.out.println("horizCmpDrugIndex,drugId:"+drugId);
		System.out.println("horizCmpDrugIndex,year:"+year);
		System.out.println("horizCmpDrugIndex,month:"+month);
		
		Drug drug=drugService.getDrugsDetailById(drugId);
		List<DrugIndex> drugIndex= 
				drugIndexService.getIndexByIdAndStatisDate(drugId,year,month);
		List<DrugIndexWithDistrict> drugIndexWithDis=
				drugIndexService.getIndexWithDisByIdAndStatisDate(drugId,year,month);
		List<DrugIndexWithPharm> drugIndexWithPharm=
				drugIndexService.getIndexWithPharmByIdAndStatisDate(drugId,year,month);
		
		return Msg.success().add("drug", drug)
				.add("drugIndex", drugIndex)
				.add("drugIndexWithDis", drugIndexWithDis)
				.add("drugIndexWithPharm", drugIndexWithPharm);
	
		
	}
	
	
	/*
	 * 从t_drugindex中查询整个市的某个药品的最近一年的指数信息
	 */
	@RequestMapping(value="/getRecentDrugIndicesById")
	@ResponseBody
	public Msg getRecentDrugIndicesById(String drugId){
		System.out.println("Controller:getRecentDrugIndicesById,drugId:"+drugId);
		Map<String, Object> map = drugIndexService.getRecentDrugIndicesById(drugId);
		return Msg.success().add("recentIndices", map);
	
		
	}
	/*
	 * 从t_drugindex_with_district中查询某个区域的某个药品的最近一年的指数信息
	 */
	@RequestMapping(value="/getRecentDrugIndicesWithDistrictById")
	@ResponseBody
	public Msg getRecentDrugIndicesWithDistrictById(String drugId,String districtId){
		System.out.println("getRecentCateg4IndicesById,drugId:"+drugId+"districtId:"+districtId);
		Map<String, Object> map = drugIndexService.getRecentDrugIndicesWithDistrictById(drugId,districtId);
		return Msg.success().add("recentIndices", map);
	
		
	}
	/*
	 * 从t_drugindex_with_district中查询某个药店的某个药品的最近一年的指数信息
	 */
	@RequestMapping(value="/getRecentDrugIndicesWithPharmById")
	@ResponseBody
	public Msg getRecentDrugIndicesWithPharmById(String drugId,String pharmId){
		System.out.println("getRecentCateg4IndicesById,drugId:"+drugId+"pharmId:"+pharmId);
		Map<String, Object> map = drugIndexService.getRecentDrugIndicesWithPharmById(drugId,pharmId);
		return Msg.success().add("recentIndices", map);
	
		
	}
	
	
	

}
