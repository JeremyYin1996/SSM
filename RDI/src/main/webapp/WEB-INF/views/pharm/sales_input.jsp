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
 <!-- 员工修改的模态框 -->
<div class="modal fade" id="tempUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">销售数据修改</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
		  <div class="form-group">
		    <label class="col-sm-2 control-label">批准文号</label>
		    <div class="col-sm-10">
		      	<p class="form-control-static"   id="approval_number_update_static"></p>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">销售价格</label>
		    <div class="col-sm-10">
		      <input type="text" name="salePrice" class="form-control" id="sale_price_update_input" placeholder="">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">销售数量</label>
		    <div class="col-sm-10">
		      <input type="text" name="saleNum" class="form-control" id="sale_num_update_input" placeholder="">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
				<label class="col-sm-2 control-label">统计日期</label>
				<div class="col-sm-10">
					<input type="date" name="statisDate" class="form-control" id="statis_date_update_input"	placeholder="统计日期为每个月倒数第二天"/>
			   </div>
			</div>
		    <div class="form-group">
		    <label class="col-sm-2 control-label">药店编号</label>
		    <div class="col-sm-10">
		      	<p class="form-control-static"  id="pharm_id_update_static"></p>
		    </div>
		  </div>
		  
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="temp_update_btn">更新</button>
      </div>
    </div>
  </div>
</div>
 
 
 
 
 
 <div class="container">
      <div class="row Top">

           <div class="col-lg-2 col-md-2 col-sm-4  col-xs-4" >
                <input type="file" id='ef' name="file" onchange="dochange(this.id)" />
            </div>
            
           <div class="col-lg-1 col-md-1 col-sm-2  col-xs-2" >
                <button  id="upload_btn"  class="upload_btn">上传</button>
          </div>
         <div class="col-lg-1 col-md-1 col-sm-2 col-xs-2  
                     col-lg-offset-7 col-md-offset-7 col-sm-offset-4 col-xs-offset-4">
          <button  id="submit_btn"  class="submit_btn">提交</button>
         </div>
        <div class="batch_delete col-lg-3 col-md-4 col-sm-4  col-xs-5  col-lg-offset-9 col-md-offset-8 col-sm-offset-7 col-xs-offset-5">
		     <button class="btn btn-danger" id="delete_all_btn">删除</button>
        </div>  
    </div>
   
   
   
   <div id="tablediv" class="row Center" align="center">
     	<table class="table table-bordered table-hover" id="sales_table" >
			   <thead>
			       <tr class='head'> 	     
			           <th style="text-align:center" >
							<input type="checkbox" id="check_all"/>
					   </th>
			           <th style="text-align:center">批准文号</th>
		    	       <th style="text-align:center">销售价格</th>
		    	       <th style="text-align:center">销售数量</th>
		    	       <th style="text-align:center">统计日期</th>
		    	       <th style="text-align:center">药店编号</th>	 
		    	       <th style="text-align:center">操作</th>	 
			      </tr>
			   </thead>		
		     <tbody>
					
		     </tbody>
		     </table>
   
   
      	
   </div>
   
      <!-- 显示分页信息 -->
		<div class="row page_info">
			<!--分页文字信息  -->
			<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6" id="page_info_area"></div>
			<!-- 分页条信息 -->
			<div class="col-lg-6 col-md-6  col-sm-6 col-xs-6" id="page_nav_area"></div>
		</div>
   
 </div>    
<script type="text/javascript">

	var allData,statisDate;
	var maxId;
	var totalRecord,currentPage;
	
	
	$(function(){
		$(".batch_delete").hide();
		$("#sales_table").hide();
		$(".page_info").hide();
		
		
		$.ajax({
			url:"${APP_PATH}/uploadExcel/maxIdFromTemp",
			type:"get",
			secureuri:false,
			success:function(result){
				 maxId=result.extend.maxId;
			   //  alert("^^"+maxId);   
		    	}	
		  });
		
	});
	
	
	
	//点击"上传",将读取到的文件上传到controller,调用函数读出其中数据，并返回，然后调用handleData在页面上显示数据。
	$(document).on("click",".upload_btn",function(){
				
		
				$.ajaxFileUpload({
					url:"${APP_PATH}/uploadExcel/handleExcelFile",
					type:"post",
					secureuri:false,
					fileElementId:"ef",
					dataType:"json",
					success:function(data,status){
						//
						//alert(data.length+"????"+data);
					    console.log(data);				  
						handleData(data,maxId);
					},
					error:function(data,status,e){
						alert(e);
					}
				});
			});
	

		function handleData(datas){
			$("#sales_table tbody").empty();
			
			for(var i=0;i<datas.length;i++){//同一个excel文件中可能会有多个excel表
				var data = datas[i];
				var sheetName = data.sheetName;
				var cols_num = data.headers.length;
				if(cols_num<=0){
					alert("空的excel表！");
					return;
				}
				if(cols_num!=5)
				{
					alert("请按给定模板格式来填写");
					return;
				}
				//以下是判断上传格式是否符合要求
				var col1Name=data.headers[0];
				var col2Name=data.headers[1];
				var col3Name=data.headers[2];
				var col4Name=data.headers[3];
				var col5Name=data.headers[4];
				//alert(approvalNumber);
				//alert("^^"+salePrice+"^^")
				//alert("^^"+saleNum+"^^")
				//alert("^^"+statisDate+"^^")
				//alert("^^"+pharmId+"^^")
				if(col1Name!="approval_number" ||col2Name!="sale_price" || col3Name!="sale_num"
							|| col4Name!="statis_date"|| col5Name!="pharm_id" )
				{
						alert("请按给定模板格式来填写销售数据~");
						return;
				}
					
				
				if(data.rows){
					contentdata=data.rows;
					allData=data.rows;
					statisDate=data.rows[0][3];
					
					pharmId=data.rows[0][4];
					username="${sessionScope.user.userName}";
					if(pharmId!=username)
						{
						alert("只能提交本药店销售数据！请查正药店编号后重修上传！");
						return;
						}
				}
			}
			savedata(contentdata);//将数据先保存到数据库，如果之前已经存过将不再保存。
			$(".batch_delete").show();
			$("#sales_table").show();
			$(".page_info").show();
			//alert(pharmId);
			//alert(statisDate);
			to_page(1,pharmId,statisDate);
			
		}
		
		
		
		//保存数据
		function savedata(contentdata)
		{
			
			var item;
			var datas = [];

			for (var i = 0; i < contentdata.length; i++) 
			{ 
				item={
	              approvalNumber:contentdata[i][0],
	              salePrice:contentdata[i][1],
	              saleNum:contentdata[i][2],
				  statisDate:contentdata[i][3],
				  pharmId:contentdata[i][4]
				};
			// alert(JSON.stringify(item));
				datas.push(item);
				
			}
	     //	alert(datas.length);
	     //	alert(JSON.stringify(datas));
	    
			$.ajax({
				url:"${APP_PATH}/uploadExcel/saveExcelData",
				type:"post",
				traditional:true,  
	            async : false, 
				data:JSON.stringify(datas),
				//data:item,
				dataType:"json",
				contentType: "application/json;charset=utf-8",
				success:function(result){
					if(result.code==100)
						alert("读取成功");
					else if(result.code==200)
						{
						alert("数据已经提交过了~");
						var pharmId="${sessionScope.user.userName}";
					//	alert(pharmId);
						var url ="${APP_PATH}/uploadExcel/toTempSales?pharmId="+pharmId;
						window.open(url);
						}					
				}
				
			});
		}
		
			
		

		//上传文件按钮改变时，判断是否是excel文件。
		function dochange(id){
			var obj = document.getElementById(id);
			var filename = obj.value;
			//alert(filename);
			var re = /.xls$/;
		//	alert(!re.test(filename));
			if(!re.test(filename)){
			    obj.value = "";
				alert("必须是excel文件");
				obj.onchange = null;
				
				obj.onchange = function(){
					dochange(id);
				}
				return;
			}
		}
		//点击提交，将数据保存到数据库，并不能再修改。
		$(document).on("click",".submit_btn",function(){
			
		    var pharmId="${sessionScope.user.userName}";

			 var url ="${APP_PATH}/uploadExcel/toTempSales?pharmId="+pharmId+"&statisDate="+statisDate;
			 window.open(url);
		
			
		});
		
		
		$(document).on("click",".edit_btn",function(){
			//alert("edit");
		
			//2、查出temp中的销售数据，显示销售数据
			var id=$(this).attr("edit-id");
			$.ajax({
				url:"${APP_PATH}/uploadExcel/getTempById/"+id,
				type:"get",
				
				success:function(result){
					//console.log(result);
					var tempData = result.extend.temp;
					$("#approval_number_update_static").text(tempData.approvalNumber);
					$("#sale_price_update_input").val(tempData.salePrice);
					$("#sale_num_update_input").val(tempData.saleNum);
					$("#statis_date_update_input").val(tempData.statisDate);
					$("#pharm_id_update_static").text(tempData.pharmId);
				}
			});
			
			//3、把员工的id传递给模态框的更新按钮
			$("#temp_update_btn").attr("edit-id",$(this).attr("edit-id"));
			$("#tempUpdateModal").modal({
				backdrop:"static"
			});
		});
		
		
		
		//点击更新，更新员工信息
		$("#temp_update_btn").click(function(){
			//验证邮箱是否合法
		
			var pharmId=$("#pharm_id_update_static").text();
			//alert(pharmId);
		//	alert(statisDate);
			//alert($("#tempUpdateModal form").serialize());
			//alert($(this).attr("edit-id"));
			//2、发送ajax请求保存更新的员工数据
			$.ajax({
				url:"${APP_PATH}/uploadExcel/updateTempById/"+$(this).attr("edit-id"),
				type:"PUT",
				data:$("#tempUpdateModal form").serialize(),
				success:function(result){
					//alert(result.msg);
					//1、关闭对话框
					$("#tempUpdateModal").modal("hide");
					//2、回到本页面
					//alert(currentPage);
				//	alert(pharmId);
					//alert(statisDate);
					to_page(currentPage,pharmId,statisDate);
				}
			});
		});
		
		//单个删除
		$(document).on("click",".delete_btn",function(){
			//1、弹出是否确认删除对话框
			var approvalNumber = $(this).parents("tr").find("td:eq(2)").text();
			var pharmId="${sessionScope.user.userName}";
			var id = $(this).attr("del-id");
			//alert($(this).parents("tr").find("td:eq(1)").text());
			if(confirm("确认删除【"+approvalNumber+"】的销售数据吗？")){
				//确认，发送ajax请求删除即可
				$.ajax({
					url:"${APP_PATH}/uploadExcel/deleteTempById/"+id,
					type:"DELETE",
					success:function(result){
						alert(result.msg);
						//回到本页
						to_page(currentPage,pharmId,statisDate);
					}
				});
			}
		});
		
		//完成全选/全不选功能
		$("#check_all").click(function(){
			//attr获取checked是undefined;
			//我们这些dom原生的属性；attr获取自定义属性的值；
			//prop修改和读取dom原生属性的值
			$(".check_item").prop("checked",$(this).prop("checked"));
		});
		
		//check_item
		$(document).on("click",".check_item",function(){
			//判断当前选择中的元素是否5个
			var flag = $(".check_item:checked").length==$(".check_item").length;
			$("#check_all").prop("checked",flag);
		});
		
		//点击全部删除，就批量删除
		$("#delete_all_btn").click(function(){
			//
			var pharmId="${sessionScope.user.userName}";
			var approvalNumbers = "";
			var del_idstr = "";
			$.each($(".check_item:checked"),function(){
				//this
				approvalNumbers += $(this).parents("tr").find("td:eq(2)").text()+",";
				//组装员工id字符串
				del_idstr += $(this).parents("tr").find("td:eq(1)").text()+"-";
			});
			//去除empNames多余的,
			approvalNumbers = approvalNumbers.substring(0, approvalNumbers.length-1);
			//去除删除的id多余的-
			del_idstr = del_idstr.substring(0, del_idstr.length-1);
		//	alert(del_idstr);
			if(confirm("确认删除【"+approvalNumbers+"】的销售数据吗？")){
				//发送ajax请求删除
				$.ajax({
					url:"${APP_PATH}/uploadExcel/deleteTempById/"+del_idstr,
					type:"DELETE",
					success:function(result){
						alert(result.msg);
						//回到当前页面
						to_page(currentPage,pharmId,statisDate);
					}
				});
			}
		});
		
		
		
		function  to_page(n,pharmId, statisDate)
		   {
			//  alert(n);
			 // alert(pharmId);
			 // alert(statisDate);
			   
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
						var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
						var tempIdTd= $("<td style='display: none'></td>").append(item.id);
						var approvalNumberTd= $("<td></td>").append(item.approvalNumber);
		                var salePriceTd= $("<td></td>").append(item.salePrice);
		                var saleNumTd= $("<td></td>").append(item.saleNum);
		                var statisDateTd= $("<td></td>").append(item.statisDate);
		                var pharmIdTd= $("<td></td>").append(item.pharmId);
		                var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
						.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
		                //为编辑按钮添加一个自定义的属性，来表示当前分类的id
		                 editBtn.attr("edit-id",item.id);
		                 var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
		 				.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
		                //为删除按钮添加一个自定义的属性来表示当前删除的分类id
		                 delBtn.attr("del-id",item.id);
		                 var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
						$("<tr></tr>").append(checkBoxTd).append(tempIdTd).append(approvalNumberTd).append(salePriceTd)
										.append(saleNumTd)
										.append(statisDateTd)
										.append(pharmIdTd)
										.append(btnTd)
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
				//alert(totalRecord);
				currentPage = result.extend.pageInfo.pageNum;
				//alert(currentPage);
			}
			
			//解析显示分页条，点击分页要能去下一页....
			function build_page_nav(result){
				//page_nav_area
				$("#page_nav_area").empty();
				var ul = $("<ul></ul>").addClass("pagination");
				
				 var pharmId="${sessionScope.user.userName}";
				// alert(pharmId);
				 // alert(statisDate);
				//构建元素
				var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
				var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
				if(result.extend.pageInfo.hasPreviousPage == false){
					firstPageLi.addClass("disabled");
					prePageLi.addClass("disabled");
				}else{
					//为元素添加点击翻页的事件
					;
					firstPageLi.click(function(){
						to_page(1,pharmId,statisDate);
					});
					prePageLi.click(function(){
						to_page(result.extend.pageInfo.pageNum -1,pharmId,statisDate);
					});
				}

				var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
				var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
				if(result.extend.pageInfo.hasNextPage == false){
					nextPageLi.addClass("disabled");
					lastPageLi.addClass("disabled");
				}else{
					nextPageLi.click(function(){
						to_page(result.extend.pageInfo.pageNum +1,pharmId,statisDate);
					});
					lastPageLi.click(function(){
						to_page(result.extend.pageInfo.pages,pharmId,statisDate);
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
						to_page(item,pharmId,statisDate);
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