package com.sqc.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sqc.bean.Drug;
import com.sqc.bean.DrugIndex;
import com.sqc.service.DrugService;
import com.sqc.utils.Msg;

@Controller
@RequestMapping("/drug")
public class DrugController {
	
	@Resource
	DrugService drugService;
	
	

	@RequestMapping("/getDrugDetail")
	@ResponseBody
	public Msg getDrugsDetailById(String drugId){
		Drug drug= drugService.getDrugsDetailById(drugId);
		return Msg.success().add("drug", drug);
		
	}
	

	@RequestMapping("/getDrugs")
	@ResponseBody
	public Msg getDrugs(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value="drugName",required=false) String drugName,
			@RequestParam(value="approvalNumber",required=false) String approvalNumber){
	      	System.out.println("drugName:"+drugName);
		    System.out.println("approvalNumber:"+approvalNumber);	
		// 这不是一个分页查询
		// 引入PageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 10);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<Drug> drugs = drugService.getDrugsByNameOrApprovalNumber
				(drugName,approvalNumber);
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(drugs, 5);
		return Msg.success().add("pageInfo", page);
	}
}

