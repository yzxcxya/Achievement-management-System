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
<script type="text/javascript">
function check(){
	if(document.frm.myfile.value == ''){
		alert('文件不能为空 !');
		document.frm.myfile.select();
		return;
	}else{
		document.frm.submit();
	}
}
	function checks(){
	if(document.frm.myfile.value == ''){
		alert('文件不能为空 !');
		document.frm.myfile.select();
		return;
	}else{
		document.frms.submit();
	}

}
</script>

<form action="Xlsadd" method="post" name="frm" enctype="multipart/form-data">
<table class="table table-bordered" width="50%" border="1" style="border-collapse:collapse">
    <tr>
    	<td>文件 ：</td>
    	<td><input type="file" name="myfile" /></td>
    </tr>
    <tr>
    <td colspan="2" align="center">
    <button type="button" class="btn btn-primary btn-lg btn-block" onclick="check()">上传excel</button>
    
    </td>
    </tr>
 </table>
</form>

<form action="Xlsread" method="post" name="frms" enctype="multipart/form-data">
  <table class="table table-bordered" width="50%" border="1" style="border-collapse:collapse">
   <tr>
    <td colspan="2" align="center">
    <button type="button" class="btn btn-primary btn-lg btn-block" onclick="checks()">查看excel</button>
    
    </td>
    </tr>
    </table>
</form>

</body>
</html>