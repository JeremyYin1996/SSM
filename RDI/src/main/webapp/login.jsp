<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>系统登录</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- web路径：
不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。
以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:3306)；需要加上项目名
		http://localhost:3306/crud
 -->

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript"   src="static/js/jquery-1.12.4.min.js"></script>	
<link rel="stylesheet"  href="static/bootstrap-3.3.7-dist/css/bootstrap.css"/>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js">
</script>
<style type="text/css">
.register {
	float:center;
	border: solid 1px #383838;
	width:300px;
	height:350px;
	background-color:#fbfbfb;
	border:1px solid #B0B0B0;
 	box-shadow:0px 0px 10px #999966;
}


</style>
</head>
<body>
<div class="container">
     <!-- logo -->
     <div class="row">
         <div class="col-md-3 col-sm-4">
			 <img src="static/image/logo.png" />	
		  </div> 
		  <div  class="col-md-1 col-sm-1"> 
		   <br>	 <br>
		  <table style="height:60px;border-color:000000;border-left-style:solid;border-width:1px">
		      <tr>
		          <td valign="top"></td>
		      </tr>
		  </table>
		  </div> 
		  <div class="col-md-4 col-sm-4">
		      <br> <br>
              <h2>登录</h2>
          </div>
     </div>
     <hr>
     <!-- 登录表单 -->
     <div class="row">
         <div class="col-md-6 col-sm-6">
			 <img src="static/image/timg.jpg" />	
		  </div> 
		  <div class="col-md-4  col-sm-4  col-md-offset-1 col-sm-offset-1 register">
			   <h3 align="center">用户登录</h3>
			   <label for="inputusername" class="control-label">用户名</label>
			   <div>
			        <input type="text" name="username" id="username" class="form-control" placeholder="用户名"/> 
			        <span class="help-block"></span>
			   </div>
			   
			   <label for="inputPassword" class="control-label">密码</label>
			   <div>
			       <input type="password" name="password" id="password" class="form-control" placeholder="密码"/>
			       <span class="help-block"></span>
			   </div>
			   <br>
			   
			   <div class="select-role" align="center" id="role">
			          <label class="radio-inline">
			              <input type="radio"  name="role" value="manager" checked="checked" />管理员
			          </label> 
			          <label class="radio-inline">
			              <input type="radio"  name="role" value="pharm" />药店   
			          </label> 	          
			          <span class="help-block"></span>
			   </div>
			   
			   
			    
			   <p id="login_error"></p>
			  
			   <div align="center">
			      <input id="button_submit" type="button" class="btn btn-success" 
			          value="安全登录   "/>
			   </div>
			   <p>忘记密码？<a href="">点击这里</a></p>
		  </div>
     </div>
     
      <hr>
      <div class="row">
        <div class="col-md-12" align="center">
      	<a href="" class="link">关于我们</a><span>|</span> <a href="" class="link">常见问题</a><span>|</span>
		<a href="" class="link">违规投诉</a><span>|</span> <a href="" class="link">用户协议</a><span>|</span>
		<span>咨询电话：18051082728 （每天8:00 - 23:00）</span>
		<p>
			<span  style="font-size: 18px;font-weight:bold">版权所有，盗版必究</span>
		</p>
		</div>
     </div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		$(".register button").mouseover(function(){ 
			$(".register button").fadeTo(300,0.8);
		});
		$(".register button").mouseout(function(){
			$(".register button").fadeTo(300,1);
		});
 	});
	
	var SUCCESS=0;
	var ERROR=1;

	$("#button_submit").click(function(){
		    
			findUser();
		});

	function findUser(){
		var username=$(".register input[name='username']").val();
		var password=$(".register input[name='password']").val();
		var role=$(".register input[name='role']:checked").val();
		
	
		if(username.trim()=="" || password.trim()==""){
			if(username.trim()=="" && password.trim()=="")
				{
				show_validate_msg("#username", "error", "用户名不能为空");
				show_validate_msg("#password", "error", "密码不能为空");
				return false;
			   }
			else if(username.trim()=="" && password.trim()!=""){
				show_validate_msg("#username", "error", "用户名不能为空");
				show_validate_msg("#password", "success", "");
				return false;
			}
			else{
				show_validate_msg("#username", "success", "");
				show_validate_msg("#password", "error", "用户名不能为空");
				return false;
				
			}
		}
		{
			show_validate_msg("#username", "success", "");
			show_validate_msg("#password", "success", "");
		}
		
	
		$.ajax({
			url:"${APP_PATH}/user/getUser",
			data:{"userName":username,
				  "password":password,
				  "role":role
				  },
			type:"POST",
			success:function(result){
				console.log(result);
				if(result.code==100){
					window.location.href="user/login";
				}
				else{
					$("#login_error").val(result.msg);
				}
			}
		});
	}
	
	//显示校验结果的提示信息
	function show_validate_msg(ele,status,msg){
		//清除当前元素的校验状态
		$(ele).parent().removeClass("has-success has-error");
		$(ele).next("span").text("");
		if("success"==status){
			$(ele).parent().addClass("has-success");
			$(ele).next("span").text(msg);
		}else if("error" == status){
			$(ele).parent().addClass("has-error");
			$(ele).next("span").text(msg);
		}
	}
		
	
</script>
</body>
</html>