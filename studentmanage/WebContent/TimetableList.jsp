<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="util.*, bean.*, bean.Timetable,java.util.*" %>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8">
        <title>
            教师信息修改
        </title>

		<link rel="stylesheet" href="./css/x-admin.css" media="all">
		<link rel="stylesheet" href="css/pag.css" media="all">
    </head>
    <%
		List<ArrayList<Timetable>> list = (ArrayList<ArrayList<Timetable>>)request.getAttribute("list");
    	String [] times = {"第1-2节","第3-4节","第5-6节","第7-8节","第9-10节"};
		%>
    
 <script src="./lib/layui/layui.js" charset="utf-8"></script> 
<script src="./js/x-layui.js" charset="utf-8"></script> 
<script src="js/jquery2.js" charset="utf-8"></script> 
<script src="js/js.js" charset="utf-8"></script>
<script>

	function queren(i){
		var se=confirm("是否删除");
		if (se==true){
			window.location.href='TeacherDelete?id='+i;		
		}
	}

            layui.use(['laydate','element','laypage','layer'], function(){
                $ = layui.jquery;
              lement = layui.element();//面包导航
              laypage = layui.laypage;//分页
              layer = layui.layer;//弹出层

            });
             /*用户-添加*/
            function user_management_add(title,url,w,h){
                x_admin_show(title,url,w,h);
            }
   
            </script> 
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
    
    <script type="text/javascript">
    	function goback(){
    		history.back(-1);
    	}
    	function queren(i,j,k,l){
    		var se=confirm("是否删除");
    		if (se==true){
    			window.location.href='admin_TimeTableDelete?id='+i+'&weekes='+j+'&weekdays='+k+'&times='+l;		
    		}
    	}
    	
    </script>
    
	<style>
		tr{
			width:30px;
			height:40px;
		}
		td{
			text-align:center;
		}
		th{
			text-align:center;
		}
	</style>
    <body>

<div class="x-nav"> <span class="layui-breadcrumb"> <a><cite>首页</cite></a> <a><cite>课表管理</cite></a> </span> <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a> </div>
<div class="x-body">
  <form class="layui-form x-center" name="frm" action="admin_TimetableList" method="post" style="width:85%">
    <div class="layui-form-pane">
      <div class="layui-form-item">
        <label class="layui-form-label">教师号</label>
        <div class="layui-input-inline" style="width:100px">
          <input type="text" name="teacherid"  placeholder="编号" autocomplete="off" class="layui-input" value="${teacherId}">
        </div>
        <label class="layui-form-label">班级</label>
 		<div class="layui-input-inline" style="width:150px;border:1px;" >
           
           <c:set var="allclass" value="${allclass }" scope="application"></c:set>
		  <select style="display:block;" name="courseId" class="layui-input">
			<option value="">请选择</option>
			 <c:forEach items="${allclass}"	var="bean">		
				<option value="${bean.clazz}" <c:if test="${bean.clazz==courseId}">${"selected"}</c:if> >${bean.clazz}</option>
			</c:forEach>
			
		  </select>
        </div>  
        <label class="layui-form-label">周次</label>
 		<div class="layui-input-inline" style="width:150px;border:1px;">
           <c:set var="allcourse" value="${allcourse }" scope="application"></c:set>
		  <select style="display:block;" name="week" class="layui-input">
		  <c:set var="allweek" value="${allweek }" scope="application"></c:set>
			<option value="">请选择</option>
			 <c:forEach items="${allweek}"	var="bean">		
				<option value="${bean}" <c:if test="${bean==week}">${"selected"}</c:if> >第${bean}周</option>
			</c:forEach>
		  </select>
        </div>  
        <div class="layui-input-inline" style="width:80px">
          <button type="submit" class="layui-btn">搜索</button>
        </div>
      </div>
    </div>
    <input type="hidden" name="cur_page" value="">
  </form>
  
 <div class="tools">
    <ul class="toolbar">
      <li onclick="user_management_add('添加课表','admin_TimeTableAdd.jsp','600','500')"><span><img src="images/t01.png" /></span>添加</li>
      <li onclick="user_management_add('审核课表','admin_TimeTableCheck.jsp','600','500')"><span><img src="images/t02.png" /></span>修改</li>
      <li onclick="user_management_add('删除课表','admin_TimeTableDelete.jsp','600','500')"><span><img src="images/t03.png" /></span>删除</li></ul>
    <span class="x-right" style="line-height:25px">共有数据： 条</span></xblock>
 </div>
  <table border = "3px" bordercolor = "0x4C96FF" align = "center" class="tablelist">

		<tr class="">
			<th>星期</th>
			<th>星期一</th>
			<th>星期二</th>
			<th>星期三</th>
			<th>星期四</th>
			<th>星期五</th>
			<th>星期六</th>
			<th>星期天</th>
		</tr>	
		<%
			for(int i=1;i<=5;i++){
				%>
				<tr>
				<td><font size="3" ><%=times[i-1] %></font></td>
		<% 
				for(int j=1;j<=7;j++){
					int change = 0;
					for(int index=0;index<list.size();index++){
						if(list.get(index).get(0).getTimes()==i&&list.get(index).get(0).getWeekdays()==j){
							change++;
		%>
				<td>
				
				<%for(int k=0;k<list.get(index).size();k++) {%>
					<% if(k>0){ %>
						--------------<br>
					<%} %>
					<%=list.get(index).get(k).getCourseName()%><br>
					<%=list.get(index).get(k).getTeacherName() %><br>
					<%=list.get(index).get(k).getAddress() %><br>
					第<%=list.get(index).get(k).getWeeks() %>周<br>		
				<a onclick="user_management_add('修改课表','admin_TimeTableEdit?id=<%=list.get(index).get(k).getTeacherId()%>&weeks=<%=list.get(index).get(k).getWeeks()%>&weekdays=<%=j%>&times=<%=i%>&address=<%=list.get(index).get(k).getAddress()%>','600','500')"><span><font color="green">修改</font></span></a>
				<a onclick="queren(<%=list.get(index).get(k).getTeacherId()%>,<%=list.get(index).get(k).getWeeks()%>,<%=j%>,<%=i%>)"><span><font color="red">删除</font></span></a><br>
				<%} %>
				
				</td>
		<% 				
						}
					}
					if(change==0){
						%>
						<td></td>
				<% 
					}
				}%>
				</tr>
				<%
				
				
			}
		%>
</table>
</div>

</body>

</html>
