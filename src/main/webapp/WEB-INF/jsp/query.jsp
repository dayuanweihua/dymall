<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>query</title>
</head>
<body>

<%=session.getAttribute("username") %>您好，您当前卡余额为<%=request.getAttribute("price") %>元

</body>
</html>