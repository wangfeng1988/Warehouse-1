<%@ page contentType="application/vnd.ms-excel; charset=utf-8"%>
<%
response.setHeader("Content-disposition","attachment; filename=entry.xls");
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
			<td><s:property value="entry_detials.prepared_by_date" /></td>
			<td>单据号码：</td>
			<td><s:property value="entry_detials.document_number" /></td>
			<td>原始单号：</td>
			<td><s:property value="entry_detials.original_invoice_number" /></td>
		</tr>
		<tr>
			<td>进货仓库：</td>
			<td><s:property value="entry_detials.shipping_warehouse" /></td>
			<td>供应商：</td>
			<td><s:property value="entry_detials.supplier" /></td>
		</tr>

		<tr>
			<th>序号</th>
			<th>货品编码</th>
			<th>货品名称</th>
			<th>货品规格</th>
			<th>单位</th>
			<th>入库单价</th>
			<th>销售单价</th>
			<th>数量</th>
			<th>入库价值</th>
			<th>备注</th>
			<s:iterator value="entry_detials.materials" id="material" status="index">
				<tr>
					<td><s:property value="#index.index" /></td>
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
		<tr>
			<td>合计金额:</td>
			<td><s:property value="entry_detials.total_money" /></td>
			<td>数量小计:</td>
			<td><s:property value="entry_detials.total_number" /></td>
		</tr>
	</table>

</body>
</html>