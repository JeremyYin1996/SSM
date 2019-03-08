package com.sqc.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sqc.bean.User;
import com.sqc.bean.UserExample;
import com.sqc.bean.UserExample.Criteria;
import com.sqc.dao.PharmacyMapper;
import com.sqc.dao.UserMapper;
import com.sqc.exception.UserException;

@Service("userService")
public class UserService {

	//@Resource
	//private SqlSessionTemplate template;
	@Resource
	UserMapper userMapper;
	
	

	public User getUserByUserName(String userName, String password, String role)
   {
		if(userName==null || userName.trim().isEmpty()){
			throw new UserException("用户名不能空");
		}
		if(password==null || password.trim().isEmpty()){
			throw new UserException("密码不能空");
		}
		
		UserExample example =new UserExample();
		Criteria criteria =example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		criteria.andPasswordEqualTo(password);
		
		System.out.println("userName:"+userName);
		System.out.println("password:"+password);
		System.out.println("role:"+role);
		
		List<User>  users=null;
		User user=null;
		
		if(role.equals("manager")){	
		
			List<String> values=new ArrayList<>();
			values.add("1");
			values.add("2");
			criteria.andRoleIdIn(values);
			users=userMapper.selectByExample(example);
			
		  }
		else if(role.equals("pharm")){
			criteria.andRoleIdEqualTo("3");
			users=userMapper.selectByExample(example);
		
		}
		
		if(users==null)	
		{
			throw new UserException("用户不存在");
    	}
		else{
			user=users.get(0);
		}
		
		return user;
	}


	
}