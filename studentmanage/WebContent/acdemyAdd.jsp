<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
    		if(document.frm.acdemyId.value == ''){
    			alert('学院编号不能为空 !');
    			document.frm.acdemyId.select();
    			return;
    		}
    		if(document.frm.acdemyName.value == ''){
    			alert('学院名不能为空 !');
    			document.frm.acdemyName.select();
    			return;
    		}
    	}
    </script>
    
    <body>
        <div class="x-body">
           <form class="layui-form layui-form-pane" action="AcdemyAdd" method="get">
                
              <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                       学院编号
                    </label>
                <div class="layui-input-block">
                  <input type="text" name="acdemyId" required lay-verify="title" value="" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                
                 <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                        学院名称
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="acdemyName" required lay-verify="title" value="" 
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