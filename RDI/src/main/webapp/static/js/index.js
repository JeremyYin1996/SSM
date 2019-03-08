var SUCCESS=0;
var ERROR=1;

$(function(){
	checkLogin();
//	$("#showIndex").click(showIndex);
//	$("#showWeight").click(showWeight);
//	$("#showIndex").click();
	$(".out").click(outUser);

});


//检测是否登录以及登录角色
function checkLogin(){
	$.ajax({
		url:"user/checkUserIsLogin",
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
					$(".manager_center").click(function(){
						alert("对不起，您没有该权限！");
						$(".manager_center a").removeAttr("href");
						window.location.href="index.jsp";
					});
					$(".manager_center li").click(function(){
						window.location.href="index.jsp";
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
					window.location.href="login.jsp";
				});
				
				$(".manager_center li").click(function(){
					window.location.href="login.jsp";
				});
				
				$(".pharm_input").click(function(){
					alert('请先登录');
					$(".pharm_input a").removeAttr("href");
					window.location.href="login.jsp";
				});
				$(".pharm_input li").click(function(){
					window.location.href="login.jsp";
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
		url:"user/outUser",
		type:"GET",
		success:function(result){
			console.log(result);
			if(result.code==100){
				//var url ="index.jsp";
				//window.open(url);
				window.location.href="index.jsp";
			}
			else{
				alert(result.msg);
			}
		}
	});
}
function showIndex(){
	$("#sliders").hide();
	var url='firstCateIndex/getFirstHZIndex.query';
	$.getJSON(url,function(result){
		if(result.state==SUCCESS){
			var ydata=result.data.dataList;
			var xdata=result.data.xdata;
			for(var j=0;j<ydata.length;j++){
				for(var i=0;i<ydata[j].data.length;i++){
					ydata[j].data[i]=Number(ydata[j].data[i]);
				}
			}
			console.log(xdata);
			console.log(ydata);
			buildLine(ydata,xdata,'FirstCatePriceIndex','药品价格指数变化趋势');
		}
		else{
			alert(result.message);
		}
	});
}

function showWeight(){
	$("#sliders").show();
	var url='firstCateIndex/getFirstHZWeight.query';
	$.getJSON(url,function(result){
		if(result.state==SUCCESS){
			var ydata=result.data.dataList;
			var xdata=result.data.xdata;
			for(var j=0;j<ydata.length;j++){
				for(var i=0;i<ydata[j].data.length;i++){
					ydata[j].data[i]=Number(ydata[j].data[i]);
				}
			}
			console.log(xdata);
			console.log(ydata);
			bulidColumn(ydata,xdata,'FirstCateWeight','药品零售权重对比');
		}
		else{
			alert(result.message);
		}
	});
}
