<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<title>小类详情</title>
<%	pageContext.setAttribute("APP_PATH", request.getContextPath()); %>

<script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<script src="${APP_PATH }/static/js/template.js"></script>
<script src="${APP_PATH }/static/js/highcharts.js"></script>
<script src="${APP_PATH }/static/js/exporting.js"></script>
<script src="${APP_PATH }/static/js/buildCharts.js"></script>

<link rel="stylesheet" href="${APP_PATH }/static/css/common/bottom_menu.css">
<link rel="stylesheet" href="${APP_PATH }/static/css/indices/categ_indices_detail.css">

<script id="categDetailTable" type="text/html">
	<tr><th>分类名称：</th><td>{{categName}}</td></tr>
	<tr><th>所属级别：</th><td>{{level}}</td></tr>
	
</script>
</head>

<body>
	<%@ include file="../common/top_menu.jsp"%>
	<div class="center">
		<div class="showCenter">
			<div id="line-labels-upper-left"></div>
			<div id="line-labels-upper-right"></div>
			<div id="line-labels-lower-left"></div>
			<div id="line-labels-lower-right"></div>
		</div>
	</div>
	<div class="bottom">
		<p>版权所有：宿迁学院  && 文理学院</p>
	</div>

<script type="text/javascript">

  
  $(function(){
	var categId = "${requestScope.categId }";
	var pharmId = "${requestScope.pharmId }";
	var districtId = "${requestScope.districtId }";

	
	if(pharmId!=null && pharmId!="" && pharmId.trim()!="")
		{
		   showLineWithPharm(categId,pharmId);
		}
	else if(districtId!=null && districtId!="" && districtId.trim()!="")
		{
		 showLineWithDistrict(categId,districtId);
		
		}
	else
		{
		showLine(categId);
		}

    });
  
//绘制整个市的某类药品指数变化折线图
  function showLine(categId){

  	$.ajax({
  		url:"${APP_PATH}/categ3index/getRecentCateg3IndicesById",
  		data:{"categId":categId},
  		type:"POST",
  		success:function(result){
  		    var ydata=result.extend.recentIndices.dataMap;
  		    var ydata1=result.extend.recentIndices.dataMap1;
		    var ydata2=result.extend.recentIndices.dataMap2;
  		    var xdata=result.extend.recentIndices.xdata;
  		
  		    console.log(result);
  		   for(var i=0;i<ydata.data.length;i++){
  				ydata.data[i]=Number(ydata.data[i]);
  		 }
  		   for(var i=0;i<ydata1.data.length;i++){
				ydata1.data[i]=Number(ydata1.data[i]);
		 }
		   for(var i=0;i<ydata2.data.length;i++){
				ydata2.data[i]=Number(ydata2.data[i]);
		 }
  		 	buildLineNew('line-labels-upper-left',[ydata],xdata,'小类指数','定基指数变化趋势');
  		 	buildLineNew('line-labels-upper-right',[ydata1],xdata,'小类指数','环比指数变化趋势');
  		 	
  		 	buildLineNew('line-labels-lower-left',[ydata2],xdata,'小类指数','同比指数变化趋势');
  		// 	buildLineNew('line-labels-lower-right',[ydata],xdata,'小类指数','指数变化趋势');
  		}
  		
  	});
}
  
//绘制某个区域的某类药品指数变化折线图
  function showLineWithDistrict(categId,districtId){

  	$.ajax({
  		url:"${APP_PATH}/categ3index/getRecentCateg3IndicesWithDistrictById",
  		data:{"categId":categId,"districtId":districtId},
  		type:"POST",
  		success:function(result){
  		    var ydata=result.extend.recentIndices.dataMap;
  		    var ydata1=result.extend.recentIndices.dataMap1;
		    var ydata2=result.extend.recentIndices.dataMap2;
		    var xdata=result.extend.recentIndices.xdata;
  		    console.log(result);
  		   for(var i=0;i<ydata.data.length;i++){
  				ydata.data[i]=Number(ydata.data[i]);
  		 }
  		   for(var i=0;i<ydata1.data.length;i++){
				ydata1.data[i]=Number(ydata1.data[i]);
		 }
		   for(var i=0;i<ydata2.data.length;i++){
				ydata2.data[i]=Number(ydata2.data[i]);
		 }
  		 	buildLineNew('line-labels-upper-left',[ydata],xdata,'小类指数','定基指数变化趋势');
  		 	buildLineNew('line-labels-upper-right',[ydata1],xdata,'小类指数','环比指数变化趋势');
  		 	
  		 	buildLineNew('line-labels-lower-left',[ydata2],xdata,'小类指数','同比指数变化趋势');
  		//	 buildLineNew('line-labels-lower-right',[ydata],xdata,'小类指数','指数变化趋势');
  		}
  		
  	});
}
  
//绘制某个具体药店的某类药品指数变化折线图
function showLineWithPharm(categId,pharmId){
	


	$.ajax({
		url:"${APP_PATH}/categ3index/getRecentCateg3IndicesWithPharmById",
		data:{"categId":categId,"pharmId":pharmId},
		type:"POST",
		success:function(result){
			
		    var ydata=result.extend.recentIndices.dataMap;
		    var ydata1=result.extend.recentIndices.dataMap1;
		    var ydata2=result.extend.recentIndices.dataMap2;
		    var xdata=result.extend.recentIndices.xdata;
		
		    console.log(result);
		   for(var i=0;i<ydata.data.length;i++){
				ydata.data[i]=Number(ydata.data[i]);
		 }
		   for(var i=0;i<ydata1.data.length;i++){
				ydata1.data[i]=Number(ydata1.data[i]);
		 }
		   for(var i=0;i<ydata2.data.length;i++){
				ydata2.data[i]=Number(ydata2.data[i]);
		 }
		 	buildLineNew('line-labels-upper-left',[ydata],xdata,'小类指数','定基指数变化趋势');
		 	buildLineNew('line-labels-upper-right',[ydata1],xdata,'小类指数','环比指数变化趋势');
		 	
		 	buildLineNew('line-labels-lower-left',[ydata2],xdata,'小类指数','同比指数变化趋势');
		 	// buildLineNew('line-labels-lower-right',[ydata],xdata,'四级分类指数','指数变化趋势');
		}
		
	});
	/*
	var xdata=['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
	var data=[{
	        name: '阿莫西林',
            data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
    }];
	buildLine(data,xdata,'四级分类指数','指数变化趋势');*/
 }
		



</script>
</body>
</html>