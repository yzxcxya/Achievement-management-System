<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	session.removeAttribute("StuId");
	session.removeAttribute("AdminId");
	session.removeAttribute("TeacherId");
	//session.invalidate();
	response.sendRedirect("Login.jsp");
%>
</body>
</html>