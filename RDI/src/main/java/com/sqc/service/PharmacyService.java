package com.sqc.service;


import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.sqc.bean.Pharmacy;
import com.sqc.bean.PharmacyExample;
import com.sqc.bean.Promotion;
import com.sqc.bean.PharmacyExample.Criteria;
import com.sqc.bean.PromotionExample;
import com.sqc.bean.Sales;
import com.sqc.bean.Shortage;
import com.sqc.dao.PharmacyMapper;
import com.sqc.dao.PromotionMapper;
import com.sqc.dao.SalesMapper;
import com.sqc.dao.ShortageMapper;
import com.sqc.utils.Msg;

@Service
public class PharmacyService {
	
	@Resource
	PharmacyMapper pharmacyMapper;
	
	@Resource
	PromotionMapper promotionMapper;
	
	@Resource
	SalesMapper salesMapper;
	
	@Resource
	ShortageMapper shortageMapper;

	public List<Pharmacy> getDrugStoresByDistrictId(String districtId) {
		
		PharmacyExample example=new PharmacyExample();	
		
		Criteria criteria=example.createCriteria();
			
		criteria.andDistrictIdEqualTo(districtId);
						
		return pharmacyMapper.selectByExample(example);
	}

	public List<Pharmacy> getPharmsByDistrictIdAndPharmName(String pharmName, String districtId) {
		
		PharmacyExample example=null;
		
		System.out.println("pharmName:"+pharmName);
		if((pharmName!=null && pharmName.trim()!="") || (districtId!=null&&districtId.trim()!=""))
		{
			example=new PharmacyExample();
			Criteria criteria=example.createCriteria();
			
			if(pharmName!=null && pharmName.trim()!=""){
				
				criteria.andPharmNameLike(pharmName);
				
			}		
			if(districtId!=null && districtId.trim()!=""){
				criteria.andDistrictIdLike(districtId+"%");
				
			}
			
		}
		
		return pharmacyMapper.selectByExample(example);
	}

	

	public Pharmacy getPharmDetailsByPharmId(String pharmId) {
		
		return pharmacyMapper.selectPharmDetailsByPharmId(pharmId);
	}

	public List<Promotion> getRecentPromotion(String pharmId) {
		PromotionExample example=null;
		if(pharmId!=null && pharmId.trim()!=""){
			example=new PromotionExample();
			com.sqc.bean.PromotionExample.Criteria criteria=example.createCriteria();
			criteria.andPharmIdEqualTo(pharmId);
			
		}	
		
		return promotionMapper.selectByExample(example);
	}

	public Promotion getPromotionById(String id) {

		return promotionMapper.selectByPrimaryKey(Integer.parseInt(id));
	}

	public List<Pharmacy> getPharmsByDrugId(String drugId) {
		System.out.println("PharmacyService drugId"+drugId);
		//return salesMapper.selectPharmsByDrugId(drugId);
		return pharmacyMapper.selectPharmsByDrugId(drugId);
	}


	/*活动登记*/
	public void promotionRegister(Promotion promotion) {
		// TODO Auto-generated method stub
		promotionMapper.insertSelective(promotion);
	}

	//药店保存
		public Msg savePharm(Pharmacy pharmacy) {
			// TODO Auto-generated method stub
			pharmacyMapper.insertSelective(pharmacy);
			return Msg.success();
		}
		//单个删除的实现方法
		public void deletePharmacy(String pharmId) {
			// TODO Auto-generated method stub
			pharmacyMapper.deleteByPrimaryKey(pharmId);
		}	
		//批量删除的实现方法
		public void deteleBatch(List<String> pharmIds) {
			// TODO Auto-generated method stub
			PharmacyExample example=new PharmacyExample();
			Criteria criteria = example.createCriteria();
			//delete from XXX where pharm_id in(1,2,3)
			criteria.andPharmIdIn(pharmIds);
			pharmacyMapper.deleteByExample(example) ;
			
			
		}
	    //得到药店ID的实现方法
		public String getMaxPharmId(String districtId) {
			// TODO Auto-generated method stub
			return pharmacyMapper.selectMaxPharmId(districtId);
		}

		public Pharmacy getPharmInfo(String pharmId) {
			// TODO Auto-generated method stub
			Pharmacy pharmacy = pharmacyMapper.selectByPrimaryKey(pharmId);
			return pharmacy;
		}

		//检验用户名是否可用
		public boolean checkPharm(String pharmName) {
			// TODO Auto-generated method stub
			PharmacyExample example = new PharmacyExample();
			Criteria criteria = example.createCriteria();
			criteria.andPharmNameEqualTo(pharmName);
			long count = pharmacyMapper.countByExample(example);
			return count==0;
		}



	//活动保存方法
	/*public void savePromotion(Promotion promotion) {
		// TODO Auto-generated method stub
		PromotionMapper.insertSelective(Promotion);
	}
*/
	
}
