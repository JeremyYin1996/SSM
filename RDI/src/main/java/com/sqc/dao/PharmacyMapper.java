package com.sqc.dao;

import com.sqc.bean.Pharmacy;
import com.sqc.bean.PharmacyExample;
import com.sqc.bean.Sales;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PharmacyMapper {
    long countByExample(PharmacyExample example);

    int deleteByExample(PharmacyExample example);

    int deleteByPrimaryKey(String pharmId);

    int insert(Pharmacy record);

    int insertSelective(Pharmacy record);

    List<Pharmacy> selectByExample(PharmacyExample example);

    Pharmacy selectByPrimaryKey(String pharmId);

    int updateByExampleSelective(@Param("record") Pharmacy record, @Param("example") PharmacyExample example);

    int updateByExample(@Param("record") Pharmacy record, @Param("example") PharmacyExample example);

    int updateByPrimaryKeySelective(Pharmacy record);

    int updateByPrimaryKey(Pharmacy record);

    /*
     * 自定义查询
     */
    Pharmacy selectPharmDetailsByPharmId(String pharmId);

	List<Pharmacy> selectPharmsByDrugId(String drugId);

	String selectMaxPharmId(String districtId);
}