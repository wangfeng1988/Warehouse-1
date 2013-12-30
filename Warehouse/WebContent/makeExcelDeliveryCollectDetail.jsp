<%@ page contentType="application/vnd.ms-excel; charset=utf-8"%>
<%
response.setHeader("Content-disposition","attachment; filename=deliveryCollectDetail.xls");
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
			<td><s:property value="deliveryCollect_details.maked_year_month" /></td>
			<td>销售出库单明细表</td>
		</tr>

		<s:iterator value="deliveryCollect_details.deliverysdetail" id="detail" status="supplier_index">
			<tr>
				<td>客户名称</td>
				<td><s:property value="#detail.customer_name" /></td>
				<td>销售金额</td>
				<td><s:property value="#detail.total_money" /></td>
			</tr>

			<tr>
				<th>序号</th>
				<th>货品编码</th>
				<th>货品名称</th>
				<th>货品规格</th>
				<th>单位</th>
				<th>单价</th>
				<th>数量</th>
				<th>金额</th>
				<th>制单日期</th>
				<th>出库单号</th>
			</tr>

			<s:iterator value="#detail.deliverys" id="delivery"
				status="delivery_index">
				<s:iterator value="#delivery.delivery_material" id="rm"
					status="rm_index">
					<tr>
						<td><s:property value="#delivery_index.index" /></td>
						<td><s:property value="#rm.material.coding" /></td>
						<td><s:property value="#rm.material.name" /></td>
						<td><s:property value="#rm.material.specification" /></td>
						<td><s:property value="#rm.material.unit" /></td>
						<td><s:property value="#rm.material.warehousing_price" /></td>
						<td><s:property value="#rm.number" /></td>
						<td><s:property value="#rm.money" /></td>
						<td><s:property value="#delivery.prepared_by_date" /></td>
						<td><s:property value="#delivery.document_number" />
					</tr>
				</s:iterator>
			</s:iterator>

		</s:iterator>
	</table>

</body>
</html>