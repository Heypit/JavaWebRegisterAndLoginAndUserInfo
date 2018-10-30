<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>分页查询页面</title>
<head>
<link href="css/bootstrap.css" rel="stylesheet">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<body>
	<h1 align="center">
		<font size="5">分页查询</font>
	</h1>
	<br />

	<table id="table" class="table table-striped" width="100%">
		<thead>
			<tr>
				<th>ID</th>
				<th>名称</th>
				<th>密码</th>
				<th>省份</th>
			</tr>
		</thead>
		<!--  	<c:if test="${empty page.users }">
			<tr>
				<td colspan="8" align="center">没有商品</td>
			</tr>
		</c:if>
		-->
		<tbody>

			<c:forEach items="${page.users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.province}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<br />
	<div align="center">
		<c:if test="${page.currentPage>1 }">
			<a
				href="${pageContext.request.contextPath }/home?page=${page.currentPage-1}">上一页</a>
		</c:if>
		<a href="${pageContext.request.contextPath }/home?page=${1}">首页</a>
		<c:forEach begin="1" end="${page.totalPage }" step="1" var="i">
			<c:if test="${page.currentPage==i }">
				<a href="${pageContext.request.contextPath }/home?page=${i}"><font
					color="#ff0000">${i}</font></a>
			</c:if>
			<c:if test="${page.currentPage!=i }">
				<a href="${pageContext.request.contextPath }/home?page=${i}">${i}</a>
			</c:if>
		</c:forEach>
		<a
			href="${pageContext.request.contextPath }/home?page=${page.totalPage}">末页</a>
		<c:if test="${page.currentPage< page.totalPage }">
			<a
				href="${pageContext.request.contextPath }/home?page=${page.currentPage+1}">下一页</a>
		</c:if>
	</div>


</body>
</html>
