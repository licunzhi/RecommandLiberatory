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

<title>随便看看的图书界面</title>
</head>
<body  style="background-color: #e2e2e2">
	<!-- 引入顶部的导航栏的信息 -->
	<s:include value="header.jsp"></s:include>

	
		<div align="left">
		<br><br>
			<c:forEach items="${randomlist }" var="book">
 			<div style="float: left;width: 30%;heigth:300px;margin-left:40px">
				<a href="BooksAction_viewBook?bookid=${book.bookid}&bookname=${book.bookname }" target="_blank">
					<img alt="${book.bookname }" src="bookimg/${book.bookid}.jpg" width="251" height="307">
						<br>${book.bookname }---作者：${book.bookauthor }
						<br><br><br><br><br><br>
						</a>
			</div>
			</c:forEach>
		</div>

</body>
</html>