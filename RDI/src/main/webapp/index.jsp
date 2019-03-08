<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>首页</title>
<%--
	pageContext.setAttribute("APP_PATH", request.getContextPath());
    System.out.print(request.getContextPath());
--%>
<!-- web路径：
不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。
以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:3306)；需要加上项目名
		http://localhost:3306/crud
 -->
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="static/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/js/highcharts.js"></script>
<script type="text/javascript" src="static/js/exporting.js"></script>
<script type="text/javascript" src="static/js/highcharts-3d.js"></script>
<script type="text/javascript" src="static/js/buildCharts.js"></script>
<script type="text/javascript" src="static/js/index.js"></script> 

<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.css"/>
<link rel="stylesheet" href="static/css/common/top_menu.css">
<link rel="stylesheet" href="static/css/index.css">
<link rel="stylesheet" href="static/css/common/bottom_menu.css">
<script>
	$(function(){
		$(".managerSecondMenu").hide();
		$(".pharmSecondMenu").hide();
		$(".querySecondMenu").hide();
		$(".indexSecondMenu").hide();
		//$(".guideSecondMenu").hide();
		$(".warnSecondMenu").hide();
		
		$(".manager_center a").hover(function(){
			$(".managerSecondMenu").slideDown("fast");
		});
		$(".manager_center").mouseleave(function(){
			$(".managerSecondMenu").slideUp("fast");
		});
		
		$(".pharm_input a").hover(function(){
			$(".pharmSecondMenu").slideDown("fast");
		});
		$(".pharm_input").mouseleave(function(){
			$(".pharmSecondMenu").slideUp("fast");
		});
		
		$(".query_info a").hover(function(){
			$(".querySecondMenu").slideDown("fast");
		});
		$(".query_info").mouseleave(function(){
			$(".querySecondMenu").slideUp("fast");
		});
		
		$(".statis_info a").hover(function(){
			$(".indexSecondMenu").slideDown("fast");
		});
		$(".statis_info").mouseleave(function(){
			$(".indexSecondMenu").slideUp("fast");
		});
		
	   $(".index_warn a").hover(function(){
			$(".warnSecondMenu").slideDown("fast");
		});
		$(".index_warn").mouseleave(function(){
			$(".warnSecondMenu").slideUp("fast");
		});
		
			
		/*$(".index_guide a").hover(function(){
			$(".guideSecondMenu").slideDown("fast");
		});
		$(".index_guide").mouseleave(function(){
			$(".guideSecondMenu").slideUp("fast");
		});
		*/

	});
</script>
</head>
<body>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<div class="container">
  
     <div class="row">
         <div class="header">
              <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
                     <img class="logo" src="${APP_PATH }/static/image/drug_logo.png" />
              </div>
              <div class="topmenu col-lg-8 col-md-8 col-sm-8 ol-xs-8">
			     <ul>
			    	<li class="home_page"><a href="${APP_PATH }/index.jsp">首页</a></li>
				    <li class="manager_center"><a href="${APP_PATH }/manager/home">管理中心</a>
				       <ul class="managerSecondMenu" >
				           <li><a href="${APP_PATH }/manager/drug" target="content">药品管理</a></li>
						   <li><a href="${APP_PATH }/manager/drugstore" target="content">药店管理</a></li>
						   <li><a href="${APP_PATH }/manager/category" target="content">分类管理</a></li>
						   <li><a href="${APP_PATH }/manager/user" target="content">用户管理</a></li>	
						   <li><a href="${APP_PATH }/manager/check" target="content">信息审核</a></li>			
					   </ul>
				    </li>
				     <li class="pharm_input"><a>数据填报</a>
				       <ul class="pharmSecondMenu" >
				          <li><a href="${APP_PATH }/pharmacy/sales_input" target="content">数据填报</a></li>
				           <li><a href="${APP_PATH }/pharmacy/shortage_input" target="content">缺货登记</a></li>
				           <li><a href="${APP_PATH }/pharmacy/promotion_input" target="content">活动登记</a></li>
						   <li><a href="${APP_PATH }/pharmacy/edit_info" target="content">修改信息</a></li> 			
					   </ul>
				    </li>
			    	<li class="query_info"><a >信息查询</a>
			    	   <ul class="querySecondMenu" >
				           <li><a href="${APP_PATH }/query/drug_info" target="content">药品信息</a></li>
						   <li><a href="${APP_PATH }/query/pharm" target="content">药店信息</a></li>
						   						
						   <li><a href="${APP_PATH }/query/category" target="content">药品分类</a></li>	
								
					   </ul>
					</li>
					<li class="statis_info"><a >指数统计</a>
					 <ul class="indexSecondMenu">
				           <li><a href="${APP_PATH }/indices/drug_indices_for_visitor" target="content">药品指数</a></li>
						   <li><a href="${APP_PATH }/indices/categ4_indices" target="content">代表品指数</a></li>
						   <li><a href="${APP_PATH }/indices/categ3_indices" target="content">小类指数</a></li>
						   <li><a href="${APP_PATH }/indices/categ2_indices" target="content">中类指数</a></li>	
						   <li><a href="${APP_PATH }/indices/categ1_indices" target="content">大类指数</a></li>
						   <li><a href="${APP_PATH }/indices/categ0_indices" target="content">总指数</a></li>			   			
					    </ul>
					  </li>
					  <!--  
					  <li class="index_guide"><a href="${APP_PATH }/indices/indexnews">指数导读</a>
					 <ul class="guideSecondMenu"> 
				           <li><a href="${APP_PATH }/indices/indexnews" target="content">指数解读</a></li>	
				           <li><a href="${APP_PATH }/indices/indexguide" target="content">使用手册</a></li>		
					    </ul>
					  </li>-->
					  <li class="index_warn"><a href="${APP_PATH }/warning/indexcateg4" >指数监测</a>
                      	<ul class="warnSecondMenu"> 
                      	  <li><a href="${APP_PATH }/warning/indexcateg4" target="content">代表品预警</a></li>		
					      <li><a href="${APP_PATH }/warning/indexcateg3" target="content">小类预警</a></li>		
                      	  <li><a href="${APP_PATH }/warning/indexcateg2" target="content">中类预警</a></li>			
                      	  <li><a href="${APP_PATH }/warning/indexcateg1" target="content">大类预警</a></li>		                    
                       </ul>
					 </li>  
			     </ul>
		      </div>
		      <div class="users col-lg-2 col-md-2 col-sm-2 ol-xs-2">
			       <div class="usersName"><a href="${APP_PATH }/login.jsp">登 录</a></div>
			         <ul class="userMenu ">
				            <li class="safeSet"><a>安全设置</a></li>
				            <li class="out"><a>退出登录</a></li>
			        </ul>
			   </div>
		  </div>
     </div>

     
      <div class="row">
      <div class="center">
		<div class="showTable">
		    <button class="showIndex" id="showIndex" type="button">
		    <p>指数对比</p>
		    </button>
		     <button class="showWeight" id="showWeight" type="button">
		    <p>权重对比</p>
		    </button>
		    <!--  
			<input id="showIndex" value="指数对比" type="button"/>
			<input id="showWeight" value="权重对比" type="button"/>
			-->
			<div id="sliders">
			    <table>
			        <tr>
			        	<td>Alpha Angle</td>
			        	<td><input id="alpha" type="range" min="-10" max="45" value="0"/> <span id="alpha-value" class="value"></span></td>
			        </tr>
			        <tr>
			        	<td>Beta Angle</td>
			        	<td><input id="beta" type="range" min="-45" max="45" value="0"/> <span id="beta-value" class="value"></span></td>
			        </tr>
			        <tr>
			        	<td>Depth</td>
			        	<td><input id="depth" type="range" min="20" max="100" value="100"/> <span id="depth-value" class="value"></span></td>
			        </tr>
			    </table>
			</div>
			<div id="line-labels">
				
			</div>
		</div>
	</div>
     </div>
      <div class="row">
      <div class="bottom">
		<a href="" class="link">关于我们</a><span>|</span> 
		<a href="" class="link">常见问题</a><span>|</span>
		<a href="" class="link">违规投诉</a><span>|</span> 
		<a href="" class="link">用户协议</a><span>|</span>
		<span>咨询电话：18051082728 （每天8:00 - 23:00）</span>
		<p>
			<span>版权所有，盗版必究</span>
		</p>
	</div>
     </div>

</div>

</body>
</html>