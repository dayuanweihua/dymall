$.extend({
	mallHost:"http://www.dymall.com"
});


/**
 * 页面传值公用方法
 * 使用样例
 * var str ="www.jb51.net/index.htm?a=1&b=1&c=测试测试";
 * alert(str.getQuery("a"));
 * alert(str.getQuery("b"));
 * alert(str.getQuery("c"));
 * 
 * 获取浏览器地址
 * alert(location.search);  ?googId=5555
 * alert(document.URL);     http://localhost:8081/dymall/home/introduction.html?googId=5555
 */
String.prototype.getQuery = function(name)
{
 　　var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
 　　var r = this.substr(this.indexOf("?")+1).match(reg);
 　　if (r!=null) return unescape(r[2]); return null;
}
 
$.ajaxSetup({
//  contentType : "application/x-www-form-urlencoded;charset=utf-8",
	
  complete : function(xhr, textStatus) {
	 
  	// 通过XMLHttpRequest取得响应头，sessionstatus
      var sessionstatus = xhr.getResponseHeader("loginStatus"); 
      if (sessionstatus == "0") {
          // 如果超时就处理 ，指定要跳转的页面
          window.location.replace("http://localhost:8080/dymall/home/login.html");
      }
  }
});


$(document).ready(function(){
		//页面头，登录相关
		$.ajax({
			type : "POST",
			url :$.mallHost+"/user/queryUserInfo.shtml",
			data : "",
			dataType: "json",
			success : function(data) {
				if(data.code==1){
					if(data.data==null){
						$(".menu-hd:first").html("<a href=\"http://localhost:8080/dymall/home/login.html\" target=\"_top\" class=\"h\">亲，请登录</a> "+
												"<a href=\"http://localhost:8080/dymall/home/register.html\" target=\"_top\">免费注册</a>");
					}			
						if(data.data.email!=null){
							$(".menu-hd:first").html("Hi "+data.data.email);
						}else if(data.data.phone!=null){
							$(".menu-hd:first").html("Hi "+data.data.phone);
						}else if(!data.data.username!=null){
							$(".menu-hd:first").html("Hi "+data.data.username);
						}
					} else {
						alert(data.msg);
					}
				}
			}
		);
});