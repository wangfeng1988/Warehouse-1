<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="navlist">
		<div class="navsection">
			<h4 id="navhead">表单管理</h4>
			<ul class="menu-one">
				<li id="selected"><a href="selectWarehousingEntry.jsp">收货入库单</a></li>
				<li><a href="selectMaterialsRequisition.jsp">领料出库单</a></li>
				<li><a href="selectDeliveryOrder.jsp">销售出库单</a></li>
			</ul>
		</div>
		
		<div class="navsection">
			<h4 id="navhead">仓库管理</h4>
			<ul>
				<li><a href="selectMaterial.jsp">仓库货品</a></li>
				<li><a href="#">盘库管理</a></li>
			</ul>
		</div>
		
		<div class="navsection">
			<h4 id="navhead">权限管理</h4>
			<ul>
				<li><a href="#">角色权限</a></li>
				<li><a href="#">人物角色</a></li>
			</ul>
		</div>
	</div>
</body>
</html>