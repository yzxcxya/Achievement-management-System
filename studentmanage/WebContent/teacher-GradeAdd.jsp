<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8">
        <title>
            成绩添加
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
    
    <body>
        <div class="x-body">
          
           <form class="layui-form layui-form-pane" action="teacher_GradeAdd" method="post">
                
              <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                       学号
                    </label>
                <div class="layui-input-block">
                  <input type="text" name="studentId" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                
                 <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                       课程号
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="courseId" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                <div class="layui-form-item">
	                <label for="L_title" class="layui-form-label">
	                        创建时间
	                    </label>
	                <div class="layui-input-block" style="width:450px;border:1px;">
					  <select style="display:block;" name="createtime" class="layui-input">
						<option value="">请选择</option>
						<option value="2018-1">2018-1</option>
						<option value="2018-2">2018-2</option>
						<option value="2019-1">2019-1</option>
						<option value="2019-2">2019-2</option>	
					  </select>
	        		</div>  
                </div>

                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                        成绩
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="grade" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                 <div class="layui-form-item">
                    <button class="layui-btn" type="submit">
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