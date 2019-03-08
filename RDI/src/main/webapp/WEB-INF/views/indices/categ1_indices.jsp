<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>大类指数</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<%	pageContext.setAttribute("APP_PATH", request.getContextPath()); %>

<script type="text/javascript" src="${APP_PATH }/static/js/template.js"></script>
<link rel="stylesheet" href="${APP_PATH }/static/css/query/query.css">

</head>

<body>
<%@ include file="../common/top_menu.jsp" %>
<div class="container">
    <div class="row Top">
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
	     <div class="col-lg-5 col-md-4 col-sm-5  col-xs-5">
		     分类名称：<input placeholder="请输入分类名称" type="text" name="categName"/>
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
	  
	    <div class="col-lg-2 col-md-3 col-sm-4  col-xs-4">
	    指数排序：    <select class="sort" name="indexSort">
			        <option value="" selected>指数</option>
			        <option value="desc">指数降序</option>
			        <option value="asc">指数升序</option>
		     </select>
	   </div>
	    <div class="col-lg-1 col-md-1 col-sm-2  col-xs-2">
             <button id="find">搜&nbsp;&nbsp;索</button>
	     </div>
    </div>
    <div class="row">
        <h6 style="color:red;">注1：地区和药店不是必选项，若都不选择，则统计的是整个宿迁市的价格指数；若仅选择地区未选择药店，则统计的是该地区的价格指数.</h6>
        <h6 style="color:red;">注2：分类名称可不填，此时将查询所有分类的价格指数.</h6>
        <h6 style="color:red;">注3：下表中，点击"指数对比"下方的"横向"按钮可以查出该类别在不同的统计范围下的指数，
                                                                                    点击"纵向"按钮可查看该类别最近一年的指数变化情况.</h6>
    </div>
    <div class="row Center">
	    	<table class="table table-bordered table-hover" id="categindex_table" >
			   <thead>
			       <tr class='head'>
		    	       <th style="text-align:center">分类名</th>
		    	       <th style="text-align:center">分类级别</th> 	 	         	
		    	       <th id="table-statis-range" style="text-align:center">所在区域</th>	
		    	       <th id="table-pharm-name" style="text-align:center">药店名</th>
		    	       <th style="text-align:center">限定日费用</th>   	      
		    	       <th style="text-align:center">统计月份</th>
		    	       <th style="text-align:center">指数对比</th>
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
 
<script type="text/javascript">
	
		var totalRecord,currentPage;
		//1、页面加载完成以后，直接去发送ajax请求,要到药店信息
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
		
		
		$("#find").click(function(){
			to_page(1);
		});
		
		function to_page(pn){
			
			var categName = $(".Top input[name='categName']").val();
			var indexSort = $(".sort[name='indexSort']").val();
			var statisYear = $(".statisyear[name='statisYear']").val();
			var statisMonth = $(".statismonth[name='statisMonth']").val();
			var districtId = $(".district[name='district']").val();
			var drugstoreId = $(".drugstore[name='drugstore']").val();
			
			if(districtId==null||districtId=="" || $.trim(districtId)==""){
				$.ajax({
					url:"${APP_PATH}/categ1index/getCateg1Indices",
					data:{"pn":pn,
						  "categName":categName,
						  "indexSort":indexSort,
						  "statisYear":statisYear,
						  "statisMonth":statisMonth,
						},
					type:"POST",
					success:function(result){
						console.log(result);
						//1、解析并显示员工药品数据
						build_all_city_index_table(result);
						//2、解析并显示分页信息
						build_page_info(result);
						//3、解析显示分页条数据
						build_page_nav(result);
					}
				});
				
			}
			else if(drugstoreId==null||drugstoreId=="" || $.trim(drugstoreId)=="")
				{
				$.ajax({
					url:"${APP_PATH}/categ1index/getCateg1IndicesWithDistrict",
					data:{"pn":pn,
						  "categName":categName,
						  "indexSort":indexSort,
						  "statisYear":statisYear,
						  "statisMonth":statisMonth,
						  "districtId":districtId
						},
					type:"POST",
					success:function(result){
						console.log(result);
						//1、解析并显示员工药品数据
						build_district_index_table(result);
						//2、解析并显示分页信息
						build_page_info(result);
						//3、解析显示分页条数据
						build_page_nav(result);
					}
				});
				
				}
			else{
				$.ajax({
					url:"${APP_PATH}/categ1index/getCateg1IndicesWithPharm",
					data:{"pn":pn,
						  "categName":categName,
						  "indexSort":indexSort,
						  "statisYear":statisYear,
						  "statisMonth":statisMonth,
						  "districtId":districtId,
						  "drugstoreId":drugstoreId
						},
					type:"POST",
					success:function(result){
						console.log(result);
						//1、解析并显示员工药品数据
						build_pharm_index_table(result);
						//2、解析并显示分页信息
						build_page_info(result);
						//3、解析显示分页条数据
						build_page_nav(result);
					}
				});
				
			}
		}
		function build_all_city_index_table(result){

            //清空table表格
			$("#categindex_table tbody").empty();		
			$("#table-pharm-name").hide();
			$("#table-statis-range").empty();
			$("#table-statis-range").text("统计范围");
			
			var categ1indices = result.extend.pageInfo.list;
			$.each(categ1indices,function(index,item){
				
			
				var categNameTd = $("<td></td>").append(item.category.categName);
				var levelTd = $("<td></td>").append("大类");
				// var avgPriceTd = $("<td></td>").append(item.categAvgPrice);	
				var categIndexTd = $("<td></td>").append(item.categIndex);	
				
				
				var districtTd = $("<td></td>").append("宿迁市");
				
				var statisDateTd = $("<td></td>").append(item.statisDate);
				var horizCmpBtn = $("<button></button>").addClass("btn btn-primary btn-sm horiz_cmp_btn").append("横向");
                //为横向比较按钮添加一个自定义的属性，来表示当前分类的id和统计日期
                horizCmpBtn.attr("details-categ-id",item.categId);
                horizCmpBtn.attr("statis-date",item.statisDate);
                var vertiCmpBtn = $("<button></button>").addClass("btn btn-primary btn-sm vertic_cmp_btn").append("纵向");
				//.append($("<span></span>").addClass("glyphicon glyphicon-option-vertical"))
               //为纵向比较按钮添加自定义的属性，来表示当前分类id和统计日期
               vertiCmpBtn.attr("details-categ-id",item.categId);
               vertiCmpBtn.attr("statis-date",item.statisDate);
           
               var btnTd = $("<td></td>").append(horizCmpBtn).append(" ").append(vertiCmpBtn);
				
				//append方法执行完成以后还是返回原来的元素
				$("<tr></tr>").append(categNameTd)				
					.append(levelTd)
					.append(districtTd)
					.append(categIndexTd)
					.append(statisDateTd)
					.append(btnTd)
			 		.appendTo("#categindex_table tbody");
			});
		}
		function build_district_index_table(result){
		
			$("#categindex_table tbody").empty();
			
			$("#table-pharm-name").hide();
			$("#table-statis-range").empty();
			$("#table-statis-range").text("统计范围");
			var categ1indices = result.extend.pageInfo.list;
			$.each(categ1indices,function(index,item){
				
			
				var categNameTd = $("<td></td>").append(item.category.categName);
				var levelTd = $("<td></td>").append("大类");
			//	var avgPriceTd = $("<td></td>").append(item.categAvgPrice);	
				var categIndexTd = $("<td></td>").append(item.categIndex);	
				
			
				var districtTd = $("<td></td>").append(item.district.county);
				
				var statisDateTd = $("<td></td>").append(item.statisDate);
				var horizCmpBtn = $("<button></button>").addClass("btn btn-primary btn-sm horiz_cmp_btn").append("横向");
                //为横向比较按钮添加一个自定义的属性，来表示当前分类的id和统计日期
                horizCmpBtn.attr("details-categ-id",item.categId);
                horizCmpBtn.attr("statis-date",item.statisDate);
                horizCmpBtn.attr("details-district-id",item.districtId);
                var vertiCmpBtn = $("<button></button>").addClass("btn btn-primary btn-sm vertic_cmp_btn").append("纵向");
				//.append($("<span></span>").addClass("glyphicon glyphicon-option-vertical"))
               //为纵向比较按钮添加自定义的属性，来表示当前分类id和统计日期
               vertiCmpBtn.attr("details-categ-id",item.categId);
               vertiCmpBtn.attr("statis-date",item.statisDate);
               vertiCmpBtn.attr("details-district-id",item.districtId);
           
               var btnTd = $("<td></td>").append(horizCmpBtn).append(" ").append(vertiCmpBtn);
				
				
				//append方法执行完成以后还是返回原来的元素
				$("<tr></tr>").append(categNameTd)				
					.append(levelTd)
					.append(districtTd)
					.append(categIndexTd)
					.append(statisDateTd)
					.append(btnTd)
			 		.appendTo("#categindex_table tbody");
			});
		}
		
		function build_pharm_index_table(result){
			//清空table表格
			$("#categindex_table tbody").empty();
			
			$("#table-pharm-name").show();
			$("#table-statis-range").empty();
			$("#table-statis-range").text("所在区域");
			var categ1indices = result.extend.pageInfo.list;
			$.each(categ1indices,function(index,item){
				
			
				var categNameTd = $("<td></td>").append(item.category.categName);
				var levelTd = $("<td></td>").append("大类");
			//	var avgPriceTd = $("<td></td>").append(item.categAvgPrice);	
				var categIndexTd = $("<td></td>").append(item.categIndex);	
				
				var pharmNameTd = $("<td></td>").append(item.pharmacy.pharmName);
				var districtTd = $("<td></td>").append(item.pharmacy.district.county);
				
				var statisDateTd = $("<td></td>").append(item.statisDate);
				var horizCmpBtn = $("<button></button>").addClass("btn btn-primary btn-sm horiz_cmp_btn").append("横向");
                //为横向比较按钮添加一个自定义的属性，来表示当前分类的id和统计日期
                horizCmpBtn.attr("details-categ-id",item.categId);
                horizCmpBtn.attr("statis-date",item.statisDate);
                horizCmpBtn.attr("details-pharm-id",item.pharmId);
                var vertiCmpBtn = $("<button></button>").addClass("btn btn-primary btn-sm vertic_cmp_btn").append("纵向");
				//.append($("<span></span>").addClass("glyphicon glyphicon-option-vertical"))
               //为纵向比较按钮添加自定义的属性，来表示当前分类id和统计日期
               vertiCmpBtn.attr("details-categ-id",item.categId);
               vertiCmpBtn.attr("statis-date",item.statisDate);
               vertiCmpBtn.attr("details-pharm-id",item.pharmId);
           
               var btnTd = $("<td></td>").append(horizCmpBtn).append(" ").append(vertiCmpBtn);
				
				//append方法执行完成以后还是返回原来的元素
				$("<tr></tr>").append(categNameTd)				
					.append(levelTd)
					.append(districtTd)
					.append(pharmNameTd)
					.append(categIndexTd)
					.append(statisDateTd)
					.append(btnTd)
			 		.appendTo("#categindex_table tbody");
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
		
		//1、我们是按钮创建之前就绑定了click，所以绑定不上。
		//1）、可以在创建按钮的时候绑定。    2）、绑定点击.live()
		//jquery新版没有live，使用on进行替代
		
		$(document).on("click",".vertic_cmp_btn",function(){

			//1、获取当前行的drug_id,并查询详细信息
			var categId=$(this).attr("details-categ-id");	
			var pharmId=$(this).attr("details-pharm-id");
			var districtId=$(this).attr("details-district-id");
			
			var url=null;
			
			if(pharmId!=null && pharmId!="" && pharmId.trim()!="")
				{
			    	url ="${APP_PATH}/categ1index/toCateg1IndicesDetail?categId="+categId+"&pharmId="+pharmId;
				
				}
			else if(districtId!=null && districtId!="" && districtId.trim()!="")
				{
				    url ="${APP_PATH}/categ1index/toCateg1IndicesDetail?categId="+categId+"&districtId="+districtId;	
				}
			else
				url="${APP_PATH}/categ1index/toCateg1IndicesDetail?categId="+categId;
				
			window.open(url);
			
		});
		
		$(document).on("click",".horiz_cmp_btn",function(){

			//1、获取当前行的drug_id,并查询详细信息
			var categId=$(this).attr("details-categ-id");	
			var statisDate=$(this).attr("statis-date");
			var year=Number(statisDate.substr(0,4));
			var month=Number(statisDate.substr(5,2));

			url="${APP_PATH}/categ1index/toHorizCmpDetail?categId="+categId+"&year="+year+"&month="+month;
				
			window.open(url);
			
			
		});
		
		
	
	</script>
	
</body>
</html>