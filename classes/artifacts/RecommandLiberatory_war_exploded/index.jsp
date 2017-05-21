<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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

<title>首     页 </title>
</head>
<body  style="background-color: #e2e2e2">
	<!-- 引入顶部的导航栏的信息 -->
	<s:include value="header.jsp"></s:include>

	<!-- 显示主界面的标题 -->
	<br>
	<div align="center">
		<h1><font color="#FF5722" size="10px">AHPU个性图书推荐系统</font></h1>
	</div>
	
 <div class="container">
			<section>
				<ul id="da-thumbs" class="da-thumbs">
					<li>
						<a href="BooksAction_getFirstPagesBooks?bookkind=计算机科学与技术">
							<img src="images/1.jpg" />
							<div><span>计算机科学与技术</span></div>
						</a>
					</li>
					<li>
						<a href="BooksAction_getFirstPagesBooks?bookkind=数理金融">
							<img src="images/2.jpg" />
							<div><span>数 理  金 融</span></div>
						</a>
					</li>
					<li>
						<a href="BooksAction_getFirstPagesBooks?bookkind=建筑工程工业技术">
							<img src="images/3.jpg" />
							<div><span>建 筑 工 程 工 业 技 术</span></div>
						</a>
					</li>
					<li>
						<a href="BooksAction_getFirstPagesBooks?bookkind=摄影影视美术音乐">
							<img src="images/4.jpg" />
							<div><span>摄 影 影 视  美 术 音 乐</span></div>
						</a>
					</li>
					<li>	
						<a href="BooksAction_getFirstPagesBooks?bookkind=书法篆刻">
							<img src="images/5.jpg" />
							<div><span>书 法 篆 刻 </span></div>
						</a>
					</li>
					<li>
						<a href="BooksAction_getFirstPagesBooks?bookkind=历史地理">
							<img src="images/6.jpg" />
							<div><span>历 史 地 理 </span></div>
						</a>
					</li>
					<li>
						<a href="BooksAction_getFirstPagesBooks?bookkind=法律">
							<img src="images/7.jpg" />
							<div><span>法 律</span></div>
						</a>
					</li>
					<li>
						<a href="BooksAction_getFirstPagesBooks?bookkind=中国文学">
							<img src="images/8.jpg" />
							<div><span>中 国 文 学</span></div>
						</a>
					</li>
					<li>
						<a href="BooksAction_getFirstPagesBooks?bookkind=小说青春">
							<img src="images/9.jpg" />
							<div><span>小 说  青 春</span></div>
						</a>
					</li>
					<li>
						<a href="BooksAction_getFirstPagesBooks?bookkind=动漫搞笑">
							<img src="images/10.jpg" />
							<div><span>动 漫  搞 笑</span></div>
						</a>
					</li>
					<li>
						<a href="BooksAction_getFirstPagesBooks?bookkind=旅游纪录">
							<img src="images/11.jpg" />
							<div><span>旅 游  纪 录</span></div>
						</a>
					</li>
					<li>
						<a href="BooksAction_getFirstPagesBooks?bookkind=心理健康">
							<img src="images/12.jpg" />
							<div><span>心 理 健 康</span></div>
						</a>
					</li>
				</ul>
			</section>
        </div>

	<div align="center" class="layui-footer footer footer-doc" style="background-color: #99CC99;">
	<br><br>
		<div class="layui-main">
			<p>2017 &copy; 安徽工程大学--曹贵梅(侵权必究)</p>
			<br><br>
			<p>
				<a>作者</a>&nbsp;&nbsp;&nbsp; <a>合作联系</a>&nbsp;&nbsp;&nbsp; <a>QQ联系</a>&nbsp;&nbsp;&nbsp; <a>微信公众号</a>
			</p>
			
			<br><br>
		</div>
	</div>
</body>
</html>