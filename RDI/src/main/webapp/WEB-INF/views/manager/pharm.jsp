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
<title>药店管理</title>

<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<script type="text/javascript" src="${APP_PATH }/static/js/template.js"></script>
<link rel="stylesheet" href="${APP_PATH }/static/css/query/query.css">

</head>

<body>
	<%@ include file="../common/top_menu.jsp"%>
	<div class="container">
		<div class="row Top">

			<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4">
				药店名称：<input placeholder="请输入药店名称" type="text" name="pharmName" />
			</div>

			<div class="col-lg-7 col-md-7 col-sm-6 col-xs-6">
				省份： <select class="province" name="province" id="province">
					<option value="" selected>请选择</option>
				</select> 
				市： 
				<select class="city" name="city" id="city">
					<option value="" selected>请选择</option>
				</select> 
				区/县： <select class="county" name="county" id="county">
					<option value="" selected>请选择</option>
				</select>
			</div>

			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<button id="find">搜&nbsp&nbsp索</button>
			</div>

			<div
				class="col-lg-3 col-md-4 col-sm-4  col-xs-5  col-lg-offset-9 col-md-offset-8 col-sm-offset-7 col-xs-offset-5">
				<button class="btn btn-primary" id="add_modal_btn">新增</button>
				<button class="btn btn-danger" id="delete_all_btn">删除</button>
			</div>
		</div>
		<div class="row Center">
			<table class="table table-bordered table-hover" id="pharm_table">
				<thead>
					<tr class='head'>
						<th style="text-align: center"><input type="checkbox"
							id="check_all" /></th>
						<th style="display: none" >药店编号</th>
					   	<!-- 此元素不会被显示 -->
						<th style="text-align: center">药店名称</th>
						<th style="text-align: center">药店地址</th>
						<th style="text-align: center">操作</th>
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


	<!-- 添加药店的模态框 -->
	<div class="modal fade" id="pharmAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加新的药店（<font color="red">*</font>为必填）</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
								<font color="red">*</font>药店名称
							</label>
							<div class="col-sm-8">
								<input type="text" name="pharmName" class="form-control"
									id="pharmName_add_input" placeholder="药店名称"/> 
								<span class="help-block"></span>
							</div>						
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">
								<font color="red">*</font>所属地区
							</label>
							<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
								省份： <select class="provinceModal" name="provinceModal" id="provinceModal">
									<option value="" selected>请选择</option>
								</select>
							</div>
							<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
								城市： <select class="cityModal" name="cityModal" id="cityModal">
									<option value="" selected>请选择</option>
								</select>
							</div>
							<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
								区/县： <select class="countyModal" name="countyModal" id="countyModal">
									<option value="" selected>请选择</option>
								</select>
								<span class="help-block"></span>
							</div>
							
						</div>
						<div class="form-group" >
							<!-- <label for="pharmid_update_input" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">药店ID</label> -->
				    			<div class="col-sm-8">		   
				        		   <p class="form-control-static"  name="pharmId" id="pharmId_static" style="display: none"></p>
				        		<!-- <button type="button" class="btn btn-primary" id="getPharmId">点击此处获取药店ID</button> -->
					    		</div>  
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">详细地址</label>
							<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
								<input type="text" class="form-control"
									id="pharmAddress_add_input" placeholder="详细地址">
								<span class="help-block"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">联系人姓名</label>
							<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
								<input type="text" class="form-control"
									id="contactName_add_input" placeholder="联系人姓名"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">联系方式</label>
							<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
								<input type="text" class="form-control"
									id="phone_add_input" placeholder="联系方式"/>
									<span class="help-block"></span>
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">许可证号</label>
							<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
								<input type="text" class="form-control" 
									id="licecse_add_input" placeholder="许可证号">
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">开业时间</label>
							<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
								<input type="date" class="form-control" id="startTime_add_input"
									placeholder="开业时间">
							</div>
						</div>
					</form>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" id="pharm_save_btn">保存</button>
					</div>

				</div>
			</div>
		</div>
	</div>

	<!-- 药店信息修改的模态框 -->
	<div class="modal fade" id="pharmUpdateModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">药店信息修改</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">药店名称</label>
							<div class="col-sm-8">
								<p class="form-control-static" id="pharmName_static"></p>
							</div>
					    </div>
					    <div class="form-group">
							<label class="col-sm-2 control-label">所属地区 </label> <label
								class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">省份:</label>
							<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
								<p class="form-control-static" id="province_static"></p>
							</div>
							<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">城市:</label>
							<div class="col-sm-2">
								<p class="form-control-static" id="city_static"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 col-lg-offset-2 col-md-offset-2 col-sm-offset-2 col-xs-offset-2 control-label">
							                      区/县:
							</label>
							<div class="col-sm-4">
								<p class="form-control-static" id="county_static"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">详细地址</label>
							<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
								<input type="text" class="form-control"
									id="pharmAddress_update_input" placeholder="详细地址">
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">联系人</label>
							<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
								<input type="text" class="form-control"
									id="contactName_update_input" placeholder="联系人姓名">
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">联系方式</label>
							<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
								<input type="text" class="form-control"
									id="phone_update_input" placeholder="联系方式">
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">许可证号</label>
							<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
								<input type="text" class="form-control"
									id="licenseNo_update_input" placeholder="许可证号">
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">开业时间</label>
							<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
								<input type="date" class="form-control"
									id="startTime_update_input" placeholder="开业时间">
							</div>
						</div>
					</form>
				</div>
				
				<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary"
							id="pharm_update_btn">更新</button>
					</div>

				</div>
			</div>
		</div>

	

	<script type="text/javascript">

	var totalRecord, currentPage;
	//1、页面加载完成以后，直接去发送ajax请求,要到分页数据
	$(function() {
		getProvince("#province");
	});
	
	

	//省份和城市联动
	$(function() {
		$("#province").change(
				function() {
				$("#city option:not(:first)").remove();
				var districtId = $(this).val();
				if(districtId=="")
					$("#county option:not(:first)").remove();
				getCitiesByProvince("#city",districtId);
				});
				
	});

	//城市和区县联动
	$(function() {
		$("#city").change(
				function() {	
					$("#county option:not(:first)").remove();
					var districtId = $(this).val();
					//alert(districtId);
					getCountiesByCity("#county",districtId);	
				});
	});
	
	//查出药店的地区信息并显示在下拉列表中
	function getProvince(ele) {

		$("ele option:not(:first)").remove();//清空之前下拉列表的值

		$.ajax({
			url:"${APP_PATH}/district/getProvince",
			type:"GET",
			success:function(result){
				console.log(result);
				$.each(result.extend.provinces,function(){
					var optionEle = $("<option></option>").append(this.province).attr("value",this.districtId);
					optionEle.appendTo(ele);
			});
			}
		});
	}
	
	function getCitiesByProvince(ele,provinceId)
	{
		//	$("ele option:not(:first)").remove();
			var districtId =provinceId;
			if (districtId != "") {
				$.ajax({
					url : "${APP_PATH}/district/getCity",
					data : {"districtId" : districtId},
					type : "POST",
					success : function(result) {
						console.log(result);
						city = result.extend.citys;
						if (districtId != "" && city.length == 0)
							alert("当前省份没有城市纳入统计");
						else {
							$.each(city, function() {
								var optionEle = $("<option></option>").append(this.city).attr("value",this.districtId);
								optionEle.appendTo(ele);
							});
						}
					}
				});
			}
	}
	
	function getCountiesByCity(ele,cityId)
	{
//		$("ele option:not(:first)").remove();
		var districtId = cityId;
		if (districtId != "") {
			$.ajax({
				url : "${APP_PATH}/district/getCounty",   
				data : {"districtId" : districtId},
				type : "POST",
				success : function(result) {
					console.log(result);
					county = result.extend.countys;
					if (districtId != "" && county.length == 0)
						alert("当前城市没有药店纳入统计");
					else {
						$.each(county, function() {
							var optionEle = $("<option></option>").append(this.county).attr("value",this.districtId);
							optionEle.appendTo(ele);
						});
					}
				}
			});
		}
	}
//-------模态框中的三级联动---------------------------//----------------------------//----------------------------
//->	//1、页面加载完成以后，直接去发送ajax请求,要到分页数据
	$(function() {
		getProvince("#provinceModal");
	});
    
	//省份和城市联动
	$(function() {
		$("#provinceModal").change(
				function() {
					$("#cityModal option:not(:first)").remove();
					var districtId = $(this).val();
					if(districtId=="")
						$("#countyModal option:not(:first)").remove();
					getCitiesByProvince("#cityModal",districtId);
					
				});
	});

	//城市和区县联动
	$(function() {
		$("#cityModal").change(
				function() {
					$("#countyModal option:not(:first)").remove();
					var districtId = $(this).val();
					getCountiesByCity("#countyModal",districtId);	
				})			
	});
	
	/**/
	$(function() {
		$("#countyModal").change(
				function (){
					var districtId = $(this).val();
				//	alert(districtId);
					if(districtId=="")
						alert("亲，需要选择具体县区哈~");
					else
						getMaxPharmId(districtId);
		})
	});
	
	 	
	function getMaxPharmId(districtId){
		  $.ajax({
			  url:"${APP_PATH}/pharmacy/getMaxPharmId/"+districtId,
				type:"GET",
				success:function(result){
					console.log(result);
					var pharmId = result.extend.pharmId;
				//	alert(pharmId);
					$("#pharmId_static").text(pharmId);
					}
		  })
	} 
	
// <-
//------以下是查询功能的实现----------------------//-----------------------------	
	
	$(function() {
		//去首页
		to_page(1);
	});

	$("#find").click(function() {
		to_page(1);
	});

	function to_page(pn) {

		var pharmName = $(".Top input[name='pharmName']").val();
	//这里有点问题，需要修改。
		var countyId = $(".county[name='county']").val();
		var cityId = $(".city[name='city']").val();
		var provinceId = $(".province[name='province']").val();
		var districtId=null;

		if(countyId!="")
			districtId=countyId;
		else if(cityId!="")
			districtId=cityId;
		else if(provinceId!="")
			districtId=provinceId;

	//	alert(districtId);
		$.ajax({
			url : "${APP_PATH}/pharmacy/getPharms",
			data : {
				"pn" : pn,
				"pharmName" : pharmName,
				"districtId" : districtId,
			},
			type : "POST",
			success : function(result) { 
				console.log(result);
				//1、解析并显示药品数据
				build_pharm_table(result);
				//2、解析并显示分页信息
				build_page_info(result);
				//3、解析显示分页条数据
				build_page_nav(result);
			}
		});
	}	

	function build_pharm_table(result) {
		$("#pharm_table tbody").empty();//清空table表格
		var pharms = result.extend.pageInfo.list;
		$
				.each(
						pharms,
						function(index, item) {

							var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
							var pharmIdTd = $("<td style='display: none'></td>").append(item.pharmId);
							var pharmNameTd = $("<td></td>").append(item.pharmName);
							var pharmAddressTd = $("<td></td>").append(item.pharmAddress);
							var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
									.append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
									.append("编辑");
							//为编辑按钮添加一个自定义的属性，来表示当前药店的id
							editBtn.attr("edit-id", item.pharmId);
							var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
									.append($("<span></span>").addClass("glyphicon glyphicon-trash"))
									.append("删除");
							//为删除按钮添加一个自定义的属性来表示当前删除的分类id
							delBtn.attr("del-id", item.pharmId);
							var btnTd = $("<td></td>").append(editBtn)
									.append(" ").append(delBtn);

							//append方法执行完成以后还是返回原来的元素
							$("<tr></tr>").append(checkBoxTd)
										  .append(pharmIdTd)
										  .append(pharmNameTd)
										  .append(pharmAddressTd)
										  .append(btnTd)
										  .appendTo("#pharm_table tbody");
						});
	}

	//解析显示分页信息
	function build_page_info(result) {
		$("#page_info_area").empty();
		$("#page_info_area").append(
				"当前" + result.extend.pageInfo.pageNum + "页,总"
						+ result.extend.pageInfo.pages + "页,总"
						+ result.extend.pageInfo.total + "条记录");
		totalRecord = result.extend.pageInfo.total;
		currentPage = result.extend.pageInfo.pageNum;
	}
	//解析显示分页条，点击分页要能去下一页....
	function build_page_nav(result) {
		//page_nav_area
		$("#page_nav_area").empty();
		var ul = $("<ul></ul>").addClass("pagination");

		//构建元素
		var firstPageLi = $("<li></li>").append(
				$("<a></a>").append("首页").attr("href", "#"));
		var prePageLi = $("<li></li>").append(
				$("<a></a>").append("&laquo;"));
		if (result.extend.pageInfo.hasPreviousPage == false) {
			firstPageLi.addClass("disabled");
			prePageLi.addClass("disabled");
		} else {
			//为元素添加点击翻页的事件
			firstPageLi.click(function() {
				to_page(1);
			});
			prePageLi.click(function() {
				to_page(result.extend.pageInfo.pageNum - 1);
			});
		}

		var nextPageLi = $("<li></li>").append(
				$("<a></a>").append("&raquo;"));
		var lastPageLi = $("<li></li>").append(
				$("<a></a>").append("末页").attr("href", "#"));
		if (result.extend.pageInfo.hasNextPage == false) {
			nextPageLi.addClass("disabled");
			lastPageLi.addClass("disabled");
		} else {
			nextPageLi.click(function() {
				to_page(result.extend.pageInfo.pageNum + 1);
			});
			lastPageLi.click(function() {
				to_page(result.extend.pageInfo.pages);
			});
		}

		//添加首页和前一页 的提示
		ul.append(firstPageLi).append(prePageLi);
		//1,2，3遍历给ul中添加页码提示
		$.each(result.extend.pageInfo.navigatepageNums, function(index,
				item) {

			var numLi = $("<li></li>").append($("<a></a>").append(item));
			if (result.extend.pageInfo.pageNum == item) {
				numLi.addClass("active");
			}
			numLi.click(function() {
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
			
	/*===============以下是新增、修改和删除等功能的实现======================================*/
	//校验表单数据
	function validate_add_form(pharmId,pharmName,districtId){
		//1.拿到要校验的数据，使用正则表达式
		//校验药店名称
		// var regName =  /(^[a-zA-Z0-9_-#]{2,16}$)|(^[\\u2E80-\\u9FFF]{2,16})/;
		var regName = /(^[a-zA-Z0-9_-]{2,30}$)|(^[\u2E80-\u9FFF0-9_-]{2,30})/;
		
		if(!regName.test(pharmName)){
			//alter("药店名称只能是2-16位中文、数字和字母的组合");
			show_validate_msg("#pharmName_add_input","error","药店名称只能是2-30位中文、数字和字母的组合");
			return false;
		}else{
			show_validate_msg("#pharmName_add_input","success","");
			
		}
		
		if(districtId=="" || districtId==null)
			{
			show_validate_msg("#countyModal","error","亲,请选择具体县区~");
			return false;
			}
		else
			show_validate_msg("#countyModal","success","");
		
		var length=pharmId.length;
		alert(length);
		if(length!=9)
			{
			alert("没有计算出正确的药店编号, 请检查所属省、市、县区信息是否选择正确~");
			return false;
			}
		
			
		return true;
	}
	
	//显示校验结果的提示信息
	function show_validate_msg(ele,status,msg){
		//清除当前元素的校验状态
		$(ele).parent().removeClass("has-success has-error");
		$(ele).next("span").text("");
		if("success"==status){
			$(ele).parent().addClass("has-success");
			$(ele).next("span").text(msg);
		}else if ("error"==status){
			$(ele).parent().addClass("has-error");
			$(ele).next("span").text(msg);
		}
	}
	


	//点击保存，保存新药店信息
	$("#pharm_save_btn").click(function(){
		var pharmId = $("#pharmId_static").text();
		var pharmName = $("#pharmName_add_input").val();
		var pharmAddress = $("#pharmAddress_add_input").val();
		// var districtId = $("#county select[name='countyModal']").val();
		var districtEle = $("#countyModal option:selected"); 
		var districtId = districtEle.val();//得到地区ID
		var contactName = $("#contactName_add_input").val();
		var phone = $("#phone_add_input").val();
		var	licenseNo = $("#licecse_add_input").val();
		var startTime = $("#startTime_add_input").val();
		
		///alert(pharmId);
		//alert(pharmId.length);
		
	 	//对表单中数据进行校验
		if(!validate_add_form(pharmId,pharmName,districtId)){
			return false;
		}
	 	/*
		//  ajax后端 校验  药店名称是否在数据库中已经存在，如果已经存在,则为当前保存按钮添加error属性
		if($(this).attr("attr-va")=="error"){
			return false;
		}
		
		 */
		//发送ajax请求保存员工
		    $.ajax({
			url:"${APP_PATH}/pharmacy/saveNewPharm",
			//data:$("#pharmAddModal form").serialize(),
			data:{"pharmId":pharmId,
				  "pharmName":pharmName,
				  "pharmAddress":pharmAddress,
				  "districtId":districtId,
				  "contactName":contactName,
				  "phone":phone,
				  "licenseNo":licenseNo,
				  "startTime":startTime,
				}, 
			type:"POST",
			success:function(result){
				//if(result.code == 100){
					//1,关闭模态框
					$('#pharmAddModal').modal('hide');
					//2.跳转到最后一页显示添加内容
					//发送ajax请求，显示最后一页数据即可
					to_page(totalRecord);    
				//}else{
					//console.log(result);
				/* 	if(undefined!=result.extend.errorFields.pharmName){
						//显示药店名字错误信息
						show_validate_msg("#pharmName_add_input","error",result.extend.errorFields.pharmName);
					} 
				} */
			}
		});   
	});
	
	$("#pharmName_add_input").change(function(){
		
		var pharmName = $("#pharmName_add_input").val();
		var regName = /(^[a-zA-Z0-9_-]{2,30}$)|(^[\u2E80-\u9FFF0-9_-]{2,30})/;
		//var regName = /(^[a-zA-Z0-9_-]{2,8}$)|(^[\u2E80-\u9FFF]{2,8})/;

		if(!regName.test(pharmName)){
			//alter("药店名称只能是2-16位中文、数字和字母的组合");
			show_validate_msg("#pharmName_add_input","error","药店名称只能是2-30位中文、数字和字母的组合");
			return false;
		}else{
			show_validate_msg("#pharmName_add_input","success","");
			
		}
	});
	$("#phone_add_input").change(function(){
		var phone = $("#phone_add_input").val();
		if(phone!=null && phone!="")
		{
			var phonereg=/^([0-9]{3})[- ]?([0-9]{4})[- ]?([0-9]{4})$/;
			//alert(phonereg.test(phone));
			if(!phonereg.test(phone)){
				show_validate_msg("#phone_add_input","error","请输入正确的手机号码~");
				return false;
				}
			else
				show_validate_msg("#phone_add_input","success","");
			}
	});
	/*
	//检验要点名是否可用，其实不必校验药店名，因为不是主键，可以换成校验pharmId
	$("#pharmName_add_input").change(function(){
		//发送ajax请求检验用户名是否可用
		var checkPharm=this.value;
		$ajax({
			url:"${APP_PATH}/pharmacy/checkPharm",
			data:"checkPharm="+checkPharm,
			type:"POST",
			success:function(result){
				if(result.code==100){
					show_validate_msg("#pharmName_add_input","success","用户名可用");
					$("#pharm_save_btn").attr("ajax-va","success");
				}else{
					show_validate_msg("#pharmName_add_input","error","用户名不可用");
					$("#pharm_save_btn").attr("ajax-va","error");
				}
			}
			
		});
		
	});
	*/	
	
		
		//点击新增按钮弹出模态框。
		$("#add_modal_btn").click(function() {
			//清除表单数据（表单完整重置（表单的数据，表单的样式））
		 //reset_form("#pharmAddModal form");
			$("#pharmAddModal form")[0].reset();
			//发送ajax请求，查出部门信息，显示在下拉列表中
			//getParents("#pharmAddModal select");
			//弹出模态框
			$("#pharmAddModal").modal({
				backdrop : "static" //点击模态框的背景后模态框不会关闭
			});
			$("#pharmAddModal").modal({
				keyboard : "boolean"
			//键盘上的 esc 键被按下时关闭模态框。
			});
		});
		
		//点击编辑按钮弹出模态框
		$(document).on("click",".edit_btn",function(){
		 // alert("edit");
			//查出地区信息并显示地区列表
			getPharmsInfo($(this).attr("edit-id"));
			$("#pharm_update_btn").attr("edit-id",$(this).attr("edit-id"));
			$("#pharmUpdateModal").modal({
				backdrop : "static", //点击模态框的背景后模态框不会关闭
				keyboard : "boolean"
			});
			
		});

		//查询药店信息并显示
		 function getPharmsInfo(pharmId){
			$.ajax({
				url:"${APP_PATH}/pharmacy/getPharmInfo/"+pharmId,
				type:"GET",
				success:function(result){
					//console.log(result);
					var pharmData = result.extend.pharmacy;
					var districtData =result.extend.district;
					$("#pharmName_static").text(pharmData.pharmName);
					$("#pharmAddress_update_input").val(pharmData.pharmAddress);
					$("#contactName_update_input").val(pharmData.contactName);
					$("#phone_update_input").val(pharmData.phone);
					$("#licenseNo_update_input").val(pharmData.licenseNo);
					$("#startTime_update_input").val(pharmData.startTime);
			        $("#province_static").text(districtData.province);
					$("#city_static").text(districtData.city);
					$("#county_static").text(districtData.county);  
				}
			});
		}   
		
		//给更新按钮添加单击事件
		$("#pharm_update_btn").click(function(){
			
			var pharmName = $("#pharmName_update_input").val();
			var pharmAddress = $("#pharmAddress_update_input").val();
			// var districtId = $("#county select[name='countyModal']").val();
			/* var districtEle = $("#countyModal option:selected"); 
			var districtId = districtEle.val();//得到地区ID */
			var contactName = $("#contactName_update_input").val();
			var phone = $("#phone_update_input").val();
			var	licenseNo = $("#licecse_update_input").val();
			var startTime = $("#startTime_update_input").val();
			var pharmId = $("#pharmId_static").text();
			
			$.ajax({	
				url:"${APP_PATH}/pharmacy/updatePharm/"+$(this).attr("edit-id"),
				type:"PUT",
				data:{"pharmName":pharmName,
						"pharmAddress":pharmAddress,
						//"districtId":districtId,
						"contactName":contactName,
						"phone":phone,
						"licenseNo":licenseNo,
						"startTime":startTime,
						"pharmId":pharmId}, 
				success:function(result){
					alert(result.msg);
					//1.关闭模态框
					$("#pharmUpdateModal").modal('hide');
					//2.打开修改的那页，定义一个全局变量使变量等于 currentPage
					to_page(currentPage);
				}
			})
		});

		
		//单个删除
		$(document).on("click", ".delete_btn", function() {
			//1、弹出是否确认删除对话框
			var pharmName = $(this).parents("tr").find("td:eq(2)").text();
			var pharmId = $(this).attr("del-id");
			//alert($(this).parents("tr").find("td:eq(2)").text());
			if (confirm("确认删除【" + pharmName + "】吗？")) {
				//确认，发送ajax请求删除即可
				$.ajax({
					url : "${APP_PATH}/pharmacy/pharmdel/" + pharmId,
					type : "DELETE",
					success : function(result) {
						alert(result.msg);
						//回到本页
						to_page(currentPage);
					}
				}); 
			}
		});

		//完成全选/全不选功能
		$("#check_all").click(function() {
			//attr获取checked是undefined;
			//我们这些dom原生的属性；attr获取自定义属性的值；
			//prop修改和读取dom原生属性的值
			$(".check_item").prop("checked", $(this).prop("checked"));
		});

		//check_item
		$(document)
				.on(
						"click",
						".check_item",
						function() {
							//判断当前选择中的元素是否5个
							var flag = $(".check_item:checked").length == $(".check_item").length;
							$("#check_all").prop("checked", flag);
						});

		//点击全部删除，就批量删除 
		$("#delete_all_btn")
				.click(
						function() {
							//
							var pharmNames = "";
							var del_idstr = "";
							$.each($(".check_item:checked"), function() {
								//this
								pharmNames += $(this).parents("tr").find(
										"td:eq(2)").text()
										+ ",";
								//组装员工id字符串
								del_idstr += $(this).parents("tr").find(
										"td:eq(1)").text()
										+ "-";
								//alert(del_idstr);
								//alert(pharmNames);

							});

							//去除pharmNames 多余的逗号,
							pharmNames = pharmNames.substring(0,
									pharmNames.length - 1);
							//去除删除的id多余的-
							del_idstr = del_idstr.substring(0,
									del_idstr.length - 1);
						/* 	alert(pharmNames);
							alert(del_idstr); */
							if (confirm("确认删除【" + pharmNames + "】吗？")) {
								//发送ajax请求删除
								$.ajax({
									url : "${APP_PATH}/pharmacy/pharmdel/" + del_idstr,
									type : "DELETE",
									success : function(result) {
										alert(result.msg);
										//回到当前页面
										to_page(currentPage);
									}
								});
							}
						});
	</script>
</body>
</html>