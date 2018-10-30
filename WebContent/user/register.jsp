<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="	Content-Type" content="text/html; charset=UTF-8">
<title>register.jsp</title>
<script type="text/javascript" src="../js/ajax.js"></script>

	<h1 align="center">注册页面</h1>

	<script type="text/javascript">
		/*
		如果一个表单项的name和<img>的id相同，可能会出问题
		*/
		function _change(){
			/*
			1.获取<img元素>
			*/
			var ele=document.getElementById("vCode");
			ele.src="<c:url value='/VertifyCodeServlet'/>?xxx="+new Date().getTime();
			}
	</script>
</head>
<body>
	<p style="color: red; font-weight: 900">${msg }</p>
	<%--${pageContext.request.contextPath }/RegisterServlet --%>
	<form action="<c:url value='/RegisterServlet'/>" method="post">
	
		用户名：<input id="usernameID" type="text" name="username" value="${user.username }" /><p style="color:red;display:inline">${errors.username }</p>	<span id="resID">
		<img src="" width="12px" height="12px"/>
	</span><br />
		密    码：<input type="password" name="password" value="${user.password }" /><p style="color:red;display:inline">${errors.password }</p><br />
	<select id="provinceID" style="width: 111px">
		<option>选择省份</option>
		<option>安徽</option>
		<option>上海</option>
	</select>
	&nbsp;&nbsp;&nbsp;
	<select id="cityID" style="width: 111px">
		<option>选择城市</option>
	</select><br/>
		验证码：<input type="text" name="verifyCode" value="${user.verifyCode}" size="3" maxlength="4" /> <p style="color:red;display:inline">${errors.verifyCode}</p><br/>
			<img id="vCode" src="<c:url value='/VertifyCodeServlet'/>" border="2" />
			 <a	href="javascript:_change()">看不清换一张</a><br /> 
			<input type="submit" value="注册" />
	</form>

	
	
	<script type="text/javascript">
		document.getElementById("usernameID").onblur=function(){
			var username = this.value;
			var ajax=createAJAX();
			//alert(ajax!=null);
			var method="POST";
			var url="${pageContext.request.contextPath}/UserServlet";

			ajax.open(method,url);
			//设置AJAX请求头为POST，他会将请求体中的汉字自动编码成UTF-8
			ajax.setRequestHeader("content-type", "application/x-www-form-urlencoded")
			var content="username="+username;
			ajax.send(content);

			ajax.onreadystatechange=function(){
				if(ajax.readyState==4){
					if(ajax.status==200){
						//从ajax获取服务端响应的数据
						var tip=ajax.responseText;

						//创建img标签
						var imgElement=document.createElement("img");
						//设置img标签的src、width、height的属性值
						imgElement.src=tip;
						imgElement.style.width="14px";
						imgElement.style.height="14px";
						//将img标签加入到p标签
						var spanElement=document.getElementById("resID");
						spanElement.innerHTML="";
						spanElement.appendChild(imgElement);
						}
					}
				}
			}


		//定位省份下拉框，同时添加内容改变事件
		document.getElementById("provinceID").onchange=function(){
				//清空城市下拉框的内容,除第一项以外
				var cityElement=document.getElementById("cityID");
				cityElement.options.length=1;

				//获取选中省份的名字
				var index=this.selectedIndex;
				//alert(index);
				var optionElement=this[index];
				var province=optionElement.innerHTML;
				//alert(province);
				if("选择省份"!=province){
					var ajax=createAJAX();
					//alert(ajax!=null);
					var method="POST";
					var url="${pageContext.request.contextPath}/ProvinceCityServlet";
					ajax.open(method,url);
					ajax.setRequestHeader("content-type", "application/x-www-form-urlencoded");
					var content="province="+province;
					ajax.send(content);

					ajax.onreadystatechange=function(){
						if(ajax.readyState==4){
							if(ajax.status==200){
								//从AJAX异步对象中获取服务器响应的xml文档
								var xmlDocument=ajax.responseXML;
								//alert(xmlDocument!=null?"得到了":"没获得到");
								var cityElementArray=xmlDocument.getElementsByTagName("city");
								//alert(cityElementArray!=null);
								var size=cityElementArray.length;
								//alert(size);
								for(var i=0;i<size;i++){
									//innerHTML只能用在html/jsp中
									var city=cityElementArray[i].firstChild.nodeValue;
									//alert(city);
									var optionElement=document.createElement("option");
									optionElement.innerHTML=city;
									cityElement.appendChild(optionElement);
									}
								}
							}
						}
				}
			}
	</script>
</body>
</html>