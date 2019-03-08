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
	 * 批量 单独 删除  二合一
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
	
	
	//获取到maxcateg
		@RequestMapping(value="/getMaxPharmId/{districtId}",method=RequestMethod.GET)
		@ResponseBody
		public Msg getMaxPharm(@PathVariable("districtId") String districtId){
			String maxPharmId=pharmacyService.getMaxPharmId(districtId);
			/*System.out.println(maxCategId);*/
			String pharmId;
			if(maxPharmId!=null){		
			//	int length=maxPharmId.length();//6位地区ID：districtId，3位药店；
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
	
	
	
	
	//保存药店方法
	@RequestMapping(value="/saveNewPharm",method=RequestMethod.POST)
	@ResponseBody
	public Msg savePharm(@Valid Pharmacy pharmacy,BindingResult result){
	
		System.out.println(pharmacy);
		if(result.hasErrors()){
			//校验失败，应该返回失败，在模态框中显示校验失败的错误信息
			Map<String, Object> map =new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for(FieldError fieldError : errors){
				System.out.println("错误的字段名："+fieldError.getField());
				System.out.println("错误信息:"+fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields",map);
		}else{
			pharmacyService.savePharm(pharmacy);
			return Msg.success();
		}
		
	}
	
	

	//更新编辑后药店方法
	@RequestMapping(value="/updatePharm/{pharmId}",method=RequestMethod.POST)
	@ResponseBody
	public Msg postUpdate(Pharmacy pharmacy){
		pharmacyService.savePharm(pharmacy);
		return Msg.success();
	}
	
	//回显药店信息
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
	 * 跳转到"pharms_by_drug.jsp"页面。
	 * @param districtId
	 * @return
	 */
	@RequestMapping("/toPharmsByDrugId")
	public ModelAndView toPharmsByDrugId(@RequestParam(value = "drugId") String drugId,
			@RequestParam(value = "drugName") String drugName){
		
		
		String viewName = "query/pharms_by_drug";
		ModelAndView modelAndView = new ModelAndView(viewName);	
		//添加模型数据到 ModelAndView 中.
		modelAndView.addObject("drugId", drugId);	
		modelAndView.addObject("drugName", drugName);	
		return modelAndView;
		
	}
	
	
	//The following was written by GuoXiujin
	/*活动登记*/
	@RequestMapping(value="/promotion_register",method=RequestMethod.POST)
	@ResponseBody
	public Msg promotionRegister(Promotion promotion){
		pharmacyService.promotionRegister(promotion);
		return Msg.success();	
	}
	



	
	
	
	/**
	 * 查询销售某药品的药店信息。
	 * @param districtId
	 * @return
	 */
	@RequestMapping("/getPharmsByDrugId")
	@ResponseBody
	public Msg getPharmsByDrugId(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value="drugId") String drugId){
		
		
		System.out.println("PharmacyController drugId："+drugId);
		PageHelper.startPage(pn, 10);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<Pharmacy> pharms=pharmacyService.getPharmsByDrugId(drugId);
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		@SuppressWarnings("unchecked")
		PageInfo page = new PageInfo(pharms, 5);
		return Msg.success().add("pageInfo", page);	
		
	}
	
	/*
	 * 根据区域id查询该区域下的所有药店名称
	 */
	@RequestMapping("/getDrugStores")
	@ResponseBody
	public Msg getDrugStores(@RequestParam(value = "districtId") String districtId){
		
		List<Pharmacy> drugstores=pharmacyService.getDrugStoresByDistrictId(districtId);
		return Msg.success().add("drugstores", drugstores);
		
	}
	
	/**
	 * 根据区域id和药店名称查询所有药店信息
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
		// startPage后面紧跟的这个查询就是一个分页查询
		List<Pharmacy> pharms=pharmacyService.getPharmsByDistrictIdAndPharmName(pharmName,districtId);
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(pharms, 5);
		return Msg.success().add("pageInfo", page);	
		
	}
	
	@RequestMapping("/toPromotionDetail")
	public ModelAndView toPromotionDetail(@RequestParam(value = "pharmId") String pharmId){
		
		String viewName = "query/pharm_detail";
		ModelAndView modelAndView = new ModelAndView(viewName);
		System.out.println("pharmId:"+pharmId);
		//添加模型数据到 ModelAndView 中.
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
