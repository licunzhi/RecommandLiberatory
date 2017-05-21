<%@ page language="java" contentType="text/html; charset=UTF-8"%>
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
layui.use(['form', 'layedit', 'laydate','upload'], function(){
	var form = layui.form();
	});
</script>
</head>
<body style="background-color: #e2e2e2">
<!-- 引入顶部的导航栏的信息 -->
	<s:include value="adminheader.jsp"></s:include>
	<br>
	<form action="BooksAction_doAddBook" class="layui-form" method="post">
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
						required lay-verify="required" placeholder="请输入书刊号(只能数字)"
						autocomplete="off" class="layui-input"></td>
				</tr>
				<tr>
					<th>书名</th>
					<td><input type="text" name="bookname" required
						lay-verify="required" placeholder="请输入书名" autocomplete="off"
						class="layui-input"></td>
				</tr>
				<tr>
					<th>作者</th>
					<td><input type="text" name="bookauthor"
						required lay-verify=required placeholder="请输入作者"
						autocomplete="off" class="layui-input"></td>
				</tr>
				<tr>
					<th>种类</th>
					<td><select name="bookkind" required="required" lay-verify="required">
							<option value="" selected="selected">---请选择---</option>
							<option value="计算机科学与技术">计算机科学与技术</option>
							<option value="数理金融">数理金融</option>
							<option value="建筑工程工业技术">建筑工程工业技术</option>
							<option value="摄影影视美术音乐">摄影影视美术音乐</option>
							<option value="书法篆刻">书法篆刻</option>
							<option value="历史地理">历史地理</option>
							<option value="法律">法律</option>
							<option value="中国文学">中国文学</option>
							<option value="小说青春">小说青春</option>
							<option value="动漫搞笑">动漫搞笑</option>
							<option value="旅游纪录">旅游纪录</option>
							<option value="心理健康">心理健康</option>
					</select>
					</td>
				</tr>
				<tr>
					<th>隶属学院</th>
					<!-- 重返显示的原因  是因为具体实现值不匹配的原意取消了回显 -->
					<td><select name="majorid" required="required" lay-verify="required">
							<option value="" selected="selected">---请选择---</option>
							<option value="31307">计算机与信息学院</option>
							<option value="31308">数理学院</option>
							<option value="31309">建筑学院</option>
							<option value="31310">机械学院</option>
							<option value="31311">纺织学院</option>
							<option value="31312">艺术学院</option>
							<option value="31313">体育学院</option>
							<option value="31314">生化学院</option>
							<option value="31300">--没有请选择默认--</option>
					</select> 
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
		
		<!-- 提交按钮的实现 -->
		<div class="layui-input-block" style="width: 350px; margin: 0 auto;">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="layui-btn layui-btn-normal layui-btn-radius"
				lay-submit lay-filter="formDemo">确认添加</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="reset"
				class="layui-btn layui-btn-primary layui-btn-radius">重 置</button>
		</div>
		</form>
		<div style="width: 350px;margin: 0 auto;">
			<font color="#FF5722" size="5px" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${session.errorbookid }</font>
		</div>
</body>
</html>