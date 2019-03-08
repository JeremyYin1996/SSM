package com.sqc.dao;

import com.sqc.bean.Categ1Index;
import com.sqc.bean.Categ1IndexExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface Categ1IndexMapper {
    long countByExample(Categ1IndexExample example);

    int deleteByExample(Categ1IndexExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Categ1Index record);

    int insertSelective(Categ1Index record);

    List<Categ1Index> selectByExample(Categ1IndexExample example);

    Categ1Index selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Categ1Index record, @Param("example") Categ1IndexExample example);

    int updateByExample(@Param("record") Categ1Index record, @Param("example") Categ1IndexExample example);

    int updateByPrimaryKeySelective(Categ1Index record);

    int updateByPrimaryKey(Categ1Index record);

	List<Categ1Index> selectByStatisDateWithCategName(Map<String, Object> map);

	List<Map<String, Object>> selectRecentCateg1IndicesById(Map<String, String> map);

	List<Categ1Index> selectByIdAndStatisDate(Map<String, Object> map);
}