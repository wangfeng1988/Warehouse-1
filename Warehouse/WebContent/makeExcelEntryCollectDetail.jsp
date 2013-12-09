<%@ page contentType="application/vnd.ms-excel; charset=utf-8"%>
<%
response.setHeader("Content-disposition","attachment; filename=entryCollectDetail.xls");
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
			<td><s:property value="entryCollect_details.maked_year_month" /></td>
			<td>收货入库单明细表</td>
		</tr>

		<s:iterator value="entryCollect_details.entrysdetail" id="detail"
			status="supplier_index">
			<tr>
				<td>供应商</td>
				<td><s:property value="#detail.supplier" /></td>
				<td>入库物料合计金额</td>
				<td><s:property value="#detail.total_money" /></td>
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
			</tr>

			<s:iterator value="#detail.entrys" id="entry" status="entry_index">
				<s:iterator value="#entry.materials" id="material"
					status="material_index">
					<tr>
						<td><s:property value="#material_index.index" /></td>
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
			</s:iterator>

		</s:iterator>
	</table>

</body>
</html>