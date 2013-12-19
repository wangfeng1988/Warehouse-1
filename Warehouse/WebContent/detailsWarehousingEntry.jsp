<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/tablecloth.js"></script>

<link rel="stylesheet" type="text/css" href="css/tablecloth.css" />
<link rel="stylesheet" type="text/css" href="css/detailtable.css" />

<title>汇总详情页面</title>

</head>

<body class="browserscripting" >

	<div class="detail_div">
		<h1>收货入库单详情</h1>

		<div id="content_head">
			<ul class="ul_nav">
				<li>制单日期：<input type="text"
					value=<s:property value="entry_details.prepared_by_date" />
					readonly="readonly" /></li>
				<li>单据号码：<input type="text"
					value=<s:property value="entry_details.document_number" />
					readonly="readonly" /></li>
				<li>原始单号：<input type="text"
					value=<s:property value="entry_details.original_invoice_number" />
					readonly="readonly" /></li>
				<li>进货仓库：<input type="text"
					value=<s:property value="entry_details.shipping_warehouse" />
					readonly="readonly" /></li>
				<li>供应商&nbsp;&nbsp;&nbsp;：<input type="text"
					value=<s:property value="entry_details.supplier" />
					readonly="readonly" /></li>
			</ul>
		</div>

		<div>
			<div id="table_head">
				<table>
					<tr>
						<th class="short">序号</th>
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
				</table>
			</div>
			<div id="table_body">
				<table id="material">
					<s:iterator value="entry_details.materials" id="material"
						status="index">
						<tr>
							<td class="short"><s:property value="#index.index" /></td>
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

		<div id="content_foot">
			<ul class="ul_nav content_foot_ul">
				<li>合计金额:<input type="text"
					value=<s:property value="entry_details.total_money" />
					readonly="readonly" /></li>
				<li>数量小计:<input type="text"
					value=<s:property value="entry_details.total_number" />
					readonly="readonly" /></li>
			</ul>
			<form action="selectDetails_WarehousingEntry">
				<input type="hidden" value=<s:property value="entry_details.id"/>
					name="id" /> <input type="hidden" value="1" name="isExcel" /> <input
					type="submit" value="导出EXCEL" />
			</form>
		</div>
	</div>

</body>
</html>