package com.sqc.dao;

import com.sqc.bean.Shortage;
import com.sqc.bean.ShortageExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ShortageMapper {
    long countByExample(ShortageExample example);

    int deleteByExample(ShortageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Shortage record);

    int insertSelective(Shortage record);

    List<Shortage> selectByExample(ShortageExample example);

    Shortage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Shortage record, @Param("example") ShortageExample example);

    int updateByExample(@Param("record") Shortage record, @Param("example") ShortageExample example);

    int updateByPrimaryKeySelective(Shortage record);

    int updateByPrimaryKey(Shortage record);

	List<Shortage> selectShortageByPharmId(Map<String, Object> map);
}