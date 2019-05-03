<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.jspsmart.upload.SmartUpload,  java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="Xlsadd" method="post" enctype="multipart/form-data">
    <input type="file" name="myfile" />
    <input type="submit" value="上传excel" />
</form>


<form action="Xlsread" method="post" >
<input type="text" id="L_title" name="filepos" required lay-verify="title" value=<%=request.getAttribute("dizhi") %> 
                        autocomplete="off" class="layui-input">
    
    <input type="submit" value="查看excel" />
</form>


</body>
</html>