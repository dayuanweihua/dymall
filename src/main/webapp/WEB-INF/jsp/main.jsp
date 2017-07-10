<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>main</title>
</head>
<body>

${user.username }你好！请选择要操作的功能。${sessionScope.message }

<br/>

<a href="${pageContext.request.contextPath }/QukuanServlet?method=toStart">取款</a>
<br/>
<a href="${pageContext.request.contextPath }/QueryPriceServlet">查询余额</a>
<br/>
<a href="${pageContext.request.contextPath }/OutServlet">退出</a>
</body>
</html>