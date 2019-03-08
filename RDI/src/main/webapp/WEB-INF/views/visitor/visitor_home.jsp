<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>游客主页</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 
 <%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
  
%>
<script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" href="${APP_PATH }/static/css/bottom_menu.css">


</head>
<body>

 <%@ include file="../common/top_menu.jsp" %>
  
  <jsp:include page="visitor_index.jsp"></jsp:include>	


<div class="bottom">
	<p>版权所有：宿迁学院.文理学院 </p>
</div>
</body>
</html>