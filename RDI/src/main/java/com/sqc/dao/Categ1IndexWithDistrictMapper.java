package com.sqc.dao;

import com.sqc.bean.Categ1IndexWithDistrict;
import com.sqc.bean.Categ1IndexWithDistrictExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface Categ1IndexWithDistrictMapper {
    long countByExample(Categ1IndexWithDistrictExample example);

    int deleteByExample(Categ1IndexWithDistrictExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Categ1IndexWithDistrict record);

    int insertSelective(Categ1IndexWithDistrict record);

    List<Categ1IndexWithDistrict> selectByExample(Categ1IndexWithDistrictExample example);

    Categ1IndexWithDistrict selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Categ1IndexWithDistrict record, @Param("example") Categ1IndexWithDistrictExample example);

    int updateByExample(@Param("record") Categ1IndexWithDistrict record, @Param("example") Categ1IndexWithDistrictExample example);

    int updateByPrimaryKeySelective(Categ1IndexWithDistrict record);

    int updateByPrimaryKey(Categ1IndexWithDistrict record);

	List<Categ1IndexWithDistrict> selectByStatisDateWithCategNameAndDistrict(Map<String, Object> map);

	List<Map<String, Object>> selectRecentCateg1IndicesById(Map<String, String> map);

	List<Categ1IndexWithDistrict> selectByIdAndStatisDate(Map<String, Object> map);

	List<Categ1IndexWithDistrict> selectCompareIndexWithDis(Map<String, Object> map);
}