<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/CookieHelp.js"></script>

<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/login.css" />

<title>登录</title>
</head>

<body onload="checkCookie()">
	<div id="head">
		<jsp:include page="headForLogin.jsp" />
	</div>
	
	<div id="login_form">
		<form id="my_login" action="login_User" method="post">
			<label class="label1" for="username"> 
			<span> 用户名:</span> 
			<input id="username" type="text" value="Administrator" name="username"></input>
			</label> 
			
			<label class="label2" for="password"> 
			<span>密码: </span> 
			<input id="password" type="password" value="password" name="password"></input>
			</label>
			
			<div class="button">
				<button class="btn_login" type="submit">登&nbsp;&nbsp;&nbsp;陆</button>
			</div>		
		</form>
	</div>
	
	 <script type="text/javascript">
		/* 提交结果，执行ajax */
		function btn_login() {

			var $btn = $("button.btn_login");
			$btn.bind("click", function() {
 				 
 				$('#my_login').ajaxSubmit(function (data) {
 					var d = eval("(" + data + ")");
 					
 					if(d["result"])
 					{
 						window.location.href="MainWarehousingEntry.jsp";
 						setCookie($("input[name=username]").val(),$("input[name=password]").val(),60);
 					}
 					else
 						alert("信息输入有误");
 				});

 				return false;
			});
		}
	</script>

	<script type="text/javascript">
		$(document).ready(function() 
		{
			btn_login();
		});
	</script>
	
</body>
</html>