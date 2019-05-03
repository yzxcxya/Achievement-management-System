<%@ page contentType="text/html; charset=utf-8" language="java"  autoFlush="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="util.*, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no"> 
<link rel="stylesheet" href="./css/x-admin.css" media="all">
<link rel="stylesheet" href="css/pag.css" media="all">
</head>

<script type="text/javascript">
	function turnPage(i) {
		document.frm.cur_page.value = i;   // 跳转页面时，设置i为要跳转的页面，然后提交表单
		document.frm.submit();
	}
</script>

<body>
<div class="x-nav"> <span class="layui-breadcrumb"> <a><cite>首页</cite></a> <a><cite>学生成绩管理</cite></a> </span> <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a> </div>
<div class="x-body">
  <form class="layui-form x-center" name="frm" action="StudentGradeList" style="width:85%" method="post">
    <div class="layui-form-pane">
      <div class="layui-form-item">
        <label class="layui-form-label">学号</label>
        <div class="layui-input-inline" style="width:100px">
          <input type="text" name="studentId"  placeholder="学号" autocomplete="off" class="layui-input" value="${studentId }">
        </div>
        <label class="layui-form-label">课程</label>
        <div class="layui-input-inline" style="width:100px">
          <input type="text" name="courseId"  placeholder="班级" autocomplete="off" class="layui-input" value="${courseId}">
        </div>
        <label class="layui-form-label">创建时间</label>
        <div class="layui-input-inline" style="width:150px">
          <input type="text" name="createtime"  placeholder="创建时间" autocomplete="off" class="layui-input" value="${createTime }">
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
      <li><span><img src="images/t03.png" /></span>批量删除</li>
   	 <a href="ExcelGrade.jsp"> <li><span><img src="images/t07.png" /></span>导出excel</li></a>
    </ul>
    <span class="x-right" style="line-height:25px">共有数据：88 条</span></xblock>
  </div>
  <table class="tablelist">
    <thead>
      <tr>
        <th> <input onclick="selectAll()" type="checkbox"   name="controlAll" style="controlAll" id="controlAll">
        </th>
        <th>学号</th>
        <th>姓名</th>
        <th>课程</th>
        <th>成绩</th>
        <th>创建时间</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${list}"	var="bean">		
					<tr>
						<td><input type="checkbox" value="1" name="selected"></td>
						<td>${bean.studentId }</td>
						<td>${bean.studentName} </td>
						<td>${bean.courseId }  ${bean.courseName}</td>
						<td>${bean.grade}</td>
						<td>${bean.createtime}</td>
						<td> 
						<ul class="toolbar">
      					 <li onclick="user_management_edit('用户编辑','admin_gradeEdit?id=${bean.studentId }&courseId=${bean.courseId}','600','500')"><span><img src="images/t02.png" /></span>编辑</li>
      					 <li onclick="queren(${bean.studentId},${bean.courseId})"><span><img src="images/t03.png" /></span>删除</li>
    					</ul>
						</td>
					</tr>
			</c:forEach>
    </tbody>
  </table>
  <div class="page"  v-show="show">
  <label>共${pager.totalPage }页${pager.totalRecord }条数据 ，导航至：  </label>
  <div class="pagelist">   
		<c:forEach var="i" begin="1" end="${pager.totalPage }">
				<span class="jump" onclick="turnPage(${i})">${i }</span>
		</c:forEach>
</div>
</div>
</div>
<br />
<br />
<br />
<script src="./lib/layui/layui.js" charset="utf-8"></script> 
<script src="./js/x-layui.js" charset="utf-8"></script> 
<script src="js/jquery2.js" charset="utf-8"></script> 
<script src="js/js.js" charset="utf-8"></script>
<script>

	function queren(i,j){
		var se=confirm("是否删除");
		if (se==true){
			window.location.href='admin_gradeDelete?studentId='+i+'&courseId='+j;		
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
            /*用户-查看*/
            function user_management_show(title,url,w,h){
                x_admin_show(title,url,w,h);
            }
            // 用户-编辑
            function user_management_edit (title,url,w,h) {
                x_admin_show(title,url,w,h); 
            }
            </script> 
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>