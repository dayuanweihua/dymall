<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>login</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

<script type="text/javascript">
	//POST方式
	/* $.ajax({
		type : "POST",
		url : "${pageContext.request.contextPath }/login/test.do",
		data : "name=xxx",
		dataType: "json",
		success : function(data) {
			alert(data.key);
		}
	});
 */
 
 
 function check() {
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath }/login/test.do",
			data : "mobile=14500000000",
			dataType: "json",
			success : function(data) {
			
				alert(data.msg);
			
				}
			}
		);

	}


	window.onload = function(){
		check();
	}
	</script>
</head>
<body>


${message }

	<form
		action="${pageContext.request.contextPath }/login/check.do"
		method="post">
		卡号：<input type="text" name="username" id="username" onblur="checkUsername();" onfocus="$('#msg').html('');" /> <br /> 密码：<input
			type="text" name="password" id="password" /> <br /> 
			<span id="msg" style="color: red"></span> <br>
			<input type="submit" value="提交" />
	</form>


</body>
</html>