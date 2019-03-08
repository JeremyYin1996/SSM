package com.sqc.dao;

import com.sqc.bean.Drug;
import com.sqc.bean.DrugExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DrugMapper {
    long countByExample(DrugExample example);

    int deleteByExample(DrugExample example);

    int deleteByPrimaryKey(String drugId);

    int insert(Drug record);

    int insertSelective(Drug record);

    List<Drug> selectByExample(DrugExample example);

    Drug selectByPrimaryKey(String drugId);

    int updateByExampleSelective(@Param("record") Drug record, @Param("example") DrugExample example);

    int updateByExample(@Param("record") Drug record, @Param("example") DrugExample example);

    int updateByPrimaryKeySelective(Drug record);

    int updateByPrimaryKey(Drug record);

	Drug selectByPrimaryKeyWithCateg(String drugId);
}