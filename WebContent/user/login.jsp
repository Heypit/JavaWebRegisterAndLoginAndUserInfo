<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login.jsp</title>
</head>
<body>
	<h1 align="center">登录页面</h1>
	<p style="color: red; font-weight: 900">${msg }</p>
	<%--${pageContext.request.contextPath }/RegisterServlet --%>
	<form action="<c:url value='/LoginServlet'/>" method="post">
		用户名：<input type="text" name="username" value="${user.username }" />${errors.username }<br />
		密 码：<input type="password" name="password" value="${user.password }" />${errors.password }<br />
		<input type="submit" value="登录" />
	</form>
</body>
</html>