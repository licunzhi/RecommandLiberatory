<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍信息展示</title>
<script type="text/javascript" src="jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		
		$("#pageNo").change(function(){
			var val = $(this).val();
			val = $.trim(val);
			
			//1. 校验 val 是否为数字 1, 2, 而不是 a12, b
			var flag = false;
			var reg = /^\d+$/g;
			var pageNo = 0;
			
			if(reg.test(val)){
				//2. 校验 val 在一个合法的范围内： 1-totalPageNumber
				pageNo = parseInt(val);
				if(pageNo >= 1 && pageNo <= parseInt("${bookspage.pageNo }")){
					flag = true;
				}
			}
			
			
			if(!flag){
				alert("输入的不是合法的页码.");
				$(this).val("");
				return;
			}
			
			//3. 页面跳转
			var href = "BooksAction_getIdentityPageBooks?currentPage=" + pageNo + "&bookkind=${bookspage.books[0].bookkind }";
			window.location.href = href;
		});
	})
	
</script>
</head>


<body style="background-color: #e2e2e2">
<a href="LoginAction_doIndex">返回主页</a>
<c:if test="${bookspage.pageNo == 0}">
	<div>
		<<img src="images/error.jpg" alt="错误页面显示" style="width: 1300px;">
	</div>
</c:if>
	<center>
		<div align="left">
		<br><br>
			<c:forEach items="${bookspage.books }" var="book">
 			<div style="float: left;width: 30%;heigth:300px;margin-left:40px">
				<a href="BooksAction_viewBook?bookid=${book.bookid}&bookname=${book.bookname }" target="_blank">
					<img alt="${book.bookname }" src="bookimg/${book.bookid}.jpg" width="251" height="307">
						<br>${book.bookname }---作者：${book.bookauthor }
						<br><br><br><br><br><br>
						</a>
			</div>
			</c:forEach>
		</div>
	</center>


	<br><br><br>
	<div style="position:fixed;bottom:0;">
		<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		共 ${bookspage.pageNo } 页
		&nbsp;&nbsp;
		当前第 ${bookspage.currentPage } 页		
		&nbsp;&nbsp;
		
		<c:if test="${bookspage.currentPage gt 1 }">
			<a href="BooksAction_getFirstPagesBooks?currentPage=1&bookkind=${bookspage.books[0].bookkind }">首页</a>
			&nbsp;&nbsp;
			<a href="BooksAction_getPrevPageBook?currentPage=${bookspage.currentPage }&bookkind=${bookspage.books[0].bookkind }">上一页</a>
		</c:if>

		&nbsp;&nbsp;
		
		<c:if test="${bookspage.currentPage  < bookspage.pageNo}">
			<a href="BooksAction_getNextPageBook?currentPage=${bookspage.currentPage }&bookkind=${bookspage.books[0].bookkind }">下一页</a>
			&nbsp;&nbsp;
			<a href="BooksAction_getLastPageBook?currentPage=${bookspage.pageNo }&bookkind=${bookspage.books[0].bookkind }">末页</a>
		</c:if>
		
		&nbsp;&nbsp;
		
		转到 <input type="text" size="1" id="pageNo"/> 页		
		</div>
</body>


</body>
</html>