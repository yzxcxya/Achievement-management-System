<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body style="background-color:#f2f2f5">
<script type="text/javascript">
	$(document).ready(function(){
		var $a = $('a');
		$a.hover(function(){
			$(this).addClass('active').siblings().removeClass('active');
		});	
	});
	</script>
	<a href="StudentRight.jsp" class="list-group-item active" target="right"><span class="glyphicon glyphicon-folder-close"></span>成绩</a>
	<a href="StuInfo.jsp" class="list-group-item" target="right"><span class="glyphicon glyphicon-user"></span>我的资料</a>
	<a href="StuInfoEdit.jsp" class="list-group-item" target="right"> <span class="glyphicon glyphicon-film"></span> 修改密码</a>
</body>
</html>