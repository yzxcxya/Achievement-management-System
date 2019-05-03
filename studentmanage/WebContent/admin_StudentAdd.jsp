<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8">
        <title>
            学生信息添加
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
    		if(document.frm.studentId.value == ''){
    			alert('学院编号不能为空 !');
    			document.frm.acdemyId.select();
    			return;
    		}
    		if(document.frm.studentName.value == ''){
    			alert('学院名不能为空 !');
    			document.frm.acdemyName.select();
    			return;
    		}
    	}
    </script>
    
    <body>
        <div class="x-body">
           <form class="layui-form layui-form-pane" action="admin_StudentAdd" method="get">
                
              <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                       学生编号
                    </label>
                <div class="layui-input-block">
                  <input type="text" name="studentId" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                
                 <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                        学生姓名
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="studentName" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                        班级号码
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="classId" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                        学院号码
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="acdemyId" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                       密码
                    </label>
                <div class="layui-input-block">
                  <input type="text" name="password" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                       性别
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
                    <label for="L_title" class="layui-form-label">
                       民族
                    </label>
                <div class="layui-input-block">
                  <input type="text" name="nation" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                <div class="layui-form-item">
                </div>
                   <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                       地址
                    </label>
                <div class="layui-input-block">
                  <input type="text" name="address" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                   <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                       电话
                    </label>
                <div class="layui-input-block">
                  <input type="text" name="tel" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                   <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                      入学时间
                    </label>
                <div class="layui-input-block">
                  <input type="text" name="admissiontime" required lay-verify="title" value="" 
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