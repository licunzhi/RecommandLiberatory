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
<script type="text/javascript">
	layui.use([ 'form', 'layedit', 'laydate', 'element' ], function() {
		var form = layui.form();
		
		var element = layui.element();

		//监听导航点击
		element.on('nav(demo)', function(elem) {
			//console.log(elem)
			layer.msg(elem.text());
		});
	});
</script>

<title>管理员权限界面</title>
</head>
<body>

	<!-- 显示主界面的标题 -->
	<br>
	<!-- 引入侧边的导航栏的信息 -->
	<s:include value="adminheader.jsp"></s:include>
	
	
		<div align="center">
			<h1><font style="color:#FF5722" size="10px">欢迎访问AHPU图书推荐系统管理员界面</font></h1>
		</div>
</body>
</html>