<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" type="text/css">
<script type="text/javascript" src="layui/layui.js"  charset="UTF-8"></script>
<script type="text/javascript" src="jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	/* see if anything is previously checked and reflect that in the view*/
	$(".checklist input:checked").parent().addClass("selected");
	
	/* handle the user selections */
	$(".checklist .checkbox-select").click(
		function(event) {
			event.preventDefault();
			$(this).parent().addClass("selected");
			$(this).parent().find(":checkbox").attr("checked","checked");
			
		}
	);
	
	$(".checklist .checkbox-deselect").click(
		function(event) {
			event.preventDefault();
			$(this).parent().removeClass("selected");
			$(this).parent().find(":checkbox").removeAttr("checked");
			
			
		}
	);
	//全选 
	$("#selectall").click(
			function(){
			$("li").addClass("selected");
			$("li").find(":checkbox").attr("checked","checked");
			}
	);
	//全不选 
	$("#removeall").click(
		function(){
			$("li").removeClass("selected");	
			$("li").find(":checkbox").removeAttr("checked");
		}		
	);
	/* 页面加载的提示信息  */
	var str = "${session.choosemessage }";
	if(str != ""){
		alert(str);
	}
	
});
	
	
$(function() {

	$(' #da-thumbs > li ').each( function() { $(this).hoverdir({
		hoverDelay : 50,
		inverse : true
	}); } );

});
</script>
<style type="text/css">

body {
	font: 12px/1.3 "Lucida Grande","Lucida","Arial",Sans-serif;
}

form {
	margin: 0 0 30px 0;
}

legend {
	font-size: 17px;
}

fieldset {
	border: 0;
}

.checklist {
	list-style: none;
	margin: 0;
	padding: 0;
}

.checklist li {
	float: left;
	margin-right: 10px;
	background: url(images/checkboxbg.gif) no-repeat 0 0;
	width: 105px;
	height: 150px;
	position: relative;
	font: normal 11px/1.3 "Lucida Grande","Lucida","Arial",Sans-serif;
}

.checklist li.selected {
	background-position: -105px 0;
}

.checklist li.selected .checkbox-select {
	display: none;
}

.checkbox-select {
	display: block;
	float: left;
	position: absolute;
	top: 118px;
	left: 10px;
	width: 85px;
	height: 23px;
	background: url(images/select.gif) no-repeat 0 0;
	text-indent: -9999px;
}

.checklist li input {
	display: none;	
}

a.checkbox-deselect {
	display: none;
	color: white;
	font-weight: bold;
	text-decoration: none;
	position: absolute;
	top: 120px;
	right: 10px;
}

.checklist li.selected a.checkbox-deselect {
	display: block;
}

.checklist li label {
	display: block;
	text-align: center;
	padding: 8px;
}

.sendit {
	display: block;
	float: left;
	top: 118px;
	left: 10px;
	width: 115px;
	height: 34px;
	border: 0;
	cursor: pointer;
	background-color: #228B22;
	/* text-indent: -9999px; */
	margin: 20px 0;
}

</style>

<title>Insert title here</title>
</head>
<body>


	<!-- 引入顶部的导航栏的信息 -->
	<s:include value="header.jsp"></s:include>


	<form action="LoginAction_addInterests" method="post">
		<fieldset>
			<legend>选择你中意的个性标签：</legend>
			<ul class="checklist">
				<li>
					<input name="interest" value="计算机科学与技术" type="checkbox" id="choice_a"/>
					<label for="choice_a">计算机科学与技术</label>
					<a class="checkbox-select" href="#">Select</a>
					<a class="checkbox-deselect" href="#">Cancel</a>
				</li>
				<li>
					<input name="interest" value="数理金融" type="checkbox" id="choice_a"/>
					<label for="choice_a">数理金融</label>
					<a class="checkbox-select" href="#">Select</a>
					<a class="checkbox-deselect" href="#">Cancel</a>
				</li>
				<li>
					<input name="interest" value="建筑工程工业技术" type="checkbox" id="choice_a"/>
					<label for="choice_a">建筑工程工业技术</label>
					<a class="checkbox-select" href="#">Select</a>
					<a class="checkbox-deselect" href="#">Cancel</a>
				</li>
				<li>
					<input name="interest" value="摄影影视美术音乐" type="checkbox" id="choice_a"/>
					<label for="choice_a">摄影影视美术音乐</label>
					<a class="checkbox-select" href="#">Select</a>
					<a class="checkbox-deselect" href="#">Cancel</a>
				</li>
				<li>
					<input name="interest" value="书法篆刻" type="checkbox" id="choice_a"/>
					<label for="choice_a">书法篆刻</label>
					<a class="checkbox-select" href="#">Select</a>
					<a class="checkbox-deselect" href="#">Cancel</a>
				</li>
				<li>
					<input name="interest" value="历史地理" type="checkbox" id="choice_a"/>
					<label for="choice_a">历史地理</label>
					<a class="checkbox-select" href="#">Select</a>
					<a class="checkbox-deselect" href="#">Cancel</a>
				</li>
				<li>
					<input name="interest" value="法律" type="checkbox" id="choice_a"/>
					<label for="choice_a">法律</label>
					<a class="checkbox-select" href="#">Select</a>
					<a class="checkbox-deselect" href="#">Cancel</a>
				</li>
				<li>
					<input name="interest" value="中国文学" type="checkbox" id="choice_a"/>
					<label for="choice_a">中国文学</label>
					<a class="checkbox-select" href="#">Select</a>
					<a class="checkbox-deselect" href="#">Cancel</a>
				</li>
				<li>
					<input name="interest" value="小说青春" type="checkbox" id="choice_a"/>
					<label for="choice_a">小说青春</label>
					<a class="checkbox-select" href="#">Select</a>
					<a class="checkbox-deselect" href="#">Cancel</a>
				</li>
				<li>
					<input name="interest" value="动漫搞笑" type="checkbox" id="choice_a"/>
					<label for="choice_a">动漫搞笑</label>
					<a class="checkbox-select" href="#">Select</a>
					<a class="checkbox-deselect" href="#">Cancel</a>
				</li>
				<li>
					<input name="interest" value="旅游纪录" type="checkbox" id="choice_a"/>
					<label for="choice_a">旅游纪录</label>
					<a class="checkbox-select" href="#">Select</a>
					<a class="checkbox-deselect" href="#">Cancel</a>
				</li>
				<li>
					<input name="interest" value="心理健康" type="checkbox" id="choice_a"/>
					<label for="choice_a">心理健康</label>
					<a class="checkbox-select" href="#">Select</a>
					<a class="checkbox-deselect" href="#">Cancel</a>
				</li>
				
			</ul>
			<div style="clear: both;"></div>
			<button class="sendit" type="button" id="selectall" title="全选">全选</button>
			&nbsp;&nbsp;&nbsp;
			<button class="sendit" type="button" id="removeall" title="全部取消">全部取消</button>
			&nbsp;&nbsp;&nbsp;
			<button class="sendit" type="submit" title="提交表单">确定</button>
		</fieldset>
	</form>


</body>
</html>