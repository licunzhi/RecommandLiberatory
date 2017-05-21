<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" type="text/css">
<script type="text/javascript" src="layui/layui.js"  charset="UTF-8"></script>
<script type="text/javascript">
layui.use(['form', 'layedit', 'laydate'], function(){
	var form = layui.form();
	});
</script>
<title>管理员登陆界面</title>
</head>
<body>
    <!-- 引入顶部的导航栏的信息 -->
	<s:include value="header.jsp"></s:include>
	
	<!-- 模范form表单的实现 -->
	<br><br><br><br><br><br><br>
	
	<form action="AdminAction_doAdminLoginProcess" class="layui-form" method="post">
	<div style="width: 350px;margin: 0 auto;">
		<table class="layui-table">
		<!-- 设置表格相关的宽度的问题 -->
				<colgroup>
					<col width="50">
					<col width="150">
				</colgroup>
			<tr>
				<th>管理员ID</th>
				<td>
					<input value="3130703232" type="text" name="adminid" required  lay-verify="required" placeholder="管理员ID" autocomplete="off" class="layui-input">
				</td>
			</tr>
			<tr>
				<th>密码</th>
				<td>
					<input value="123" type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
				</td>
			</tr>
			</table>
		</div>
			<!-- 提交按钮的实现 -->
		<div class="layui-input-block" style="width: 350px;margin: 0 auto;">
			<button class="layui-btn layui-btn-normal layui-btn-radius" lay-submit lay-filter="formDemo">登      陆</button>
			<button type="reset" class="layui-btn layui-btn-primary layui-btn-radius">重  置</button>
		</div>
	</form>
	<div style="width: 350px;margin: 0 auto;">
			<font color="#FF5722" size="5px" >
			     <s:property value="#session.errormessageinf"/>
			</font>
		</div>

<div>
	<s:include value="bottom.jsp"></s:include>
</div>

</body>
</html>

