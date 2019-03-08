package com.sqc.dao;

import com.sqc.bean.District;
import com.sqc.bean.DistrictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DistrictMapper {
    long countByExample(DistrictExample example);

    int deleteByExample(DistrictExample example);

    int deleteByPrimaryKey(String districtId);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByExample(DistrictExample example);

    District selectByPrimaryKey(String districtId);

    int updateByExampleSelective(@Param("record") District record, @Param("example") DistrictExample example);

    int updateByExample(@Param("record") District record, @Param("example") DistrictExample example);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);

	List<District> selectAllProvince();

	List<District> selectAllCity(String districtId);

	List<District> selectAllCounty(String districtId);
}