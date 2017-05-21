<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" type="text/css">
<script type="text/javascript" src="layui/layui.js" charset="UTF-8"></script>
<script>
layui.use(['jquery', 'layer','element'], function(){
  var element = layui.element(); //导航的hover效果、二级菜单等功能，需要依赖element模块
  
  var $ = layui.jquery ;//重点处
  var layer = layui.layer;
  
  $("#logouter").click(function(){
	  var flag = confirm("确认注销？");
	  if(flag){
		  window.location = "LoginAction_doLogoutAdmin";
	  }
	  
  });
});


</script>
<title>top</title>
</head>
<body>
<!-- 头部的导航栏实现  -->
<ul class="layui-nav">
  <li class="layui-nav-item"><a href="AdminAction_toAdminIndexPage">首页</a></li>
  <li class="layui-nav-item"><a href="LoginAction_toUserListPage">用户信息更改</a></li>
  <li class="layui-nav-item"><a href="BooksAction_toBooksListPage">书籍信息更改</a></li>
  <li class="layui-nav-item"><a href="BugsAction_toBugsListPage">异常处理</a></li>
  <li class="layui-nav-item"><a href="#">待续</a></li>
</ul>

	<s:if test="#session['admin'].adminname != null">
		<span class="layui-btn layui-btn-radius layui-btn-primary" style="" id="logouter">
			Welcome Administrator：<s:property value="#session['admin'].adminname" />&nbsp;&nbsp;&nbsp;
		</span>
	</s:if>

</body>
</html>