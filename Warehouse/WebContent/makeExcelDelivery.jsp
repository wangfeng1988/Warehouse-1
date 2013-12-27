<%@ page contentType="application/vnd.ms-excel; charset=utf-8"%>
<%
response.setHeader("Content-disposition","attachment; filename=requisition.xls");
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>临时页面</title>

</head>

<body class="browserscripting">

	<table id="details">
		<tr>
			<td>制单日期：</td>
			<td><s:property value="delivery_detials.prepared_by_date" /></td>
			<td>单据号码：</td>
			<td><s:property value="delivery_detials.document_number" /></td>
		</tr>
		<tr>
			<td>发货仓库：</td>
			<td><s:property value="delivery_detials.shipping_warehouse" /></td>
			<td>顾客名称：</td>
			<td><s:property value="delivery_detials.customer_name" /></td>
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

		<s:iterator value="delivery_detials.delivery_material" id="rm" status="index">
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
			<td>合计金额:</td><td><s:property value="delivery_detials.total_money" /></td>
			<td>数量小计:</td><td><s:property value="delivery_detials.total_number" /></td>
		</tr>
	</table>
</body>
</html>