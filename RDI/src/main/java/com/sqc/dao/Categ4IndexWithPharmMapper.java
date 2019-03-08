package com.sqc.dao;

import com.sqc.bean.Categ4Index;
import com.sqc.bean.Categ4IndexWithPharm;
import com.sqc.bean.Categ4IndexWithPharmExample;
import com.sqc.bean.DrugIndexWithPharm;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface Categ4IndexWithPharmMapper {
    long countByExample(Categ4IndexWithPharmExample example);

    int deleteByExample(Categ4IndexWithPharmExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Categ4IndexWithPharm record);

    int insertSelective(Categ4IndexWithPharm record);

    List<Categ4IndexWithPharm> selectByExample(Categ4IndexWithPharmExample example);

    Categ4IndexWithPharm selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Categ4IndexWithPharm record, @Param("example") Categ4IndexWithPharmExample example);

    int updateByExample(@Param("record") Categ4IndexWithPharm record, @Param("example") Categ4IndexWithPharmExample example);

    int updateByPrimaryKeySelective(Categ4IndexWithPharm record);

    int updateByPrimaryKey(Categ4IndexWithPharm record);

	List<Categ4IndexWithPharm> selectByStatisDateWithCategNameAndDrugStore(Map<String, Object> map);

	List<Categ4IndexWithPharm> selectByStatisDateWithCategNameAndDistrict(Map<String, Object> map);

	List<Map<String, Object>> selectRecentCateg4IndicesById(Map<String, String> map);

	List<Categ4IndexWithPharm> selectByIdAndStatisDate(Map<String, Object> map);

	List<Categ4IndexWithPharm> selectCompareIndexByIdAndStatisDate(Map<String, Object> map);

	List<Categ4IndexWithPharm> selectCompareIndex(Map<String, Object> map);

	List<Categ4IndexWithPharm> selectCompareIndexWithPharam(Map<String, Object> map);

	List<Categ4IndexWithPharm> selectClassify(Map<String, Object> map);

	List<Categ4IndexWithPharm> selectCompareIndexWithKinds(Map<String, Object> map);

	
}