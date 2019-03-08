package com.sqc.dao;

import com.sqc.bean.Categ3IndexWithPharm;
import com.sqc.bean.Categ3IndexWithPharmExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface Categ3IndexWithPharmMapper {
    long countByExample(Categ3IndexWithPharmExample example);

    int deleteByExample(Categ3IndexWithPharmExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Categ3IndexWithPharm record);

    int insertSelective(Categ3IndexWithPharm record);

    List<Categ3IndexWithPharm> selectByExample(Categ3IndexWithPharmExample example);

    Categ3IndexWithPharm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Categ3IndexWithPharm record, @Param("example") Categ3IndexWithPharmExample example);

    int updateByExample(@Param("record") Categ3IndexWithPharm record, @Param("example") Categ3IndexWithPharmExample example);

    int updateByPrimaryKeySelective(Categ3IndexWithPharm record);

    int updateByPrimaryKey(Categ3IndexWithPharm record);

	List<Categ3IndexWithPharm> selectByStatisDateWithCategNameAndDrugStore(Map<String, Object> map);

	

	List<Map<String, Object>> selectRecentCateg3IndicesById(Map<String, String> map);

	List<Categ3IndexWithPharm> selectByIdAndStatisDate(Map<String, Object> map);

	List<Categ3IndexWithPharm> selectCompareIndexWithPharam(Map<String, Object> map);

	List<Categ3IndexWithPharm> selectCompareIndex(Map<String, Object> map);

	
	
}