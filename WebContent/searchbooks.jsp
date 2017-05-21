<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	window.onload = function(){
		//人性化显示特殊字体的颜色 
		 var xsxf = document.getElementsByTagName("a");
		 var str2 = "${bookslimit.lablevalue }";
		 //alert(str2);
		/*  var str3 = "字段2"; */
		 var reg=eval("/"+str2+"/gi");//全局匹配实现  不要求特定的字符串显示在一句话的最前面 
		 for(var i = 0;i < xsxf.length;i++){
		 xsxf[i].innerHTML =  xsxf[i].innerHTML.replace(reg,"<font color='#FF0000'>"+ str2 + "</font>");
		 }
		
		
		var la = document.getElementsByName("lable");
		la[0].setAttribute("checked","checked");
		
		for(var i = 0;i < la.length;i++){
			var lava = la[i].getAttribute("value");
			if(lava == "${bookslimit.lable }"){
				la[i].setAttribute("checked","checked");
			}
		}
	}
	function validate_required(field,alerttxt)
	{
	with (field)
	  {
	  if (value==null||value=="")
	    {alert("请输入相关查询信息！");return false}
	  else {return true}
	  }
	}

	function validate_form(thisform)
	{
	with (thisform)
	  {
	  if (validate_required(lablevalue,"输入相关查询信息!")==false)
	    {lablevalue.focus();return false}
	  }
	}
</script>
<title>限定条件查询书籍信息</title>
</head>
<body style="background-color: #e2e2e2">
	<jsp:include page="header.jsp"></jsp:include>
	<br><br>
	<center>
	<form action="BooksAction_getLimitBooks" method="post" onsubmit="return validate_form(this)">
		<input type="text" name="lablevalue" value="${bookslimit.lablevalue }">&nbsp;&nbsp;&nbsp;<input type="submit" value="查询">
		<input type="radio" name="lable" value="bookid" title="书刊号">书刊号
		<input type="radio" name="lable" value="bookname" title="书名">书名
		<input type="radio" name="lable" value="bookauthor" title="作者">作者
		<input type="radio" name="lable" value="bookkind" title="类别">类别
	</form>
	</center>
	
	
	<br><br>
		<center>
		<div align="left">
		<br><br>
			<c:if test="${empty bookslimit.books}">
				<div>
					<<img src="images/error.jpg" alt="错误页面显示" style="width: 1300px;">
				</div>
			</c:if>
			<c:forEach items="${bookslimit.books }" var="book">
 			<div style="float: left;width: 30%;heigth:300px;margin-left:40px">
					<img alt="${book.bookname }" src="bookimg/${book.bookid}.jpg" width="251" height="307">
					<br>
					<a href="BooksAction_viewBook?bookid=${book.bookid}&bookname=${book.bookname }" target="_blank">
						${book.bookname }-------作者：${book.bookauthor }
					</a>
					<br>
					<a href="BooksAction_viewBook?bookid=${book.bookid}&bookname=${book.bookname }">
						书刊号：${book.bookid }---类别：${book.bookkind }
					</a>
						
						<br><br><br><br><br><br>
			</div>
			</c:forEach>
		</div>
	</center>
</body>
</html>