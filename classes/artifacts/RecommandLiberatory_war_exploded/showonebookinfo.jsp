<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
layui.use(['form', 'layedit', 'laydate','upload'], function(){
	var form = layui.form();
	
	});
</script>
<title>书籍信息详细的展示界面</title>
</head>
<body style="background-color: #e2e2e2">
 <!-- 引入顶部的导航栏的信息 -->
	<br>

	<form action="BooksAction_toBooksListPage" class="layui-form" method="post">
		<div style="width: 350px; margin: 0 auto;">
			<table class="layui-table" lay-even="" lay-skin="nob">
				<!-- 设置表格相关的宽度的问题 -->
				<colgroup>
					<col width="100">
					<col width="150">
				</colgroup>
				<tr>
					<th>书刊号</th>
					<td><input type="text" name="bookid"
						required lay-verify="required" value="${showonebookinf.bookid }"
						autocomplete="off" class="layui-input layui-btn-disabled"></td>
				</tr>
				<tr>
					<th>书名</th>
					<td><input type="text" name="bookname" required
						lay-verify="required" value="${showonebookinf.bookname }" autocomplete="off"
						class="layui-input  layui-btn-disabled"></td>
				</tr>
				<tr>
					<th>作者</th>
					<td><input type="text" name="bookauthor"
						required lay-verify=required value="${showonebookinf.bookauthor }"
						autocomplete="off" class="layui-input  layui-btn-disabled"></td>
				</tr>
				<tr>
					<th>种类</th>
					<td><select name="bookkind" required="required" lay-verify="required" class="layui-btn-disabled">
							<option value="${showonebookinf.bookkind }">${showonebookinf.bookkind }</option>
					</select>
					</td>
				</tr>
				<tr>
					<th>隶属学院</th>
					<td>&nbsp;&nbsp;&nbsp;
								<c:if test="${showonebookinf.majorid=='31307' }">计算机与信息学院</c:if>
								<c:if test="${showonebookinf.majorid=='31308' }">数理学院</c:if>
								<c:if test="${showonebookinf.majorid=='31309' }">建筑学院</c:if>
								<c:if test="${showonebookinf.majorid=='31310' }">机械学院</c:if>
								<c:if test="${showonebookinf.majorid=='31311' }">纺织学院学院</c:if>
								<c:if test="${showonebookinf.majorid=='31312' }">艺术学院</c:if>
								<c:if test="${showonebookinf.majorid=='31313' }">体育学院</c:if>
								<c:if test="${showonebookinf.majorid=='31314' }">生化学院</c:if>
								<c:if test="${showonebookinf.majorid=='31300' }">---默认----</c:if>
					</td>
				</tr>
				<tr>
						<th>详细描述：</th>
						<td>
							<textarea name="booksinformation" class="layui-textarea layui-btn-disabled">${showonebookinf.booksinformation }</textarea>
						</td>
				</tr>
			<!-- 	<tr>
					<th>上传图片</th>
					<td>
						<div style="position: relative;width: 200px;">
							<img src="images/licunzhiandcaoguimei.jpg" width="200px;">
						<div style="position: absolute;left: 20px;top:60px;">
								<font color="red"><input type="file" name="file"></font>
						</div>
						</div>	
					</td>
				</tr> -->
			</table>
		</div>
		
		</form>
	
</body>
</html>