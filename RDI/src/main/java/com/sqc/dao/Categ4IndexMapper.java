package com.sqc.dao;

import com.sqc.bean.Categ4Index;
import com.sqc.bean.Categ4IndexExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface Categ4IndexMapper {
    long countByExample(Categ4IndexExample example);

    int deleteByExample(Categ4IndexExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Categ4Index record);

    int insertSelective(Categ4Index record);

    List<Categ4Index> selectByExample(Categ4IndexExample example);

    Categ4Index selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Categ4Index record, @Param("example") Categ4IndexExample example);

    int updateByExample(@Param("record") Categ4Index record, @Param("example") Categ4IndexExample example);

    int updateByPrimaryKeySelective(Categ4Index record);

    int updateByPrimaryKey(Categ4Index record);

	List<Categ4Index> selectByStatisDateWithCategName(Map<String, Object> map);

	

	List<Map<String, Object>> selectRecentCateg4IndicesById(Map<String, String> map);

	List<Categ4Index> selectByIdAndStatisDate(Map<String, Object> map);
}