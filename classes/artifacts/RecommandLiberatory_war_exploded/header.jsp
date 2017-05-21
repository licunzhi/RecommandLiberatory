<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" type="text/css">
<script type="text/javascript" src="layui/layui.js"  charset="UTF-8"></script>
<link rel="stylesheet" href="jsandcss/header.css" type="text/css">
<script>
layui.use(['jquery', 'layer','element'], function(){
  var $ = layui.jquery ;//重点处
  var layer = layui.layer;
  
  $("#logouter").click(function(){
	  var flag = confirm("确认注销？");
	  if(flag){
		  window.location = "LoginAction_doLogout";
	  }
	  
  });
  
});

</script>
<title>top</title>
</head>
<body>
<!-- 头部的导航栏实现  -->

<ul class="layui-nav">
  <li class="layui-nav-item"><a href="LoginAction_doIndex">首页</a></li>
  <li class="layui-nav-item"><a href="BooksAction_toLimitPage">条件查找</a></li>
  <li class="layui-nav-item"><a href="LoginAction_toUserFavor">个性推荐</a></li>
  <li class="layui-nav-item"><a href="BooksAction_toViewHisPage">最近浏览</a></li>
  <li class="layui-nav-item"><a href="BooksAction_toFireBooksPage">大家都在看</a></li>
  <li class="layui-nav-item"><a href="BooksAction_toRandomBooksPage">随便看看</a></li>
  <li class="layui-nav-item"><a href="BugsAction_toCollectBugsPage">意见反馈</a></li>
  <li class="layui-nav-item"><a href="LoginAction_doLogin">用户登陆/注册</a></li>
  <li class="layui-nav-item layui-btn-normal"><a href="AdminAction_toAdminPage">管理员登陆</a></li>
</ul>

	<s:if test="#session['user'].username != null">
	<a class="layui-btn layui-btn-radius layui-btn-primary" id="logouter">
		欢迎登陆：<s:property value="#session['user'].username"/>&nbsp;&nbsp;&nbsp; 
	</a>
	</s:if>
</body>
</html>