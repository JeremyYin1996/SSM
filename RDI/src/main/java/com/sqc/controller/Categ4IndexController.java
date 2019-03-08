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
import com.sqc.bean.Categ2IndexWithPharm;
import com.sqc.bean.Categ3IndexWithPharm;
import com.sqc.bean.Categ4Index;
import com.sqc.bean.Categ4IndexWithDistrict;
import com.sqc.bean.Categ4IndexWithPharm;
import com.sqc.bean.Category;
import com.sqc.bean.Drug;
import com.sqc.bean.DrugIndex;
import com.sqc.bean.DrugIndexWithDistrict;
import com.sqc.bean.DrugIndexWithPharm;
import com.sqc.service.Categ4IndexService;
import com.sqc.service.CategoryService;
import com.sqc.utils.Msg;

@Controller
@RequestMapping("/categ4index")
public class Categ4IndexController {
	
	@Resource
	private Categ4IndexService categ4IndexService;
	
	@Resource
	private CategoryService catgoryService;
	/**
	 * ��ѯ������Ǩ�еļ۸�ָ�� 
	 */
	@RequestMapping(value="/getCateg4Indices",method=RequestMethod.POST)
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
		List<Categ4Index> categ4Indices = categ4IndexService.getCateg4Indices
				(categName,indexSort,statisYear,statisMonth);
		System.out.println(categ4Indices.size());
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(categ4Indices, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	/*
	 * ��ѯĳ������ļ۸�ָ��
	 */
	@RequestMapping(value="/getCateg4IndicesWithDistrict",method=RequestMethod.POST)
	@ResponseBody
	public Msg getCateg4IndicesWithDistrict(
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
		List<Categ4IndexWithDistrict> categ4Indices = categ4IndexService.getCateg4IndicesWithDistrict
				(categName,indexSort,statisYear,statisMonth,districtId);
		System.out.println(categ4Indices.size());
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(categ4Indices, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	/*
	 * ��ѯĳ������ĳ������ҩ���ָ����Ϣ
	 */
	@RequestMapping(value="/getCateg4IndicesWithPharm",method=RequestMethod.POST)
	@ResponseBody
	public Msg getCateg4IndicesWithPharm(
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
		List<Categ4IndexWithPharm> categ4Indices = categ4IndexService.getCateg4IndicesWithPharm
				(categName,indexSort,statisYear,statisMonth,districtId,drugstoreId);
		System.out.println(categ4Indices.size());
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(categ4Indices, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	@RequestMapping("/toCateg4IndicesDetail")
	public ModelAndView toCateg4IndicesDetail(
			@RequestParam(value = "categId") String categId,
			@RequestParam(value = "pharmId",required=false,defaultValue="") String pharmId,
			@RequestParam(value = "districtId",required=false,defaultValue="") String districtId)
	{
		
		
		String viewName = "indices/categ4_indices_detail";
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
		
		String viewName = "indices/categ4_indices_horizcmp";
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
		List<Categ4Index> categIndex= 
				categ4IndexService.getIndexByIdAndStatisDate(categId,year,month);
		List<Categ4IndexWithDistrict> categIndexWithDis=
				categ4IndexService.getIndexWithDisByIdAndStatisDate(categId,year,month);
		List<Categ4IndexWithPharm> categIndexWithPharm=
				categ4IndexService.getIndexWithPharmByIdAndStatisDate(categId,year,month);
		
		return Msg.success().add("category", category)
				.add("categIndex", categIndex)
				.add("categIndexWithDis", categIndexWithDis)
				.add("categIndexWithPharm", categIndexWithPharm);
	
		
	}
	
	/*
	 * ��t_categ4index�в�ѯ�����е�ĳ��4����������һ���ָ����Ϣ
	 */
	@RequestMapping(value="/getRecentCateg4IndicesById")
	@ResponseBody
	public Msg getRecentCateg4IndicesById(String categId){
		System.out.println("getRecentCateg4IndicesById,categId:"+categId);
		Map<String, Object> map = categ4IndexService.getRecentCateg4IndicesById(categId);
		return Msg.success().add("recentIndices", map);
	
		
	}
	/*
	 * ��t_categ4index_with_district�в�ѯĳ�������ĳ��4����������һ���ָ����Ϣ
	 */
	@RequestMapping(value="/getRecentCateg4IndicesWithDistrictById")
	@ResponseBody
	public Msg getRecentCateg4IndicesWithDistrictById(String categId,String districtId){
		System.out.println("getRecentCateg4IndicesById,categId:"+categId+"districtId:"+districtId);
		Map<String, Object> map = categ4IndexService.getRecentCateg4IndicesWithDistrictById(categId,districtId);
		return Msg.success().add("recentIndices", map);
	
		
	}
	/*
	 * ��t_categ4index_with_district�в�ѯĳ��ҩ���ĳ��4����������һ���ָ����Ϣ
	 */
	@RequestMapping(value="/getRecentCateg4IndicesWithPharmById")
	@ResponseBody
	public Msg getRecentCateg4IndicesWithPharmById(String categId,String pharmId){
		System.out.println("getRecentCateg4IndicesById,categId:"+categId+"pharmId:"+pharmId);
		Map<String, Object> map = categ4IndexService.getRecentCateg4IndicesWithPharmById(categId,pharmId);
		return Msg.success().add("recentIndices", map);
	
		
	}
	

}

