var SUCCESS=0;
var ERROR=1;

$("#button_submit").click(function(){
		findUser();
	});
	


function findUser(){
	var username=$(".register input[name='username']").val();
	var password=$(".register input[name='password']").val();
	console.log(username+"   "+password);
	data={'userName':username,
		  'password':password};
	var url='user/getUser';
	$.post(url,data,function(result){
		console.log(result);
		if(result.state==SUCCESS){
			window.location.href="visitor/visitor_home.jsp";
		}
		else{
			$("#login_error").val(result.message);
		}
		
	});
	
}