package com.sqc.dao;

import com.sqc.bean.DrugIndex;
import com.sqc.bean.DrugIndexWithDistrict;
import com.sqc.bean.DrugIndexWithDistrictExample;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DrugIndexWithDistrictMapper {
    long countByExample(DrugIndexWithDistrictExample example);

    int deleteByExample(DrugIndexWithDistrictExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DrugIndexWithDistrict record);

    int insertSelective(DrugIndexWithDistrict record);

    List<DrugIndexWithDistrict> selectByExample(DrugIndexWithDistrictExample example);

    DrugIndexWithDistrict selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DrugIndexWithDistrict record, @Param("example") DrugIndexWithDistrictExample example);

    int updateByExample(@Param("record") DrugIndexWithDistrict record, @Param("example") DrugIndexWithDistrictExample example);

    int updateByPrimaryKeySelective(DrugIndexWithDistrict record);

    int updateByPrimaryKey(DrugIndexWithDistrict record);

	List<DrugIndex> selectByStatisDateWithDrugNameAndDistrict(Map<String, Object> map);


	List<Map<String, Object>> selectRecentIndicesById(Map<String, String> map);

	

	List<DrugIndexWithDistrict> selectByIdAndStatisDate(Map<String, Object> map);
}