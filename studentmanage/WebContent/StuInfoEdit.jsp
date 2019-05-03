<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	.info{
		text-align:center;
		width: 100%;
		height:580px;
		background-color:#eeeeee;
		border: solid 1px #666666;
		padding:10px;
		padding-top:40px;
	}
</style>
<script type="text/javascript">
	function check(){
		if(form.newPassword1.value!=form.newPassword2.value){
			alert("两次密码输入不一致");
			form.newPassword2.select();
			return;
		}else{
			form.submit();
		}
		
	}
</script>
</head>
<body>
	<div class="info">
		<form class="form-horizontal" role="form" name="form" action="StuInfoEdit" method="post" >
		  <div style="padding-left:170px;">
		  <%
				String f = request.getParameter("f");
				if (f != null && f.equals("1")) {
					out.println("<font color='red'>原密码错误</font>");
				}else {
					out.println("  ");
				}
			%>	
		  </div>
		   <div class="form-group" style="padding-left:170px;">
		      <label class="col-sm-2 control-label">原密码</label>
		      <div class="col-sm-10">
		         <input type="text" class="form-control" name="originalPassword" style="width:500px" >
		      </div>
		   </div>
		  <div class="form-group" style="padding-left:170px;">
		      <label class="col-sm-2 control-label">新密码</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" name="newPassword1" style="width:500px" >
		      </div>
		  </div>
		  <div class="form-group" style="padding-left:170px;">
		      <label class="col-sm-2 control-label">确认新密码</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" name="newPassword2" style="width:500px" >
		      </div>
		  </div>
		  <button type="button" class="btn btn-info btn-lg" style="height:38px" onClick="check()">
          			<span class="glyphicon glyphicon-wrench"></span>修改
          </button>&nbsp;
		</form>
	</div>
</body>
</html>