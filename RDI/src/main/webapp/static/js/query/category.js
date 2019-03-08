/**
 * 
 */

var totalRecord,currentPage;
		//1、页面加载完成以后，直接去发送ajax请求,要到分页数据
$("#find").click(function(){

	to_page(1);
});
		


$(function(){
	getClassifyByLarge("#classifybylarge");			
});

function getClassifyByLarge(ele){
	//清空之前下拉列表的值
	$("ele option:not(:first)").remove();
	$.ajax({
		url:"../category/getClassifyByLarge",
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
$(function(){
	$("#classifybysmall").change(function(){
		$("#classifybykinds option:not(:first)").remove();
		var classifybysmallId=$(this).val();
		
		if(classifybysmall!=""){
			$.ajax({
				url:"../category/getClassifyByKinds",
				data:{"classifybysmallId":classifybysmallId},
				type:"POST",
				success:function(result){
					console.log(result);
					classifybykinds=result.extend.category;
					if(classifybysmallId!="" && classifybysmallId.length==0)
						alert("当前城市没有药纳入统计");		
					else{
						$.each(classifybykinds,function(){
						var optionEle = $("<option></option>").append(this.categName).attr("value",this.categId);
						optionEle.appendTo("#classifybykinds");
				      });
					}
				}
			});					
		}		
	})	
});
$(function(){
	$("#classifybymiddle").change(function(){
		$("#classifybysmall option:not(:first)").remove();
		var classifybymiddleId=$(this).val();
		
		if(classifybymiddle!=""){
			$.ajax({
				url:"../category/getClassifyBySmall",
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
				url:"../category/getClassifyByMiddle",
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


	

		
function to_page(pn){
			
			var categ4Id = $(".classifybykinds[name='classifybykinds']").val();
			var categ3Id = $(".classifybysmall[name='classifybysmall']").val();
			var categ2Id = $(".classifybymiddle[name='classifybymiddle']").val();
			var categ1Id = $(".classifybylarge[name='classifybylarge']").val();
			var parentId=null;
			//var level=null;
			if(categ4Id!="")
				parentId=categ4Id;
			else if(categ3Id!="")
				parentId=categ3Id;
			else if(categ2Id!="")
				parentId=categ2Id;
			else if(categ1Id!="")
				parentId=categ1Id;
			else
				parentId=null;
			
			//alert(categId);
			
			if(parentId!=null)
				{
				$.ajax({
					url:"../category/getCategoriesByParentId",
					data:{"pn":pn,
						"parentId":parentId,
						},
					type:"POST",
					success:function(result){
						console.log(result);
						build_categories_table(result);
							
						//2、解析并显示分页信息
						build_page_info(result);
						//3、解析显示分页条数据
						build_page_nav(result);
					}
				});
				
				}
			else
				{
				var categName= $(".Top input[name='categName']").val();
				var categLevel = $(".level[name='categLevel']").val();


				$.ajax({
					url:"../category/getCategories",
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
							build_categories_table_levelequals1(result);
						}
						else
						{
							build_categories_table(result);
						}
						
						//2、解析并显示分页信息
						build_page_info(result);
						//3、解析显示分页条数据
						build_page_nav(result);
						}
					});
				}
			}
		
		
		
		function build_categories_table_levelequals1(result){
			//清空table表格
			$("#categories_table tbody").empty();
			var categories = result.extend.pageInfo.list;
			$.each(categories,function(index,item){
				
				var categIdTd = $("<td></td>").append(item.categId);
				var categNameTd = $("<td></td>").append(item.categName);
				var levelTd = $("<td></td>").append(item.level);
				var parentCategNameTd = $("<td></td>").append("无");
		
				//下级分类信息按钮
                var childrenCategBtn = $("<button></button>").addClass("btn btn-primary btn-sm children_btn")
								.append($("<span></span>")).append("查看");
				
                childrenCategBtn.attr("details-id",item.categId);
				
				var childrenBtnTd = $("<td></td>").append(childrenCategBtn);
				
				
				//下级分类信息按钮
                var drugsCategBtn = $("<button></button>").addClass("btn btn-primary btn-sm drugs_btn")
								.append($("<span></span>")).append("详细列表");
				
                drugsCategBtn.attr("details-id",item.categId);
				
				var drugsBtnTd = $("<td></td>").append(drugsCategBtn);
				
				//append方法执行完成以后还是返回原来的元素
				$("<tr></tr>").append(categNameTd)
					.append(levelTd)
					.append(parentCategNameTd)
				//	.append(childrenBtnTd)
				//	.append(drugsBtnTd)
			 		.appendTo("#categories_table tbody");
			});
		}
		
		function build_categories_table(result){
			//清空table表格
			$("#categories_table tbody").empty();
			var categories = result.extend.pageInfo.list;
		//	alert(categories.length);
			$.each(categories,function(index,item){
				
				var categIdTd = $("<td></td>").append(item.categId);
				var categNameTd = $("<td></td>").append(item.categName);
				var levelTd = $("<td></td>").append(item.level);
				var parentCategNameTd = $("<td></td>").append(item.parentCategory.categName);
		
				//下级分类信息按钮
                var childrenCategBtn = $("<button></button>").addClass("btn btn-primary btn-sm children_btn")
								.append($("<span></span>")).append("详细列表");
				
                childrenCategBtn.attr("details-id",item.categId);
				
				var childrenBtnTd = $("<td></td>").append(childrenCategBtn);
				
				
				//下级分类信息按钮
                var drugsCategBtn = $("<button></button>").addClass("btn btn-primary btn-sm drugs_btn")
								.append($("<span></span>")).append("详细列表");
				
                drugsCategBtn.attr("details-id",item.categId);
				
				var drugsBtnTd = $("<td></td>").append(drugsCategBtn);
				
				//append方法执行完成以后还是返回原来的元素
				$("<tr></tr>").append(categNameTd)
					.append(levelTd)				
					.append(parentCategNameTd)
					//.append(childrenBtnTd)
					//.append(drugsBtnTd)
			 		.appendTo("#categories_table tbody");
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
		/*
		$(document).on("click",".details_btn",function(){

			//1、获取当前行的drug_id,并查询详细信息
			var drugId=$(this).attr("details-id");			
			
			var url ="../drugindex/drugIndicesDetail?drugId="+drugId;
			window.open(url);
			
			//getDrugIndices(drugId);
			
		});
		*/
		