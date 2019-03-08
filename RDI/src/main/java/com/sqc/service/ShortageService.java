package com.sqc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sqc.bean.Shortage;
import com.sqc.dao.ShortageMapper;

@Service
public class ShortageService {
	@Resource
	ShortageMapper shortageMapper;

	public List<Shortage> getShortageByPharmId(String drugName, String approvalNumber,
			String pharmId) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(drugName!=null&&drugName.trim()!=""){
			map.put("drugName", drugName);
		}
		
		if(approvalNumber!=null&&approvalNumber.trim()!=""){
			map.put("approvalNumber", approvalNumber);
		}
		
		if(pharmId!=null&&pharmId.trim()!=""){
			map.put("pharmId", pharmId);
		}

		
		return shortageMapper.selectShortageByPharmId(map);
	}

	
	/*È±»õµÇ¼Ç*/
	public void shortageRegister(Shortage shortage) {
		// TODO Auto-generated method stub
		shortageMapper.insertSelective(shortage);
	}

}
