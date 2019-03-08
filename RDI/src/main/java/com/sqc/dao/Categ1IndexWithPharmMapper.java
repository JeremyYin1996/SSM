package com.sqc.dao;

import com.sqc.bean.Categ1IndexWithPharm;
import com.sqc.bean.Categ1IndexWithPharmExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface Categ1IndexWithPharmMapper {
    long countByExample(Categ1IndexWithPharmExample example);

    int deleteByExample(Categ1IndexWithPharmExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Categ1IndexWithPharm record);

    int insertSelective(Categ1IndexWithPharm record);

    List<Categ1IndexWithPharm> selectByExample(Categ1IndexWithPharmExample example);

    Categ1IndexWithPharm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Categ1IndexWithPharm record, @Param("example") Categ1IndexWithPharmExample example);

    int updateByExample(@Param("record") Categ1IndexWithPharm record, @Param("example") Categ1IndexWithPharmExample example);

    int updateByPrimaryKeySelective(Categ1IndexWithPharm record);

    int updateByPrimaryKey(Categ1IndexWithPharm record);

	List<Categ1IndexWithPharm> selectByStatisDateWithCategNameAndDrugStore(Map<String, Object> map);

	List<Categ1IndexWithPharm> selectByStatisDateWithCategNameAndDistrict(Map<String, Object> map);

	List<Map<String, Object>> selectRecentCateg1IndicesById(Map<String, String> map);

	List<Categ1IndexWithPharm> selectByIdAndStatisDate(Map<String, Object> map);

	List<Categ1IndexWithPharm> selectCompareIndex(Map<String, Object> map);

	List<Categ1IndexWithPharm> selectCompareIndexWithPharam(Map<String, Object> map);
}