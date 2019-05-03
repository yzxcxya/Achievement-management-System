<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="util.*, bean.*, java.util.*" %>
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
<div class="x-nav"> <span class="layui-breadcrumb"> <a><cite>首页</cite></a> <a><cite>档案管理</cite></a> </span> <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a> </div>
<div class="x-body">
  <form class="layui-form x-center" name="frm" action="teacherList" method="get" style="width:85%">
    <div class="layui-form-pane">
      <div class="layui-form-item">
        <label class="layui-form-label">编号</label>
        <div class="layui-input-inline" style="width:100px">
          <input type="text" name="id"  placeholder="编号" autocomplete="off" class="layui-input" value="${teacher.teacherId}">
        </div>
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline" style="width:100px">
          <input type="text" name="name"  placeholder="姓名" autocomplete="off" class="layui-input" value="${teacher.teacherName}">
        </div>
        <label class="layui-form-label">所在学院</label>
 		<div class="layui-input-inline" style="width:150px;border:1px;">
         
         	<c:set var="acdemyLists" value="${acdemyList}" scope="application"></c:set>
        
          
		  <select style="display:block;" name="acdemyId" class="layui-input">
			<option value="">请选择</option>
				<c:forEach items="${acdemyLists}"	var="acde">		
						<option value="${acde.acdemyId}" <c:if test="${acde.acdemyId==teacher.acdemyId}">${"selected"}</c:if> >[${acde.acdemyId}] ${acde.acdemyName}</option>
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
      <li><span><img src="images/t03.png" /></span>批量删除</li>
      <li onclick="user_management_add('添加用户','teacherAdd.jsp','600','500')"><span><img src="images/t01.png" /></span>添加</li>
      </ul>
    <span class="x-right" style="line-height:25px">共有数据：88 条</span></xblock>
  </div>
  <table class="tablelist">
    <thead>
      <tr>
        <th> <input onclick="selectAll()" type="checkbox"   name="controlAll" style="controlAll" id="controlAll">
        </th>
        <th>教师编号</th>
        <th>教师姓名</th>
        <th>头像</th>
        <th>电话</th>
        <th>性别</th>
        <th>学院</th>
        <th>地址</th>
        <th>其他</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${list}"	var="bean">		
					<tr>
						<td><input type="checkbox" value="1" name="selected"></td>
						<td>${bean.teacherId }</td>
						<td>${bean.teacherName}</td>							
						<td><a href="image.jsp?id=${bean.teacherId }&img=${bean.image }"><img src=  <c:choose> <c:when test="${bean.image==null}">"images\TX.jpg"</c:when> <c:otherwise>'image/${bean.image }'</c:otherwise></c:choose> style="width:40px;;heigth:40px;"></a></td>
						<td>${bean.tel}</td>
						<td>${bean.sex}</td>
						<td>${bean.acdemyName}</td>
						<td>${bean.address}</td>
						<td>
						<ul class="toolbar">
      					 <li onclick="user_management_edit('用户编辑','admin_teacherEdit?id=${bean.teacherId }','600','500')"><span><img src="images/t02.png" /></span>编辑</li>
      					 <li onclick="queren(${bean.teacherId })"><span><img src="images/t03.png" /></span>删除</li>
    					</ul></td>
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