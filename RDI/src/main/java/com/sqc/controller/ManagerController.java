package com.sqc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@RequestMapping("/home")
	public String toManagerHome(){
		return "manager/manager_home";
		
	}
	
	@RequestMapping("/drug")
	public String toDrugManage(){
		return "manager/drug";
		
	}
	
	@RequestMapping("/drugstore")
	public String toPharmManage(){
		return "manager/pharm";
		
	}
	
	@RequestMapping("/category")
	public String toCategoryManage(){
		return "manager/category";
		
	}
	
	@RequestMapping("/user")
	public String toUserManage(){
		return "manager/user";
		
	}

}
