package com.sqc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.sqc.bean.Categ2IndexWithPharm;
import com.sqc.bean.Categ2Index;
import com.sqc.bean.Categ2IndexWithDistrict;

import com.sqc.bean.Category;

import com.sqc.dao.Categ2IndexWithPharmMapper;
import com.sqc.dao.Categ2IndexMapper;
import com.sqc.dao.Categ2IndexWithDistrictMapper;


import com.sqc.dao.CategoryMapper;
import com.sqc.exception.CategNotFoundException;


@Service
public class Categ2IndexService {

	

	@Resource
	Categ2IndexWithPharmMapper categ2IndexWithPharmMapper;
	
	@Resource
	Categ2IndexWithDistrictMapper categ2IndexWithDistrictMapper;
	
	@Resource
	Categ2IndexMapper categ2IndexMapper;
	
	@Resource
	CategoryMapper categoryMapper;
	
	

	/*
	 * ��ѯ������Ǩ�еļ۸�ָ��
	 */
	public List<Categ2Index> getCateg2Indices(String categName, String indexSort, Integer statisYear,
			Integer statisMonth) {
		Map<String, Object> map = new HashMap<String, Object>();
		//�ж����ݸ�ʽ�Ϸ��Բ��ŵ�map��
		
		if(categName!=null&&categName.trim()!=""){
			map.put("categName", categName);
		}

		if(indexSort!=null&&indexSort.trim()!=""){
			map.put("indexSort", indexSort);
			}
			
		map.put("statisYear", statisYear);
		map.put("statisMonth", statisMonth);
		
		
		return categ2IndexMapper.selectByStatisDateWithCategName(map);
		
	}
	
	/*
	 * ��ѯ����ĳ������ļ۸�ָ��
	 */	
	public List<Categ2IndexWithDistrict> getCateg2IndicesWithDistrict(String categName, String indexSort,
			Integer statisYear, Integer statisMonth, String districtId) {
		Map<String, Object> map = new HashMap<String, Object>();
		//�ж����ݸ�ʽ�Ϸ��Բ��ŵ�map��
		
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
			return categ2IndexWithDistrictMapper.selectByStatisDateWithCategNameAndDistrict(map);
		}
		else{
			return null;
		}
	}

	/*
	 * ��ѯĳ������ҩ��ļ۸�ָ��
	 */	
	public List<Categ2IndexWithPharm> getCateg2IndicesWithPharm(String categName, String indexSort, Integer statisYear,
			Integer statisMonth, String districtId, String drugstoreId) {
		Map<String, Object> map = new HashMap<String, Object>();
		//�ж����ݸ�ʽ�Ϸ��Բ��ŵ�map��
		
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
			return categ2IndexWithPharmMapper.selectByStatisDateWithCategNameAndDrugStore(map);
			
		}
		else{
			return null;
		}
		
	}
	/*
	 * ��t_categ4index�в�ѯ�����е�ĳ��4����������һ���ָ����Ϣ
	 */

	public Map<String, Object> getRecentCateg2IndicesById(String categId) {
		if(categId==null||categId.trim()==""){
			throw new CategNotFoundException("categIdΪ��");
		}
		
		Category  category=categoryMapper.selectByPrimaryKey(categId);
	    if(category==null){
			throw new CategNotFoundException("û�и÷���");
	    }
		Map<String,String> map=new HashMap<>();
		map.put("categId", categId);
		

		List<Map<String, Object>> recentCateg2Indices = categ2IndexMapper.selectRecentCateg2IndicesById(map);
			
		System.out.println("services"+recentCateg2Indices.size());
		List<Object> timelist = new ArrayList<Object>();
		List<Object> datalist = new ArrayList<Object>();
		List<Object> datalist1 = new ArrayList<Object>();
		List<Object> datalist2 = new ArrayList<Object>();
		for(int i=0;i<recentCateg2Indices.size();i++){
			timelist.add(recentCateg2Indices.get(i).get("maxtime"));
			if(recentCateg2Indices.get(i).get("baselyindex")==null)
				datalist.add("1");
			else
				datalist.add(recentCateg2Indices.get(i).get("baselyindex").toString());
			if(recentCateg2Indices.get(i).get("monthlyindex")==null)	
				datalist1.add("1");
			else {
				datalist1.add(recentCateg2Indices.get(i).get("monthlyindex").toString());
			}		
			if(recentCateg2Indices.get(i).get("yearlyindex")==null)
					datalist2.add("1");
			else {
				datalist2.add(recentCateg2Indices.get(i).get("yearlyindex").toString());
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
	 * ��t_categ4index_with_district�в�ѯĳ�������ĳ��4����������һ���ָ����Ϣ
	 */
	public Map<String, Object> getRecentCateg2IndicesWithDistrictById(String categId, String districtId) {
		if(categId==null||categId.trim()==""){
			throw new CategNotFoundException("categIdΪ��");
		}
		
		Category  category=categoryMapper.selectByPrimaryKey(categId);
	    if(category==null){
			throw new CategNotFoundException("û�и÷���");
	    }
		Map<String,String> map=new HashMap<>();
		map.put("categId", categId);
		map.put("districtId", districtId);

		List<Map<String, Object>> recentCateg2Indices = categ2IndexWithDistrictMapper.selectRecentCateg2IndicesById(map);
			
		System.out.println("services"+recentCateg2Indices.size());
		List<Object> timelist = new ArrayList<Object>();
		List<Object> datalist = new ArrayList<Object>();
	
		List<Object> datalist1 = new ArrayList<Object>();
		List<Object> datalist2 = new ArrayList<Object>();
		for(int i=0;i<recentCateg2Indices.size();i++){
			timelist.add(recentCateg2Indices.get(i).get("maxtime"));
			if(recentCateg2Indices.get(i).get("baselyindex")==null)
				datalist.add("1");
			else
				datalist.add(recentCateg2Indices.get(i).get("baselyindex").toString());
			if(recentCateg2Indices.get(i).get("monthlyindex")==null)	
				datalist1.add("1");
			else {
				datalist1.add(recentCateg2Indices.get(i).get("monthlyindex").toString());
			}		
			if(recentCateg2Indices.get(i).get("yearlyindex")==null)
					datalist2.add("1");
			else {
				datalist2.add(recentCateg2Indices.get(i).get("yearlyindex").toString());
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
	 * ��t_categ2index_with_district�в�ѯĳ��ҩ���ĳ��3����������һ���ָ����Ϣ
	 */
	public Map<String, Object> getRecentCateg2IndicesWithPharmById(String categId, String pharmId) {
		if(categId==null||categId.trim()==""){
			throw new CategNotFoundException("categIdΪ��");
		}
		
		Category  category=categoryMapper.selectByPrimaryKey(categId);
	    if(category==null){
			throw new CategNotFoundException("û�и÷���");
	    }
		Map<String,String> map=new HashMap<>();
		map.put("categId", categId);
		map.put("pharmId", pharmId);

		List<Map<String, Object>> recentCateg2Indices = categ2IndexWithPharmMapper.selectRecentCateg2IndicesById(map);
			
		System.out.println("services"+recentCateg2Indices.size());
		List<Object> timelist = new ArrayList<Object>();
		List<Object> datalist = new ArrayList<Object>();
		List<Object> datalist1 = new ArrayList<Object>();
		List<Object> datalist2 = new ArrayList<Object>();
		for(int i=0;i<recentCateg2Indices.size();i++){
			timelist.add(recentCateg2Indices.get(i).get("maxtime"));
			if(recentCateg2Indices.get(i).get("baselyindex")==null)
				datalist.add("1");
			else
				datalist.add(recentCateg2Indices.get(i).get("baselyindex").toString());
			if(recentCateg2Indices.get(i).get("monthlyindex")==null)	
				datalist1.add("1");
			else {
				datalist1.add(recentCateg2Indices.get(i).get("monthlyindex").toString());
			}		
			if(recentCateg2Indices.get(i).get("yearlyindex")==null)
					datalist2.add("1");
			else {
				datalist2.add(recentCateg2Indices.get(i).get("yearlyindex").toString());
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

	public List<Categ2Index> getIndexByIdAndStatisDate(String categId, Integer year, Integer month) {
		Map<String, Object> map=new HashMap<>();
		map.put("categId", categId);
		map.put("year", year);
		map.put("month", month);
		
		return categ2IndexMapper.selectByIdAndStatisDate(map);
	}

	public List<Categ2IndexWithDistrict> getIndexWithDisByIdAndStatisDate(String categId, Integer year, Integer month) {
		Map<String, Object> map=new HashMap<>();
		map.put("categId", categId);
		map.put("year", year);
		map.put("month", month);
		
		return categ2IndexWithDistrictMapper.selectByIdAndStatisDate(map);
	}

	public List<Categ2IndexWithPharm> getIndexWithPharmByIdAndStatisDate(String categId, Integer year, Integer month) {
		Map<String, Object> map=new HashMap<>();
		map.put("categId", categId);
		map.put("year", year);
		map.put("month", month);
		
		return categ2IndexWithPharmMapper.selectByIdAndStatisDate(map);
	}

	public List<Categ2IndexWithPharm> getCompareIndex(String categName, Float rise, Float decrease, Integer year,
			Integer month, String classifybymiddleId) {
		Map<String, Object> map=new HashMap<>();
		map.put("categName", categName);
		map.put("rise", rise);
		map.put("decrease", decrease);
		map.put("year", year);
		map.put("month", month);
		map.put("classifybymiddleId", classifybymiddleId);

		return categ2IndexWithPharmMapper.selectCompareIndex(map);
	}

	public List<Categ2IndexWithDistrict> getCompareIndexWithDis(String categName, Float rise, Float decrease,
			Integer year, Integer month, String districtId, String classifybymiddleId) {
		Map<String, Object> map=new HashMap<>();
		map.put("categName", categName);
		map.put("rise", rise);
		map.put("decrease", decrease);
		map.put("year", year);
		map.put("month", month);
		map.put("districtId", districtId);
		map.put("classifybymiddleId", classifybymiddleId);

		return categ2IndexWithDistrictMapper.selectCompareIndexWithDis(map);
		
	}

	public List<Categ2IndexWithPharm> getCompareIndexWithPharam(String categName, Float rise, Float decrease,
			Integer year, Integer month, String districtId, String drugstoreId, String classifybymiddleId) {
		Map<String, Object> map=new HashMap<>();
		map.put("categName", categName);
		map.put("rise", rise);
		map.put("decrease", decrease);
		map.put("year", year);
		map.put("month", month);
		map.put("districtId", districtId);
		map.put("drugstoreId", drugstoreId);
		map.put("classifybymiddleId", classifybymiddleId);

		return categ2IndexWithPharmMapper.selectCompareIndexWithPharam(map);
	}

	

}
