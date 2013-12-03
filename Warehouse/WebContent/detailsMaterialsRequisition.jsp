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

<body class="browserscripting">

	<div id="wrapper">
	
		<div id="maincontent" STYLE="border-style: solid; border-width: 5pt;">
			<h1>入库单详情</h1>
			<table id="details">
				<tr>
					<td>制单日期：</td><td><s:property value="requisition_detials.prepared_by_date" /></td>
					<td>单据号码：</td><td><s:property value="requisition_detials.document_number" /></td>
					<td>原始单号：</td><td><s:property value="requisition_detials.original_invoice_number" /></td>
				</tr>
				<tr>
					<td>发货仓库：</td><td><s:property value="requisition_detials.shipping_warehouse" /></td>
					<td>领料单位：</td><td><s:property value="requisition_detials.requisition_unit" /></td>
				</tr>
				
				<tr>
					<th>序号</th>
					<th>物料编码</th>
					<th>物料名称</th>
					<th>物料规格</th>
					<th>单位</th>
					<th>单价</th>
					<th>数量</th>
					<th>金额</th>
					<th>备注</th>
				</tr>

				<s:iterator value="requisition_detials.requisition_material" id="rm" status="index">
				<tr>
						<td><s:property value="#index.index" /></td>
						<td><s:property value="#rm.material.coding" /></td>
						<td><s:property value="#rm.material.name" /></td>
						<td><s:property value="#rm.material.specification" /></td>
						<td><s:property value="#rm.material.unit" /></td>
						<td><s:property value="#rm.material.warehousing_price" /></td>
						<td><s:property value="#rm.number" /></td>
						<td><s:property value="#rm.money" /></td>
						<td><s:property value="#rm.material.remark" /></td>
				</tr>
				</s:iterator>
				
				<tr>
					<td>合计金额:</td><td><s:property value="requisition_detials.total_money" /></td>
					<td>数量小计:</td><td><s:property value="requisition_detials.total_number" /></td>
				</tr>
			</table>
				
			<form action="selectDetails_MaterialsRequisition">
				<input type="hidden" value=<s:property value="requisition_detials.id"/> name="id"/>
				<input type="hidden" value="1" name="isExcel" />
				<input type="submit" value="导出EXCEL"/>
			</form>
			
		</div>
	</div>
	
</body>
</html>