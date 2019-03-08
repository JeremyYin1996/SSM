package com.sqc.dao;

import com.sqc.bean.Category;
import com.sqc.bean.CategoryExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
	
	//Œ¥ π”√
	
	List<Category> selectByLevelAssociationWithSelf(Map<String, String> map);
	
	List<Category> selectByExampleAssociationWithSelf(CategoryExample example);
	
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(String categId);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(String categId);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> selectByParentId(String parentId);

  
	String selectMaxCategId(String parentId);
	
    /**
     * written by miaoziqiu
     * @param map
     * @return
     */
	List<Category> selectClassifyBySmall(Map<String, Object> map);

	List<Category> selectClassifyByKinds(Map<String, Object> map);

	List<Category> selectClassifyByLarge(Object object);

	List<Category> selectClassifyByMiddle(Map<String, Object> map);

	
	
	

	
}