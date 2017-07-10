$(document).ready(function(){
		//页面头，登录相关
		$.ajax({
			type : "POST",
			url : "http://localhost:8080/dymall/user/queryUserInfo.shtml",
			data : "",
			dataType: "json",
			success : function(data) {
				if(data.code==1){
					if(data.data==null){
						$(".menu-hd:first").html("<a href=\"../home/login.html\" target=\"_top\" class=\"h\">亲，请登录</a> "+
												"<a href=\"../home/register.html\" target=\"_top\">免费注册</a>");
					}			
						if(data.data.username!=null){
							$(".menu-hd:first").html("Hi "+data.data.username);
						}else if(data.data.phone!=null){
							$(".menu-hd:first").html("Hi "+data.data.phone);
						}else if(!data.data.email!=null){
							$(".menu-hd:first").html("Hi "+data.data.email);
						}
					} else {
						alert(data.msg);
					}
				}
			}
		);
});
//alert("#amount1").text();

	
$.ajax({
	type : "POST",
	url : "http://localhost:8080/dymall/order/getOrdersByParams.shtml",
	data:"orderStatus=-1",
	dataType : "json",
	success:function(data){
		if(data.code==1){
			if(data.data==null){
				alert("未登录");
			}else{
				var app4=new Vue({
					el:'#app-4',
					data:{
						todos:data.data
					}
				})
			}
		}else{
			alert(data.msg);
		}
	}
});
