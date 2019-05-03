<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>请登录哟~</title>
    <script src="http://api.asilu.com/cdn/jquery.js,jquery.backstretch.min.js" type="text/javascript"></script>
	<style type="text/css">
		@import url('css/Login.css');
	</style>
	<!-- <link href="CSS/Login.css" rel="stylesheet" type="text/css"/> -->
</head>
<%
		String StuId = "";
		String StuPassword = "";
		String TeacherId = "";
		String TeacherPassword = "";
		String AdminId = "";
		String AdminPassword = "";
		Cookie[] c = request.getCookies();
		if (c != null) {
			for (int i = 0; i < c.length; i++) {
				if ("StuId".equals(c[i].getName())) {
					StuId = c[i].getValue();
				} else if ("StuPassword".equals(c[i].getName())) {
					StuPassword = c[i].getValue();
				} else if ("TeacherId".equals(c[i].getName())) {
					TeacherId = c[i].getValue();
				} else if ("TeacherPassword".equals(c[i].getName())) {
					TeacherPassword = c[i].getValue();
				} else if ("AdminId".equals(c[i].getName())) {
					AdminId = c[i].getValue();
				} else if ("AdminPassword".equals(c[i].getName())) {
					AdminPassword = c[i].getValue();
				}
			}
		} else {
			StuId = " ";
			StuPassword = " ";
			TeacherId = " ";
			TeacherPassword = " ";
			AdminId = " ";
			AdminPassword = " ";
		}
	%>
	<script>
	function check(){
  	var incode = (String)document.getElementById("codenum1").value; 
  	var rightcode = (String)session.getAttribute("rCode"); 
  	
  	if(incode != null && rightcode != null){
  		if(!incode.equals(rightcode)){
  			alert("验证码输入不正确！");
  			form1.code1.focus();
  		}else{
  			form1.submit();
  		}
  	}
  
	}</script>
<body>
	<script type="text/javascript" src="js/Login.js"></script>
	<div id="tab">
	  <ul class="tab_menu">
	    <li class="selected">学生登录</li>
	    <li>教师登录</li>
	    <li>管理员登录</li>
	  </ul>
	  <div class="tab_box"> 
	    <!-- 学生登录开始 -->
	    <div>
	      <div class="stu_error_box">
	      	<%
				String f = request.getParameter("f");
				if (f != null && f.equals("1")) {
					out.println("<font color='red'>密码错误</font>");
				} else if (f != null && f.equals("2")) {
					out.println("<font color='red'>学号不存在</font>");
				} else if (f != null && f.equals("3")) {
					out.println("<font color='red'>数据库连接出错</font>");
				} else if (f != null && f.equals("4")) {
					out.println("<font color='red'>验证码出错</font>");
				}else {
					out.println("  ");
				}
			%>	
	      </div>
	      <form action="Login" method="post" onSubmit="return check()" name="form1">
	        <div id="username">
	          <label>学&nbsp;&nbsp;&nbsp;号：</label>
	          <input type="text" id="StuId" name="StuId" required="required" placeholder="输入学号" value=<%=StuId %> >
	        </div>
	        <div id="password">
	          <label>密&nbsp;&nbsp;&nbsp;码：</label>
	          <input type="password" id="StuPassword" name="StuPassword" placeholder="输入密码" required="required" value="<%=StuPassword %>" >
	        </div>
	        <div id="code">
	          <label>验证码：</label>
	          <input type="text" id="codenum1" name="code1"  placeholder="输入验证码" required="required"/>
	          <img id="picture1" title="看不清？点击换一张" onclick="refresh()" src="number.jsp" style="width:96px;height:40px;vertical-align:middle">
	        </div>
	        <div id="remember">
	          <input type="checkbox" name="remember" value="remember">
	          <label>记住密码</label>
	        </div>
	        <div id="login">
	          <button type="submit">登录</button>
	        </div>
	      </form>
	    </div>
	   <!-- 学生登录结束-->
	   <!-- 导师登录开始-->
	    <div class="hide">
	      <div class="Tea_error_box">
	      <%
				String g = request.getParameter("g");
				if (g != null && g.equals("1")) {
					out.println("<font color='red'>密码错误</font>");
				} else if (g != null && g.equals("2")) {
					out.println("<font color='red'>教工号不存在</font>");
					//out.println("<Script> document.getElementById("TeacherId").focus()</script>");
				} else if (g != null && g.equals("3")) {
					out.println("<font color='red'>数据库连接出错</font>");
				}else if (g != null && g.equals("4")) {
					out.println("<font color='red'>验证码出错</font>");
				}else {
					out.println("  ");
				}
			%>	
	      </div>
	      <form action="TeacherLogin" method="post">
	        <div id="username">
	          <label>教工号：</label>
	          <input type="text" id="TeacherId" name="TeacherId" placeholder="输入教工号" required="required" value="<%=TeacherId %>"/>
	        </div>
	        <div id="password">
	          <label>密&nbsp;&nbsp;&nbsp;码：</label>
	          <input type="password" id="TeacherPassword" name="TeacherPassword" placeholder="输入密码" required="required" value="<%=TeacherPassword %>"/>
	        </div>
	        <div id="code">
	          <label>验证码：</label>
	          <input type="text" id="codenum2" name="code2"  placeholder="输入验证码" required="required"/>
	          <img id="picture2" title="看不清？点击换一张" onclick="refresh2()" src="number.jsp" style="width:96px;height:40px;vertical-align:middle"> 
	        </div>
	        <div id="remember">
	          <input type="checkbox" name="TeacherRemember" value="remember">
	          <label>记住密码</label>
	        </div>
	        <div id="login">
	          <button type="submit">登录</button>
	        </div>
	      </form>
	    </div>
	     <!-- 导师登录结束-->
	     <!-- 教务登录开始-->
	    <div class="hide">
	      <div class="Adm_error_box">
	      <%
				String h = request.getParameter("h");
				if (h != null && h.equals("1")) {
					out.println("<font color='red'>密码错误</font>");
				} else if (h != null && h.equals("2")) {
					out.println("<font color='red'>管理号不存在</font>");
				} else if (h != null && h.equals("3")) {
					out.println("<font color='red'>数据库连接出错</font>");
				}else if (h != null && h.equals("4")) {
					out.println("<font color='red'>验证码出错</font>");
				}else {
					out.println("  ");
				}
			%>	
	      </div>
	      <form action="AdmLogin" method="post">
	        <div id="username">
	          <label>管理号：</label>
	          <input type="text" id="AdminId" name="AdminId" placeholder="输入管理号" required="required" value="<%=AdminId %>"/>
	        </div>
	        <div id="password">
	          <label>密&nbsp;&nbsp;&nbsp;码：</label>
	          <input type="password" id="AdminPassword" name="AdminPassword" placeholder="输入密码" required="required" value="<%=AdminPassword %>"/>
	        </div>
	        <div id="code">
	          <label>验证码：</label>
	          <input type="text" id="codenum3" name="code3"  placeholder="输入验证码" required="required"/>
	          <img id="picture3" title="看不清？点击换一张" onclick="refresh3()" src="number.jsp" style="width:96px;height:40px;vertical-align:middle">
	        </div>
	        <div id="remember">
	          <input type="checkbox" name="remember" value="remember">
	          <label>记住密码</label>
	        </div>
	        <div id="login">
	          <button type="submit">登录</button>
	        </div>
	      </form>
	    </div>
	     <!-- 教务登录结束-->
	  </div>
	</div>
</body>
</html>