<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
	.container1{
		
		border:1px solid #00ff00;
		width:1340px;
		height:108px;
		background-color:#0b5ea5;
		line-height:100px;
		
		margin:auto;
	}
	.a{
		
		float:left;
		text-align:center;
		width:70%;
		
		height:106px;
		font-family:
		font-size:50px;
	}
	.b{
		
		float:left;
		text-align:center;
		width:30%;
		height:106px;
		font-size:20px;
	}
</style>
</head>
<body>
	<div class="container1">
		<div class="a">
			<h1 style="text-shadow: gray 5px 3px 3px;letter-spacing:5px;display:inline;">同学，欢迎使用本系统</h1>
        </div>
        <div class="b">
        	欢迎你<font color="red"><%=session.getAttribute("StuId") %>${stu.name}</font>
			<a href="logout.jsp" target="_parent">
          		<span class="glyphicon glyphicon-off" style="color:white">退出</span>
        	</a>
        </div>
	</div>
</body>
</html>