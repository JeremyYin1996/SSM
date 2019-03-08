package com.sqc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sqc.bean.Categ1IndexWithPharm;

import com.sqc.bean.Categ1Index;
import com.sqc.bean.Categ1IndexWithDistrict;


import com.sqc.bean.Category;
import com.sqc.dao.Categ1IndexWithPharmMapper;

import com.sqc.dao.Categ1IndexMapper;
import com.sqc.dao.Categ1IndexWithDistrictMapper;

import com.sqc.dao.CategoryMapper;
import com.sqc.exception.CategNotFoundException;


@Service
public class Categ1IndexService {



	@Resource
	Categ1IndexWithPharmMapper categ1IndexWithPharmMapper;
	
	@Resource
	Categ1IndexWithDistrictMapper categ1IndexWithDistrictMapper;
	
	@Resource
	Categ1IndexMapper categ1IndexMapper;
	
	@Resource
	CategoryMapper categoryMapper;
	
	

	/*
	 * 查询整个宿迁市的价格指数
	 */
	public List<Categ1Index> getCateg1Indices(String categName, String indexSort, Integer statisYear,
			Integer statisMonth) {
		Map<String, Object> map = new HashMap<String, Object>();
		//判断数据格式合法性并放到map中
		
		if(categName!=null&&categName.trim()!=""){
			map.put("categName", categName);
		}

		if(indexSort!=null&&indexSort.trim()!=""){
			map.put("indexSort", indexSort);
			}
			
		map.put("statisYear", statisYear);
		map.put("statisMonth", statisMonth);
		
		
		return categ1IndexMapper.selectByStatisDateWithCategName(map);
		
	}
	
	/*
	 * 查询整个某个区域的价格指数
	 */	
	public List<Categ1IndexWithDistrict> getCateg1IndicesWithDistrict(String categName, String indexSort,
			Integer statisYear, Integer statisMonth, String districtId) {
		Map<String, Object> map = new HashMap<String, Object>();
		//判断数据格式合法性并放到map中
		
		if(categName!=null&&categName.trim()!=""){
			map.put("categName", categName);
		}

		if(indexSort!=null&&indexSort.trim()!=""){
			map.put("indexSort", indexSort);
			}
			
		map.put("statisYear", statisYear);
		map.put("statisMonth", statisMonth);
		
		if(districtId!=null&&districtId.trim()!=""){
			map.put("districtId", districtId);
			return categ1IndexWithDistrictMapper.selectByStatisDateWithCategNameAndDistrict(map);
		}
		else{
			return null;
		}
	}

	/*
	 * 查询某个具体药店的价格指数
	 */	
	public List<Categ1IndexWithPharm> getCateg1IndicesWithPharm(String categName, String indexSort, Integer statisYear,
			Integer statisMonth, String districtId, String drugstoreId) {
		Map<String, Object> map = new HashMap<String, Object>();
		//判断数据格式合法性并放到map中
		
		if(categName!=null&&categName.trim()!=""){
			map.put("categName", categName);
		}

		if(indexSort!=null&&indexSort.trim()!=""){
			map.put("indexSort", indexSort);
			}
			
		map.put("statisYear", statisYear);
		map.put("statisMonth", statisMonth);
		
		if(districtId!=null&&districtId.trim()!=""){
			map.put("districtId", districtId);
		}
		if(drugstoreId!=null&&drugstoreId.trim()!=""){
			map.put("drugstoreId", drugstoreId);
			return categ1IndexWithPharmMapper.selectByStatisDateWithCategNameAndDrugStore(map);
			
		}
		else{
			return null;
		}
		
	}
	/*
	 * 从t_categ4index中查询整个市的某个4级分类的最近一年的指数信息
	 */

	public Map<String, Object> getRecentCateg1IndicesById(String categId) {
		if(categId==null||categId.trim()==""){
			throw new CategNotFoundException("categId为空");
		}
		
		Category  category=categoryMapper.selectByPrimaryKey(categId);
	    if(category==null){
			throw new CategNotFoundException("没有该分类");
	    }
		Map<String,String> map=new HashMap<>();
		map.put("categId", categId);
		

		List<Map<String, Object>> recentCateg1Indices = categ1IndexMapper.selectRecentCateg1IndicesById(map);
			
		System.out.println("services"+recentCateg1Indices.size());
		List<Object> timelist = new ArrayList<Object>();
		List<Object> datalist = new ArrayList<Object>();
		List<Object> datalist1 = new ArrayList<Object>();
		List<Object> datalist2 = new ArrayList<Object>();
		for(int i=0;i<recentCateg1Indices.size();i++){
			timelist.add(recentCateg1Indices.get(i).get("maxtime"));
			if(recentCateg1Indices.get(i).get("baselyindex")==null)
				datalist.add("1");
			else
				datalist.add(recentCateg1Indices.get(i).get("baselyindex").toString());
			if(recentCateg1Indices.get(i).get("monthlyindex")==null)	
				datalist1.add("1");
			else {
				datalist1.add(recentCateg1Indices.get(i).get("monthlyindex").toString());
			}		
			if(recentCateg1Indices.get(i).get("yearlyindex")==null)
					datalist2.add("1");
			else {
				datalist2.add(recentCateg1Indices.get(i).get("yearlyindex").toString());
			}
			
		
		}
		Map<String,Object> dataMap = new HashMap<String, Object>();
		Map<String,Object> dataMap1 = new HashMap<String, Object>();
		Map<String,Object> dataMap2 = new HashMap<String, Object>();
		Map<String,Object> resultMap = new HashMap<String, Object>();
		
		dataMap.put("name", category.getCategName());
		dataMap.put("data", datalist);
		dataMap1.put("name", category.getCategName());
		dataMap1.put("data", datalist1);
		
		dataMap2.put("name", category.getCategName());
		dataMap2.put("data", datalist2);
		
		resultMap.put("xdata", timelist);
		resultMap.put("dataMap", dataMap);
		resultMap.put("dataMap1", dataMap1);
		resultMap.put("dataMap2", dataMap2);
		System.out.println("resultMap:"+resultMap);
		return resultMap;
	}
	/*
	 * 从t_categ4index_with_district中查询某个区域的某个4级分类的最近一年的指数信息
	 */
	public Map<String, Object> getRecentCateg1IndicesWithDistrictById(String categId, String districtId) {
		if(categId==null||categId.trim()==""){
			throw new CategNotFoundException("categId为空");
		}
		
		Category  category=categoryMapper.selectByPrimaryKey(categId);
	    if(category==null){
			throw new CategNotFoundException("没有该分类");
	    }
		Map<String,String> map=new HashMap<>();
		map.put("categId", categId);
		map.put("districtId", districtId);

		List<Map<String, Object>> recentCateg1Indices = categ1IndexWithDistrictMapper.selectRecentCateg1IndicesById(map);
			
		System.out.println("services"+recentCateg1Indices.size());
		List<Object> timelist = new ArrayList<Object>();
		List<Object> datalist = new ArrayList<Object>();
	
		List<Object> datalist1 = new ArrayList<Object>();
		List<Object> datalist2 = new ArrayList<Object>();
		for(int i=0;i<recentCateg1Indices.size();i++){
			timelist.add(recentCateg1Indices.get(i).get("maxtime"));
			if(recentCateg1Indices.get(i).get("baselyindex")==null)
				datalist.add("1");
			else
				datalist.add(recentCateg1Indices.get(i).get("baselyindex").toString());
			if(recentCateg1Indices.get(i).get("monthlyindex")==null)	
				datalist1.add("1");
			else {
				datalist1.add(recentCateg1Indices.get(i).get("monthlyindex").toString());
			}		
			if(recentCateg1Indices.get(i).get("yearlyindex")==null)
					datalist2.add("1");
			else {
				datalist2.add(recentCateg1Indices.get(i).get("yearlyindex").toString());
			}
			
		
		}
		Map<String,Object> dataMap = new HashMap<String, Object>();
		Map<String,Object> dataMap1 = new HashMap<String, Object>();
		Map<String,Object> dataMap2 = new HashMap<String, Object>();
		Map<String,Object> resultMap = new HashMap<String, Object>();
		
		dataMap.put("name", category.getCategName());
		dataMap.put("data", datalist);
		dataMap1.put("name", category.getCategName());
		dataMap1.put("data", datalist1);
		
		dataMap2.put("name", category.getCategName());
		dataMap2.put("data", datalist2);
		
		resultMap.put("xdata", timelist);
		resultMap.put("dataMap", dataMap);
		resultMap.put("dataMap1", dataMap1);
		resultMap.put("dataMap2", dataMap2);
		System.out.println("resultMap:"+resultMap);
		return resultMap;
	}
	/*
	 * 从t_categ1index_with_district中查询某个药店的某个3级分类的最近一年的指数信息
	 */
	public Map<String, Object> getRecentCateg1IndicesWithPharmById(String categId, String pharmId) {
		if(categId==null||categId.trim()==""){
			throw new CategNotFoundException("categId为空");
		}
		
		Category  category=categoryMapper.selectByPrimaryKey(categId);
	    if(category==null){
			throw new CategNotFoundException("没有该分类");
	    }
		Map<String,String> map=new HashMap<>();
		map.put("categId", categId);
		map.put("pharmId", pharmId);

		List<Map<String, Object>> recentCateg1Indices = categ1IndexWithPharmMapper.selectRecentCateg1IndicesById(map);
			
		System.out.println("services"+recentCateg1Indices.size());
		List<Object> timelist = new ArrayList<Object>();
		List<Object> datalist = new ArrayList<Object>();
		List<Object> datalist1 = new ArrayList<Object>();
		List<Object> datalist2 = new ArrayList<Object>();
		for(int i=0;i<recentCateg1Indices.size();i++){
			timelist.add(recentCateg1Indices.get(i).get("maxtime"));
			if(recentCateg1Indices.get(i).get("baselyindex")==null)
				datalist.add("1");
			else
				datalist.add(recentCateg1Indices.get(i).get("baselyindex").toString());
			if(recentCateg1Indices.get(i).get("monthlyindex")==null)	
				datalist1.add("1");
			else {
				datalist1.add(recentCateg1Indices.get(i).get("monthlyindex").toString());
			}		
			if(recentCateg1Indices.get(i).get("yearlyindex")==null)
					datalist2.add("1");
			else {
				datalist2.add(recentCateg1Indices.get(i).get("yearlyindex").toString());
			}
			
		
		}
		Map<String,Object> dataMap = new HashMap<String, Object>();
		Map<String,Object> dataMap1 = new HashMap<String, Object>();
		Map<String,Object> dataMap2 = new HashMap<String, Object>();
		Map<String,Object> resultMap = new HashMap<String, Object>();
		
		dataMap.put("name", category.getCategName());
		dataMap.put("data", datalist);
		
		dataMap1.put("name", category.getCategName());
		dataMap1.put("data", datalist1);
		
		dataMap2.put("name", category.getCategName());
		dataMap2.put("data", datalist2);
		
		resultMap.put("xdata", timelist);
		resultMap.put("dataMap", dataMap);
		resultMap.put("dataMap1", dataMap1);
		resultMap.put("dataMap2", dataMap2);
		System.out.println("resultMap:"+resultMap);
		return resultMap;
	}

	public List<Categ1Index> getIndexByIdAndStatisDate(String categId, Integer year, Integer month) {
		Map<String, Object> map=new HashMap<>();
		map.put("categId", categId);
		map.put("year", year);
		map.put("month", month);
		
		return categ1IndexMapper.selectByIdAndStatisDate(map);
	}

	public List<Categ1IndexWithDistrict> getIndexWithDisByIdAndStatisDate(String categId, Integer year, Integer month) {
		Map<String, Object> map=new HashMap<>();
		map.put("categId", categId);
		map.put("year", year);
		map.put("month", month);
		
		return categ1IndexWithDistrictMapper.selectByIdAndStatisDate(map);
	}

	public List<Categ1IndexWithPharm> getIndexWithPharmByIdAndStatisDate(String categId, Integer year, Integer month) {
		Map<String, Object> map=new HashMap<>();
		map.put("categId", categId);
		map.put("year", year);
		map.put("month", month);
		
		return categ1IndexWithPharmMapper.selectByIdAndStatisDate(map);
	}

	public List<Categ1IndexWithPharm> getCompareIndex(String categName, Float rise, Float decrease, Integer year,
			Integer month, String classifybylargeId) {
		Map<String, Object> map=new HashMap<>();
		map.put("categName", categName);
		map.put("rise", rise);
		map.put("decrease", decrease);
		map.put("year", year);
		map.put("month", month);
		map.put("classifybylargeId", classifybylargeId);

		return categ1IndexWithPharmMapper.selectCompareIndex(map);
	}

	public List<Categ1IndexWithDistrict> getCompareIndexWithDis(String categName, Float rise, Float decrease,
			Integer year, Integer month, String districtId, String classifybylargeId) {
		Map<String, Object> map=new HashMap<>();
		map.put("categName", categName);
		map.put("rise", rise);
		map.put("decrease", decrease);
		map.put("year", year);
		map.put("month", month);
		map.put("districtId", districtId);
		map.put("classifybylargeId", classifybylargeId);

		return categ1IndexWithDistrictMapper.selectCompareIndexWithDis(map);
	}

	public List<Categ1IndexWithPharm> getCompareIndexWithPharam(String categName, Float rise, Float decrease,
			Integer year, Integer month, String districtId, String drugstoreId, String classifybylargeId) {
		Map<String, Object> map=new HashMap<>();
		map.put("categName", categName);
		map.put("rise", rise);
		map.put("decrease", decrease);
		map.put("year", year);
		map.put("month", month);
		map.put("districtId", districtId);
		map.put("drugstoreId", drugstoreId);
		map.put("classifybylargeId", classifybylargeId);

		return categ1IndexWithPharmMapper.selectCompareIndexWithPharam(map);
	}




}
