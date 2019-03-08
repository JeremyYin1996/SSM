package com.sqc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sqc.bean.District;
import com.sqc.service.DistrictService;
import com.sqc.utils.Msg;

@Controller
@RequestMapping("/district")
public class DistrictController {

	@Resource
	DistrictService districtService;
	
	@RequestMapping("/getDistricts")
	@ResponseBody
	public Msg getDistricts(){
		
		List<District> districts=districtService.getDistricts();
		return Msg.success().add("districts", districts);
		
	}
	
	@RequestMapping("/getProvince")
	@ResponseBody
	public Msg getProvince(){
		
		List<District> province=districtService.getProvince();
		return Msg.success().add("provinces", province);
		
	}
	
	@RequestMapping("/getCity")
	@ResponseBody
	public Msg getCity(@RequestParam(value = "districtId",required=false)String districtId){
		List<District> city=districtService.getCity(districtId);
		return Msg.success().add("citys", city);
		
	}
	/*
	@RequestMapping("/getDrugStores")
	@ResponseBody
	public Msg getDrugStores(@RequestParam(value = "districtId") String districtId){
		List<Pharmacy> drugstores=pharmacyService.getDrugStoresByDistrictId(districtId);
		return Msg.success().add("drugstores", drugstores);
		
	}
	
	*/
	@RequestMapping("/getCounty")
	@ResponseBody
	public Msg getCounty(@RequestParam(value = "districtId",required=false)String districtId){
		List<District> county=districtService.getCounty(districtId);
		return Msg.success().add("countys", county);
	}
	
}
