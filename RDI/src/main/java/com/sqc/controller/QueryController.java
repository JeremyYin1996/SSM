package com.sqc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/query")
public class QueryController {
	

	@RequestMapping("/home")
	public String toVisitorHome(){
		return "visitor/visitor_home";
		
	}
	
	@RequestMapping("/drug_info")
	public String toDrugInfo(){
		return "query/drug_info";
		
	}
	
	@RequestMapping("/pharm")
	public String toDrugStore(){
		return "query/pharm";
		
	}
	
	@RequestMapping("/category")
	public String toCategory(){
		return "query/category";
		
	}
}
