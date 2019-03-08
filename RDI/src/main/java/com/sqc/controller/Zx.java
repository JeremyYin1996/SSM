package com.sqc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/zx")
public class Zx {
	
	@RequestMapping("/test")
	public String toSuccess(){
	return "success";	
	}

}
