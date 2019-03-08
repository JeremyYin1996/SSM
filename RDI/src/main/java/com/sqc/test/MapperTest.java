package com.sqc.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.Resource;


import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sqc.bean.Categ4IndexWithPharm;

import com.sqc.bean.Drug;

import com.sqc.bean.DrugIndex;
import com.sqc.bean.Sales;
import com.sqc.bean.Shortage;
import com.sqc.dao.Categ4IndexWithPharmMapper;
import com.sqc.dao.CategoryMapper;
import com.sqc.dao.DrugIndexMapper;
import com.sqc.dao.DrugMapper;
import com.sqc.dao.SalesMapper;
import com.sqc.dao.ShortageMapper;
import com.sqc.dao.TempMapper;




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
public class MapperTest {
	
	@Autowired
	DrugMapper drugMapper;
	
	//@Resource
	//UserMapper userMapper;
	
	@Autowired
	DrugIndexMapper drugIndexMapper;
	
	@Resource
	CategoryMapper categoryMapper;
	
	@Resource
	Categ4IndexWithPharmMapper categ4IndexWithPharmMapper;
	
	@Resource
	SalesMapper salesMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	@Resource
	ShortageMapper shortageMapper;
	
	@Resource
	TempMapper tempMapper;
	
	
	@Test
	public void  testTempMapperr()
	{
		
		Integer maxId= tempMapper.selectMaxId();
		System.out.println(maxId);
		maxId=maxId+4;
		tempMapper.alterAutoIncrement(maxId);
		
	}
	
	@Test
	public void  testShortageMapper()
	{
		Map<String,Object> map=new HashMap<>();
		map.put("pharmId", "321301001");
		
		List<Shortage> shorts= shortageMapper.selectShortageByPharmId(map);
		System.out.println(shorts.size());
		
	}
	
	@Test
	public void testSalesMapper(){
		String drugId="H010101003";
		List<Sales> sales=salesMapper.selectPharmsByDrugId(drugId);
		System.out.println(sales.size());
	}
	
	
	@Test
	public void testCateg4Index(){
		Map<String,Object> map=new HashMap<>();
		
		map.put("statisYear",2017);
		map.put("statisMonth",1);
		map.put("districtId","321301");
		map.put("drugstoreId","321301002");
		List<Categ4IndexWithPharm> lists=
				categ4IndexWithPharmMapper.selectByStatisDateWithCategNameAndDrugStore(map);
		System.out.println(lists.size());
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testCategoryMapper2(){
		
		
		Map<String,String> map=new HashMap<String, String>();
		map.put("categName", null);
		map.put("categLevel", "3");
		
	
	    System.out.println(categoryMapper.selectByLevelAssociationWithSelf(map).size());
	    
	}
	
	
	@Test
	public void testDrugIndexMapper(){
		//List<DrugIndex> drugIndexs=drugIndexMapper.selectByExampleWithDrug(null);
		//drugIndexMapper.selectRecentIndicesById("H010101003");
		
	//	System.out.println(drugIndexMapper.selectRecentIndicesById("H010101003").size());
		
		System.out.println(drugMapper.selectByPrimaryKey("H010102001"));
	}
	
	@Test
	public void testDrugIndex(){
		Map<String, Object> map = new HashMap<String, Object>();
		//�ж����ݸ�ʽ�Ϸ��Բ��ŵ�map��
	
			map.put("drugName", "ͷ��");
			map.put("indexSort", "asc");	
		    map.put("statisYear", "2017");
		    map.put("statisMonth", "1");
		    List<DrugIndex> drugIndexs=drugIndexMapper.selectByStatisDateWithDrugName(map);
		    System.out.println(drugIndexs.size());
	}
	
	@Test
	public void testUserMapper(){
		Map<String,String> map=new HashMap<>();
		map.put("userName", "sha");
		map.put("password", "123456");
	//	User user=userMapper.selectByUserName(map);
		//System.out.println(user);
	}
	
	
	/**
	 * ����DrugMapper
	 */
	@Test
	public void testCRUD(){
	/*	//1������SpringIOC����
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2���������л�ȡmapper
		DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);*/
		System.out.println(drugMapper);
		Drug drug= drugMapper.selectByPrimaryKey("H010101001");
		System.out.println(drug);
	
		//1�����뼸������
//		departmentMapper.insertSelective(new Department(null, "������"));
//		departmentMapper.insertSelective(new Department(null, "���Բ�"));
		
		//2������Ա�����ݣ�����Ա������
		//employeeMapper.insertSelective(new Employee(null, "Jerry", "M", "Jerry@atguigu.com", 1));
		
		//3������������Ա����������ʹ�ÿ���ִ������������sqlSession��
		
//		for(){
//			employeeMapper.insertSelective(new Employee(null, , "M", "Jerry@atguigu.com", 1));
//		}
//		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//		for(int i = 0;i<1000;i++){
//			String uid = UUID.randomUUID().toString().substring(0,5)+i;
//			mapper.insertSelective(new Employee(null,uid, "M", uid+"@atguigu.com", 1));
//		}
//		System.out.println("�������");
		
	}

}
