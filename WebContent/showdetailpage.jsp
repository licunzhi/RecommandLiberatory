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
	  
	});
 </script>
<title>意见反馈界面</title>
</head>
<body>

<!-- 引入顶部的导航栏的信息 -->
	<s:include value="adminheader.jsp"></s:include>
	
	<br><br><br>
	<form class="layui-form" action="BugsAction_toDeleteBugs?id=${bug.id }" method="post">
		<div class="layui-form-item" style="width: 500px;">
			<label class="layui-form-label">标题：</label>
			<div class="layui-input-block">
				<input type="text" name="title" value="${bug.title }" class="layui-input layui-btn-disabled">
			</div>
		</div>
		<div class="layui-form-item layui-form-text" style="width: 500px;">
				<label class="layui-form-label">问题描述：</label>
				<div class="layui-input-block">
					<textarea required lay-verify="required" name="detial"class="layui-textarea layui-btn-disabled"> ${bug.detial }</textarea>
				</div>
		</div>
		<div class="layui-form-item" style="width: 500px;">
			<label class="layui-form-label">提交者：</label>
			<div class="layui-input-block">
				<input type="text" name="title" value="${bug.studentid }" class="layui-input  layui-btn-disabled">
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="">已经解决</button>
				<a class="layui-btn" href="BugsAction_toBugsListPage">未解决</a>
			</div>
		</div>

	</form>
	

</body>
</html>