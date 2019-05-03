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
    	function check(){
    		if(document.frm.acdemyName.value == ''){
    			alert('学院名不能为空 !');
    			document.frm.acdemyName.select();
    			return;
    		}else{
    			document.frm.submit();
    		}
    	}
    </script>
    
    <body>
        
          <form method="get" name="frm" action="AcdemyEditdo">
			<table class="table table-bordered" width="50%" border="1" style="border-collapse:collapse">
			<caption><h3>学院信息修改</h3></caption>
			
			<tr>
				<td>学院编号:</td>
				<td><input type="text" disabled="disabled" value="${bean.acdemyId}">
				<input  type="hidden" name="acdemyId" value="${bean.acdemyId}">
				</td>
			</tr>
			<tr>
				<td>学院名:</td>
				<td><input type="text" name="acdemyName" value="${bean.acdemyName}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">	
					<input type="hidden" name="id" value="${bean.acdemyId}">
					<button type="button" class="btn btn-primary btn-lg btn-block" onclick="check()">保存</button>
				</td>
			</tr>
		</table>
	</form>	
          
  
    </body>

</html>