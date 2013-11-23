<%@ page contentType="application/vnd.ms-excel; charset=utf-8"%>
<%
response.setHeader("Content-disposition","attachment; filename=resource.xls");
%>

<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
</head>
<body>
	<script>
		document.write(document.referrer);
	</script>
</body>
</html>

	<script>
		alert(<%=request.getParameter("table")%>);
		document.write("<table>"+<%=request.getParameter("table")%>+</table>");
	</script>