package com.sqc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sqc.bean.District;
import com.sqc.dao.DistrictMapper;

@Service
public class DistrictService {

	@Resource
	DistrictMapper districtMapper;
	public List<District> getDistricts() {
		
		return districtMapper.selectByExample(null);
	}
	
	public List<District> getProvince() {
		
		return districtMapper.selectAllProvince();
	}
	
	public List<District> getCity(String districtId) {
		
		return districtMapper.selectAllCity(districtId);
		
	}
	public List<District> getCounty(String districtId) {
		
		return districtMapper.selectAllCounty(districtId);
	}
	public District getDistrictById(String districtId) {
		
		return districtMapper.selectByPrimaryKey(districtId);
	}
}
