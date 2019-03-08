package com.sqc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/indices")
public class IndicesController {
	
	@RequestMapping("/home")
	public String toIndicesHome(){
		return "indices/indices_home";
		
	}
	
	@RequestMapping("/drug_indices_for_visitor")
	public String toDrugIndicesForVisitor(){
		return "indices/drug_indices_for_visitor";
		
	}
	
	@RequestMapping("/categ4_indices")
	public String toCategory4Indices(){
		return "indices/categ4_indices";
		
	}
	
	@RequestMapping("/categ3_indices")
	public String toCategory3Indices(){
		return "indices/categ3_indices";
		
	}
	
	@RequestMapping("/categ2_indices")
	public String toCategory2Indices(){
		return "indices/categ2_indices";
		
	}
	
	@RequestMapping("/categ1_indices")
	public String toCategory1Indices(){
		return "indices/categ1_indices";
		
	}
	@RequestMapping("/categ0_indices")
	public String toCategory0Indices(){
		return "indices/categ0_indices";
		
	}
	
	@RequestMapping("/indexnews")
	public String toIndexNews(){
		return "news/indexnews";
		
	}
	
	@RequestMapping("/indexguide")
	public String toIndexGuide(){
		return "news/indexguide";
		
	}

}
