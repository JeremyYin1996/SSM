package com.sqc.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sqc.bean.Drug;
import com.sqc.bean.DrugIndex;
import com.sqc.bean.DrugIndexExample;
import com.sqc.bean.DrugIndexExample.Criteria;
import com.sqc.bean.DrugIndexWithDistrict;
import com.sqc.bean.DrugIndexWithDistrictExample;
import com.sqc.bean.DrugIndexWithPharm;
import com.sqc.bean.DrugIndexWithPharmExample;
import com.sqc.dao.DrugIndexMapper;
import com.sqc.dao.DrugIndexWithDistrictMapper;
import com.sqc.dao.DrugIndexWithPharmMapper;
import com.sqc.dao.DrugMapper;
import com.sqc.exception.DrugNotFoundException;

@Service
public class DrugIndexService {
	
	@Resource
	DrugIndexMapper drugIndexMapper;
	
	@Resource
	DrugIndexWithDistrictMapper drugIndexWithDistrictMapper;
	
	@Resource
	DrugIndexWithPharmMapper drugIndexWithPharmMapper;
	
	@Resource
	DrugMapper drugMapper;

	/*
	 * 统计整个市的药品指数信息
	 */

	public List<DrugIndex> getDrugIndices(String drugName, String indexSort, Integer statisYear, Integer statisMonth) {
		Map<String, Object> map = new HashMap<String, Object>();
		//判断数据格式合法性并放到map中
		
		if(drugName!=null&&drugName.trim()!=""){
			map.put("drugName", drugName);
		}

		if(indexSort!=null&&indexSort.trim()!=""){
			map.put("indexSort", indexSort);
			}
			
		map.put("statisYear", statisYear);
		map.put("statisMonth", statisMonth);
		return drugIndexMapper.selectByStatisDateWithDrugName(map);
	}

	/*
	 * 统计某个区的药品指数信息
	 */
	public List<DrugIndex> getDrugIndicesWithDistrict(String drugName, String indexSort, Integer statisYear,
			Integer statisMonth, String districtId) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(drugName!=null&&drugName.trim()!=""){
			map.put("drugName", drugName);
		}

		if(indexSort!=null&&indexSort.trim()!=""){
			map.put("indexSort", indexSort);
			}
			
		map.put("statisYear", statisYear);
		map.put("statisMonth", statisMonth);
		if(districtId!=null&&districtId.trim()!=""){
			map.put("districtId", districtId);
			return drugIndexWithDistrictMapper.selectByStatisDateWithDrugNameAndDistrict(map);
		}
		else{
			return null;
		}
	}
	/*
	 * 统计某个区某家药店的药品指数信息
	 */

	public List<DrugIndex> getDrugIndicesWithPharm(String drugName, String indexSort, Integer statisYear,
			Integer statisMonth, String districtId, String pharmId) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(drugName!=null&&drugName.trim()!=""){
			map.put("drugName", drugName);
		}

		if(indexSort!=null&&indexSort.trim()!=""){
			map.put("indexSort", indexSort);
			}
			
		map.put("statisYear", statisYear);
		map.put("statisMonth", statisMonth);
		if(districtId!=null&&districtId.trim()!=""){
			map.put("districtId", districtId);
		}
		if(pharmId!=null&&pharmId.trim()!=""){
			map.put("pharmId", pharmId);
			return drugIndexWithPharmMapper.selectByStatisDateWithDrugNameAndPharm(map);
			
		}
		else{
			return null;
		}
	}


	/*
	 * 从t_drugindex中查询整个市的某个药品的最近一年的指数信息
	 */
	
	public Map<String, Object> getRecentDrugIndicesById(String drugId) {
		
		System.out.println("Service:getRecentDrugIndicesById,drugId:"+drugId);
		if(drugId==null||drugId.trim()==""){
			throw new DrugNotFoundException("drugId为空");
		}
		
		
	    Drug drug=drugMapper.selectByPrimaryKey(drugId);
	    if(drug==null){
			throw new DrugNotFoundException("查无此药");
	}

		List<Map<String, Object>> recentIndices = drugIndexMapper.selectRecentIndicesById(drugId);
			
		System.out.println("services"+recentIndices);
		List<Object> timelist = new ArrayList<Object>();
		List<Object> datalist = new ArrayList<Object>();
		List<Object> datalist1 = new ArrayList<Object>();
		List<Object> datalist2 = new ArrayList<Object>();
		for(int i=0;i<recentIndices.size();i++){
			timelist.add(recentIndices.get(i).get("maxtime"));
			if(recentIndices.get(i).get("baselyindex")==null)
				datalist.add("1");
			else{
				datalist.add(recentIndices.get(i).get("baselyindex").toString());
			}
			
			if(recentIndices.get(i).get("monthlyindex")==null)
				datalist1.add("1");
			else{
				datalist1.add(recentIndices.get(i).get("monthlyindex").toString());
			}
			
			if(recentIndices.get(i).get("yearlyindex")==null)
				datalist2.add("1");
			else{
				datalist2.add(recentIndices.get(i).get("yearlyindex").toString());
			}
		}
		Map<String,Object> dataMap = new HashMap<String, Object>();
		Map<String,Object> dataMap1 = new HashMap<String, Object>();
		Map<String,Object> dataMap2 = new HashMap<String, Object>();
		Map<String,Object> resultMap = new HashMap<String, Object>();
		
		dataMap.put("name", drug.getDrugName());
		dataMap.put("data", datalist);
		
		dataMap1.put("name", drug.getDrugName());
		dataMap1.put("data", datalist1);
		
		dataMap2.put("name", drug.getDrugName());
		dataMap2.put("data", datalist2);
		
		resultMap.put("xdata", timelist);
		resultMap.put("dataMap", dataMap);
		resultMap.put("dataMap1", dataMap1);
		resultMap.put("dataMap2", dataMap2);
		System.out.println("resultMap:"+resultMap);
		return resultMap;
	}


	/*
	 * 从t_drugindex_with_district中查询某个区域的某个药品的最近一年的指数信息
	 */
	public Map<String, Object> getRecentDrugIndicesWithDistrictById(String drugId, String districtId) {
		if(drugId==null||drugId.trim()==""){
			throw new DrugNotFoundException("drugId为空");
		}
		
		
	    Drug drug=drugMapper.selectByPrimaryKey(drugId);
	    if(drug==null){
			throw new DrugNotFoundException("查无此药");
	  }
	    
	    Map<String,String> map=new HashMap<>();
		map.put("drugId", drugId);
		map.put("districtId", districtId);

		List<Map<String, Object>> recentIndices = drugIndexWithDistrictMapper.selectRecentIndicesById(map);
			
		System.out.println("services"+recentIndices);
		List<Object> timelist = new ArrayList<Object>();
		List<Object> datalist = new ArrayList<Object>();
		List<Object> datalist1 = new ArrayList<Object>();
		List<Object> datalist2 = new ArrayList<Object>();
		for(int i=0;i<recentIndices.size();i++){
			timelist.add(recentIndices.get(i).get("maxtime"));
			if(recentIndices.get(i).get("baselyindex")==null)
				datalist.add("1");
			else{
				datalist.add(recentIndices.get(i).get("baselyindex").toString());
			}
			
			if(recentIndices.get(i).get("monthlyindex")==null)
				datalist1.add("1");
			else{
				datalist1.add(recentIndices.get(i).get("monthlyindex").toString());
			}
			
			if(recentIndices.get(i).get("yearlyindex")==null)
				datalist2.add("1");
			else{
				datalist2.add(recentIndices.get(i).get("yearlyindex").toString());
			}
		}
		Map<String,Object> dataMap = new HashMap<String, Object>();
		Map<String,Object> dataMap1 = new HashMap<String, Object>();
		Map<String,Object> dataMap2 = new HashMap<String, Object>();
		Map<String,Object> resultMap = new HashMap<String, Object>();
		
		dataMap.put("name", drug.getDrugName());
		dataMap.put("data", datalist);
		
		dataMap1.put("name", drug.getDrugName());
		dataMap1.put("data", datalist1);
		
		dataMap2.put("name", drug.getDrugName());
		dataMap2.put("data", datalist2);
		
		resultMap.put("xdata", timelist);
		resultMap.put("dataMap", dataMap);
		resultMap.put("dataMap1", dataMap1);
		resultMap.put("dataMap2", dataMap2);
		System.out.println("resultMap:"+resultMap);
		return resultMap;
	}


	/*
	 * 从t_drugindex_with_district中查询某个药店的某个药品的最近一年的指数信息
	 */
	public Map<String, Object> getRecentDrugIndicesWithPharmById(String drugId, String pharmId) {
		if(drugId==null||drugId.trim()==""){
			throw new DrugNotFoundException("drugId为空");
		}
		
		
	    Drug drug=drugMapper.selectByPrimaryKey(drugId);
	    if(drug==null){
			throw new DrugNotFoundException("查无此药");
	}
	    Map<String,String> map=new HashMap<>();
		map.put("drugId", drugId);
		map.put("pharmId", pharmId);


		List<Map<String, Object>> recentIndices = drugIndexWithPharmMapper.selectRecentIndicesById(map);
			
		System.out.println("services"+recentIndices);
		List<Object> timelist = new ArrayList<Object>();
		List<Object> datalist = new ArrayList<Object>();
		List<Object> datalist1 = new ArrayList<Object>();
		List<Object> datalist2 = new ArrayList<Object>();
		for(int i=0;i<recentIndices.size();i++){
			timelist.add(recentIndices.get(i).get("maxtime"));
			if(recentIndices.get(i).get("baselyindex")==null)
				datalist.add("1");
			else{
				datalist.add(recentIndices.get(i).get("baselyindex").toString());
			}
			
			if(recentIndices.get(i).get("monthlyindex")==null)
				datalist1.add("1");
			else{
				datalist1.add(recentIndices.get(i).get("monthlyindex").toString());
			}
			
			if(recentIndices.get(i).get("yearlyindex")==null)
				datalist2.add("1");
			else{
				datalist2.add(recentIndices.get(i).get("yearlyindex").toString());
			}
		}
		Map<String,Object> dataMap = new HashMap<String, Object>();
		Map<String,Object> dataMap1 = new HashMap<String, Object>();
		Map<String,Object> dataMap2 = new HashMap<String, Object>();
		Map<String,Object> resultMap = new HashMap<String, Object>();
		
		dataMap.put("name", drug.getDrugName());
		dataMap.put("data", datalist);
		
		dataMap1.put("name", drug.getDrugName());
		dataMap1.put("data", datalist1);
		
		dataMap2.put("name", drug.getDrugName());
		dataMap2.put("data", datalist2);
		
		resultMap.put("xdata", timelist);
		resultMap.put("dataMap", dataMap);
		resultMap.put("dataMap1", dataMap1);
		resultMap.put("dataMap2", dataMap2);
		
		System.out.println("resultMap:"+resultMap);
		return resultMap;
	}


	public List<DrugIndex> getIndexByIdAndStatisDate(String drugId, 
			Integer year,Integer month) {
		Map<String, Object> map=new HashMap<>();
		map.put("drugId", drugId);
		map.put("year", year);
		map.put("month", month);
		
		return drugIndexMapper.selectByIdAndStatisDate(map);
		
	}


	public List<DrugIndexWithDistrict> getIndexWithDisByIdAndStatisDate(String drugId, 
			Integer year,Integer month) {
		
		Map<String, Object> map=new HashMap<>();
		map.put("drugId", drugId);
		map.put("year", year);
		map.put("month", month);
		return drugIndexWithDistrictMapper.selectByIdAndStatisDate(map);
		
	}


	public List<DrugIndexWithPharm> getIndexWithPharmByIdAndStatisDate(String drugId, 
			Integer year,Integer month) {
		Map<String, Object> map=new HashMap<>();
		map.put("drugId", drugId);
		map.put("year", year);
		map.put("month", month);
		return drugIndexWithPharmMapper.selectByIdAndStatisDate(map);
	}
}
