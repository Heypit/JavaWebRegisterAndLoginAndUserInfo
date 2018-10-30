<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Information界面</title>
<head>
<link href="../css/bootstrap.css" rel="stylesheet">
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/ajax.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="navbar-header">
		<a class=""  href="#"> <img
			alt="Brand" src="../images/jordan.jpg"
			style="height: 49px; width: 80px;">
		</a>
	</div>
	</nav>
	<div class="page-header">
		<h1>
			用户个人信息 <small>详细消息</small>
		</h1>
	</div>
	<div class="col-xs-6 col-md-3">
		<br /> <a href="#" class="thumbnail"> <img src="../images/头像.png">
		</a>
	</div>
	<div class="media">
		<div class="media-body">
			</br>
			</br>
			<h3 class="media-heading">ID：  ${sessionScope.sessionUser.id} </h3>
			<h3 class="media-heading">用户名：  ${sessionScope.sessionUser.username} </h3>
			<h3 class="media-heading">密码：  ${sessionScope.sessionUser.password}</h3>
			<h3 class="media-heading">省份：  ${sessionScope.sessionUser.province}</h3>
		</div>
	</div>
	<br />

	<nav aria-label="Page navigation" style="text-align: center">
	<ul class="pagination">

		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
		</a></li>
	</ul>
	</nav>
</body>
</html>