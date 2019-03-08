package com.sqc.dao;

import com.sqc.bean.Temp;
import com.sqc.bean.TempExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TempMapper {
    long countByExample(TempExample example);

    int deleteByExample(TempExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Temp record);

    int insertSelective(Temp record);

    List<Temp> selectByExample(TempExample example);

    Temp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Temp record, @Param("example") TempExample example);

    int updateByExample(@Param("record") Temp record, @Param("example") TempExample example);

    int updateByPrimaryKeySelective(Temp record);

    int updateByPrimaryKey(Temp record);

	Integer selectMaxId();
	void alterAutoIncrement(Integer maxId);
}