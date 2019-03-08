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
<title>小类指数预警</title>

<%	pageContext.setAttribute("APP_PATH", request.getContextPath()); %>

<script type="text/javascript" src="${APP_PATH }/static/js/template.js"></script>
<link rel="stylesheet" href="${APP_PATH }/static/css/query/query.css">

</head>

<body>
<%@ include file="../common/top_menu.jsp" %>


<div class="container">
    <div class="row Top">
 <div class="col-lg-12 col-md-4 col-sm-5 col-xs-5">    
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
</div>
	   <div class="col-lg-3 col-md-4 col-sm-5 col-xs-5">
		分类名称：<input placeholder="请输入分类名称" type="text" name="categName"/>
	 </div>
         <div class="col-lg-2 col-md-3 col-sm-4  col-xs-4">
	      地区：
	        <select class="district" name="district" id="district">
			         <option value="" selected>请选择</option>     
		     </select>
	    </div>
	    <div class="col-lg-3 col-md-4 col-sm-5  col-xs-5">
	      药店：
	        <select class="drugstore" name="drugstore" id="drugstore">
			         <option value="" selected>请选择</option>
			      
		     </select>
	    </div> 
	   
	    <div class="col-lg-3 col-md-4 col-sm-4  col-xs-5">
	             统计月份：<select class="statisyear" name="statisYear">	    
			         <option value="2017" selected>2017</option>
			         <option value="2018">2018</option>
			         <option value="2019">2019</option>
			         <option value="2020">2020</option>
			         <option value="2021">2021</option>
			         <option value="2022">2022</option>
			         <option value="2023">2023</option>
			         <option value="2024">2024</option>
			         <option value="2025">2025</option>
			         <option value="2026">2026</option>
		     </select>年
		     <select class="statismonth" name="statisMonth">   
			         <option value="1" selected>1</option>
			         <option value="2">2</option>
			         <option value="3">3</option>
			         <option value="4">4</option>
			         <option value="5">5</option>
			         <option value="6">6</option>
			         <option value="7">7</option>
			         <option value="8">8</option>
			         <option value="9">9</option>
			         <option value="10">10</option>
			         <option value="11">11</option>
			         <option value="12">12</option>
		     </select>月
	    </div>

	    <div class="col-lg-3 col-md-4 col-sm-4  col-xs-5">
	               下浮百分比：      <select class="sort" name="decrease" id="decrease">
			        <option value="-0.5" selected>请选择</option>
			        <option value="-0.3">-30%</option>
			        <option value="-0.4">-40%</option>
			        <option value="-0.5">-50%</option>
			        <option value="-0.6">-60%</option>
			        <option value="-0.7">-70%</option>
			        <option value="-0.8">-80%</option>
			        <option value="-0.9">-90%</option>
			        <option value="-1">-100%以上</option>
			        
		     </select>
		     </div>
		      <div class="col-lg-3 col-md-4 col-sm-4  col-xs-5">
		      上浮百分比：    <select class="sort" name="rise" id="rise">
			        <option value="0.5" selected>请选择</option>
			        <option value="0.3">30%</option>
			        <option value="0.4">40%</option>
			        <option value="0.5">50%</option>
			        <option value="0.6">60%</option>
			        <option value="0.7">70%</option>
			        <option value="0.8">80%</option>
			        <option value="0.9">90%</option>
			        <option value="1">100%以上</option>     
		      </select>
	        
	   </div>
	    <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
             <button id="find">搜&nbsp&nbsp索</button>
	     </div>
</div>
    
    <div class="row">
        <h6 style="color:red;">注1：本页面显示的是价格波动异常的数据，即与全市均价比，差距较大的地区或药店。</h6>
        <h6 style="color:red;">注2：浮动百分比即以全市均值为参照值，药店药品价格指数与之差的百分比，浮动百分比绝对值越大，则药品价格越不稳定。</h6>
        <h6 style="color:red;">注3：地区和药店不是必选项，若都不选择，则统计的是整个宿迁市的价格指数；若仅选择地区未选择药店，则统计的是该地区的价格指数.   
        <p> </p>
                <p> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上下浮动百分比不是必选项，若不选择，默认值为下浮50%，上浮50%之外的数据异常；</p>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;药品分类不是必选项，若都不选择，则统计全市所有当前分类的价格指数；若选择，需选取当前最小分类（一级分类最大，四级分类最小）
        </h6>
    </div>
     <div class="row Center">
	    	<table class="table table-bordered table-hover" id="warning_table" >
			   <thead>
			       <tr class='head'>
		    	       <th style="text-align:center">分类名称</th>
		    	       <th id="table-statis-range" style="text-align:center">所在区域</th>
		    	       <th id="table-pharm-name" style="text-align:center">药店名</th>	
		    	       <th id="pharam-index"style="text-align:center">药店均值</th>
		    	       <th id="area-index"style="text-align:center">地区均值</th>
		    	       <th style="text-align:center">全市均值</th>     
		    	       <th style="text-align:center">浮动百分比</th>     	    	       	     
		    	       <th style="text-align:center">统计月份</th>
			      </tr>
			   </thead>		
		     <tbody>
					
		     </tbody>
		     </table>


<!-- 显示分页信息 -->
	<div class="row">
		<!--分页文字信息  -->
		<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6" id="page_info_area"></div>
		<!-- 分页条信息 -->
		<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6" id="page_nav_area"></div>
	</div>

</div>
</div>



<script type="text/javascript">

var totalRecord,currentPage;

$(function(){
	$("#classifybymiddle").change(function(){
		$("#classifybysmall option:not(:first)").remove();
		var classifybymiddleId=$(this).val();
		
		if(classifybymiddle!=""){
			$.ajax({
				url:"${APP_PATH}/category/getClassifyBySmall",
				data:{"classifybymiddleId":classifybymiddleId},
				type:"POST",
				success:function(result){
					console.log(result);
					classifybysmall=result.extend.category;
					if(classifybymiddleId!="" && classifybysmall.length==0)
						alert("当前城市没有药纳入统计");		
					else{
						$.each(classifybysmall,function(){
						var optionEle = $("<option></option>").append(this.categName).attr("value",this.categId);
						optionEle.appendTo("#classifybysmall");
				      });
					}
				}
			});					
		}		
	})	
});
$(function(){
	$("#classifybylarge").change(function(){
		$("#classifybymiddle option:not(:first)").remove();
		var classifybylargeId=$(this).val();
		
		if(classifybylarge!=""){
			$.ajax({
				url:"${APP_PATH}/category/getClassifyByMiddle",
				data:{"classifybylargeId":classifybylargeId},
				type:"POST",
				success:function(result){
					console.log(result);
					classifybymiddle=result.extend.category;
					if(classifybylargeId!="" && classifybymiddle.length==0)
						alert("当前城市没有药纳入统计");		
					else{
						$.each(classifybymiddle,function(){
						var optionEle = $("<option></option>").append(this.categName).attr("value",this.categId);
						optionEle.appendTo("#classifybymiddle");
				      });
					}
				}
			});					
		}		
	})	
});

$(function(){
	getClassifyByLarge("#classifybylarge");			
});

function getClassifyByLarge(ele){
	//清空之前下拉列表的值
	$("ele option:not(:first)").remove();
	$.ajax({
		url:"${APP_PATH}/category/getClassifyByLarge",
		type:"GET",
		success:function(result){
			console.log(result);
			$.each(result.extend.category,function(){
				var optionEle = $("<option></option>").append(this.categName).attr("value",this.categId);
				optionEle.appendTo(ele);
		});
		}
	});
}



$(function(){
	$("#district").change(function(){
		$("#drugstore option:not(:first)").remove();
		var districtId=$(this).val();
		
		if(district!=""){
			$.ajax({
				url:"${APP_PATH}/pharmacy/getDrugStores",
				data:{"districtId":districtId},
				type:"POST",
				success:function(result){
					console.log(result);
					drugstores=result.extend.drugstores;
					if(districtId!="" && drugstores.length==0)
						alert("当前城市没有药店纳入统计");		
					else{
						$.each(drugstores,function(){
						var optionEle = $("<option></option>").append(this.pharmName).attr("value",this.pharmId);
						optionEle.appendTo("#drugstore");
				      });
					}
				}
			});					
		}		
	})	
});

$(function(){
	getDistricts("#district");			
});

function getDistricts(ele){
	//清空之前下拉列表的值
	$("ele option:not(:first)").remove();
	$.ajax({
		url:"${APP_PATH}/district/getDistricts",
		type:"GET",
		success:function(result){
			console.log(result);
			$.each(result.extend.districts,function(){
				var optionEle = $("<option></option>").append(this.county).attr("value",this.districtId);
				optionEle.appendTo(ele);
		});
		}
	});
	
}


//1、页面加载完成以后，直接去发送ajax请求,要到分页数据
/*$(function(){
	//去首页
	to_page(1);
});*/
$("#find").click(function(){
	to_page(1);
});

function to_page(pn){

	var categName = $(".Top input[name='categName']").val();
	var rise = $(".sort[name='rise']").val();
	var decrease = $(".sort[name='decrease']").val();
	var year = $(".Top select[name='statisYear']").val();
	var month = $(".Top select[name='statisMonth']").val();
	var districtId = $(".district[name='district']").val();
	var drugstoreId = $(".drugstore[name='drugstore']").val();
	var classifybykindsId=$(".Top select[name='classifybykinds']").val();
	var classifybysmallId=$(".Top select[name='classifybysmall']").val();
	var classifybymiddleId=$(".Top select[name='classifybymiddle']").val();
	var classifybylargeId=$(".Top select[name='classifybylarge']").val();
	if(districtId==null||districtId=="" || $.trim(districtId)=="")
	{
		$.ajax({
			url:"${APP_PATH}/warning/allExceptionDataSmall",
			data:{"pn":pn,
				  "categName":categName,
				  "rise":rise,
				  "decrease":decrease,	
				  "year":year,	
				  "month":month,
				  "classifybysmallId":classifybysmallId,
				},
			type:"POST",
			success:function(result){
				console.log(result);
				build_warning_table(result);
				build_page_info(result);
				build_page_nav(result);
				}
				});
	}
	else if(drugstoreId==null||drugstoreId=="" || $.trim(drugstoreId)=="")
	{
		$.ajax({
			url:"${APP_PATH}/warning/withDisExceptionDataSmall",
			data:{"pn":pn,
				  "categName":categName,
				  "rise":rise,
				  "decrease":decrease,	
				  "year":year,	
				  "month":month,
				  "districtId":districtId,
				  "classifybysmallId":classifybysmallId,
				},
			type:"POST",
			success:function(result){
				console.log(result);
				//1、解析并显示员工药品数据
				build_warning_withDis_table(result);
				//2、解析并显示分页信息
				build_page_info(result);
				//3、解析显示分页条数据
				build_page_nav(result);
				}
				});
		
	}
	else
		{
		$.ajax({
			url:"${APP_PATH}/warning/withPharamExceptionDataSmall",
			data:{"pn":pn,
				  "categName":categName,
				  "rise":rise,
				  "decrease":decrease,	
				  "year":year,	
				  "month":month,
				  "districtId":districtId,
				  "drugstoreId":drugstoreId,
				  "classifybysmallId":classifybysmallId,

				},
			type:"POST",
			success:function(result){
				console.log(result);
				//1、解析并显示员工药品数据
				build_warning__withPharm_table(result);
				//2、解析并显示分页信息
				build_page_info(result);
				//3、解析显示分页条数据
				build_page_nav(result);
				}
				});
		
		}
	
	
				       
}		
function build_warning_table(result){
	$("#warning_table tbody").empty();
	$("#table-statis-range").hide();
	$("#area-index").hide();
	var warning=result.extend.pageInfo.list;
	$.each(warning,function(index,item){
		//item=warning[index]
		var categNameTd=$("<td></td>").append(item.category.categName);
		var pharmNameTd=$("<td></td>").append(item.pharmacy.pharmName);
		var cityCategIndex=$("<td></td>").append(item.categ3Index.categIndex);
		var categIndex=$("<td></td>").append(item.categIndex);
		var percent=$("<td></td>").append((((item.categIndex-item.categ3Index.categIndex)/item.categ3Index.categIndex)*100).toFixed(2)+"%");
		var statisDateTd = $("<td></td>").append(item.statisDate);
		$("<tr></tr>").append(categNameTd)
		              .append(pharmNameTd)
					  .append(categIndex)
					  .append(cityCategIndex)
					  .append(percent)
					  .append(statisDateTd)
					  .appendTo("#warning_table tbody");
		
	});	
}

function build_warning_table(result){
	$("#warning_table tbody").empty();
	$("#table-statis-range").hide();
	$("#area-index").hide();
	var warning=result.extend.pageInfo.list;
	$.each(warning,function(index,item){
		//item=warning[index]
		var categNameTd=$("<td></td>").append(item.category.categName);
		var pharmNameTd=$("<td></td>").append(item.pharmacy.pharmName);
		var cityCategIndex=$("<td></td>").append(item.categ3Index.categIndex);
		var categIndex=$("<td></td>").append(item.categIndex);
		var percent=$("<td></td>").append((((item.categIndex-item.categ3Index.categIndex)/item.categ3Index.categIndex)*100).toFixed(2)+"%");
		var statisDateTd = $("<td></td>").append(item.statisDate);
		$("<tr></tr>").append(categNameTd)
		              .append(pharmNameTd)
					  .append(categIndex)
					  .append(cityCategIndex)
					  .append(percent)
					  .append(statisDateTd)
					  .appendTo("#warning_table tbody");
		
	});	
}

function build_warning_withDis_table(result){
	$("#warning_table tbody").empty();
	$("#table-pharm-name").hide();
	$("#pharam-index").hide();
	$("#table-statis-range").show();
	$("#area-index").show();

	var warning=result.extend.pageInfo.list;
	$.each(warning,function(index,item){
		//item=warning[index]
		var categNameTd=$("<td></td>").append(item.category.categName);
		var districtId=$("<td></td>").append(item.district.county);
		var cityCategIndex=$("<td></td>").append(item.categ3Index.categIndex);
		var categIndex=$("<td></td>").append(item.categIndex);
		var percent=$("<td></td>").append((((item.categIndex-item.categ3Index.categIndex)/item.categ3Index.categIndex)*100).toFixed(2)+"%");
		var statisDateTd = $("<td></td>").append(item.statisDate);
		$("<tr></tr>").append(categNameTd)
		              .append(districtId)
					  .append(categIndex)
					  .append(cityCategIndex)
					  .append(percent)
					  .append(statisDateTd)
					  .appendTo("#warning_table tbody");
		
	});	
}

function build_warning__withPharm_table(result){
	$("#warning_table tbody").empty();
	$("#table-statis-range").hide();
	$("#area-index").hide();
	$("#table-pharm-name").show();
	$("#pharam-index").show();
	var warning=result.extend.pageInfo.list;
	//if(item.size==0)
	//{alert("当前无数据异常1");}

	$.each(warning,function(index,item){
		//if(item.size==0)
			//{alert("当前无数据异常1");}

		var categNameTd=$("<td></td>").append(item.category.categName);
		var pharmNameTd=$("<td></td>").append(item.pharmacy.pharmName);
		var cityCategIndex=$("<td></td>").append(item.categ3Index.categIndex);
		var categIndex=$("<td></td>").append(item.categIndex);
		var percent=$("<td></td>").append((((item.categIndex-item.categ3Index.categIndex)/item.categ3Index.categIndex)*100).toFixed(2)+"%");
		var statisDateTd = $("<td></td>").append(item.statisDate);
		$("<tr></tr>").append(categNameTd)
					  .append(pharmNameTd)
					  .append(categIndex)
						  .append(cityCategIndex)
					  .append(percent)
					  .append(statisDateTd)
					  .appendTo("#warning_table tbody");
		
	});	
}

//解析显示分页信息
function build_page_info(result){
	$("#page_info_area").empty();
	$("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页,总"+
			result.extend.pageInfo.pages+"页,总"+
			result.extend.pageInfo.total+"条记录");
	totalRecord = result.extend.pageInfo.total;
	currentPage = result.extend.pageInfo.pageNum;
}
//解析显示分页条，点击分页要能去下一页....
function build_page_nav(result){
	//page_nav_area
	$("#page_nav_area").empty();
	var ul = $("<ul></ul>").addClass("pagination");
	
	//构建元素
	var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
	var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
	if(result.extend.pageInfo.hasPreviousPage == false){
		firstPageLi.addClass("disabled");
		prePageLi.addClass("disabled");
	}else{
		//为元素添加点击翻页的事件
		firstPageLi.click(function(){
			to_page(1);
		});
		prePageLi.click(function(){
			to_page(result.extend.pageInfo.pageNum -1);
		});
	}

	var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
	var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
	if(result.extend.pageInfo.hasNextPage == false){
		nextPageLi.addClass("disabled");
		lastPageLi.addClass("disabled");
	}else{
		nextPageLi.click(function(){
			to_page(result.extend.pageInfo.pageNum +1);
		});
		lastPageLi.click(function(){
			to_page(result.extend.pageInfo.pages);
		});
	}

	//添加首页和前一页 的提示
	ul.append(firstPageLi).append(prePageLi);
	//1,2，3遍历给ul中添加页码提示
	$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
		
		var numLi = $("<li></li>").append($("<a></a>").append(item));
		if(result.extend.pageInfo.pageNum == item){
			numLi.addClass("active");
		}
		numLi.click(function(){
			to_page(item);
		});
		ul.append(numLi);
	});
	//添加下一页和末页 的提示
	ul.append(nextPageLi).append(lastPageLi);
	
	//把ul加入到nav
	var navEle = $("<nav></nav>").append(ul);
	navEle.appendTo("#page_nav_area");
}


	</script>

</body>
</html>