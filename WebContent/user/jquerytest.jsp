<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>菜鸟教程(runoob.com)</title>
<script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js">
	
</script>
<script>
	$(document).ready(function() {
		$("button").click(function() {
			$("div").text($("form").serialize());
		});
	});
</script>
</head>
<body>

	<form action="">
		第一个名称: <input type="text" name="FirstName" value="Mickey" /><br>
		最后一个名称: <input type="text" name="LastName" value="Mouse" /><br>
	</form>
	<button>序列化表单值</button>
	<div></div>

</body>
</html>