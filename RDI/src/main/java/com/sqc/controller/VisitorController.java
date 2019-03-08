package com.sqc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visitor")
public class VisitorController{
	
	@RequestMapping("/home")
	public String toVisitorHome(){
		return "visitor/visitor_home";
		
	}

}
