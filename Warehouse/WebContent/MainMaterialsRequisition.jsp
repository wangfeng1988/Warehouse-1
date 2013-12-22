<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="js/open_window.js" ></script>
<script type="text/javascript" src="js/tablecloth.js"></script>
<script type="text/javascript" src="js/add_delete_td.js"></script>
<script type="text/javascript" src="js/switchPage.js"></script>
<script type="text/javascript" src="js/prepared.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>

<link rel="stylesheet" type="text/css" href="css/tablecloth.css" media="screen" />
<link rel="stylesheet" type="text/css" href="css/main.css" />

<title>收货入库单</title>

</head>

<body class="browserscripting" onload="load('2')">
	<div id="wrapper">
		<div id="head">
			<jsp:include page="head.jsp" />
		</div>

		<div id="navleft">
			<jsp:include page="navleft.jsp" />
		</div>

		<div id="maincontent" >
			<jsp:include page="navtopOfRequisition.jsp" />
			<jsp:include page="selectMaterialsRequisition.jsp" />
			<jsp:include page="addMaterialsRequisition.jsp" />
			<jsp:include page="selectMaterialsRequisitionCollect.jsp" />
		</div>
		
		<div id="footer">
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function() 
		{
			btn_search_requisition();
 			btn_submit_requisition();
			btn_collect();
		});
	</script>
</body>
</html>

