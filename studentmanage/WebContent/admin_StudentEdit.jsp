<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="util.*, bean.*, java.util.List" %>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8">
        <title>
            学生信息修改
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
        
          <form method="get" action="admin_StudentEditdo">
			<table class="table table-bordered" width="50%" border="1" style="border-collapse:collapse">
			<caption><h3>学生信息修改</h3></caption>
			<tr>
				<td>学生姓名:</td>
				<td><input type="text" name="studentName" value="${bean.studentName}"></td>
			</tr>
			<tr>
				<td>电话:</td>
				<td><input type="text" name="tel" value="${bean.tel}"></td>
			</tr>
			<tr>
				<td>班级:</td>
				<td><input type="text" name="classId" value="${bean.classId}"></td>
			</tr>
			<tr>
				<td>所在学院:</td>
				<td>
					<select name="acdemyId">
							<option value="">请选择</option>
							<c:forEach items="${acdemyLists }"	var="acde">		
							  <option value="${acde.acdemyId}" <c:if test="${bean.acdemyId == acde.acdemyId}">${"selected" }</c:if>>[${acde.acdemyId}] ${acde.acdemyName}</option>
						    </c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>地址:</td>
				<td><input name="address" type="text" value="${bean.address}"></td>
			</tr>
			<tr>
				<td>性别:</td>
				<td><input type="text" name="sex" value="${bean.sex}"></td>
			</tr>
			<tr>
				<td>民族:</td>
				<td><input type="text" name="nation" value="${bean.nation}"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="hidden" name="id" value="${bean.studentId }" />
					<button type="submit" class="btn btn-primary btn-lg btn-block">保存</button>
					<button type="button" class="btn btn-primary btn-lg btn-block" onclick="back()">取消</button>
				</td>
			</tr>
		</table>
	</form>	
          
  
    </body>

</html>