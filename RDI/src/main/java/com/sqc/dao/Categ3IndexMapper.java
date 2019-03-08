package com.sqc.dao;

import com.sqc.bean.Categ3Index;
import com.sqc.bean.Categ3IndexExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface Categ3IndexMapper {
    long countByExample(Categ3IndexExample example);

    int deleteByExample(Categ3IndexExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Categ3Index record);

    int insertSelective(Categ3Index record);

    List<Categ3Index> selectByExample(Categ3IndexExample example);

    Categ3Index selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Categ3Index record, @Param("example") Categ3IndexExample example);

    int updateByExample(@Param("record") Categ3Index record, @Param("example") Categ3IndexExample example);

    int updateByPrimaryKeySelective(Categ3Index record);

    int updateByPrimaryKey(Categ3Index record);

	List<Categ3Index> selectByStatisDateWithCategName(Map<String, Object> map);

	List<Map<String, Object>> selectRecentCateg3IndicesById(Map<String, String> map);

	List<Categ3Index> selectByIdAndStatisDate(Map<String, Object> map);
}