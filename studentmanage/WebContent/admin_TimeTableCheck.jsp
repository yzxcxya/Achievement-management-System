<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="util.*, bean.*, java.util.List" %>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8">
        <title>
           课表审核
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
    <style>
    	
    </style>
    
    <script type="text/javascript">
    	function goback(){
    		history.back(-1);
    	}
    	
    	function check(){
    		if(document.frm.teacherId.value == ''){
    			alert('教师编号不能为空 !');
    			document.frm.teacherId.select();
    			return;
    		}
    		if(document.frm.weekdays.value == ''){
    			alert('星期不能为空 !');
    			document.frm.weekdays.select();
    			return;
    		}
    		if(document.frm.classId.value == ''){
    			alert('班级不能为空 !');
    			document.frm.classId.select();
    			return;
    		}
    		if(document.frm.weeks.value == ''){
    			alert('周次不能为空 !');
    			document.frm.weeks.select();
    			return;
    		}
    		if(document.frm.times.value == ''){
    			alert('时间不能为空 !');
    			document.frm.times.select();
    			return;
    		}
    		if(document.frm.address.value == ''){
    			alert('地址不能为空 !');
    			document.frm.address.select();
    			return;
    		}
    	}
    	
</script>
    
    <body>
        
        
        
          <form name="frm" method="post" action="admin_TimeTableEditdo">
			<table class="table table-bordered" width="50%" border="1" style="border-collapse:collapse">
			<caption><h3>课表审核</h3></caption>
			<tr>
				<td>教师工号:</td>
				<td><input type="text" disabled="disabled"  value="${table.teacherId }">
					<input type="hidden"  name="teacherId" value="${table.teacherId }">
				</td>
			</tr>
			<tr>
			<input type="hidden" name="weeks" value="${table.weeks }" />
				<td>周次:</td>
				<td>
				<select style="display:block;" name="newWeeks" class="layui-input">
					<option value="">请选择</option>
			 		<c:forEach items="${allweek}"	var="bean">		
						<option value="${bean}"<c:if test="${table.weeks==bean }">${"selected" }</c:if> >第${bean}周</option>
				</c:forEach>
		  		</select>
				</td>
			</tr>
			<tr>
			<input type="hidden" name="weekdays" value="${table.weekdays}" />
				<td>星期:</td>
				<td>
					<select name="newWeekdays">
							<option value="">请选择</option>
							<option value="1" <c:if test="${table.weekdays==1}">${"selected"}</c:if>>星期一</option>
							<option value="2" <c:if test="${table.weekdays==2}">${"selected"}</c:if>>星期二</option>
							<option value="3" <c:if test="${table.weekdays==3}">${"selected"}</c:if>>星期三</option>
							<option value="4" <c:if test="${table.weekdays==4}">${"selected"}</c:if>>星期四</option>
							<option value="5" <c:if test="${table.weekdays==5}">${"selected"}</c:if>>星期五</option>
							<option value="6" <c:if test="${table.weekdays==6}">${"selected"}</c:if>>星期六</option>
							<option value="7" <c:if test="${table.weekdays==7}">${"selected"}</c:if>>星期天</option>
					</select>
				</td>
			</tr>
			<tr>
			<input type="hidden"  name="times" value="${table.times }" />
				<td>时间:</td>
				<td>
					<select name="newTimes">
							<option value="">请选择</option>
							<option value="1" <c:if test="${table.times==1}">${"selected"}</c:if>>第一  二节</option>
							<option value="2" <c:if test="${table.times==2}">${"selected"}</c:if>>第三 四节</option>
							<option value="3" <c:if test="${table.times==3}">${"selected"}</c:if>>第五  六节</option>
							<option value="4" <c:if test="${table.times==4}">${"selected"}</c:if>>第七  八节</option>
							<option value="5" <c:if test="${table.times==5}">${"selected"}</c:if>>第九  十节</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>地址:</td>
				<td><input name="address" type="text" value="${table.address}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-primary btn-lg btn-block" onclick="check()">保存</button>
					<button type="button" class="btn btn-primary btn-lg btn-block" onclick="back()">取消</button>
				</td>
			</tr>
		</table>
	</form>	
          
  
    </body>

</html>