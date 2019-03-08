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
	 * ͳ�������е�ҩƷָ����Ϣ
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
		// �ⲻ��һ����ҳ��ѯ
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 10);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<DrugIndex> drugindices = drugIndexService.getDrugIndices
				(drugName,indexSort,statisYear,statisMonth);
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(drugindices, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	/*
	 * ͳ��ĳ������ҩƷָ����Ϣ
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
		// �ⲻ��һ����ҳ��ѯ
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 10);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<DrugIndex> drugindices = drugIndexService.getDrugIndicesWithDistrict
				(drugName,indexSort,statisYear,statisMonth,districtId);
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(drugindices, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	/*
	 * ͳ��ĳ����ĳ��ҩ���ҩƷָ����Ϣ
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
		// �ⲻ��һ����ҳ��ѯ
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 10);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<DrugIndex> drugindices = drugIndexService.getDrugIndicesWithPharm
				(drugName,indexSort,statisYear,statisMonth,districtId,pharmId);
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
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
		
		//���ģ�����ݵ� ModelAndView ��.
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
		
		//���ģ�����ݵ� ModelAndView ��.
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
	 * ��t_drugindex�в�ѯ�����е�ĳ��ҩƷ�����һ���ָ����Ϣ
	 */
	@RequestMapping(value="/getRecentDrugIndicesById")
	@ResponseBody
	public Msg getRecentDrugIndicesById(String drugId){
		System.out.println("Controller:getRecentDrugIndicesById,drugId:"+drugId);
		Map<String, Object> map = drugIndexService.getRecentDrugIndicesById(drugId);
		return Msg.success().add("recentIndices", map);
	
		
	}
	/*
	 * ��t_drugindex_with_district�в�ѯĳ�������ĳ��ҩƷ�����һ���ָ����Ϣ
	 */
	@RequestMapping(value="/getRecentDrugIndicesWithDistrictById")
	@ResponseBody
	public Msg getRecentDrugIndicesWithDistrictById(String drugId,String districtId){
		System.out.println("getRecentCateg4IndicesById,drugId:"+drugId+"districtId:"+districtId);
		Map<String, Object> map = drugIndexService.getRecentDrugIndicesWithDistrictById(drugId,districtId);
		return Msg.success().add("recentIndices", map);
	
		
	}
	/*
	 * ��t_drugindex_with_district�в�ѯĳ��ҩ���ĳ��ҩƷ�����һ���ָ����Ϣ
	 */
	@RequestMapping(value="/getRecentDrugIndicesWithPharmById")
	@ResponseBody
	public Msg getRecentDrugIndicesWithPharmById(String drugId,String pharmId){
		System.out.println("getRecentCateg4IndicesById,drugId:"+drugId+"pharmId:"+pharmId);
		Map<String, Object> map = drugIndexService.getRecentDrugIndicesWithPharmById(drugId,pharmId);
		return Msg.success().add("recentIndices", map);
	
		
	}
	
	
	

}
