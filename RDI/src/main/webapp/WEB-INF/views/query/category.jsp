<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>药品分类查询</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<%	pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
<!-- <script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
 <script type="text/javascript" src="${APP_PATH }/static/js/template.js"></script> -->

<link rel="stylesheet" href="${APP_PATH }/static/css/query/query.css">

</head>

<body>
<%@ include file="../common/top_menu.jsp" %>

<div class="container">
    <div class="row Top">
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
    
	   一级分类：
	        <select class="classifybylarge" name="classifybylarge" id="classifybylarge">
			         <option value="" selected>请选择</option>     
		     </select>
	  
	   二级分类：
	        <select class="classifybymiddle" name="classifybymiddle" id="classifybymiddle">
			         <option value="" selected>请选择</option>     
		     </select>
	  

	   三级分类：
	        <select class="classifybysmall" name="classifybysmall" id="classifybysmall">
			         <option value="" selected>请选择</option>     
		     </select>

	    

                 四级分类：
	        <select class="classifybykinds" name="classifybykinds" id="classifybykinds">
			         <option value="" selected>请选择</option>     
		     </select>
	    </div>
        <div class="col-lg-3 col-md-3 col-sm-3  col-xs-3">
		   分类名称：<input placeholder="请输入药品分类名称" type="text" name="categName"/>
	   </div>
	   <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"  align="right">   
	        <h5> 分类级别：</h5>
	   </div>
	    <div class="col-lg-1 col-md-1 col-sm-1  col-xs-1" >
	         <select class="level" name="categLevel">
			        <option value="" selected>请选择</option>
			        <option value="1">大类</option>
			        <option value="2">中类</option>
			        <option value="3">小类</option> 
			        <option value="4">代表品类</option>			        
		     </select>
	   </div>	  
	  
	    <div class="col-lg-2 col-md-2 col-sm-2  col-xs-2">
             <button id="find">搜&nbsp&nbsp索</button>
	     </div>
    </div>
     <div class="row">
        <h6 style="color:red;">注1：可以根据父分类查询，比如选择具体的大类和中类，可以查看某中类下所有的小类信息.</h6>
        <h6 style="color:red;">注2：可以根据级别查询，查询所有大类或中类或小类或代表品类信息.</h6>
        <h6 style="color:red;">注3：因为类别只分了4个级别，所以当选择了某个具体的代表品类时，下面就不再有子分类.</h6>
    </div>
    <div class="row Center">
	    	<table  class="table table-bordered table-hover col-md-12  col-sm-12 col-xs-12" id="categories_table" >
			   <thead>
			       <tr class='head'>
		    	       <th style="text-align:center" >分类名称</th>
		    	       <th style="text-align:center">级别</th>
		   	 	       <th style="text-align:center">上级分类名称</th>
		    	     <!--  <th style="text-align:center">下级分类信息</th>
		    	       <th style="text-align:center">药品信息</th>
		    	       -->
			      </tr>
			   </thead>		
		     <tbody>
					
		     </tbody>
		     </table>
    </div>
   <!-- 显示分页信息 -->
	<div class="row">
		<!--分页文字信息  -->
		<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6" id="page_info_area"></div>
		<!-- 分页条信息 -->
		<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6" id="page_nav_area"></div>
	</div>

</div>
<script type="text/javascript" src="${APP_PATH }/static/js/query/category.js"></script>
</body>
</html>