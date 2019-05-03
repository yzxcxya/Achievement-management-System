<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	.info{
		text-align:center;
		width: 65%;
		height:495px;
		background-color:#eeeeee;
		
		padding:10px;
		float:left;
	}
	.image{
		text-align:center;
		width: 35%;
		height:495px;
		background-color:#eeeeee;
		
		padding:10px;
		float:left;
	}
</style>
</head>
<body>
	<div class="info">
		<form class="form-horizontal" role="form" action="#" method="post">
		   <div class="form-group">
		      <label class="col-sm-2 control-label">学号</label>
		      <div class="col-sm-10">
		         <input type="text" class="form-control" name="title" style="width:500px" value="${stu.id }" readonly="readonly">
		      </div>
		   </div>
		  <div class="form-group">
		      <label class="col-sm-2 control-label">姓名</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" name="content" style="width:500px" value="${stu.name }" readonly="readonly">
		      </div>
		  </div>
		  <div class="form-group">
		      <label class="col-sm-2 control-label">性别</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" name="creat_Time" style="width:500px" value="${stu.sex }" readonly="readonly">
		      </div>
		  </div>
		  <div class="form-group">
		      <label class="col-sm-2 control-label">民族</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" name="read_count" style="width:500px" value="${stu.nation }" readonly="readonly">
		      </div>
		  </div>
		  <div class="form-group">
		      <label class="col-sm-2 control-label">班级</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" name="read_count" style="width:500px" value="${stu.classId }" readonly="readonly">
		      </div>
		  </div>
		  <div class="form-group">
		      <label class="col-sm-2 control-label">学院</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" name="read_count"  style="width:500px" value="${stu.acdemyId }" readonly="readonly">
		      </div>
		  </div>
		  <div class="form-group">
		      <label class="col-sm-2 control-label">电话</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" name="read_count"  style="width:500px" value="${stu.tel }" readonly="readonly">
		      </div>
		  </div>
		  <div class="form-group">
		      <label class="col-sm-2 control-label">入学时间</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" name="read_count"  style="width:500px" value="${stu.admissiontime }" readonly="readonly">
		      </div>
		  </div>
		  <div class="form-group">
		      <label class="col-sm-2 control-label">地址</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" name="read_count"  style="width:500px" value="${stu.address }" readonly="readonly">
		      </div>
		  </div>
		</form>
	</div>
	<div class="image">
		<a href="studentimage.jsp?id=${StuId } &img=${stu.image }"><img src=  <c:choose> <c:when test="${stu.image==null}">"images\TX.jpg"</c:when> <c:otherwise>'image/${stu.image }'</c:otherwise></c:choose> style="width:300px;;heigth:400px;"></a>
	</div>
</body>
</html>