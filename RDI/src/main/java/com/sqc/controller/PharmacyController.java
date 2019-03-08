package com.sqc.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sqc.bean.District;
import com.sqc.bean.Drug;
import com.sqc.bean.Pharmacy;
import com.sqc.bean.Promotion;
import com.sqc.bean.Sales;
import com.sqc.bean.Shortage;
import com.sqc.service.DistrictService;
import com.sqc.service.PharmacyService;
import com.sqc.utils.Msg;

@Controller
@RequestMapping("/pharmacy")
public class PharmacyController {
	
	@Resource
	PharmacyService pharmacyService;
	
	@Resource
	DistrictService districtService;

	// The following was written by YinHaonan
	/*
	 * ���� ���� ɾ��  ����һ
	 * */
	@ResponseBody
	@RequestMapping(value= "/pharmdel/{pharmIds}",method=RequestMethod.DELETE)
	public Msg deletePharm(@PathVariable("pharmIds")String pharmIds){
		if (pharmIds.contains("-")){
			List<String> del_ids= new ArrayList<>();
			String[] str_ids = pharmIds.split("-");
			 for (String string : str_ids) {
				 del_ids.add(string);
			}
			 pharmacyService.deteleBatch(del_ids); 
		}else{
			String pharmId= pharmIds;
			pharmacyService.deletePharmacy(pharmId);
		}
		return Msg.success();
	}
	
	
	//��ȡ��maxcateg
		@RequestMapping(value="/getMaxPharmId/{districtId}",method=RequestMethod.GET)
		@ResponseBody
		public Msg getMaxPharm(@PathVariable("districtId") String districtId){
			String maxPharmId=pharmacyService.getMaxPharmId(districtId);
			/*System.out.println(maxCategId);*/
			String pharmId;
			if(maxPharmId!=null){		
			//	int length=maxPharmId.length();//6λ����ID��districtId��3λҩ�ꣻ
				String str1=null;
				String str2=null;
				Integer maxNum;
				
				str1=maxPharmId.substring(0, 6);
				str2=maxPharmId.substring(6, 9);
				maxNum=Integer.parseInt(str2)+1;
				if(maxNum<10)
					str2="00"+maxNum;
				else if(maxNum<100)
					str2="0"+maxNum;
				else
					str2=""+maxNum;
				 pharmId=str1+str2;
				
			}else {
				
				pharmId=districtId+"001";
			}
			return Msg.success().add("pharmId",pharmId);
		}
	
	
	
	
	//����ҩ�귽��
	@RequestMapping(value="/saveNewPharm",method=RequestMethod.POST)
	@ResponseBody
	public Msg savePharm(@Valid Pharmacy pharmacy,BindingResult result){
	
		System.out.println(pharmacy);
		if(result.hasErrors()){
			//У��ʧ�ܣ�Ӧ�÷���ʧ�ܣ���ģ̬������ʾУ��ʧ�ܵĴ�����Ϣ
			Map<String, Object> map =new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for(FieldError fieldError : errors){
				System.out.println("������ֶ�����"+fieldError.getField());
				System.out.println("������Ϣ:"+fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields",map);
		}else{
			pharmacyService.savePharm(pharmacy);
			return Msg.success();
		}
		
	}
	
	

	//���±༭��ҩ�귽��
	@RequestMapping(value="/updatePharm/{pharmId}",method=RequestMethod.POST)
	@ResponseBody
	public Msg postUpdate(Pharmacy pharmacy){
		pharmacyService.savePharm(pharmacy);
		return Msg.success();
	}
	
	//����ҩ����Ϣ
	@RequestMapping(value="/getPharmInfo/{pharmId}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getPharmInfo(@PathVariable("pharmId")String pharmId){
		//System.out.println(pharmId);
		Pharmacy pharmacy = pharmacyService.getPharmInfo(pharmId);
		 String districtId=pharmacy.getDistrictId();
		 
		 District district=districtService.getDistrictById(districtId);
		
		
		
		return Msg.success().add("pharmacy",pharmacy).add("district", district);
	}
	
	/**
	 * ��ת��"pharms_by_drug.jsp"ҳ�档
	 * @param districtId
	 * @return
	 */
	@RequestMapping("/toPharmsByDrugId")
	public ModelAndView toPharmsByDrugId(@RequestParam(value = "drugId") String drugId,
			@RequestParam(value = "drugName") String drugName){
		
		
		String viewName = "query/pharms_by_drug";
		ModelAndView modelAndView = new ModelAndView(viewName);	
		//���ģ�����ݵ� ModelAndView ��.
		modelAndView.addObject("drugId", drugId);	
		modelAndView.addObject("drugName", drugName);	
		return modelAndView;
		
	}
	
	
	//The following was written by GuoXiujin
	/*��Ǽ�*/
	@RequestMapping(value="/promotion_register",method=RequestMethod.POST)
	@ResponseBody
	public Msg promotionRegister(Promotion promotion){
		pharmacyService.promotionRegister(promotion);
		return Msg.success();	
	}
	



	
	
	
	/**
	 * ��ѯ����ĳҩƷ��ҩ����Ϣ��
	 * @param districtId
	 * @return
	 */
	@RequestMapping("/getPharmsByDrugId")
	@ResponseBody
	public Msg getPharmsByDrugId(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value="drugId") String drugId){
		
		
		System.out.println("PharmacyController drugId��"+drugId);
		PageHelper.startPage(pn, 10);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Pharmacy> pharms=pharmacyService.getPharmsByDrugId(drugId);
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		@SuppressWarnings("unchecked")
		PageInfo page = new PageInfo(pharms, 5);
		return Msg.success().add("pageInfo", page);	
		
	}
	
	/*
	 * ��������id��ѯ�������µ�����ҩ������
	 */
	@RequestMapping("/getDrugStores")
	@ResponseBody
	public Msg getDrugStores(@RequestParam(value = "districtId") String districtId){
		
		List<Pharmacy> drugstores=pharmacyService.getDrugStoresByDistrictId(districtId);
		return Msg.success().add("drugstores", drugstores);
		
	}
	
	/**
	 * ��������id��ҩ�����Ʋ�ѯ����ҩ����Ϣ
	 * @param pn
	 * @param pharmName
	 * @param districtId
	 * @return
	 */
	@RequestMapping("/getPharms")
	@ResponseBody
	public Msg getPharms(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value="pharmName",required=false) String pharmName,
			@RequestParam(value = "districtId") String districtId){
		
		System.out.println("Pharmacy:getPharms:districtId:"+ districtId);
		
		PageHelper.startPage(pn, 10);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Pharmacy> pharms=pharmacyService.getPharmsByDistrictIdAndPharmName(pharmName,districtId);
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(pharms, 5);
		return Msg.success().add("pageInfo", page);	
		
	}
	
	@RequestMapping("/toPromotionDetail")
	public ModelAndView toPromotionDetail(@RequestParam(value = "pharmId") String pharmId){
		
		String viewName = "query/pharm_detail";
		ModelAndView modelAndView = new ModelAndView(viewName);
		System.out.println("pharmId:"+pharmId);
		//���ģ�����ݵ� ModelAndView ��.
		modelAndView.addObject("pharmId", pharmId);
		
		return modelAndView;
		
	}
	@RequestMapping("/getPharmDetails")
	@ResponseBody
	public Msg getPharmDetails(@RequestParam(value = "pharmId") String pharmId){
		
		
		Pharmacy pharm=pharmacyService.getPharmDetailsByPharmId(pharmId);
		return Msg.success().add("pharm", pharm);
		
	}
	
	@RequestMapping("/getRecentPromotion")
	@ResponseBody
	public Msg getRecentPromotion(@RequestParam(value = "pharmId") String pharmId){

		List<Promotion> promotions=pharmacyService.getRecentPromotion(pharmId);
		return Msg.success().add("promotions", promotions);
		
	}
	
	@RequestMapping("/getPromotionById")
	@ResponseBody
	public Msg getPromotionById(@RequestParam(value = "id") String id){

		Promotion promotion=pharmacyService.getPromotionById(id);
		return Msg.success().add("promotion", promotion);
		
	}
	

	
	@RequestMapping("/pharm_home")
	public String toPharmHome(){
		return "pharm/pharm_home";
		
	}
	
	@RequestMapping("/sales_input")
	public String toSalesInput(){
		return "pharm/sales_input";
		
	}
	
	@RequestMapping("/shortage_input")
	public String toShortageInput(){
		return "pharm/shortage_input";
		
	}
	
	
	
	@RequestMapping("/promotion_input")
	public String toPromotionInput(){
		//return "pharm/promotion_input";
		return "pharm/pharm_promotion";
		
	}
	
	@RequestMapping("/edit_info")
	public String toManagerHome(){
		return "pharm/edit_info";
		
	}
}
