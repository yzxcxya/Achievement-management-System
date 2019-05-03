<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
  <div class="layui-form-pane">
<form name="frm" action="DownGrade" method="post" class="layui-form x-center">
   <label class="btn btn-primary">学号</label>
        <div class="layui-input-inline" style="width:100px">
          <input type="text" name="studentId" id="studentID"  placeholder="学号" autocomplete="off" class="layui-input" value="">
        </div>
         <label class="btn btn-primary">课程</label>
        <div class="layui-input-inline" style="width:100px">
          <input type="text" name="courseId"  placeholder="班级" autocomplete="off" class="layui-input" value="">
        </div>
        <label class="layui-form-label">创建时间</label>
        <div class="layui-input-inline" style="width:150px">
          <input type="text" name="createtime"  placeholder="创建时间" autocomplete="off" class="layui-input" value="">
        </div>
<input type="submit" value="导出excel"/>
</form>
</div>

</body>
</html>