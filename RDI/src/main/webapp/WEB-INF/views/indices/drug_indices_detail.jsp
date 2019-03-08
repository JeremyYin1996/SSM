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

<title>药品详情</title>
<%	pageContext.setAttribute("APP_PATH", request.getContextPath()); %>

<script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<script src="${APP_PATH }/static/js/template.js"></script>
<script src="${APP_PATH }/static/js/highcharts.js"></script>
<script src="${APP_PATH }/static/js/exporting.js"></script>
<script src="${APP_PATH }/static/js/buildCharts.js"></script>

<link rel="stylesheet" href="${APP_PATH }/static/css/common/bottom_menu.css">
<link rel="stylesheet" href="${APP_PATH }/static/css/indices/drug_indices_detail.css">

<script id="drugDetailTable" type="text/html">
	<tr><th>中文名称：</th><td>{{drugName}}</td></tr>
	<tr><th>剂型：</th><td>{{dosageForm}}</td></tr>
	<tr><th>ATC编码：</th><td>{{atcCode}}</td></tr>
	<tr><th>批准文号：</th><td>{{approvalNumber}}</td></tr>
	<tr><th>条形码：</th><td>{{barCode}}</td></tr>
	<tr><th>生产厂家：</th><td>{{manufacturer}}</td></tr>
	<tr><th>规格：</th><td>{{spec}}</td></tr>
	<tr><th>日剂量：</th><td>{{ddd}}</td></tr>
</script>
<script id="categDetailTable" type="text/html">
	<tr><th>所属类别：</th><td>{{categName}}</td></tr>
</script>

</head>

<body>
	<%@ include file="../common/top_menu.jsp"%>
	<div class="center">
		<div class="showCenter">
			<div id="showData">
				<table></table>
			</div>
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
	var drugId = "${requestScope.drugId }";
	var pharmId = "${requestScope.pharmId }";
	var districtId = "${requestScope.districtId }";

	
	showData(drugId);
	
	if(pharmId!=null && pharmId!="" && pharmId.trim()!="")
		{
		   showLineWithPharm(drugId,pharmId);
		}
	else if(districtId!=null && districtId!="" && districtId.trim()!="")
		{
		 showLineWithDistrict(drugId,districtId);
		
		}
	else
		{
		showLine(drugId);
		}

    });
  
//绘制整个市的某类药品指数变化折线图
  function showLine(drugId){

  	$.ajax({
  		url:"${APP_PATH}/drugindex/getRecentDrugIndicesById",
  		data:{"drugId":drugId},
  		type:"POST",
  		success:function(result){
  			console.log(result);
  		    var ydata=result.extend.recentIndices.dataMap;
  		    var ydata1=result.extend.recentIndices.dataMap1;
		    var ydata2=result.extend.recentIndices.dataMap2;
  		    var xdata=result.extend.recentIndices.xdata;
  		
  		    
  		   for(var i=0;i<ydata.data.length;i++){
  				ydata.data[i]=Number(ydata.data[i]);
  		 }
  		   for(var i=0;i<ydata1.data.length;i++){
				ydata1.data[i]=Number(ydata1.data[i]);
		 }
		   for(var i=0;i<ydata2.data.length;i++){
				ydata2.data[i]=Number(ydata2.data[i]);
		 }
  		 	
		   buildLineNew('line-labels-upper-right',[ydata],xdata,'药品指数','定基指数变化趋势'); 	
		   buildLineNew('line-labels-lower-left',[ydata1],xdata,'药品指数','环比指数变化趋势');
		   buildLineNew('line-labels-lower-right',[ydata2],xdata,'药品指数','同比指数变化趋势');
  		}
  		
  	});
}
  
//绘制某个区域的某类药品指数变化折线图
  function showLineWithDistrict(drugId,districtId){

  	$.ajax({
  		url:"${APP_PATH}/drugindex/getRecentDrugIndicesWithDistrictById",
  		data:{"drugId":drugId,"districtId":districtId},
  		type:"POST",
  		success:function(result){
  			console.log(result);
  		    var ydata=result.extend.recentIndices.dataMap;
  		    var ydata1=result.extend.recentIndices.dataMap1;
		    var ydata2=result.extend.recentIndices.dataMap2;
		    var xdata=result.extend.recentIndices.xdata;
  		    
  		   for(var i=0;i<ydata.data.length;i++){
  				ydata.data[i]=Number(ydata.data[i]);
  		 }
  		   for(var i=0;i<ydata1.data.length;i++){
				ydata1.data[i]=Number(ydata1.data[i]);
		 }
		   for(var i=0;i<ydata2.data.length;i++){
				ydata2.data[i]=Number(ydata2.data[i]);
		 }
  		 
		   buildLineNew('line-labels-upper-right',[ydata],xdata,'药品指数','定基指数变化趋势'); 	
		   buildLineNew('line-labels-lower-left',[ydata1],xdata,'药品指数','环比指数变化趋势');
		   buildLineNew('line-labels-lower-right',[ydata2],xdata,'药品指数','同比指数变化趋势');
  		}
  		
  	});
}
  
//绘制某个具体药店的某类药品指数变化折线图
function showLineWithPharm(drugId,pharmId){
	


	$.ajax({
		url:"${APP_PATH}/drugindex/getRecentDrugIndicesWithPharmById",
		data:{"drugId":drugId,"pharmId":pharmId},
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
		 	
		 	buildLineNew('line-labels-upper-right',[ydata],xdata,'药品指数','定基指数变化趋势'); 	
		 	buildLineNew('line-labels-lower-left',[ydata1],xdata,'药品指数','环比指数变化趋势');
		 	buildLineNew('line-labels-lower-right',[ydata2],xdata,'药品指数','同比指数变化趋势');
		}
		
	});
}
	
	
	
 
  
  function showData(drugId){
		$.ajax({
			url:"${APP_PATH}/drug/getDrugDetail",
			data:{"drugId":drugId},
			type:"POST",
			success:function(result){
			var drugDetail = result.extend.drug;
			console.log(result);
			var insertDrugDetail = template('drugDetailTable',drugDetail);
				$("#showData table").append(insertDrugDetail);
			var categDetail = result.extend.drug.category;
			var insertCategDetail = template('categDetailTable',categDetail);
				$("#showData table").append(insertCategDetail);
				
			}		
		});
	}


</script>
</body>
</html>