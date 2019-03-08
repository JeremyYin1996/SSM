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

<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.css"/>
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/js/highcharts.js"></script>
<script type="text/javascript" src="static/js/exporting.js"></script>
<script type="text/javascript" src="static/js/highcharts-3d.js"></script>
<script type="text/javascript" src="static/js/buildCharts.js"></script>
<script type="text/javascript" src="static/js/index.js"></script>

<link rel="stylesheet" href="static/css/top_menu_for_visitor.css">
<link rel="stylesheet" href="static/css/index.css">
<link rel="stylesheet" href="static/css/bottom_menu.css">

</head>
<body>
<%--
	pageContext.setAttribute("APP_PATH", request.getContextPath());
--%>
<div class="container">
     <div class="row">
         <div class="header">
              <div class="col-lg-2 col-md-2 col-sm-2 ol-xs-2">
                     <img class="logo" src="static/image/drug_logo.png" />
              </div>
              <div class="topmenu col-lg-8 col-md-8 col-sm-8 ol-xs-8">
			     <ul>
			    	<li class="home_page"><a href="index.jsp">首页</a></li>
				    <li class="manager_center"><a href="login.jsp">管理中心</a></li>
			    	<li class="query_info"><a href="query/home">信息查询</a></li>
			    	<li class="statis_info"><a href="indices/home">指数统计</a>			    	
			    	</li>
			     </ul>
		      </div>
		      <div class="users col-lg-1 col-md-1 col-sm-1 ol-xs-1">
			       <div class="usersName"><a href="login.jsp">登 录</a></div>
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