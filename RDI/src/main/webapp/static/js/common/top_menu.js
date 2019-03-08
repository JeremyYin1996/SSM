var SUCCESS=0;
var ERROR=1;

$(function(){
	//var APP_PATH= ${requestScope.contextPath };
	//alert(APP_PATH);
	checkLogin();
	$(".out").click(outUser);
});
//检测是否登录以及登录角色
function checkLogin(){
	$.ajax({
		url:"../user/checkUserIsLogin",
		type:"GET",
		success:function(result){
			console.log(result);
			if(result.code==100){
				userMenu();
				var user=result.extend.user;
				$(".usersName a").text(user.userName+",你好");
				$(".usersName a").removeAttr("href");	
				if(user.roleId!="1" && user.roleId!="2" )
				{
					
					$(".manager_center").hide();
					$(".index_warn").hide();
					/*
					 * $(".manager_center").click(function(){
						alert("对不起，您没有该权限！");
						$(".manager_center a").removeAttr("href");
						window.location.href="../index.jsp";
					});
					$(".manager_center li").click(function(){
						//alert("对不起，您没有该权限！");
						window.location.href="../index.jsp";
					});
					*/
				}			
			}
			else{
				
				$(".manager_center").hide();
				$(".pharm_input").hide();
				$(".index_warn").hide();
				/*
				$(".manager_center").click(function(){
					alert('请先登录');
					$(".manager_center a").removeAttr("href");
					window.location.href="../login.jsp";
				});
				
				$(".manager_center li").click(function(){
					//alert('请先登录');
					window.location.href="../login.jsp";
				});
				
				$(".pharm_input").click(function(){
					alert('请先登录');
					$(".pharm_input a").removeAttr("href");
					window.location.href="../login.jsp";
				});
				$(".pharm_input li").click(function(){
					//alert('请先登录');
					window.location.href="../login.jsp";
				});
				*/
			}
		}	
	});	
}
//绑定用户退出登录菜单
function userMenu(){
	console.log("userMenu");
	$(".usersName").hover(function(){
		$(".userMenu").slideDown("fast");
	});
	$(".users").mouseleave(function(){
		$(".userMenu").slideUp("fast");
	});
}
//退出用户
function outUser(){
	console.log("outUser");
	$.ajax({
		url:"../user/outUser",
		type:"GET",
		success:function(result){
			console.log(result);
			if(result.code==100){
				//var url ="../index.jsp";
				//window.open(url);
				window.location.href="../index.jsp";
			}
			else{
				alert(result.msg);
			}
		}
	});
}