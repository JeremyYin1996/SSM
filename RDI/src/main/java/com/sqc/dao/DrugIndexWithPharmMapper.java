package com.sqc.dao;

import com.sqc.bean.DrugIndex;
import com.sqc.bean.DrugIndexWithPharm;
import com.sqc.bean.DrugIndexWithPharmExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DrugIndexWithPharmMapper {
    long countByExample(DrugIndexWithPharmExample example);

    int deleteByExample(DrugIndexWithPharmExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DrugIndexWithPharm record);

    int insertSelective(DrugIndexWithPharm record);

    List<DrugIndexWithPharm> selectByExample(DrugIndexWithPharmExample example);

    DrugIndexWithPharm selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DrugIndexWithPharm record, @Param("example") DrugIndexWithPharmExample example);

    int updateByExample(@Param("record") DrugIndexWithPharm record, @Param("example") DrugIndexWithPharmExample example);

    int updateByPrimaryKeySelective(DrugIndexWithPharm record);

    int updateByPrimaryKey(DrugIndexWithPharm record);

	List<DrugIndex> selectByStatisDateWithDrugNameAndPharm(Map<String, Object> map);

	List<Map<String, Object>> selectRecentIndicesById(Map<String, String> map);

	List<DrugIndexWithPharm> selectByIdAndStatisDate(Map<String, Object> map);
}