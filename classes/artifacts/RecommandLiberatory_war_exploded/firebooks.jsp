<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" type="text/css">
<script type="text/javascript" src="layui/layui.js"  charset="UTF-8"></script>
<script type="text/javascript" src="jquery/jquery-1.7.2.min.js"></script>
        <link rel="stylesheet" type="text/css" href="jsandcss/lrtk.css" />
        <link rel="stylesheet" type="text/css" href="jsandcss/style.css" />
<script type="text/javascript" src="jsandcss/jquery.hoverdir.js"></script>
<script type="text/javascript" src="jsandcss/modernizr.custom.97074.js"></script>
<script type="text/javascript">
			$(function() {
			
				$(' #da-thumbs > li ').each( function() { $(this).hoverdir({
					hoverDelay : 50,
					inverse : true
				}); } );

			});
		</script>

<style type="text/css">
.ts {
	width: 500px;
	background-color : rgb( 81, 130, 187);
	color: #fff;
	margin-left: 0px;
	margin-bottom: 0px;
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
	font-family: Verdana;
	font-weight: bold;
}
</style>

<title>浏览历史界面</title>
</head>
<body>
	<!-- 引入顶部的导航栏的信息 -->
	<s:include value="header.jsp"></s:include>
	<s:if test="#session['user'].username != null">
	<span class="layui-btn layui-btn-radius layui-btn-primary" style="">
		欢迎登陆：<s:property value="#session['user'].username"/>&nbsp;&nbsp;&nbsp; 
	</span>
	</s:if>
		<table>
			<tr>
				<td class="ts"><font size="5px" >书籍信息</font></td>
				<td class="ts"><font size="5px">人气值</font></td>
			</tr>
			<c:forEach items="${booksview }" var="book">
 			<tr>
 				<td>
				<a href="BooksAction_viewBook?bookid=${book.bookid}&bookname=${book.bookname }" target="_blank">
				<font size="4px">${book.bookname }</font>
				</a>
				</td>
				<td>
					${book.viewtimes }
				</td>
			</tr>
			</c:forEach>
		</table>

</body>
</html>