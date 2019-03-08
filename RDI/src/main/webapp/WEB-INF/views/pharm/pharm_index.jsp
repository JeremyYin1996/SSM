<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>药品指数</title>
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

<div class="container">
    <div class="row Top">
       <div class="col-lg-3 col-md-3 col-sm-3  col-xs-3">
		     药品名称：<input placeholder="请输入药品名称" type="text" name="drugName"/>
	   </div>
	   <div class="col-lg-2 col-md-2 col-sm-2  col-xs-2">
	        <select class="sort" name="indexSort">
			        <option value="" selected>指数</option>
			        <option value="desc">指数降序</option>
			        <option value="asc">指数升序</option>
		     </select>
	   </div>
	   <div class="col-lg-3 col-md-3 col-sm-3  col-xs-3">
	        <select class="statisyear" name="statisYear">
			         <option value="" selected>请选择</option>
			         <option value="2017">2017</option>
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
			         <option value="" selected>请选择</option>
			         <option value="1">1</option>
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
	    <div class="col-lg-2 col-md-2 col-sm-2  col-xs-2">
             <button id="find">搜&nbsp&nbsp索</button>
	     </div>
    </div>
    <div class="row Center">
	    	<table class="table table-bordered table-hover" id="drugs_table" >
			   <thead>
			       <tr class='head'>
		    	       <th style="text-align:center">药品名称</th>
		    	       <th style="text-align:center">批准文号</th>
		   	 	       <th style="text-align:center">剂型</th>
		    	       <th style="text-align:center">规格</th>
		    	       <th style="text-align:center">厂商</th>
		    	       <th style="text-align:center">权重</th>
		    	       <th style="text-align:center">价格指数</th>
		    	       <th style="text-align:center">统计日期</th>
		    	       <th style="text-align:center">操作</th>
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
		
		$("#find").click(function(){
			to_page(1);
		});
		
		function to_page(pn){
			
			var drugName = $(".Top input[name='drugName']").val();
			var indexSort = $(".sort[name='indexSort']").val();
			var statisYear = $(".statisyear[name='statisYear']").val();
			var statisMonth = $(".statismonth[name='statisMonth']").val();
			
			
			$.ajax({
				url:"${APP_PATH}/drugindex/getdrugindices",
				data:{"pn":pn,
					  "drugName":drugName,
					  "indexSort":indexSort,
					  "statisYear":statisYear,
					  "statisMonth":statisMonth  
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
				var drugNameTd = $("<td></td>").append(item.drug.drugName);
				var dosageFormTd = $("<td></td>").append(item.drug.dosageForm);
				var approvalNumberTd = $("<td></td>").append(item.drug.approvalNumber);
				//var specificationsTd = $("<td></td>").append(item.drug.specifications);	
				var specTd = $("<td></td>").append(item.drug.spec);	
				var manufacturerTd = $("<td></td>").append(item.drug.manufacturer);
				var drugWeightTd = $("<td></td>").append(item.drugWeight);
				var drugIndexTd = $("<td></td>").append(item.drugIndex);
				var statisDateTd = $("<td></td>").append(item.statisDate);
                var detailsBtn = $("<button></button>").addClass("btn btn-primary btn-sm details_btn")
								.append($("<span></span>").addClass("glyphicon glyphicon-info-sign")).append("查看详情");
				//为详情按钮添加一个自定义的属性，来表示当前药品id
				detailsBtn.attr("details-id",item.drugId);
				
				var btnTd = $("<td></td>").append(detailsBtn);
				
				//append方法执行完成以后还是返回原来的元素
				$("<tr></tr>").append(drugNameTd)				
					.append(approvalNumberTd)
					.append(dosageFormTd)
					.append(specTd)
					.append(manufacturerTd)
					.append(drugWeightTd)
					.append(drugIndexTd)
					.append(statisDateTd)
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
			
			var url ="${APP_PATH}/drugindex/drugIndicesDetail?drugId="+drugId;
			window.open(url);
			
			//getDrugIndices(drugId);
			
		});
		/*function getDrugIndices(drugId){
			var url ="${APP_PATH}/query/drugIndicesDetail?drugId="+drugId;
			window.open(url);
		}
		*/
		
	
	</script>
</body>
</html>