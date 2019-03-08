package com.sqc.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.objenesis.instantiator.sun.MagicInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sqc.bean.User;
import com.sqc.exception.UserException;
import com.sqc.service.UserService;
import com.sqc.utils.JsonResult;
import com.sqc.utils.Msg;

import net.sf.jsqlparser.util.AddAliasesVisitor;



//@SessionAttributes(value={"user"})
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Resource
	private UserService userService;
	
	
	@RequestMapping("/getUser")
	@ResponseBody
	public Msg getUserByName(HttpServletRequest request,
			@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password,
	        @RequestParam(value = "role") String role,
            Map<String,User> map )
	{
		User user = userService.getUserByUserName(userName, password,role);
		if(user!=null){
			map.put("user", user);	
			request.getSession().setAttribute("user", user);
		    return Msg.success().add("user", user);	
		}
		else{
			Msg msg=new Msg();		
			msg.setCode(200);			
			msg.setMsg("该用户不存在");
			return msg.add("user", user);	
		}
	}
	
	@RequestMapping("/login")
	public String userLogin(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		if(user.getRoleId().equals("3"))
			return "pharm/pharm_home";
		else if(user.getRoleId().equals("1")|| user.getRoleId().equals("2"))
			return "manager/manager_home";		
		else return "visitor/visitor_home";
	}
	
	
	
	@RequestMapping("/checkUserIsLogin")
	@ResponseBody
	public Msg checkUserIsLogin(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){
			///throw new UserException("没有登录");
			return Msg.fail().add("user", null);
		}
		return Msg.success().add("user", user);
	}
	
	@RequestMapping("/outUser")
	@ResponseBody
	public Msg outUser(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){
			throw new UserException("没有登录");
		}
		request.getSession().removeAttribute("user");
		return Msg.success().add("user", user);
		}
}
