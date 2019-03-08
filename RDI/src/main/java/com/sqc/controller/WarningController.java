package com.sqc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sqc.bean.Categ4IndexWithPharm;
import com.sqc.bean.Categ1IndexWithDistrict;
import com.sqc.bean.Categ1IndexWithPharm;
import com.sqc.bean.Categ2IndexWithDistrict;
import com.sqc.bean.Categ2IndexWithPharm;
import com.sqc.bean.Categ3IndexWithDistrict;
import com.sqc.bean.Categ3IndexWithPharm;
import com.sqc.bean.Categ4IndexWithDistrict;
import com.sqc.service.Categ1IndexService;
import com.sqc.service.Categ2IndexService;
import com.sqc.service.Categ3IndexService;
import com.sqc.service.Categ4IndexService;
import com.sqc.utils.Msg;
@Controller
@RequestMapping("/warning")
public class WarningController {

	@Resource
	Categ4IndexService categ4IndexService;
	
	@Resource
	Categ3IndexService categ3IndexService;
	
	@Resource
	Categ2IndexService categ2IndexService;
	
	@Resource
	Categ1IndexService categ1IndexService;
	

	@RequestMapping("/indexcateg3")
	public String toIndexWarn3(){
		return "warning/categ3";
		}
	
	@RequestMapping("/indexcateg2")
	public String toIndexWarn2(){
		return "warning/categ2";
		}
	@RequestMapping("/indexcateg1")
	public String toIndexWarn1(){
		return "warning/categ1";
	}
	
	@RequestMapping("/indexcateg4")
	public String toIndexWarn(){
		return "warning/categ4";
	}

	@RequestMapping("/indexcateg5")
	public String toIndexWarn5(){
		return "warning/NewFile";
	}


	@RequestMapping(value="/allExceptionData")
	@ResponseBody
	public Msg allExceptionData(@RequestParam(value = "pn", defaultValue = "1")Integer pn,
			@RequestParam(value = "categName") String categName,
			@RequestParam(value="rise",required=false) Float rise,
			@RequestParam(value="decrease",required=false) Float decrease,
			@RequestParam(value = "year") Integer year,
			@RequestParam(value = "month") Integer month,
			@RequestParam(value="classifybykindsId") String classifybykindsId)
	
	{
			System.out.println("horizCmpDrugIndex,categName:"+categName);
			System.out.println("rise:"+rise);
			System.out.println("floating:"+decrease);
			System.out.println("horizCmpDrugIndex,year:"+year);
			System.out.println("horizCmpDrugIndex,month:"+month);
			System.out.println("classifybykindsId:"+classifybykindsId);


			PageHelper.startPage(pn, 10);
			List<Categ4IndexWithPharm> warningIndices=categ4IndexService.getCompareIndex(categName,rise,decrease,year,month,classifybykindsId);
			PageInfo page = new PageInfo(warningIndices, 5);
			
			return Msg.success().add("pageInfo", page);
     }
	
	
	@RequestMapping(value="/withKindsExceptionData")
	@ResponseBody
	public Msg withKindsExceptionData(@RequestParam(value = "pn", defaultValue = "1")Integer pn,
			@RequestParam(value = "categName") String categName,
			@RequestParam(value="rise",required=false) Float rise,
			@RequestParam(value="decrease",required=false) Float decrease,
			@RequestParam(value = "year") Integer year,
			@RequestParam(value = "month") Integer month,
			@RequestParam(value="classifybykindsId") String classifybykindsId)	
	{
			System.out.println("horizCmpDrugIndex,categName:"+categName);
			System.out.println("rise:"+rise);
			System.out.println("floating:"+decrease);
			System.out.println("horizCmpDrugIndex,year:"+year);
			System.out.println("horizCmpDrugIndex,month:"+month);
			System.out.println("classifybykindsId:"+classifybykindsId);


			PageHelper.startPage(pn, 10);
			List<Categ4IndexWithPharm> warningIndices=categ4IndexService.getCompareIndexWithKinds(categName,rise,decrease,year,month,classifybykindsId);
			PageInfo page = new PageInfo(warningIndices, 5);
			
			return Msg.success().add("pageInfo", page);
     }
	
	
	
	
	@RequestMapping(value="/withDisExceptionData")
	@ResponseBody
	public Msg withDisExceptionData(@RequestParam(value = "pn", defaultValue = "1")Integer pn,
			@RequestParam(value = "categName") String categName,
			@RequestParam(value="rise",required=false) Float rise,
			@RequestParam(value="decrease",required=false) Float decrease,
			@RequestParam(value = "year") Integer year,
			@RequestParam(value = "month") Integer month,
			@RequestParam(value="districtId") String districtId,
			@RequestParam(value="classifybykindsId") String classifybykindsId) 
	
	{
			System.out.println("horizCmpDrugIndex,categName:"+categName);
			System.out.println("rise:"+rise);
			System.out.println("floating:"+decrease);
			System.out.println("horizCmpDrugIndex,year:"+year);
			System.out.println("horizCmpDrugIndex,month:"+month);
			System.out.println("districtId:"+districtId);
			System.out.println("classifybykindsId:"+classifybykindsId);
			PageHelper.startPage(pn, 10);
			List<Categ4IndexWithDistrict> warningIndices=categ4IndexService.getCompareIndexWithDis(categName,rise,decrease,year,month,districtId,classifybykindsId);
			PageInfo page = new PageInfo(warningIndices, 5);
			
			return Msg.success().add("pageInfo", page);
     }
	
	
	@RequestMapping(value="/withPharamExceptionData")
	@ResponseBody
	public Msg withPharamExceptionData(@RequestParam(value = "pn", defaultValue = "1")Integer pn,
			@RequestParam(value = "categName") String categName,
			@RequestParam(value="rise",required=false) Float rise,
			@RequestParam(value="decrease",required=false) Float decrease,
			@RequestParam(value = "year") Integer year,
			@RequestParam(value = "month") Integer month,
			@RequestParam(value="districtId") String districtId,
			@RequestParam(value="drugstoreId") String drugstoreId,
			@RequestParam(value="classifybykindsId") String classifybykindsId)
	
	{
			System.out.println("horizCmpDrugIndex,categName:"+categName);
			System.out.println("rise:"+rise);
			System.out.println("floating:"+decrease);
			System.out.println("horizCmpDrugIndex,year:"+year);
			System.out.println("horizCmpDrugIndex,month:"+month);
			System.out.println("districtId:"+districtId);
			System.out.println("drugstoreId:"+drugstoreId);
			System.out.println("classifybykindsId:"+classifybykindsId);

			PageHelper.startPage(pn, 10);
			List<Categ4IndexWithPharm> warningIndices=categ4IndexService.getCompareIndexWithPharam(categName,rise,decrease,year,month,districtId,drugstoreId,classifybykindsId);
			PageInfo page = new PageInfo(warningIndices, 5);
			
			return Msg.success().add("pageInfo", page);
     }
	
	
	//小类

	@RequestMapping(value="/allExceptionDataSmall")
	@ResponseBody
	public Msg allExceptionDataSmall(@RequestParam(value = "pn", defaultValue = "1")Integer pn,
			@RequestParam(value = "categName") String categName,
			@RequestParam(value="rise",required=false) Float rise,
			@RequestParam(value="decrease",required=false) Float decrease,
			@RequestParam(value = "year") Integer year,
			@RequestParam(value = "month") Integer month,
			@RequestParam(value="classifybysmallId") String classifybysmallId)
	
	{
			System.out.println("horizCmpDrugIndex,categName:"+categName);
			System.out.println("rise:"+rise);
			System.out.println("floating:"+decrease);
			System.out.println("horizCmpDrugIndex,year:"+year);
			System.out.println("horizCmpDrugIndex,month:"+month);
			System.out.println("classifybysmallId:"+classifybysmallId);

			PageHelper.startPage(pn, 10);
			List<Categ3IndexWithPharm> warningIndices=categ3IndexService.getCompareIndex(categName,rise,decrease,year,month,classifybysmallId);
			PageInfo page = new PageInfo(warningIndices, 5);
			
			return Msg.success().add("pageInfo", page);
     }
	
	@RequestMapping(value="/withDisExceptionDataSmall")
	@ResponseBody
	public Msg withDisExceptionDataSmall(@RequestParam(value = "pn", defaultValue = "1")Integer pn,
			@RequestParam(value = "categName") String categName,
			@RequestParam(value="rise",required=false) Float rise,
			@RequestParam(value="decrease",required=false) Float decrease,
			@RequestParam(value = "year") Integer year,
			@RequestParam(value = "month") Integer month,
			@RequestParam(value="districtId") String districtId,
			@RequestParam(value="classifybysmallId") String classifybysmallId	) 
	
	{
			System.out.println("horizCmpDrugIndex,categName:"+categName);
			System.out.println("rise:"+rise);
			System.out.println("floating:"+decrease);
			System.out.println("horizCmpDrugIndex,year:"+year);
			System.out.println("horizCmpDrugIndex,month:"+month);
			System.out.println("districtId:"+districtId);
			System.out.println("classifybysmallId:"+classifybysmallId);

			PageHelper.startPage(pn, 10);
			List<Categ3IndexWithDistrict> warningIndices=categ3IndexService.getCompareIndexWithDis(categName,rise,decrease,year,month,districtId,classifybysmallId);
			PageInfo page = new PageInfo(warningIndices, 5);
			
			return Msg.success().add("pageInfo", page);
     }
	
	
	@RequestMapping(value="/withPharamExceptionDataSmall")
	@ResponseBody
	public Msg withPharamExceptionDataSmall(@RequestParam(value = "pn", defaultValue = "1")Integer pn,
			@RequestParam(value = "categName") String categName,
			@RequestParam(value="rise",required=false) Float rise,
			@RequestParam(value="decrease",required=false) Float decrease,
			@RequestParam(value = "year") Integer year,
			@RequestParam(value = "month") Integer month,
			@RequestParam(value="districtId") String districtId,
			@RequestParam(value="drugstoreId") String drugstoreId,
			@RequestParam(value="classifybysmallId") String classifybysmallId)
	
	{
			System.out.println("horizCmpDrugIndex,categName:"+categName);
			System.out.println("rise:"+rise);
			System.out.println("floating:"+decrease);
			System.out.println("horizCmpDrugIndex,year:"+year);
			System.out.println("horizCmpDrugIndex,month:"+month);
			System.out.println("districtId:"+districtId);
			System.out.println("drugstoreId:"+drugstoreId);
			System.out.println("classifybysmallId:"+classifybysmallId);


			PageHelper.startPage(pn, 10);
			List<Categ3IndexWithPharm> warningIndices=categ3IndexService.getCompareIndexWithPharam(categName,rise,decrease,year,month,districtId,drugstoreId,classifybysmallId);
			PageInfo page = new PageInfo(warningIndices, 5);
			
			return Msg.success().add("pageInfo", page);
     }
	
//中类

	@RequestMapping(value="/allExceptionDataMiddle")
	@ResponseBody
	public Msg allExceptionDataMiddle(@RequestParam(value = "pn", defaultValue = "1")Integer pn,
			@RequestParam(value = "categName") String categName,
			@RequestParam(value="rise",required=false) Float rise,
			@RequestParam(value="decrease",required=false) Float decrease,
			@RequestParam(value = "year") Integer year,
			@RequestParam(value = "month") Integer month,
			@RequestParam(value="classifybymiddleId") String classifybymiddleId )
	
	{
			System.out.println("horizCmpDrugIndex,categName:"+categName);
			System.out.println("rise:"+rise);
			System.out.println("floating:"+decrease);
			System.out.println("horizCmpDrugIndex,year:"+year);
			System.out.println("horizCmpDrugIndex,month:"+month);
			System.out.println("classifybymiddleId:"+classifybymiddleId);


			PageHelper.startPage(pn, 10);
			List<Categ2IndexWithPharm> warningIndices=categ2IndexService.getCompareIndex(categName,rise,decrease,year,month,classifybymiddleId);
			PageInfo page = new PageInfo(warningIndices, 5);
			
			return Msg.success().add("pageInfo", page);
     }
	
	@RequestMapping(value="/withDisExceptionDataMiddle")
	@ResponseBody
	public Msg withDisExceptionDataMiddle(@RequestParam(value = "pn", defaultValue = "1")Integer pn,
			@RequestParam(value = "categName") String categName,
			@RequestParam(value="rise",required=false) Float rise,
			@RequestParam(value="decrease",required=false) Float decrease,
			@RequestParam(value = "year") Integer year,
			@RequestParam(value = "month") Integer month,
			@RequestParam(value="districtId") String districtId,
			@RequestParam(value="classifybymiddleId") String classifybymiddleId	) 
	
	{
			System.out.println("horizCmpDrugIndex,categName:"+categName);
			System.out.println("rise:"+rise);
			System.out.println("floating:"+decrease);
			System.out.println("horizCmpDrugIndex,year:"+year);
			System.out.println("horizCmpDrugIndex,month:"+month);
			System.out.println("districtId:"+districtId);
			System.out.println("classifybymiddleId:"+classifybymiddleId);

			PageHelper.startPage(pn, 10);
			List<Categ2IndexWithDistrict> warningIndices=categ2IndexService.getCompareIndexWithDis(categName,rise,decrease,year,month,districtId,classifybymiddleId);
			PageInfo page = new PageInfo(warningIndices, 5);
			
			return Msg.success().add("pageInfo", page);
     }
	
	
	@RequestMapping(value="/withPharamExceptionDataMiddle")
	@ResponseBody
	public Msg withPharamExceptionDataMiddle(@RequestParam(value = "pn", defaultValue = "1")Integer pn,
			@RequestParam(value = "categName") String categName,
			@RequestParam(value="rise",required=false) Float rise,
			@RequestParam(value="decrease",required=false) Float decrease,
			@RequestParam(value = "year") Integer year,
			@RequestParam(value = "month") Integer month,
			@RequestParam(value="districtId") String districtId,
			@RequestParam(value="drugstoreId") String drugstoreId,
			@RequestParam(value="classifybymiddleId") String classifybymiddleId)
	
	{
			System.out.println("horizCmpDrugIndex,categName:"+categName);
			System.out.println("rise:"+rise);
			System.out.println("floating:"+decrease);
			System.out.println("horizCmpDrugIndex,year:"+year);
			System.out.println("horizCmpDrugIndex,month:"+month);
			System.out.println("districtId:"+districtId);
			System.out.println("drugstoreId:"+drugstoreId);
			System.out.println("classifybymiddleId:"+classifybymiddleId);


			PageHelper.startPage(pn, 10);
			List<Categ2IndexWithPharm> warningIndices=categ2IndexService.getCompareIndexWithPharam(categName,rise,decrease,year,month,districtId,drugstoreId,classifybymiddleId);
			PageInfo page = new PageInfo(warningIndices, 5);
			
			return Msg.success().add("pageInfo", page);
     }
	
	//大类
	

	@RequestMapping(value="/allExceptionDataLarge")
	@ResponseBody
	public Msg allExceptionDataLarge(@RequestParam(value = "pn", defaultValue = "1")Integer pn,
			@RequestParam(value = "categName") String categName,
			@RequestParam(value="rise",required=false) Float rise,
			@RequestParam(value="decrease",required=false) Float decrease,
			@RequestParam(value = "year") Integer year,
			@RequestParam(value = "month") Integer month,
			@RequestParam(value="classifybylargeId") String classifybylargeId	 )
	
	{
			System.out.println("horizCmpDrugIndex,categName:"+categName);
			System.out.println("rise:"+rise);
			System.out.println("floating:"+decrease);
			System.out.println("horizCmpDrugIndex,year:"+year);
			System.out.println("horizCmpDrugIndex,month:"+month);
			System.out.println("classifybylargeId:"+classifybylargeId);


			PageHelper.startPage(pn, 10);
			List<Categ1IndexWithPharm> warningIndices=categ1IndexService.getCompareIndex(categName,rise,decrease,year,month,classifybylargeId);
			PageInfo page = new PageInfo(warningIndices, 5);
			
			return Msg.success().add("pageInfo", page);
     }
	
	@RequestMapping(value="/withDisExceptionDataLarge")
	@ResponseBody
	public Msg withDisExceptionDataLarge(@RequestParam(value = "pn", defaultValue = "1")Integer pn,
			@RequestParam(value = "categName") String categName,
			@RequestParam(value="rise",required=false) Float rise,
			@RequestParam(value="decrease",required=false) Float decrease,
			@RequestParam(value = "year") Integer year,
			@RequestParam(value = "month") Integer month,
			@RequestParam(value="districtId") String districtId,
			@RequestParam(value="classifybylargeId") String classifybylargeId		) 
	
	{
			System.out.println("horizCmpDrugIndex,categName:"+categName);
			System.out.println("rise:"+rise);
			System.out.println("floating:"+decrease);
			System.out.println("horizCmpDrugIndex,year:"+year);
			System.out.println("horizCmpDrugIndex,month:"+month);
			System.out.println("districtId:"+districtId);
			System.out.println("classifybylargeId:"+classifybylargeId);

			PageHelper.startPage(pn, 10);
			List<Categ1IndexWithDistrict> warningIndices=categ1IndexService.getCompareIndexWithDis(categName,rise,decrease,year,month,districtId,classifybylargeId);
			PageInfo page = new PageInfo(warningIndices, 5);
			
			return Msg.success().add("pageInfo", page);
     }
	
	
	@RequestMapping(value="/withPharamExceptionDataLarge")
	@ResponseBody
	public Msg withPharamExceptionDataLarge(@RequestParam(value = "pn", defaultValue = "1")Integer pn,
			@RequestParam(value = "categName") String categName,
			@RequestParam(value="rise",required=false) Float rise,
			@RequestParam(value="decrease",required=false) Float decrease,
			@RequestParam(value = "year") Integer year,
			@RequestParam(value = "month") Integer month,
			@RequestParam(value="districtId") String districtId,
			@RequestParam(value="drugstoreId") String drugstoreId,
			@RequestParam(value="classifybylargeId") String classifybylargeId	)
	
	{
			System.out.println("horizCmpDrugIndex,categName:"+categName);
			System.out.println("rise:"+rise);
			System.out.println("floating:"+decrease);
			System.out.println("horizCmpDrugIndex,year:"+year);
			System.out.println("horizCmpDrugIndex,month:"+month);
			System.out.println("districtId:"+districtId);
			System.out.println("drugstoreId:"+drugstoreId);
			System.out.println("classifybylargeId:"+classifybylargeId);


			PageHelper.startPage(pn, 10);
			List<Categ1IndexWithPharm> warningIndices=categ1IndexService.getCompareIndexWithPharam(categName,rise,decrease,year,month,districtId,drugstoreId,classifybylargeId);
			PageInfo page = new PageInfo(warningIndices, 5);
			
			return Msg.success().add("pageInfo", page);
     }
}