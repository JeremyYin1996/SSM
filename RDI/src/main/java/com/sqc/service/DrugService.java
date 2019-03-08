package com.sqc.service;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sqc.bean.Drug;
import com.sqc.bean.DrugExample;
import com.sqc.bean.DrugExample.Criteria;
import com.sqc.dao.DrugMapper;

@Service
public class DrugService {
	@Resource
	DrugMapper drugMapper;

	public List<Drug> getAll() {
		
		return drugMapper.selectByExample(null);
	}

	public Drug getDrugsDetailById(String drugId) {
	
		return drugMapper.selectByPrimaryKeyWithCateg(drugId);
	}

	public List<Drug> getDrugsByNameOrApprovalNumber(String drugName, String approvalNumber) {
		
		DrugExample example=null;
		
		
		if(drugName!=null && drugName.trim()!=""|| approvalNumber!=null && approvalNumber.trim()!="")
		{
			example=new DrugExample();
		    Criteria criteria=example.createCriteria();
		    if(drugName!=null && drugName.trim()!="")
			    criteria.andDrugNameLike("%"+drugName+"%"); 
		    if(approvalNumber!=null && approvalNumber.trim()!="")
		    	criteria.andApprovalNumberEqualTo(approvalNumber);
		}
		return drugMapper.selectByExample(example);
	}

}
