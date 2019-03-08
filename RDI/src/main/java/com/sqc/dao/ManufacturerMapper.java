package com.sqc.dao;

import com.sqc.bean.Manufacturer;
import com.sqc.bean.ManufacturerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManufacturerMapper {
    long countByExample(ManufacturerExample example);

    int deleteByExample(ManufacturerExample example);

    int deleteByPrimaryKey(String manuId);

    int insert(Manufacturer record);

    int insertSelective(Manufacturer record);

    List<Manufacturer> selectByExample(ManufacturerExample example);

    Manufacturer selectByPrimaryKey(String manuId);

    int updateByExampleSelective(@Param("record") Manufacturer record, @Param("example") ManufacturerExample example);

    int updateByExample(@Param("record") Manufacturer record, @Param("example") ManufacturerExample example);

    int updateByPrimaryKeySelective(Manufacturer record);

    int updateByPrimaryKey(Manufacturer record);
}