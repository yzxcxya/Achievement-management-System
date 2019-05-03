<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8">
        <title>
            课程添加
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
    		if(document.frm.courseId.value == ''){
    			alert('课程编号不能为空 !');
    			document.frm.courseId.select();
    			return;
    		}
    		if(document.frm.courseName.value == ''){
    			alert('课程名不能为空 !');
    			document.frm.courseName.select();
    			return;
    		}
    	}
    </script>
    
    <body>
        <div class="x-body">
           <form class="layui-form layui-form-pane" action="admin_CourseAdd" method="get">
                
              <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                      课程编号
                    </label>
                <div class="layui-input-block">
                  <input type="text" name="courseId" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                
                 <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                        课程名称
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="courseName" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                        课程性质
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="courseProperty" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                        考察方式
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="courseWay" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                        学分
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="courseCredit" required lay-verify="title" value="" 
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