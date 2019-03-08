package com.sqc.dao;

import com.sqc.bean.Categ4IndexWithDistrict;
import com.sqc.bean.Categ4IndexWithDistrictExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface Categ4IndexWithDistrictMapper {
    long countByExample(Categ4IndexWithDistrictExample example);

    int deleteByExample(Categ4IndexWithDistrictExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Categ4IndexWithDistrict record);

    int insertSelective(Categ4IndexWithDistrict record);

    List<Categ4IndexWithDistrict> selectByExample(Categ4IndexWithDistrictExample example);

    Categ4IndexWithDistrict selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Categ4IndexWithDistrict record, @Param("example") Categ4IndexWithDistrictExample example);

    int updateByExample(@Param("record") Categ4IndexWithDistrict record, @Param("example") Categ4IndexWithDistrictExample example);

    int updateByPrimaryKeySelective(Categ4IndexWithDistrict record);

    int updateByPrimaryKey(Categ4IndexWithDistrict record);

	List<Categ4IndexWithDistrict> selectByStatisDateWithCategNameAndDistrict(Map<String, Object> map);

	


	List<Map<String, Object>> selectRecentCateg4IndicesById(Map<String, String> map);

	List<Categ4IndexWithDistrict> selectByIdAndStatisDate(Map<String, Object> map);

 List<Categ4IndexWithDistrict> selectCompareIndexWithDis(Map<String, Object> map);
	
}