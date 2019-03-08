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
	<div class="center">
		<div class="showCenter">
			<div id="showData">
				<table></table>
			</div>
			<div id="showAction">
				<div id="showAction_menu">
					<table>
					 	<tr class="action_head">
				    		<th class='promotionContent'>活动标题</th>
						</tr>
					
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
		var pharmId = "${requestScope.pharmId }";
	   // alert(pharmId);
		console.log(pharmId);
		showData(pharmId);
		showAction(pharmId);
	});

	function showData(pharmId){	
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
					$("#showAction_menu table").append(insertDetail);
					$("#showAction_menu table tr:last").data("id",item.id);
	
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

</script>
</body>
</html>
