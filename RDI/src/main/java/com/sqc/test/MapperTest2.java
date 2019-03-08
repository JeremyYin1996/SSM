package com.sqc.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sqc.bean.Drug;
import com.sqc.dao.DrugMapper;





/**
 * ����dao��Ĺ���
 * @author lfy
 *�Ƽ�Spring����Ŀ�Ϳ���ʹ��Spring�ĵ�Ԫ���ԣ������Զ�ע��������Ҫ�����
 *1������SpringTestģ��
 *2��@ContextConfigurationָ��Spring�����ļ���λ��
 *3��ֱ��autowiredҪʹ�õ��������
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:conf/applicationContext.xml"})
public class MapperTest2 {
	
	@Autowired
	DrugMapper drugMapper;
	

	
	/**
	 * ����DrugMapper
	 */
	@Test
	public void testDrugMapper(){
	
		System.out.println(drugMapper);
		Drug drug= drugMapper.selectByPrimaryKey("H0101010001");
		System.out.println(drug);
	
		
	}

}
