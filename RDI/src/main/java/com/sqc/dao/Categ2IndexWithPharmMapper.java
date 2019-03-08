package com.sqc.dao;

import com.sqc.bean.Categ2IndexWithPharm;
import com.sqc.bean.Categ2IndexWithPharmExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface Categ2IndexWithPharmMapper {
    long countByExample(Categ2IndexWithPharmExample example);

    int deleteByExample(Categ2IndexWithPharmExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Categ2IndexWithPharm record);

    int insertSelective(Categ2IndexWithPharm record);

    List<Categ2IndexWithPharm> selectByExample(Categ2IndexWithPharmExample example);

    Categ2IndexWithPharm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Categ2IndexWithPharm record, @Param("example") Categ2IndexWithPharmExample example);

    int updateByExample(@Param("record") Categ2IndexWithPharm record, @Param("example") Categ2IndexWithPharmExample example);

    int updateByPrimaryKeySelective(Categ2IndexWithPharm record);

    int updateByPrimaryKey(Categ2IndexWithPharm record);

	List<Categ2IndexWithPharm> selectByStatisDateWithCategNameAndDrugStore(Map<String, Object> map);

	List<Categ2IndexWithPharm> selectByStatisDateWithCategNameAndDistrict(Map<String, Object> map);

	List<Map<String, Object>> selectRecentCateg2IndicesById(Map<String, String> map);

	List<Categ2IndexWithPharm> selectByIdAndStatisDate(Map<String, Object> map);

	List<Categ2IndexWithPharm> selectCompareIndex(Map<String, Object> map);

	List<Categ2IndexWithPharm> selectCompareIndexWithPharam(Map<String, Object> map);
}