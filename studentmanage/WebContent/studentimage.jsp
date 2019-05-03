<%@ page language="java" contentType="text/html;utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.*,java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>
            头像
        </title>
       <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
<body>


<script>
	function ProcessFile() {
            var file = document.getElementById('imageFile').files[0];
            if (file) {
                var reader = new FileReader();
                reader.onload = function (event) {
                    var txt = event.target.result;
 
                    var img = document.getElementById("image");
                    img.src = txt;//将图片base64字符串赋值给img的src
                   // console.log(txt);
                    
                };
            }
            reader.readAsDataURL(file);
        }
	
</script>


<center>
<form role="form" method="post" action="StudentImageAdd" enctype="multipart/form-data">
	<input type="hidden"  name="id" value='<%=request.getParameter("id")%>'>
	<table border="0" style="width:10%;height30%;background-color:#79cdef">
		<tr style="width:90%;height80%">
			<td  style="width:100%;heigth:60%">
				<image src="<% if(request.getParameter("img").length()==0){%>images\TX.jpg<%}else{ %>image\<%=request.getParameter("img") %><%}%>" id="image" class="img-thumbnail" style="width:100%;heigth:100%;"></image>
			</td>
		</tr>
		<tr style="width:90%;height20%">
			<td><input type="file" value="选择图片" id="imageFile" name="file"  onchange="ProcessFile()"></td>
			
		</tr>
		<tr style="width:90%;height20%;align:center">	
			<td><button type="submit" class="btn btn-primary">提交</button></td>
		</tr>
		
		
	</table>
</form>
</center>
</body>
</html>