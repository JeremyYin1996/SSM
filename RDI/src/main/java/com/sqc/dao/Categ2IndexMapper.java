package com.sqc.dao;

import com.sqc.bean.Categ2Index;
import com.sqc.bean.Categ2IndexExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface Categ2IndexMapper {
    long countByExample(Categ2IndexExample example);

    int deleteByExample(Categ2IndexExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Categ2Index record);

    int insertSelective(Categ2Index record);

    List<Categ2Index> selectByExample(Categ2IndexExample example);

    Categ2Index selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Categ2Index record, @Param("example") Categ2IndexExample example);

    int updateByExample(@Param("record") Categ2Index record, @Param("example") Categ2IndexExample example);

    int updateByPrimaryKeySelective(Categ2Index record);

    int updateByPrimaryKey(Categ2Index record);

	List<Categ2Index> selectByStatisDateWithCategName(Map<String, Object> map);

	List<Map<String, Object>> selectRecentCateg2IndicesById(Map<String, String> map);

	List<Categ2Index> selectByIdAndStatisDate(Map<String, Object> map);
}