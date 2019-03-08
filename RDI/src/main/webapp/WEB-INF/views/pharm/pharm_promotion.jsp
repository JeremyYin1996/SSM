<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>药店活动详情</title>

<%	pageContext.setAttribute("APP_PATH", request.getContextPath()); %>

<script type="text/javascript" src="${APP_PATH }/static/js/template.js"></script>
<link rel="stylesheet" href="${APP_PATH }/static/css/query/pharm_detail.css">


<script id="detailTable" type="text/html">

	<tr><th>药店名称：</th><td>{{pharmName}}</td></tr>
	<tr><th>所属区域：</th><td>{{district.county}}</td></tr>
	<tr><th>地址：</th><td>{{pharmAddress}}</td></tr>
	<tr><th>销售许可证：</th><td>{{licenseNo}}</td></tr>
	<tr><th>开业时间：</th><td>{{startTime}}</td></tr>
</script>
<script id="action_menu" type="text/html">
	<tr class="action_content"><td>{{promotionContent}}</td></tr>
</script>
<script id="action" type="text/html">
<table>
	<tr><th>开始时间：</th><td>{{startTime}}</td></tr>
	<tr><th>结束时间：</th><td>{{endTime}}</td></tr>
	<tr><th colspan="2">活动内容：</th></tr>
	<tr><td colspan="2">{{remark}}</td></tr>
</table>
</script>

</head>

<body>
	<%@ include file="../common/top_menu.jsp"%>
	
	<!-- 活动登记的模态框 -->
<div class="modal fade" id="add_promotion_info" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
     <div class="modal-dialog" role="document">
          <div class="modal-content">
           <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                     <h4 class="modal-title" id="myModalLabel">添加活动信息</h4>
               </div>
           <div class="modal-body">
              <form class="form-horizontal">
               <!--    <div class="form-group">
                         <label class="col-sm-3 control-label">药店编号</label>
                         <div class="col-sm-9">
                         <input type="text" class="form-control" placeholder="请输入活动内容" name="promotionContent" id="Content_input">
                         </div>  
                 </div>  -->
                 <div class="form-group">
                         <label class="col-sm-3 control-label">活动内容</label>
                         <div class="col-sm-9">
                          <input type="text" class="form-control" placeholder="请输入活动内容" name="promotionContent" id="content_input">
                         </div>  
                 </div>
                 <div class="form-group">
                      <label class="col-sm-3 control-label">活动开始时间</label>
                      <div class="col-sm-9">
                      <input type="date" id="start_time" name="startTime" class="form-control"/>
                      </div>  
                </div>
                <div class="form-group">
                     <label class="col-sm-3 control-label">活动结束时间</label>
                     <div class="col-sm-9">
                     <input type="date" id="end_time" name="endTime" class="form-control"/>
                     </div>
                </div>
                <div class="form-group">
                     <label class="col-sm-3 control-label">活动说明</label>
                     <div class="col-sm-9">
                     <input type="text" class="form-control" placeholder="请输入活动说明" name="remark" id="remark_input">
                     </div>
                </div>
 
                <div class="form-group">
                     <div class="col-sm-offset-4 col-sm-8">
                      <button type="button" class="btn btn-default" style="margin-right:30px;">清空</button>
                      <button type="button" class="btn btn-default" id="promotion_submit_btn">提交</button>
                      </div>
               </div>
           </form>
      </div>
    </div>
   </div>
</div>

<div class="container">
    <div class="row Top">
       <div class="col-lg-3 col-md-4 col-sm-5 col-xs-5">
		  <div class="page-header">
                    <h3>往期活动</h3>
           </div>
	   </div>
	   <div class="col-lg-2 col-md-3 col-sm-4 col-xs-4   col-lg-offset-7 col-md-offset-6 col-sm-offset-1 col-xs-offset-1">
		   <div class="page-header" align="right">
                    <button type="button" class="btn btn-info add_promotion_btn" id="add_promotion_btn">添加新活动</button>
         </div>
	   </div>
    </div>
</div>
	  
	
	<div class="center">
		<div class="showCenter">
			<div id="showData">
				<table></table>
			</div>
			<div id="showAction">
				<div id="showAction_menu">
					<table>
					 	<tr class="action_head">
				    		<th class='promotionContent'>往期活动</th>
						</tr>
						<tbody  id="showAction_menu_tbody">
						
						</tbody>
					
					</table>
				</div>
				<div id="showAction_text"></div>
			</div>
		</div>
	</div>
	<div class="bottom">
		<p>版权所有：宿迁学院  && 文理学院</p>
	</div>
<script type="text/javascript">
	
	
	$(function(){
		var pharmId = "${sessionScope.user.userName}";
	   // alert(pharmId);
		console.log(pharmId);
		showData(pharmId);
		showAction(pharmId);
	});

	function showData(pharmId){	
		$("#showData table").empty();
		
		$.ajax({
			url:"${APP_PATH}/pharmacy/getPharmDetails",
			data:{"pharmId":pharmId	},
			type:"POST",
			success:function(result){
				console.log(result);
				var detail = result.extend.pharm;
				
				 var insertDetail = template('detailTable',detail);
				 $("#showData table").append(insertDetail);
			}			
		});
	}

	function showAction(pharmId){
		$("#showAction_menu_tbody").empty();
		$.ajax({
			url:"${APP_PATH}/pharmacy/getRecentPromotion",
			data:{"pharmId":pharmId	},
			type:"POST",
			success:function(result){
			//	console.log(result);		
				promotions = result.extend.promotions;
			    $.each(promotions,function(index,item){
			    	var insertDetail = template('action_menu',item);
					$(insertDetail).data("id",item.id);
					$("#showAction_menu_tbody").append(insertDetail);
					$("#showAction_menu_tbody tr:last").data("id",item.id);
	
				});
				
				$(document).on("click",".action_content",function(){			
					var id = $(this).data("id");
					$.ajax({
						url:"${APP_PATH}/pharmacy/getPromotionById",
						data:{"id":id	},
						type:"POST",
					   success:function(result){				   
						//   console.log(result);
						   $("#showAction_text").empty();
							 action=result.extend.promotion;
							 var insertDetail = template('action',action);
							 $("#showAction_text").append(insertDetail);
					   }
					});	
				});	
			}		
		});
	}
	
	//点击新增按钮弹出模态框。
	$(document).on("click",".add_promotion_btn",function(){
		//弹出模态框
			
		$("#add_promotion_info").modal({
			backdrop:"static"//点击背景不删除
		});
	});
	
	
	function validate_submit_form(pharmId,promotionContent,remark,startTime,endTime){
		//1、拿到要校验的数据，使用正则表达式
			
	    var roleId = "${sessionScope.user.roleId}";
	    if(roleId!=3)
		{
		    alert("只有药店才有此权限");
		    return false;
		}
		
		
				//
			//if(!promotionContent ||  trim(promotionContent)=="")
				if(!promotionContent)
			{
				alert("请输入活动内容！");
				return false;
			};
			if(!remark){
				alert("请输入说明！");
				return false;
			};
			if(!startTime){
				alert("请输入活动开始时间！");
				return false;
			};
			if(!endTime){
				alert("请输入活动结束时间！");
				return false;
			};
			return true;
		}

		$("#promotion_submit_btn").click(function(){
			//1、模态框中填写的表单数据提交给服务器进行保存
			//2、发送ajax请求保存缺货信息
			
			
			
			var pharmId = "${sessionScope.user.userName}";
			var promotionContent=$("#content_input").val();
			var remark=$("#remark_input").val();
			var startTime=$("#start_time").val();
			var endTime=$("#end_time").val();
			
			if(!validate_submit_form(pharmId,promotionContent,remark,startTime,endTime)){
				return false;
			}

		//alert("^^"+startTime+"^^");
			
			$.ajax({
				url:"${APP_PATH}/pharmacy/promotion_register",
				type:"POST",
				//data:$("#Addshortageinfo form").serialize(),
				data:{"pharmId":pharmId,
					  "promotionContent":promotionContent,
					  "remark":remark,
					  "startTime":startTime,
					  "endTime":endTime,
					},
				success:function(result){
					//alert(result.msg);
					alert("保存成功");
					$("#add_promotion_info").modal("hide");
					showData(pharmId);
					showAction(pharmId);
				}
			})
		})

</script>
</body>
</html>
