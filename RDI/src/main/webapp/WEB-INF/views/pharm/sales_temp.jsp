<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售数据录入</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<link rel="stylesheet" href="${APP_PATH }/static/css/query/query.css">
</head>
<body>
 <%@ include file="../common/top_menu.jsp" %>
 <div class="container">
      <div class="row Top">
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" align="center">
		<!--    <div class="page-header">-->
                    <h3>提交的销售数据</h3>
         <!--  </div>-->  
	   </div>

    </div>
    <div class="row">
       <h6 style="color:red;">注：数据提交成功, 不可再修改, 如需修改, 请联系管理员.</h6>
    </div>
   

   <div id="tablediv" class="row Center" align="center">
     	<table class="table table-bordered table-hover" id="sales_table" >
			   <thead>
			       <tr class='head'> 	     
			           <th style="text-align:center">批准文号</th>
		    	       <th style="text-align:center">销售价格</th>
		    	       <th style="text-align:center">销售数量</th>
		    	       <th style="text-align:center">统计日期</th>
		    	       <th style="text-align:center">药店编号</th>	 
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


   $(function(){
	   to_page(1);

   });
   
   function  to_page(n)
   {
	   var pharmId="${requestScope.pharmId}";
	   var statisDate="${requestScope.statisDate}";
	   
	//  alert("sales_temp:statidDate"+statisDate);
	   
	   //发送请求，查询该药店刚刚提交的数据。
	   $.ajax({
			url:"${APP_PATH}/uploadExcel/getTempSalesByPharmIdAndStatisDate",
			type:"post",
			data:{
				"pn":n,
				"pharmId":pharmId,
				"statisDate":statisDate,	
			},
			success:function(result){
			//	alert("数据提交成功，不可再修改~");
				console.log(result);
				//1、解析并显示员工药品数据
				build_sales_table(result);
				//2、解析并显示分页信息
				build_page_info(result);
				//3、解析显示分页条数据
				build_page_nav(result);
				
			}
			
		});
	   
	 }
	
		function build_sales_table(result){
			$("#sales_table tbody").empty();
			var tempsales = result.extend.pageInfo.list;
			$.each(tempsales,function(index,item)
			{
				var approvalNumberTd= $("<td></td>").append(item.approvalNumber);
                var salePriceTd= $("<td></td>").append(item.salePrice);
                var saleNumTd= $("<td></td>").append(item.saleNum);
                var statisDateTd= $("<td></td>").append(item.statisDate);
                var pharmIdTd= $("<td></td>").append(item.pharmId);
				$("<tr></tr>").append(approvalNumberTd).append(salePriceTd)
								.append(saleNumTd)
								.append(statisDateTd)
								.append(pharmIdTd)
						 		.appendTo("#sales_table tbody");
					
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