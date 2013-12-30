<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/CookieHelp.js"></script>
</head>
<body>
	<div id="logo">
		<h1>邮政部门商品管理系统</h1>
		<h4>winter is coming</h4>
		<ul id="welcome">
			<li><a href="#">设置</a></li>
			<li><a href="javascript:login_out()">登出</a></li>
			<li>欢迎</li>
		</ul>
	</div>
</body>

<script type="text/javascript">
	function login_out()
	{
		setCookie("","","");
		window.location.href="MainLogin.jsp";
	}
</script>

</html>