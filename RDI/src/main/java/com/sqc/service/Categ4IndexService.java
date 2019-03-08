package com.sqc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sqc.bean.Categ4Index;
import com.sqc.bean.Categ4IndexWithDistrict;
import com.sqc.bean.Categ4IndexWithPharm;
import com.sqc.bean.Category;
import com.sqc.bean.DrugIndexWithPharm;
import com.sqc.dao.Categ4IndexMapper;
import com.sqc.dao.Categ4IndexWithDistrictMapper;
import com.sqc.dao.Categ4IndexWithPharmMapper;
import com.sqc.dao.CategoryMapper;
import com.sqc.exception.CategNotFoundException;


@Service
public class Categ4IndexService {

	@Resource
	Categ4IndexWithPharmMapper categ4IndexWithPharmMapper;
	
	@Resource
	Categ4IndexWithDistrictMapper categ4IndexWithDistrictMapper;
	
	@Resource
	Categ4IndexMapper categ4IndexMapper;
	
	@Resource
	CategoryMapper categoryMapper;
	
	

	/*
	 * ��ѯ������Ǩ�еļ۸�ָ��
	 */
	public List<Categ4Index> getCateg4Indices(String categName, String indexSort, Integer statisYear,
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
		
		
		return categ4IndexMapper.selectByStatisDateWithCategName(map);
		
	}
	
	/*
	 * ��ѯ����ĳ������ļ۸�ָ��
	 */	
	public List<Categ4IndexWithDistrict> getCateg4IndicesWithDistrict(String categName, String indexSort,
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
			return categ4IndexWithDistrictMapper.selectByStatisDateWithCategNameAndDistrict(map);
		}
		else{
			return null;
		}
	}

	/*
	 * ��ѯĳ������ҩ��ļ۸�ָ��
	 */	
	public List<Categ4IndexWithPharm> getCateg4IndicesWithPharm(String categName, String indexSort, Integer statisYear,
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
			return categ4IndexWithPharmMapper.selectByStatisDateWithCategNameAndDrugStore(map);
			
		}
		else{
			return null;
		}
		
	}
	/*
	 * ��t_categ4index�в�ѯ�����е�ĳ��4����������һ���ָ����Ϣ
	 */

	public Map<String, Object> getRecentCateg4IndicesById(String categId) {
		if(categId==null||categId.trim()==""){
			throw new CategNotFoundException("categIdΪ��");
		}
		
		Category  category=categoryMapper.selectByPrimaryKey(categId);
	    if(category==null){
			throw new CategNotFoundException("û�и÷���");
	    }
		Map<String,String> map=new HashMap<>();
		map.put("categId", categId);
		

		List<Map<String, Object>> recentCateg4Indices = categ4IndexMapper.selectRecentCateg4IndicesById(map);
			
		System.out.println("services"+recentCateg4Indices.size());
		List<Object> timelist = new ArrayList<Object>();
		List<Object> datalist = new ArrayList<Object>();
		List<Object> datalist1 = new ArrayList<Object>();
		List<Object> datalist2 = new ArrayList<Object>();
		for(int i=0;i<recentCateg4Indices.size();i++){
			timelist.add(recentCateg4Indices.get(i).get("maxtime"));
			if(recentCateg4Indices.get(i).get("baselyindex")==null)
				datalist.add("1");
			else
				datalist.add(recentCateg4Indices.get(i).get("baselyindex").toString());
			if(recentCateg4Indices.get(i).get("monthlyindex")==null)	
				datalist1.add("1");
			else {
				datalist1.add(recentCateg4Indices.get(i).get("monthlyindex").toString());
			}		
			if(recentCateg4Indices.get(i).get("yearlyindex")==null)
					datalist2.add("1");
			else {
				datalist2.add(recentCateg4Indices.get(i).get("yearlyindex").toString());
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
	public Map<String, Object> getRecentCateg4IndicesWithDistrictById(String categId, String districtId) {
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

		List<Map<String, Object>> recentCateg4Indices = categ4IndexWithDistrictMapper.selectRecentCateg4IndicesById(map);
			
		System.out.println("services"+recentCateg4Indices.size());
		List<Object> timelist = new ArrayList<Object>();
		List<Object> datalist = new ArrayList<Object>();
	
		List<Object> datalist1 = new ArrayList<Object>();
		List<Object> datalist2 = new ArrayList<Object>();
		for(int i=0;i<recentCateg4Indices.size();i++){
			timelist.add(recentCateg4Indices.get(i).get("maxtime"));
			if(recentCateg4Indices.get(i).get("baselyindex")==null)
				datalist.add("1");
			else
				datalist.add(recentCateg4Indices.get(i).get("baselyindex").toString());
			if(recentCateg4Indices.get(i).get("monthlyindex")==null)	
				datalist1.add("1");
			else {
				datalist1.add(recentCateg4Indices.get(i).get("monthlyindex").toString());
			}		
			if(recentCateg4Indices.get(i).get("yearlyindex")==null)
					datalist2.add("1");
			else {
				datalist2.add(recentCateg4Indices.get(i).get("yearlyindex").toString());
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
	 * ��t_categ4index_with_district�в�ѯĳ��ҩ���ĳ��4����������һ���ָ����Ϣ
	 */
	public Map<String, Object> getRecentCateg4IndicesWithPharmById(String categId, String pharmId) {
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

		List<Map<String, Object>> recentCateg4Indices = categ4IndexWithPharmMapper.selectRecentCateg4IndicesById(map);
			
		System.out.println("services"+recentCateg4Indices.size());
		List<Object> timelist = new ArrayList<Object>();
		List<Object> datalist = new ArrayList<Object>();
		List<Object> datalist1 = new ArrayList<Object>();
		List<Object> datalist2 = new ArrayList<Object>();
		for(int i=0;i<recentCateg4Indices.size();i++){
			timelist.add(recentCateg4Indices.get(i).get("maxtime"));
			if(recentCateg4Indices.get(i).get("baselyindex")==null)
				datalist.add("1");
			else
				datalist.add(recentCateg4Indices.get(i).get("baselyindex").toString());
			if(recentCateg4Indices.get(i).get("monthlyindex")==null)	
				datalist1.add("1");
			else {
				datalist1.add(recentCateg4Indices.get(i).get("monthlyindex").toString());
			}		
			if(recentCateg4Indices.get(i).get("yearlyindex")==null)
					datalist2.add("1");
			else {
				datalist2.add(recentCateg4Indices.get(i).get("yearlyindex").toString());
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



	public List<Categ4Index> getIndexByIdAndStatisDate(String categId, Integer year, Integer month) {
		Map<String, Object> map=new HashMap<>();
		map.put("categId", categId);
		map.put("year", year);
		map.put("month", month);
		
		return categ4IndexMapper.selectByIdAndStatisDate(map);
	}

	public List<Categ4IndexWithDistrict> getIndexWithDisByIdAndStatisDate(String categId, Integer year, Integer month) {
		Map<String, Object> map=new HashMap<>();
		map.put("categId", categId);
		map.put("year", year);
		map.put("month", month);
		
		return categ4IndexWithDistrictMapper.selectByIdAndStatisDate(map);
	}

	public List<Categ4IndexWithPharm> getIndexWithPharmByIdAndStatisDate(String categId, Integer year, Integer month) {
		Map<String, Object> map=new HashMap<>();
		map.put("categId", categId);
		map.put("year", year);
		map.put("month", month);
		
		return categ4IndexWithPharmMapper.selectByIdAndStatisDate(map);
	}
/*
	public List<Categ4IndexWithPharm> getCompareIndexByIdAndStatisDate(String categName, Integer year, Integer month) {
		Map<String, Object> map=new HashMap<>();
		map.put("categName", categName);
		map.put("year", year);
		map.put("month", month);
		
		return categ4IndexWithPharmMapper.selectCompareIndexByIdAndStatisDate(map);
	}
*/
	
	public List<Categ4IndexWithPharm> getCompareIndex(String categName, Float rise, Float decrease, Integer year,
			Integer month, String classifybykindsId) {
		Map<String, Object> map=new HashMap<>();
		map.put("categName", categName);
		map.put("rise", rise);
		map.put("decrease", decrease);
		map.put("year", year);
		map.put("month", month);
		map.put("classifybykindsId", classifybykindsId);

		return categ4IndexWithPharmMapper.selectCompareIndex(map);
	}

	public List<Categ4IndexWithDistrict> getCompareIndexWithDis(String categName, Float rise, Float decrease, Integer year,
			Integer month, String districtId, String classifybykindsId) {
		Map<String, Object> map=new HashMap<>();
		map.put("categName", categName);
		map.put("rise", rise);
		map.put("decrease", decrease);
		map.put("year", year);
		map.put("month", month);
		map.put("districtId", districtId);
		map.put("classifybykindsId", classifybykindsId);
		return categ4IndexWithDistrictMapper.selectCompareIndexWithDis(map);
	}

	public List<Categ4IndexWithPharm> getCompareIndexWithPharam(String categName, Float rise, Float decrease,
			Integer year, Integer month, String districtId, String drugstoreId, String classifybykindsId) {
		Map<String, Object> map=new HashMap<>();
		map.put("categName", categName);
		map.put("rise", rise);
		map.put("decrease", decrease);
		map.put("year", year);
		map.put("month", month);
		map.put("districtId", districtId);
		map.put("drugstoreId", drugstoreId);
		map.put("classifybykindsId", classifybykindsId);

		return categ4IndexWithPharmMapper.selectCompareIndexWithPharam(map);
	}

	/*public List<Categ4IndexWithPharm> getClassify(String drugstoreId) {
		Map<String, Object> map=new HashMap<>();
		map.put("drugstoreId", drugstoreId);
		
		return categ4IndexWithPharmMapper.selectClassify(map);
	}
*/
	public List<Categ4IndexWithPharm> getCompareIndexWithKinds(String categName, Float rise, Float decrease,
			Integer year, Integer month, String classifybykindsId) {
		Map<String, Object> map=new HashMap<>();
		map.put("categName", categName);
		map.put("rise", rise);
		map.put("decrease", decrease);
		map.put("year", year);
		map.put("month", month);
		map.put("classifybykindsId", classifybykindsId);
		return categ4IndexWithPharmMapper.selectCompareIndexWithKinds(map);
	}



}
