<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>query</title>

<script type="text/javascript">
	function check(){
		document.getElementById("submit").disabled=true;
		
		return true;
	}
</script>

</head>
<body>

	<%=session.getAttribute("username")%>您好，您当前卡余额为<%=request.getAttribute("price")%>元

	<form action="QukuanServlet?method=qukuan" method="POST" onsubmit="return check();">
		<input name="token" type="hidden" value="${token }"/>
		取款金额：<input name="price" type="text" />
		<br/>
		<input id="submit" type="submit" value="提交">
	</form>


</body>
</html>