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
		// �ⲻ��һ����ҳ��ѯ
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 10);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Drug> drugs = drugService.getDrugsByNameOrApprovalNumber
				(drugName,approvalNumber);
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(drugs, 5);
		return Msg.success().add("pageInfo", page);
	}
}

