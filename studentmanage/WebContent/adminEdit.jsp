<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8">
        <title>
            管理员信息修改
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
    	
    </script>
    <style>
    	.x-body{
    		width:60%;
    		float:left;
    		height:100%;
    	}
    	.a{
    		width:35%;
    		float:left;
    		height:100%;
    		text-align:center;
    		margin-top:20px;
    		padding:auto;
    	}
    </style>
    <body>
        <div class="x-body">
          
           <form class="layui-form layui-form-pane" action="adminInfoEdit" method="post">
                
              <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                       编号
                    </label>
                <div class="layui-input-block">
                  <input type="text" name="adminId" required lay-verify="title" value="${admin.id }" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                
                 <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                        姓名
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="adminName" required lay-verify="title" value="${admin.name }" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                        密码
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="password" required lay-verify="title" value="${admin.password}" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                        性别
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="sex" required lay-verify="title" value="${admin.sex }" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                        地址
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="address" required lay-verify="title" value="${admin.address }" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                        电话
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="tel" required lay-verify="title" value="${admin.tel }" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                 <div class="layui-form-item">
                    <button class="layui-btn" type="submit">
                       修改
                    </button>
                     <button class="layui-btn" type="reset">
                       重置
                    </button>
                 
                     
                </div>
          </form>
    </div>
    <div class="a">
    	<a href="adminImage.jsp?id=${AdminId } &img=${admin.image }"><img src=  <c:choose> <c:when test="${admin.image==null}">"images\TX.jpg"</c:when> <c:otherwise>'image/${admin.image }'</c:otherwise></c:choose> style="width:300px;;heigth:460px;"></a>
    	<h2>点击修改图片</h2>
    </div>
    </body>

</html>