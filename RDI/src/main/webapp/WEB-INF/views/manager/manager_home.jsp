<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理中心</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
  
%>
<script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>

<link rel="stylesheet" href="${APP_PATH }/static/css/bottom_menu.css">

</head>
<body>

 <%@ include file="../common/top_menu.jsp" %>
 <!-- 本页面还需要修改，下面将显示各种管理中心相关信息 ，即要修改下面的页面-->
  <jsp:include page="manager_index.jsp"></jsp:include>	

<div class="bottom">
		<p>版权所有：宿迁学院.文理学院 </p>
	</div>
</body>
</html>