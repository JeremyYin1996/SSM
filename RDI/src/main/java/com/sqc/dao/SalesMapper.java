package com.sqc.dao;


import com.sqc.bean.Sales;
import com.sqc.bean.SalesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesMapper {
    long countByExample(SalesExample example);

    int deleteByExample(SalesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Sales record);

    int insertSelective(Sales record);

    List<Sales> selectByExample(SalesExample example);

    Sales selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Sales record, @Param("example") SalesExample example);

    int updateByExample(@Param("record") Sales record, @Param("example") SalesExample example);

    int updateByPrimaryKeySelective(Sales record);

    int updateByPrimaryKey(Sales record);

	List<Sales> selectPharmsByDrugId(String drugId);
}