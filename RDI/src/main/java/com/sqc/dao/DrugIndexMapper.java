package com.sqc.dao;

import com.sqc.bean.DrugIndex;
import com.sqc.bean.DrugIndexExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DrugIndexMapper {
    long countByExample(DrugIndexExample example);

    int deleteByExample(DrugIndexExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DrugIndex record);

    int insertSelective(DrugIndex record);

    List<DrugIndex> selectByExample(DrugIndexExample example);

    DrugIndex selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DrugIndex record, @Param("example") DrugIndexExample example);

    int updateByExample(@Param("record") DrugIndex record, @Param("example") DrugIndexExample example);

    int updateByPrimaryKeySelective(DrugIndex record);

    int updateByPrimaryKey(DrugIndex record);

	
    List<DrugIndex> selectByStatisDateWithDrugName(Map<String, Object> map);
    
	List<Map<String, Object>> selectRecentIndicesById(String drugId);

	List<DrugIndex> selectByStatisDateWithDrugAndOrderByIndex(Map<String, Object> map);

	List<DrugIndex> selectByIdAndStatisDate(Map<String, Object> map);


	

	
}