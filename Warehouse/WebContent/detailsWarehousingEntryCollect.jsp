<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/main.css" />

<title>临时页面</title>

</head>

<body class="browserscripting" >

	<div id="wrapper">
	
		<div id="maincontent" STYLE="border-style: solid; border-width: 5pt;">
			<h1>入库单详情</h1>
			<table id="details">
					<tr>
						<td><s:property value="entryCollect_detials.maked_year_month" /></td><td>收货入库单汇总</td>
					</tr>
					
					<tr>
						<th>序号</th>
						<th>供应商</th>
						<th>合计金额</th>
						<th>备注</th>
					</tr>
					<s:iterator value="supplier_of_entrys" id="soes" status="index">
						<tr>
							<td><s:property value="#index.index" /></td>
							<td><s:property value="#soes.supplier" /></td>
							<td><s:property value="#soes.total_money" /></td>
							<td><s:property value="#soes.remark" /></td>
						</tr>
					</s:iterator>
					
					<tr>
						<td>合计金额:</td><td><s:property value="entryCollect_detials.total_money" /></td>
					</tr>
				</table>
				
				<form action="selectDetails_WarehousingEntryCollect">
					<input type="hidden" value=<s:property value="entryCollect_detials.id"/> name="id"/>
					<input type="hidden" value="1" name="isExcel" />
					<input type="submit" value="导出EXCEL"/>
				</form>
		</div>
	</div>
	
</body>
</html>