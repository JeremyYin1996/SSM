package com.sqc.dao;

import com.sqc.bean.Promotion;
import com.sqc.bean.PromotionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromotionMapper {
    long countByExample(PromotionExample example);

    int deleteByExample(PromotionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Promotion record);

    int insertSelective(Promotion record);

   // List<Promotion> selectByExampleWithBLOBs(PromotionExample example);

    List<Promotion> selectByExample(PromotionExample example);

    Promotion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Promotion record, @Param("example") PromotionExample example);

    int updateByExampleWithBLOBs(@Param("record") Promotion record, @Param("example") PromotionExample example);

    int updateByExample(@Param("record") Promotion record, @Param("example") PromotionExample example);

    int updateByPrimaryKeySelective(Promotion record);

    int updateByPrimaryKeyWithBLOBs(Promotion record);

    int updateByPrimaryKey(Promotion record);
}