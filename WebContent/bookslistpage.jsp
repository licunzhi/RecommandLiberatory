<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="text/javascript" src="jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
window.onload = function(){
	
	var la = document.getElementsByName("lable");
	la[0].setAttribute("checked","checked");
	
	for(var i = 0;i < la.length;i++){
		var lava = la[i].getAttribute("value");
		if(lava == "${lable }"){
			la[i].setAttribute("checked","checked");
		}
	}
	
}
</script>
<style type="text/css">
.ts {
	width: 500px; background-color : rgb( 81, 130, 187);
	color: #fff;
	border-bottom-width: 0;
	background-color: rgb(81, 130, 187);
}

/* Column Style */
td {
	color: #000;
}
/* Heading and Column Style */
tr, th {
	border-width: 1px;
	border-style: solid;
	border-color: rgb(81, 130, 187);
}

/* Padding and font style */
td, th {
	padding: 5px 10px;
	font-size: 12px;
	font-family: Verdana;
	font-weight: bold;
}
</style>
<title>用户信息列表</title>
</head>
<body>
  <!-- 引入顶部的导航栏的信息 -->
	<s:include value="adminheader.jsp"></s:include>
	<br>
	<center>
	<form action="BooksAction_getLimitBooksm" method="post">
		<input type="text" name="lablevalue" value="${lablevalue }">&nbsp;&nbsp;&nbsp;<input type="submit" value="查询">
		<input type="radio" name="lable" value="bookid" title="书刊号">书刊号
		<input type="radio" name="lable" value="bookname" title="书名">书名
		<input type="radio" name="lable" value="bookauthor" title="作者">作者
		<input type="radio" name="lable" value="bookkind" title="类别">类别 
		<a href="BooksAction_toAddBook" style="float: right;" class="layui-btn layui-btn-danger">添加书籍</a>
		</form>
	</center>
	<br>
		<table>
			<tr>
				<td class="ts"><font size="5px">书名</font></td>
				<td class="ts"><font size="5px">期刊号</font></td>
				<td class="ts"><font size="5px">操作</font></td>
			</tr>
			<c:forEach items="${allbooks }" var="aweb">
 			<tr>
 				<td>
				<font size="4px">${aweb.bookname }</font>
				</td>
				<td>
					${aweb.bookid }
				</td>
				<td>
					<a href="BooksAction_toDetialBooks?id=${aweb.id }">
					<font size="4px" color="red">查看详情</font>
					</a>||
					<a href="BooksAction_toDeleteBookbyid?id=${aweb.id }">
					<font size="4px" color="red">删除书籍</font>
					</a>
				</td>
			</tr>
			</c:forEach>
		</table>

</body>
</html>