<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="css/main.css" />

<title>临时页面</title>

</head>

<body>
	<s:action name="selectDetails_DeliveryOrderCollect" executeResult="true">
		<s:param name="tag">2</s:param>
		<s:param name="id"><%=request.getParameter("id")%></s:param>
	</s:action>
</body>
</html>