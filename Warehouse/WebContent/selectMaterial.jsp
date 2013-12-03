<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="js/nav.js" ></script>
<script type="text/javascript" src="js/ajax_flush.js" ></script>
<script type="text/javascript" src="js/open_window.js" ></script>

<link rel="stylesheet" type="text/css" href="css/main.css" />

<title>临时页面</title>

</head>

<body class="browserscripting">
	<div id="wrapper">

		<div id="navfirst"  STYLE="border-style:solid;border-width:5pt;">

		</div>

		<div id="navsecond" STYLE="border-style:solid;border-width:5pt;">
			<jsp:include page="control/control_nav.jsp" />
		</div>

		<div id="maincontent" STYLE="border-style: solid; border-width: 5pt;">

			<div id="head">
				<h1>查询货品单</h1>
				<ul class="ul_nav">
					<li id="help"><button class="funcation">帮助</button></li>
					<li id="select"><button class="funcation">查询</button></li>
					<li id="modify"><button class="funcation">修改</button></li>
					<li id="delete"><button class="funcation">删除</button></li>
					<li id="add"><button class="funcation">增加</button></li>
				</ul>
			</div>

			<div id="search_information">
				<form action="select_Material" method="post">
					<ul class="ul_nav">
						<li>关键字:<s:textfield name="searchKey" /></li>
						<li>搜索类型: <select name="searchType">
								<option value="货品编码" selected="selected">货品编码</option>
								<option value="货品名称">货品名称</option>
						</select>
						</li>
						<li>
							<input type="submit" value="搜索" />
						</li>
					</ul>
				</form>
			</div>

			<div id="select_result">
				<table border="1">
					<tr>
						<th>序号</th>
						<th>货品编码</th>
						<th>货品名称</th>
						<th>货品规格</th>
						<th>单位</th>
						<th>入库单价</th>
						<th>销售单价</th>
						<th>数量</th>
						<th>金额</th>
						<th>备注</th>
					</tr>				
					<s:iterator value="result" id="material" status="index">
						<tr>
							<th class="spec"><s:property value="#index.index" /></th>
							<td><s:property value="#material.coding" /></td>
							<td><s:property value="#material.name" /></td>
							<td><s:property value="#material.specification" /></td>
							<td><s:property value="#material.unit" /></td>
							<td><s:property value="#material.warehousing_price" /></td>
							<td><s:property value="#material.sales_price" /></td>
							<td><s:property value="#material.amount" /></td>
							<td><s:property value="#material.money" /></td>
							<td><s:property value="#material.remark" /></td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>