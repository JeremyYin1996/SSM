package com.sqc.dao;

import com.sqc.bean.Categ2IndexWithDistrict;
import com.sqc.bean.Categ2IndexWithDistrictExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface Categ2IndexWithDistrictMapper {
    long countByExample(Categ2IndexWithDistrictExample example);

    int deleteByExample(Categ2IndexWithDistrictExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Categ2IndexWithDistrict record);

    int insertSelective(Categ2IndexWithDistrict record);

    List<Categ2IndexWithDistrict> selectByExample(Categ2IndexWithDistrictExample example);

    Categ2IndexWithDistrict selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Categ2IndexWithDistrict record, @Param("example") Categ2IndexWithDistrictExample example);

    int updateByExample(@Param("record") Categ2IndexWithDistrict record, @Param("example") Categ2IndexWithDistrictExample example);

    int updateByPrimaryKeySelective(Categ2IndexWithDistrict record);

    int updateByPrimaryKey(Categ2IndexWithDistrict record);

	List<Map<String, Object>> selectRecentCateg2IndicesById(Map<String, String> map);

	List<Categ2IndexWithDistrict> selectByStatisDateWithCategNameAndDistrict(Map<String, Object> map);

	List<Categ2IndexWithDistrict> selectByIdAndStatisDate(Map<String, Object> map);

	List<Categ2IndexWithDistrict> selectCompareIndexWithDis(Map<String, Object> map);
}