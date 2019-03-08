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
import com.sqc.bean.Categ1IndexWithPharm;
import com.sqc.bean.Categ4Index;
import com.sqc.bean.Categ4IndexWithDistrict;
import com.sqc.bean.Category;
import com.sqc.bean.DrugIndexWithPharm;
import com.sqc.bean.Categ1Index;
import com.sqc.bean.Categ1IndexWithDistrict;

import com.sqc.service.Categ1IndexService;
import com.sqc.service.CategoryService;
import com.sqc.utils.Msg;

@Controller
@RequestMapping("/categ1index")
public class Categ1IndexController {
	
	@Resource
	private Categ1IndexService categ1IndexService;
	
	@Resource
	private CategoryService catgoryService;
	
	
	/**
	 * ��ѯ������Ǩ�еļ۸�ָ�� 
	 */
	@RequestMapping(value="/getCateg1Indices",method=RequestMethod.POST)
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
		
		
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 10);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Categ1Index> categ1Indices = categ1IndexService.getCateg1Indices
				(categName,indexSort,statisYear,statisMonth);
		System.out.println(categ1Indices.size());
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(categ1Indices, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	/*
	 * ��ѯĳ������ļ۸�ָ��
	 */
	@RequestMapping(value="/getCateg1IndicesWithDistrict",method=RequestMethod.POST)
	@ResponseBody
	public Msg getCateg1IndicesWithDistrict(
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
		
		
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 10);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Categ1IndexWithDistrict> categ1Indices = categ1IndexService.getCateg1IndicesWithDistrict
				(categName,indexSort,statisYear,statisMonth,districtId);
		System.out.println(categ1Indices.size());
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(categ1Indices, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	/*
	 * ��ѯĳ������ĳ������ҩ���ָ����Ϣ
	 */
	@RequestMapping(value="/getCateg1IndicesWithPharm",method=RequestMethod.POST)
	@ResponseBody
	public Msg getCateg1IndicesWithPharm(
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
		
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 10);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Categ1IndexWithPharm> categ1Indices = categ1IndexService.getCateg1IndicesWithPharm
				(categName,indexSort,statisYear,statisMonth,districtId,drugstoreId);
		System.out.println(categ1Indices.size());
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(categ1Indices, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	@RequestMapping("/toCateg1IndicesDetail")
	public ModelAndView toCateg1IndicesDetail(
			@RequestParam(value = "categId") String categId,
			@RequestParam(value = "pharmId",required=false,defaultValue="") String pharmId,
			@RequestParam(value = "districtId",required=false,defaultValue="") String districtId)
	{
		
		
		String viewName = "indices/categ1_indices_detail";
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
		
		String viewName = "indices/categ1_indices_horizcmp";
		ModelAndView modelAndView = new ModelAndView(viewName);
		
		//���ģ�����ݵ� ModelAndView ��.
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
		List<Categ1Index> categIndex= 
				categ1IndexService.getIndexByIdAndStatisDate(categId,year,month);
		List<Categ1IndexWithDistrict> categIndexWithDis=
				categ1IndexService.getIndexWithDisByIdAndStatisDate(categId,year,month);
		List<Categ1IndexWithPharm> categIndexWithPharm=
				categ1IndexService.getIndexWithPharmByIdAndStatisDate(categId,year,month);
		
		return Msg.success().add("category", category)
				.add("categIndex", categIndex)
				.add("categIndexWithDis", categIndexWithDis)
				.add("categIndexWithPharm", categIndexWithPharm);
	
		
	}
	
	/*
	 * ��t_categ1index�в�ѯ�����е�ĳ��4����������һ���ָ����Ϣ
	 */
	@RequestMapping(value="/getRecentCateg1IndicesById")
	@ResponseBody
	public Msg getRecentCateg1IndicesById(String categId){
		System.out.println("getRecentCateg1IndicesById,categId:"+categId);
		Map<String, Object> map = categ1IndexService.getRecentCateg1IndicesById(categId);
		return Msg.success().add("recentIndices", map);
	
		
	}
	/*
	 * ��t_categ1index_with_district�в�ѯĳ�������ĳ��4����������һ���ָ����Ϣ
	 */
	@RequestMapping(value="/getRecentCateg1IndicesWithDistrictById")
	@ResponseBody
	public Msg getRecentCateg1IndicesWithDistrictById(String categId,String districtId){
		System.out.println("getRecentCateg1IndicesById,categId:"+categId+"districtId:"+districtId);
		Map<String, Object> map = categ1IndexService.getRecentCateg1IndicesWithDistrictById(categId,districtId);
		return Msg.success().add("recentIndices", map);
	
		
	}
	/*
	 * ��t_categ1index_with_district�в�ѯĳ��ҩ���ĳ��4����������һ���ָ����Ϣ
	 */
	@RequestMapping(value="/getRecentCateg1IndicesWithPharmById")
	@ResponseBody
	public Msg getRecentCateg1IndicesWithPharmById(String categId,String pharmId){
		System.out.println("getRecentCateg1IndicesById,categId:"+categId+"pharmId:"+pharmId);
		Map<String, Object> map = categ1IndexService.getRecentCateg1IndicesWithPharmById(categId,pharmId);
		return Msg.success().add("recentIndices", map);
	
		
	}
	

	

}

