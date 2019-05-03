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
	.searchbox{
		text-align:center;
		width: 100%;
		height:580px;
		background-color:#eeeeee;
		border: solid 1px #666666;
		padding:10px;
	}
	
	.DataArea {
		margin: 10px;
	}
	th{
		text-align:center;
	}
</style>
</head>
<body>
	<div class="searchbox">
		<div class="DataArea">
			<form name="frm" action="stuGrade" method="post">
				时间:<select class="form-control" style="width:120px;display:inline" name="time">
				    <option value="">请选择学年学期</option>
				    <option value="2018-1" <c:if test="${time=='2018-1'}">${"selected" }</c:if> > 2018-1</option>
				    <option value="2018-2" <c:if test="${time=='2018-2'}">${"selected" }</c:if> > 2018-2</option>
				    <option value="2019-1" <c:if test="${time=='2019-1'}">${"selected" }</c:if> > 2019-1</option>
				    <option value="2019-2" <c:if test="${time=='2019-2'}">${"selected" }</c:if> > 2019-2</option>
				</select>&nbsp;
				<button type="submit" class="btn btn-info btn-lg" style="height:38px">
          			<span class="glyphicon glyphicon-search"></span> 查找
        		</button>&nbsp;
			</form>
		</div>
		<div class="DataArea">
				<table class="table table-hover">
					<caption>你的成绩啊</caption>
					<thead>
						<tr>
							<th width="100px">序号</th>
							<th width="200px">课程名称</th>
							<th wdth="100px">成绩</th>
							<th width="100px">学分</th>
							<th width="200px">考核方式</th>
							<th width="200px">课程性质</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${list }"	var="a" varStatus="b">	
						<tr>
							<td width="100px">${b.count}</td>
							<td width="200px">${a.courseName }</td>
							<td width="100px"><div class="wrap" title="${a.grade }">${a.grade }</div></td>
							<td width="100px"><div class="wrap" title="${a.courseCredit }">${a.courseCredit }</div></td>
							<td width="200px">${a.courseWay }</td>
							<td width="200px">${a.courseProperty }</td>
						</tr>
						</c:forEach>
						<tr>
							<td>各科平均分：</td>
							<td>${avgGrade}</td>
							<td></td>
							<td></td>
							<td>总分：</td>
							<td>${sumGrade}</td>
						</tr>
						
					</tbody>
				</table>
			</div>
			
			
		<div class="DataArea">
			<form name="frm" action="StuUnGrade" method="post">
				<button type="submit" class="btn btn-info btn-lg" style="width:250px">
          			<span class="glyphicon glyphicon-search"></span> 查看所有未过成绩及学分
        		</button>
			</form>
		</div>
		<div class="DataArea">
				<table class="table table-hover">
					<caption>已挂科成绩啊</caption>
					<thead>
						<tr>
							<th >序号</th>
							<th >课程名称</th>
							<th >成绩</th>
							<th >学分</th>
							<th >考核方式</th>
							<th>课程性质</th>
							<th>学年学期</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${listUngrade }"	var="a" varStatus="b">	
						<tr>
							<td >${b.count}</td>
							<td >${a.courseName }</td>
							<td ><div class="wrap" title="${a.grade }">${a.grade }</div></td>
							<td ><div class="wrap" title="${a.courseCredit }">${a.courseCredit }</div></td>
							<td >${a.courseWay }</td>
							<td >${a.courseProperty }</td>
							<td>${a.creatTime}</td>
						</tr>
						</c:forEach>
						<tr>
							<td>未过总学分：</td>
							<td>${totalCredit}</td>
						</tr>
					</tbody>
				</table>
			</div>
	</div>
</body>
</html>