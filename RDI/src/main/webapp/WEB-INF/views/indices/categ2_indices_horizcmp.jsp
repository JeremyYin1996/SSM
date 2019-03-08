<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>中类指数横向对比</title>
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
	   <div class="col-lg-3 col-md-4 col-sm-4  col-xs-5  col-lg-offset-8 col-md-offset-6 col-sm-offset-6 col-xs-offset-5">
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

	    <div class="col-lg-1 col-md-1 col-sm-2  col-xs-2">
             <button id="find">搜&nbsp;&nbsp;索</button>
	     </div>
    </div>
<div class="row">
        <h5 style="color:red;">注1：若统计范围为"宿迁市"，则表示整个宿迁市的分类指数；若统计范围为"市区"、"沭阳县"、"泗阳县"或"泗洪县"表示各县区的分类指数。</h5>
        <h5 style="color:red;">注2：点击"纵向对比"按钮可以查看最近一年指数变化情况。</h5>
   
    </div>
    <div class="row Center">
	    	<table class="table table-bordered table-hover" id="categindex_table" >
			   <thead>
			       <tr class='head'>
		    	      <tr class='head'>
		    	       <th style="text-align:center">化学通用名</th>
		    	       <th style="text-align:center">分类级别</th>
		    	       <th id="table-statis-range" style="text-align:center">统计范围</th>	        	
		    	       <th style="text-align:center">限定日费用</th>   
		    	       <th style="text-align:center">统计月份</th>
		    	       <th style="text-align:center">纵向对比</th>       
			      </tr>
			   </thead>		
		     <tbody>
					
		     </tbody>
		     </table>
    </div>
 
</div>
<script type="text/javascript">
	
   $(function(){
	var categId = "${requestScope.categId }";
	var year = "${requestScope.year }";
	var month = "${requestScope.month }";
	
	//showData(drugId);
	
	$.ajax({
		url:"${APP_PATH}/categ2index/horizCmpDrugIndex",
		data:{"categId":categId,
			  "year":year,
			  "month":month,
			},
		type:"GET",
		success:function(result){
			console.log(result);
			//1、解析并显示员工药品数据
			build_categ_index_table(result);
		
		}
	});
   });
   
   $("#find").click(function(){
	    var categId = "${requestScope.categId }";
	    var year = $(".statisyear[name='statisYear']").val();
		var month = $(".statismonth[name='statisMonth']").val();
		
		//showData(drugId);
		
		$.ajax({
			url:"${APP_PATH}/categ2index/horizCmpDrugIndex",
			data:{"categId":categId,
				  "year":year,
				  "month":month,
				},
			type:"GET",
			success:function(result){
				console.log(result);
				//1、解析并显示员工药品数据
				build_categ_index_table(result);
			
			}
		});
		
	});

   
   
   
   function build_categ_index_table(result){
		$("#categindex_table tbody").empty();		
/*
 * 
 <th id="table-avg-price" style="text-align:center">均价</th> 	      
 <th style="text-align:center">当月指数</th>
 <th id="table-pharm-name" style="text-align:center">药店名称</th>
 <th id="table-statis-range" style="text-align:center">所在区域</th>
 <th style="text-align:center">统计月份</th>
 */
		var category = result.extend.category;		
		var categIndex= result.extend.categIndex;
		$.each(categIndex,function(index,item){
		
			var categNameTd = $("<td></td>").append(category.categName);
	    	var levelTd=$("<td></td>").append("中类");
			var districtTd = $("<td></td>").append("宿迁市");
			//var pharmacyTd=$("<td></td>").append(" ");
			var categIndexTd = $("<td></td>").append(item.categIndex);
			var statisDateTd = $("<td></td>").append(item.statisDate);
			var vertiCmpBtn = $("<button></button>").addClass("btn btn-primary btn-sm vertic_cmp_btn").append("纵向比较");
			//.append($("<span></span>").addClass("glyphicon glyphicon-option-vertical"))
           //为纵向比较按钮添加自定义的属性，来表示当前分类id和统计日期
            vertiCmpBtn.attr("details-categ-id",item.categId);
       
            var btnTd = $("<td></td>").append(vertiCmpBtn);
			//append方法执行完成以后还是返回原来的元素
			$("<tr></tr>").append(categNameTd)				
				.append(levelTd)
				.append(districtTd)
				.append(categIndexTd)
				.append(statisDateTd)
				.append(btnTd)
		 		.appendTo("#categindex_table tbody");
		});
		
		
		categIndexWithDis=result.extend.categIndexWithDis;
		$.each(categIndexWithDis,function(index,item){
		
			var categNameTd = $("<td></td>").append(category.categName);
	    	var levelTd=$("<td></td>").append("中类");
	    	var districtTd = $("<td></td>").append(item.district.county);
			//var pharmacyTd=$("<td></td>").append(" ");
			var categIndexTd = $("<td></td>").append(item.categIndex);
			var statisDateTd = $("<td></td>").append(item.statisDate);

           var vertiCmpBtn = $("<button></button>").addClass("btn btn-primary btn-sm vertic_cmp_btn").append("纵向比较");
			//.append($("<span></span>").addClass("glyphicon glyphicon-option-vertical"))
            //为纵向比较按钮添加自定义的属性，来表示当前分类id和统计日期
           vertiCmpBtn.attr("details-categ-id",item.categId);
           vertiCmpBtn.attr("details-district-id",item.districtId);
   
       var btnTd = $("<td></td>").append(vertiCmpBtn);
			//append方法执行完成以后还是返回原来的元素
			$("<tr></tr>").append(categNameTd)				
				.append(levelTd)
				.append(districtTd)
				.append(categIndexTd)
				.append(statisDateTd)
				.append(btnTd)
		 		.appendTo("#categindex_table tbody");
		});
		
		categIndexWithPharm=result.extend.categIndexWithPharm;
		$.each(categIndexWithPharm,function(index,item){
		
			var categNameTd = $("<td></td>").append(category.categName);
	    	var levelTd=$("<td></td>").append("中类");
	    	var districtTd = $("<td></td>").append(item.pharmacy.district.county+" . "
					+item.pharmacy.pharmName);
			//var pharmacyTd=$("<td></td>").append(" ");
			var categIndexTd = $("<td></td>").append(item.categIndex);
			var statisDateTd = $("<td></td>").append(item.statisDate);

            var vertiCmpBtn = $("<button></button>").addClass("btn btn-primary btn-sm vertic_cmp_btn").append("纵向比较");
			//.append($("<span></span>").addClass("glyphicon glyphicon-option-vertical"))
           //为纵向比较按钮添加自定义的属性，来表示当前分类id和统计日期
           vertiCmpBtn.attr("details-categ-id",item.categId);
           vertiCmpBtn.attr("details-pharm-id",item.pharmId);
       
           var btnTd = $("<td></td>").append(vertiCmpBtn);
			$("<tr></tr>").append(categNameTd)				
			.append(levelTd)
			.append(districtTd)
			.append(categIndexTd)
			.append(statisDateTd)
			.append(btnTd)
	 		.appendTo("#categindex_table tbody");

			
		});
	}

   $(document).on("click",".vertic_cmp_btn",function(){

		//1、获取当前行的drug_id,并查询详细信息
		var categId=$(this).attr("details-categ-id");	
		var pharmId=$(this).attr("details-pharm-id");
		var districtId=$(this).attr("details-district-id");
		
		var url=null;
		
		if(pharmId!=null && pharmId!="" && pharmId.trim()!="")
			{
		    	url ="${APP_PATH}/categ2index/toCateg2IndicesDetail?categId="+categId+"&pharmId="+pharmId;
			
			}
		else if(districtId!=null && districtId!="" && districtId.trim()!="")
			{
			    url ="${APP_PATH}/categ2index/toCateg2IndicesDetail?categId="+categId+"&districtId="+districtId;	
			}
		else
			url="${APP_PATH}/categ2index/toCateg2IndicesDetail?categId="+categId;
			
		window.open(url);

	});
	

	
		
	
	
	</script>
</body>
</html>