<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="util.*, bean.*, java.util.List" %>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8">
        <title>
            教师信息修改
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
       <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <script type="text/javascript">
    	function goback(){
    		history.back(-1);
    	}
    	
    </script>
    
    <body>
        
          <form method="get" action="admin_gradeEditdo">
			<table class="table table-bordered" width="50%" border="1" style="border-collapse:collapse">
			<caption><h3>成绩信息修改</h3></caption>
			<tr>
				<td>学号:</td>
				<td><input type="text" disabled="disabled" value="${bean.studentId}"></td>
			</tr>
			<tr>
				<td>姓名:</td>
				<td><input type="text" name="studentName" disabled="disabled" value="${bean.studentName}"></td>
			</tr>
			<tr>
				<td>课程:</td>
				<td><input type="text" disabled="disabled" value="${bean.courseId} ${bean.courseName}"></td>
			</tr>
			<tr>
				<td>成绩:</td>
				<td><input type="text" name="grade" value="${bean.grade}"></td>
			</tr>
			<tr>
				
				<td colspan="2" align="center">
					<input type="hidden" name="studentId" value="${bean.studentId}">
					<input type="hidden" name="courseId" value="${bean.courseId}">
					<button type="submit" class="btn btn-primary btn-lg btn-block">保存</button>
					<button type="button" class="btn btn-primary btn-lg btn-block" onclick="back()">取消</button>
				</td>
			</tr>
		</table>
	</form>	
          
  
    </body>

</html>