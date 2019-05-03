<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="util.*, bean.*, java.util.List" %>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8">
        <title>
            学院添加
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="./css/x-admin.css" media="all">
    </head>
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
    		if(document.frm.teacherName.value == ''){
    			alert('教师姓名不能为空 !');
    			document.frm.teacherName.select();
    			return;
    		}
    		if(document.frm.password.value == ''){
    			alert('密码不能为空 !');
    			document.frm.password.select();
    			return;
    		}
    		if(document.frm.sex.value == ''){
    			alert('性别不能为空 !');
    			document.frm.sex.select();
    			return;
    		}
    		if(document.frm.acdemyId.value == ''){
    			alert('学院不能为空 !');
    			document.frm.acdemyId.select();
    			return;
    		}
    	}
    	
    </script>
    
    <body>
        <div class="x-body">
           <form name="frm" class="layui-form layui-form-pane" action="TeacherAdd" method="get">
                
              <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label" style="width:80px">
                       教师编号<font color="red">*</font>
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="id" name="teacherId" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                
                 <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label" style="width:80px">
                        教师姓名<font color="red">*</font>
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" id="name" name="teacherName" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label" style="width:80px">
                        密码<font color="red">*</font>
                    </label>
                <div class="layui-input-block">
                  <input type="password" id="L_title" id="password" name="password" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                
                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label" style="width:80px">
                        性别<font color="red">*</font>
                    </label>
                <div class="layui-input-block">
                  <select style="display:block;" id="sex" name="sex" class="layui-input">
			<option value="">请选择</option>	
						<option value="男" >男</option>
						<option value="女" >女</option>		  
		  </select>
                </div>
                </div>
                
                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label" style="width:80px">
                        学院<font color="red">*</font>
                    </label>
                <div class="layui-input-block">
                  <select style="display:block;" id="acdemy" name="acdemyId" class="layui-input">
			<option value="">请选择</option>
				<c:forEach items="${acdemyLists}"	var="acde">		
						<option value="${acde.acdemyId}" <c:if test="${acde.acdemyId==teacher.acdemyId}">${"selected"}</c:if> >[${acde.acdemyId}] ${acde.acdemyName}</option>
			    </c:forEach>
		  </select>
                </div>
                </div>    
                
                 <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label" style="width:80px">
                        电话
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="tel" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                
                 <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label" style="width:80px">
                        地址
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="address" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                
                 <div class="layui-form-item">
                    <button class="layui-btn" type="submit" onclick="check()">
                       添加
                    </button>
                     <button class="layui-btn" type="reset">
                       重置
                    </button>
                     
                </div>
          </form>
    </div>
    </body>

</html>