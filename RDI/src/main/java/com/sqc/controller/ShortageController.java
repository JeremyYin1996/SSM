package com.sqc.controller;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.sqc.bean.Shortage;

import com.sqc.service.ShortageService;
import com.sqc.utils.Msg;

@Controller
@RequestMapping("/shortage")
public class ShortageController {
	
	@Resource
	ShortageService shortageService;
	
	/* ȱ���Ǽ�*/
	@RequestMapping(value="/shortage_register",method=RequestMethod.POST)
	@ResponseBody
	public Msg shortageRegister(Shortage shortage){
		System.out.println(shortage);
		shortageService.shortageRegister(shortage);
		return Msg.success();	
	}

	@RequestMapping("/toShortageInfo")
	public ModelAndView toShortageInfo(@RequestParam(value ="pharmId") String pharmId){
		
		
		String viewName = "pharm/short_info";
		ModelAndView modelAndView = new ModelAndView(viewName);	
		//���ģ�����ݵ� ModelAndView ��.
		modelAndView.addObject("pharmId", pharmId);	
		return modelAndView;
		
	}
	
	@RequestMapping("/getShortageByPharmId")
	@ResponseBody
	public Msg getShortageByPharmId(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value="drugName") String drugName,
			@RequestParam(value="approvalNumber") String approvalNumber,
			@RequestParam(value="pharmId") String pharmId){
		
		
		System.out.println("ShortageController pharmId��"+pharmId);
		PageHelper.startPage(pn, 10);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Shortage> shortages=shortageService.getShortageByPharmId(drugName,approvalNumber,pharmId);
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		@SuppressWarnings("unchecked")
		PageInfo page = new PageInfo(shortages, 5);
		return Msg.success().add("pageInfo", page);	
		
	}
	
	
}
