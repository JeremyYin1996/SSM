package com.sqc.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sqc.bean.Drug;
import com.sqc.dao.DrugMapper;





/**
 * 测试dao层的工作
 * @author lfy
 *推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 *1、导入SpringTest模块
 *2、@ContextConfiguration指定Spring配置文件的位置
 *3、直接autowired要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:conf/applicationContext.xml"})
public class MapperTest2 {
	
	@Autowired
	DrugMapper drugMapper;
	

	
	/**
	 * 测试DrugMapper
	 */
	@Test
	public void testDrugMapper(){
	
		System.out.println(drugMapper);
		Drug drug= drugMapper.selectByPrimaryKey("H0101010001");
		System.out.println(drug);
	
		
	}

}
