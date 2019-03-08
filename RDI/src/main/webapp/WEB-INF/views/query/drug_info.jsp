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
<title>药品信息</title>

<%	pageContext.setAttribute("APP_PATH", request.getContextPath()); %>

<script type="text/javascript" src="${APP_PATH }/static/js/template.js"></script>
<link rel="stylesheet" href="${APP_PATH }/static/css/query/query.css">

</head>

<body>
<%@ include file="../common/top_menu.jsp" %>

<div class="container">
    <div class="row Top">
       <div class="col-lg-3 col-md-4 col-sm-5 col-xs-5">
		     药品名称：<input placeholder="请输入药品名称" type="text" name="drugName"/>
	   </div>
	   <div class="col-lg-3 col-md-4 col-sm-5 col-xs-5">
	                批准文号：<input placeholder="请输入批准文号" type="text" name="approvalNumber"/>
	   </div>
	  
	    <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
             <button id="find">搜&nbsp&nbsp索</button>
	     </div>
    </div>
    <div class="row Center">
	    	<table class="table table-bordered table-hover" id="drugs_table" >
			   <thead>
			       <tr class='head'> 	     
		    	       <th style="text-align:center">药品名称</th>
		    	       <th style="text-align:center">剂型</th>
		    	       <th style="text-align:center">批准文号</th>
		    	      <!--  <th style="text-align:center">ATC编码</th> -->
		    	       <th style="text-align:center">条形码</th>
		    	       <th style="text-align:center">规格</th>
		    	       <th style="text-align:center">限定日剂量</th>
		    	       <th style="text-align:center">厂商</th>
		    	       <th style="text-align:center">所属类别</th>	 
		    	       <th style="text-align:center">销售药店</th>
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
		//1、页面加载完成以后，直接去发送ajax请求,要到分页数据
		$(function(){
			//去首页
			to_page(1);
		});
		
		$("#find").click(function(){
			to_page(1);
		});
		
		function to_page(pn){
			
			var drugName = $(".Top input[name='drugName']").val();
			var approvalNumber = $(".Top input[name='approvalNumber']").val();
			
			
			$.ajax({
				url:"${APP_PATH}/drug/getDrugs",
				data:{"pn":pn,
					  "drugName":drugName,
					  "approvalNumber":approvalNumber,				
					},
				type:"POST",
				success:function(result){
					console.log(result);
					//1、解析并显示员工药品数据
					build_drugs_table(result);
					//2、解析并显示分页信息
					build_page_info(result);
					//3、解析显示分页条数据
					build_page_nav(result);
				}
			});
		}
		
		function build_drugs_table(result){
			//清空table表格
			$("#drugs_table tbody").empty();
			var drugs = result.extend.pageInfo.list;
			$.each(drugs,function(index,item){
			//	var drugIdTd = $("<td></td>").append(item.drugId);
				var drugNameTd = $("<td></td>").append(item.drugName);
				var dosageFormTd = $("<td></td>").append(item.dosageForm);
				var approvalNumberTd = $("<td></td>").append(item.approvalNumber);
				//var atcCodeTd = $("<td></td>").append(item.atcCode);
				var barCodeTd = $("<td></td>").append(item.barCode);	
				var specTd = $("<td></td>").append(item.spec);	
				var dddTd = $("<td></td>").append(item.ddd);	
				var manufacturerTd = $("<td></td>").append(item.manufacturer);
				var categNameTd = $("<td></td>").append(item.category.categName);		
                var detailsBtn = $("<button></button>").addClass("btn btn-primary btn-sm details_btn")
								.append($("<span></span>").addClass("glyphicon glyphicon-info-sign")).append("查看详情");
				//为详情按钮添加一个自定义的属性，来表示当前药品id
				detailsBtn.attr("details-id",item.drugId);	
				detailsBtn.attr("drug-name",item.drugName);
				var btnTd = $("<td></td>").append(detailsBtn);				
				//append方法执行完成以后还是返回原来的元素
				$("<tr></tr>").append(drugNameTd)				
					.append(dosageFormTd)
					.append(approvalNumberTd)
					//.append(atcCodeTd)
					.append(barCodeTd)
					.append(specTd)
					.append(dddTd)
					.append(manufacturerTd)
					.append(categNameTd)
					.append(btnTd)
			 		.appendTo("#drugs_table tbody");
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
	
		$(document).on("click",".details_btn",function(){

			//1、获取当前行的drug_id,并查询详细信息
			var drugId=$(this).attr("details-id");	
			var drugName=$(this).attr("drug-name");	
			
			var url ="${APP_PATH}/pharmacy/toPharmsByDrugId?drugId="+drugId+
					"&drugName="+drugName;
			window.open(url);
	
		});
		
		
	
	</script>
</body>
</html>