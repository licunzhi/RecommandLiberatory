<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" type="text/css">
<script type="text/javascript" src="layui/layui.js"  charset="UTF-8"></script>
<script type="text/javascript" src="jquery/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
layui.use(['form','layer'], function(){
	var form = layui.form();
	});
	
	$(function(){
		$("#sub").click(function(){
			var flag = confirm("确定要修改${userinfo.studentid}的信息？")
			if(!flag){
			return false;
			}
		});
	});
</script>
<title>用户信息修改界面</title>
</head>
<body>
  <!-- 引入顶部的导航栏的信息 -->
	<s:include value="adminheader.jsp"></s:include>
	
	<!-- 模范form表单的实现 -->
	<br><br><br><br>
	<!-- 跳转到指定的登陆的界面的先关的处理方法中 -->
	<form action="LoginAction_doModify" class="layui-form" method="post">
	<div style="width: 350px;margin: 0 auto;">
		<table class="layui-table" lay-even="" lay-skin="nob" >
		<!-- 设置表格相关的宽度的问题 -->
				<colgroup>
					<col width="50">
					<col width="150">
				</colgroup>
			<tr>
				<th>学号</th>
				<td><input value="${userinfo.studentid }" type="text" name="studentid" required  lay-verify="required" placeholder="请输入学号(只能数字)" autocomplete="off" class="layui-input layui-btn layui-btn-disabled"></td>
			</tr>
			<tr>
				<th>姓名</th>
				<td><input  value="${userinfo.username }" type="text" name="username" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input"></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input  value="${userinfo.password }" type="password" name="password" required lay-verify= required placeholder="请输入密码" autocomplete="off" class="layui-input"></td>
			</tr>
			<tr>
				<th>邮箱</th>
				<td><input value="${userinfo.email }" type="text" name="email" lay-verify="email" autocomplete="off" class="layui-input layui-btn layui-btn-disabled" placeholder="注意邮箱格式"></td>
			</tr>
			<tr>
				<th>专业</th>
				<td>
				<select name="major" required="required">
					<option value="${userinfo.major }">${userinfo.major }</option>
					<option value="信息管理与信息系统">信息管理与信息系统</option>
					<option value="物联网工程专业">物联网工程专业</option>
					<option value="软件工程专业">软件工程专业</option>
					<option value="计算机科学与技术">计算机科学与技术</option>
					<option value="其他专业">其他专业</option>
				</select>
				<!-- <input  value="信管" type="text" name="major" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input"> -->
				</td>
			</tr>
			 <tr>
				 	<th>性别</th>
	      			<td>
	      				<select name="sex" required="required">
	      					<option value="${userinfo.sex }">${userinfo.sex }</option>
							<option value="man">man</option>
							<option value="woman">woman</option>
						</select>
	      			</td>	
    		</tr>
		</table>
		</div>
		<input name="interest" value="${userinfo.interest }" type="hidden"/>
		<input name="id" value="${userinfo.id }" type="hidden"/>
			<!-- 提交按钮的实现 -->
		<div class="layui-input-block" style="width: 350px;margin: 0 auto;">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button id="sub" class="layui-btn layui-btn-normal layui-btn-radius" lay-submit lay-filter="formDemo">确定修改</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="reset" class="layui-btn layui-btn-primary layui-btn-radius">重  置</button>
			<button type="reset" class="layui-btn layui-btn-danger layui-btn-radius" id="delete" onclick="window.location='LoginAction_deleteuserinfo?studentid=${userinfo.studentid}'">删除</button>
		</div>
	</form>
	<div style="width: 350px;margin: 0 auto;">
			<font color="#FF5722" size="5px" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${session.errormessage }</font>
		</div>
</body>
</html>