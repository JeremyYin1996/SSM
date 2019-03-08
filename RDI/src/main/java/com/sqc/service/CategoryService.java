package com.sqc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import com.sqc.bean.Category;
import com.sqc.bean.CategoryExample;
import com.sqc.bean.CategoryExample.Criteria;
import com.sqc.bean.Drug;
import com.sqc.dao.CategoryMapper;




@Service
public class CategoryService {
	
	@Resource
	CategoryMapper categoryMapper;

	public List<Category> getCategoriesByNameAndLevel(String categName, String categLevel) {
       
		
		if(categLevel.equals("1"))
		{
			CategoryExample example=null;
			if(categName!=null && categName.trim()!=""|| categLevel!=null && categLevel.trim()!="")
			{
				example=new CategoryExample();
				Criteria criteria=example.createCriteria();
				if(categName!=null && categName.trim()!="")
					criteria.andCategNameLike("%"+categName+"%");
				if(categLevel!=null && categLevel.trim()!="")
					criteria.andLevelEqualTo(categLevel);				
			}
			return categoryMapper.selectByExample(example);
			
		}
		else
		{
			Map<String, String> map = new HashMap<String, String>();
			//判断数据格式合法性并放到map中
			if(categName!=null && categName.trim()!=""){
				map.put("categName", categName);
			}
			if(categLevel!=null && categLevel.trim()!=""){
				System.out.println("categLevel:"+categLevel+" ");
				map.put("categLevel", categLevel);
			}
		    return categoryMapper.selectByLevelAssociationWithSelf(map);
			
		}
			
	}

	public Category getCategDetailById(String categId) {
		
		return categoryMapper.selectByPrimaryKey(categId);
	}
	
	
	public List<Category> getCategoriesByParentId(String parentId) {
		
		return categoryMapper.selectByParentId(parentId);
	}
	/**
	 * written by miaoziqiu
	 * @param classifybylargeId
	 * @return
	 */
	public List<Category> getClassifyByMiddle(String classifybylargeId) {
		Map<String, Object> map=new HashMap<>();
		map.put("classifybylargeId", classifybylargeId);
		return categoryMapper.selectClassifyByMiddle(map);
	}

	public List<Category> getClassifyBySmall(String classifybymiddleId) {
		Map<String, Object> map=new HashMap<>();
		map.put("classifybymiddleId", classifybymiddleId);
		return categoryMapper.selectClassifyBySmall(map);
	}

	public List<Category> getClassifyByKinds(String classifybysmallId) {
		Map<String, Object> map=new HashMap<>();
		map.put("classifybysmallId", classifybysmallId);
		return categoryMapper.selectClassifyByKinds(map);
	}

	public List<Category> getClassifyByLarge() {
		return categoryMapper.selectClassifyByLarge(null);

	}


	
	/**
	 * written by zhuqiguo
	 * @param classifybylargeId
	 * @return
	 */

	public void saveNewCateg(Category category) {
		categoryMapper.insertSelective(category);
		
	}

	public Category getCategInfo(String categid) {
		
		Category category = categoryMapper.selectByPrimaryKey(categid);
		return category;
	}

	public String getMaxCategId(String parentId) {
		System.out.println("CategoryService getMaxCategId:"+parentId);
		return categoryMapper.selectMaxCategId(parentId);
	}

	public void deteleBatch(ArrayList<String> categIds ) {
		CategoryExample example =new CategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategIdIn(categIds);
		categoryMapper.deleteByExample(example);
		
	}

	public void deleteCate(String categId) {
		categoryMapper.deleteByPrimaryKey(categId);
		
	}

	public void updateCateg(Category category) {
		categoryMapper.updateByPrimaryKeySelective(category);
		
	}
	

	

	

}
