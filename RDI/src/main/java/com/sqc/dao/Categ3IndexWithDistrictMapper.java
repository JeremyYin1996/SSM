package com.sqc.dao;

import com.sqc.bean.Categ3IndexWithDistrict;
import com.sqc.bean.Categ3IndexWithDistrictExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface Categ3IndexWithDistrictMapper {
    long countByExample(Categ3IndexWithDistrictExample example);

    int deleteByExample(Categ3IndexWithDistrictExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Categ3IndexWithDistrict record);

    int insertSelective(Categ3IndexWithDistrict record);

    List<Categ3IndexWithDistrict> selectByExample(Categ3IndexWithDistrictExample example);

    Categ3IndexWithDistrict selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Categ3IndexWithDistrict record, @Param("example") Categ3IndexWithDistrictExample example);

    int updateByExample(@Param("record") Categ3IndexWithDistrict record, @Param("example") Categ3IndexWithDistrictExample example);

    int updateByPrimaryKeySelective(Categ3IndexWithDistrict record);

    int updateByPrimaryKey(Categ3IndexWithDistrict record);

	List<Categ3IndexWithDistrict> selectByStatisDateWithCategNameAndDistrict(Map<String, Object> map);


	List<Map<String, Object>> selectRecentCateg3IndicesById(Map<String, String> map);

	List<Categ3IndexWithDistrict> selectByIdAndStatisDate(Map<String, Object> map);

	List<Categ3IndexWithDistrict> selectCompareIndexWithDis(Map<String, Object> map);
}