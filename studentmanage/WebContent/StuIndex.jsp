<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生主界面</title>
</head>
<frameset rows="18%,*">
		<frame src="StudentTop.jsp" noresize="noresize"/>
		<frameset cols="200PX,*">
			<frame src="StudentLeft.jsp" noresize="noresize"/>
			<frame name="right" noresize="noresize" src="StudentRight.jsp"/>
		</frameset>
	</frameset>
</html>