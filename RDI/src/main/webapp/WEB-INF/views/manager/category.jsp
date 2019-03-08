<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>分类管理</title>
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
<link rel="stylesheet" href="${APP_PATH }/static/css/manager/crud.css">

</head>

<body>
<%@ include file="../common/top_menu.jsp" %>
<div class="container">
   <div class="Top">
    <div class="row">
       <div class="col-lg-3 col-md-3 col-sm-5  col-xs-5">
		   分类名称：<input placeholder="请输入药品分类名称" type="text" name="categName"/>
	   </div>
	  
	    <div class="col-lg-2 col-md-3 col-sm-5 col-xs-5">   
	           分类级别：
	            <select class="categLevel" name="categLevel">
			        <option value="" selected>请选择</option>
			        <option value="1">大类</option>
			        <option value="2">中类</option>
			        <option value="3">小类</option> 
			        <option value="4">代表品类</option>			        
		     </select>
	   </div> 
	    <div class="col-lg-3 col-md-2 col-sm-2  col-xs-2">
             <button id="find">搜&nbsp&nbsp索</button>
	    </div>  
	    
	    <div class="col-lg-3 col-md-4 col-sm-4  col-xs-5  col-lg-offset-9 col-md-offset-8 col-sm-offset-7 col-xs-offset-5">
				<button class="btn btn-primary" id="add_modal_btn">新增</button>
				<button class="btn btn-danger" id="delete_all_btn">删除</button>
        </div>       
    </div>

  </div>
    <div class="row Center">
	    	<table  class="table table-bordered table-hover col-md-12  col-sm-12 col-xs-12" id="categ_table" >
			   <thead>
			       <tr class='head'>
			           <th style="text-align:center" >
							<input type="checkbox" id="check_all"/>
					   </th>
					   <th style="display: none" >分类编号</th>
					   <!-- 此元素不会被显示 -->
		    	       <th style="text-align:center" >分类名称</th>
		    	       <th style="text-align:center">分类级别</th>
		   	 	       <th style="text-align:center">所属上级分类</th>
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
<!-- 添加分类的模态框 -->
<div class="modal fade" id="categAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加新的分类</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
		     <div class="form-group" >
					<label for="emp_update_input" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">分类ID</label>
				    	<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">		   
				           <p class="form-control-static"  name="categId" id="categId_static"></p>
				           <button type="button" class="btn btn-primary" id="getCategID">获取分类ID</button>
					    </div>  
			</div>
		<!-- <div class="modal-footer">
       		<button type="button" class="btn btn-primary" id="getCategID">点击此处获取分类ID</button>
       	</div> -->
		  <div class="form-group">
		    <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">分类名称</label>
		    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
		      <input type="text" name="categName" class="form-control" id="categName_add_input" placeholder="分类名称">
		      <span class="help-block"></span>
		    </div>
		  </div>
		
		  <div class="form-group">
		    <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">分类级别</label>
		    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8" id="categ_level" >
		      <label class="radio-inline">
				  <input type="radio" name="level" id="level1_add_input" value="1" > 大类
				</label>
				<label class="radio-inline">
				  <input type="radio" name="level" id="level2_add_input" value="2"> 中类
				</label>
				 <label class="radio-inline">
				  <input type="radio" name="level" id="level3_add_input" value="3" > 小类
				</label>
				<label class="radio-inline">
				  <input type="radio" name="level" id="level4_add_input" value="4" checked="checked"> 代表品类
				</label>
		    </div>
		  </div>
	
		  
		  <div class="form-group" id="parent_id">
		    <label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">所属上级分类</label>
		  <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9" >
    
	   
	        <select class="classifybylarge" name="classifybylarge" id="classifybylarge">
			         <option value="" selected>请选择</option>     
		     </select>
	
	        <select class="classifybymiddle" name="classifybymiddle" id="classifybymiddle">
			         <option value="" selected>请选择</option>     
		     </select>
	  

	 
	        <select class="classifybysmall" name="classifybysmall" id="classifybysmall">
			         <option value="" selected>请选择</option>     
		     </select>
		     </div>
		  </div>
		</form>
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="categ_save_btn">保存</button>
      </div>
    </div>
  </div>
</div>
<!-- 编辑的模态框 -->
<div class="modal fade" id="editcategAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加新的分类</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
        
        
          <div class="form-group">
		    <label class="col-sm-3 control-label">分类ID</label>
		    <div class="col-sm-8">
		      <p class="form-control-static" id="categId_update"></p>
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-3 control-label">分类名称</label>
		    <div class="col-sm-8">
		      <input type="text" name="categName" class="form-control" id="categName_update_input" placeholder="分类名称">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="categ_update_btn">更新</button>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
	

//获取分类ID
$("#getCategID").click(function(){
	  //1模态框中填写的表单数据提交给服务器进行保存
	  //2发送ajax请求保存分类
  //alert($("#categAddModal form").serialize());
	  var parentId="";
	  var level = $('#categ_level input[name="level"]:checked ').val();
	  if(level=="1")
		{
		parentId="0";
		}
	  if(level=="2")
		{
		parentId=$(".classifybylarge[name='classifybylarge']").val();
		}
	  if(level=="3")
	  {
		parentId=$(".classifybymiddle[name='classifybymiddle']").val();
	  }
	  if(level=="4")
	  {
		parentId=$(".classifybysmall[name='classifybysmall']").val();
	  }
	  //先获取参数的值 //先获取参数的值
	  if(parentId=="")
		  alert("请先选择上级分类！");
	  if(parentId=="0")
		  alert("抱歉，暂时不可添加大类！");
	
	 getMaxCategId(parentId);
	
	 
	 /* alert(categId);
	 alert(categName);
	 alert(parentId);
	 alert(level); */
});
//点击保存按钮
	  $("#categ_save_btn").click(function(){
		  	 var categId=$("#categId_static").text();
			 var categName=$("#categName_add_input").val();
			 var parentId="";
			  var level = $('#categ_level input[name="level"]:checked ').val();
			  if(level=="1")
				{
				parentId="0";
				}
			  if(level=="2")
				{
				parentId=$(".classifybylarge[name='classifybylarge']").val();
				}
			  if(level=="3")
			  {
				parentId=$(".classifybymiddle[name='classifybymiddle']").val();
			  }
			  if(level=="4")
			  {
				parentId=$(".classifybysmall[name='classifybysmall']").val();
			  }
			
			 /*  alert(categId);
			 alert(categName);
			 alert(parentId);
			 alert(level); */
			 $.ajax({
				 	url:"${APP_PATH}/category/savenewcateg",
					data:{"categId":categId,
						"categName":categName,
						"parentId":parentId,
						"level":level},
					type:"POST",
					success:function(result){
						$("#categAddModal").modal('hide');
						
					}
			 })
	  })
function getMaxCategId(parentId){
	  $.ajax({
		  url:"${APP_PATH}/category/getMaxCategId/"+parentId,
			type:"GET",
			success:function(result){
				//console.log(result);
				var categId = result.extend.categId;
			  // var categId=categData.categId;
				$("#categId_static").text(categId);
				}
	  })
}
//点击新增按钮弹出模态框。
$("#add_modal_btn").click(function(){
	//清除表单数据（表单完整重置（表单的数据，表单的样式））
	// reset_form("#categAddModal form");
	//s$("")[0].reset();
	//发送ajax请求，查出部门信息，显示在下拉列表中
	// getParents("#categAddModal select");
	//弹出模态框
	
	$("#categAddModal").modal({
		backdrop:"static"
	});
	
});
	
$(":radio").click(function(){
	var categ_level = $('#categ_level input[name="level"]:checked ').val();
	//alert(categ_level);
//	var sign;
	if(categ_level=="1")
		{
		$("#parent_id").hide();
		//parentId="0";
		}
	else if(categ_level=="2")
		{
		$("#parent_id").show();
		$("#classifybylarge").show();
		$("#classifybymiddle").hide();
		$("#classifybysmall").hide();
		//parentId=$(".classifybylarge[name='classifybylarge']").val();
		}
	else if(categ_level=="3")
	{
	
		$("#parent_id").show();
		$("#classifybylarge").show();
		$("#classifybymiddle").show();
		$("#classifybysmall").hide();
		//parentId=$(".classifybymiddle[name='classifybymiddle']").val();
	}
	else if(categ_level=="4")
	{
		$("#parent_id").show();
		$("#classifybylarge").show();
		$("#classifybymiddle").show();
		$("#classifybysmall").show();
		//parentId=$(".classifybysmall[name='classifybysmall']").val();
	
	}
	
	
   });
	
	
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


		var totalRecord,currentPage;
		//1、页面加载完成以后，直接去发送ajax请求,要到分页数据
		$(function(){
			to_page(1);
		});
		
		$("#find").click(function(){
			to_page(1);
		});
		
		function to_page(pn){
			
			var categName = $(".Top input[name='categName']").val();
			var categLevel = $(".categLevel[name='categLevel']").val();
					
			$.ajax({
				url:"${APP_PATH}/category/getCategories",
				data:{"pn":pn,
					  "categName":categName,
					  "categLevel":categLevel,
					},
				type:"POST",
				success:function(result){
					console.log(result);
					//1、解析并显示员工药品数据
					if(categLevel=="1")
						{
						build_categ_table_levelequals1(result);
						}
					else
						{
						build_categ_table(result);
						}
						
					//2、解析并显示分页信息
					build_page_info(result);
					//3、解析显示分页条数据
					build_page_nav(result);
				}
			});
		}
		
		function build_categ_table_levelequals1(result){
			//清空table表格
			$("#categ_table tbody").empty();
			var categories = result.extend.pageInfo.list;
			$.each(categories,function(index,item){
				
				var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
				var categIdTd = $("<td style='display: none'></td>").append(item.categId);
				var categNameTd = $("<td></td>").append(item.categName);
				var levelTd = $("<td></td>").append(item.level);
				var parentCategNameTd = $("<td></td>").append("无");
		

                var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
				.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
                //为编辑按钮添加一个自定义的属性，来表示当前分类的id
                editBtn.attr("edit-id",item.categId);
                var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
				.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
               //为删除按钮添加一个自定义的属性来表示当前删除的分类id
               delBtn.attr("del-id",item.categId);
               var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);

				//append方法执行完成以后还是返回原来的元素
				$("<tr></tr>").append(checkBoxTd).append(categIdTd).append(categNameTd)
					.append(levelTd)
					.append(parentCategNameTd)
					.append(btnTd)
			 		.appendTo("#categ_table tbody");
			});
		}
		
		function build_categ_table(result){
			//清空table表格
			$("#categ_table tbody").empty();
			var categories = result.extend.pageInfo.list;
			$.each(categories,function(index,item){
				
				var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
				var categIdTd = $("<td style='display: none'></td>").append(item.categId);
				var categNameTd = $("<td></td>").append(item.categName);
				var levelTd = $("<td></td>").append(item.level);
				var parentCategNameTd = $("<td></td>").append(item.parentCategory.categName);
		
				  var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
	                //为编辑按钮添加一个自定义的属性，来表示当前分类的id
	                editBtn.attr("edit-id",item.categId);
	                var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
	               //为删除按钮添加一个自定义的属性来表示当前删除的分类id
	               delBtn.attr("del-id",item.categId);
	               var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);

					//append方法执行完成以后还是返回原来的元素
					$("<tr></tr>").append(checkBoxTd).append(categIdTd).append(categNameTd)
						.append(levelTd)
						.append(parentCategNameTd)
						.append(btnTd)
				 		.appendTo("#categ_table tbody");
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
		
		
		
		
		
		//单个删除
		$(document).on("click",".delete_btn",function(){
			//1、弹出是否确认删除对话框
			var categName = $(this).parents("tr").find("td:eq(2)").text();
			var categId = $(this).attr("del-id");
			//alert($(this).parents("tr").find("td:eq(1)").text());
			if(confirm("确认删除【"+categName+"】吗？")){
				//确认，发送ajax请求删除即可
				$.ajax({
					url:"${APP_PATH}/category/categdel/"+categId,
					type:"DELETE",
					success:function(result){
						alert(result.msg);
						//回到本页
						to_page(currentPage);
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
			var categNames = "";
			var del_idstr = "";
			$.each($(".check_item:checked"),function(){
				//this
				categNames += $(this).parents("tr").find("td:eq(2)").text()+",";
				//组装员工id字符串
				del_idstr += $(this).parents("tr").find("td:eq(1)").text()+"-";
				//alert(del_idstr);
				//alert(categNames);
				
			});
			
			
			//去除empNames多余的逗号,
			categNames = categNames.substring(0, categNames.length-1);
			//去除删除的id多余的-
			del_idstr = del_idstr.substring(0, del_idstr.length-1);
			//alert(del_idstr);
			//alert(categNames);
			if($(".check_item:checked").length==0){
				alert("请勾选需要删除的药品");
			}else{
				if(confirm("确认删除【"+categNames+"】吗？")){
					//发送ajax请求删除
					$.ajax({
						url:"${APP_PATH}/category/categdel/"+del_idstr,
						type:"DELETE",
						success:function(result){
							alert(result.msg);
							//回到当前页面
							to_page(currentPage);
						}
					});
				}
			}
		});
	
		// 编辑按钮模态框
		$(document).on("click",".edit_btn",function(){
			//清除表单数据（表单完整重置（表单的数据，表单的样式））
			// reset_form("#categAddModal form");
			//s$("")[0].reset();
			//发送ajax请求，查出部门信息，显示在下拉列表中
			// getParents("#categAddModal select");
			//弹出模态框
			getcateginfo($(this).attr("edit-id"));
			$("#categ_update_btn").attr("edit-id",$(this).attr("edit-id"));
			$("#editcategAddModal").modal({
				backdrop:"static"
			});
		});
		function getcateginfo(categid){
			$.ajax({
				url:"${APP_PATH}/category/getCategInfo/"+categid,
				type:"GET",
				success:function(result){
				var categData = result.extend.categ;
				$("#categId_update").text(categData.categId);
				$("#categName_update_input").val(categData.categName);
				}
			})
		}
      //给更新按钮添加单击事件
			$("#categ_update_btn").click(function(){
				$.ajax({
					
					url:"${APP_PATH}/category/updatecateg/"+$(this).attr("edit-id"),
					type:"PUT",
					data:$("#editcategAddModal form").serialize(),
					success:function(result){
						alert(result.msg);
						//1.关闭模态框
						$("#editcategAddModal").modal('hide');
						//2.打开修改的那页，定义一个全局变量使变量等于 currentPage
						to_page(currentPage);
					}
				})
			});
 
	</script>
</body>
</html>