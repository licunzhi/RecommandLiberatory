<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" type="text/css">
<script type="text/javascript" src="layui/layui.js"  charset="UTF-8"></script>
<script type="text/javascript" src="jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
layui.use(['form', 'layedit', 'laydate'], function(){
	var form = layui.form();
	});
 </script>
<title>意见反馈界面</title>
</head>
<body>

<!-- 引入顶部的导航栏的信息 -->
	<s:include value="header.jsp"></s:include>
	
	<br><br><br>
	<form class="layui-form" action="BugsAction_toCommit">
		<div class="layui-form-item" style="width: 500px;">
			<label class="layui-form-label">输入标题：</label>
			<div class="layui-input-block">
				<input type="text" name="title" required lay-verify="required"
					placeholder="请输入标题" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item layui-form-text" style="width: 500px;">
				<label class="layui-form-label">问题描述：</label>
				<div class="layui-input-block">
					<textarea required lay-verify="required" name="detial" placeholder="请输入内容" class="layui-textarea"></textarea>
				</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">匿名</label>
			<div class="layui-input-block">
				<input type="checkbox" name="studentid" lay-skin="switch" title="开关">
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>

	</form>
	

</body>
</html>