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

				<div id="form_information">
					<ul class="ul_nav">
						<li>制单日期：<s:property value="entry_detials.prepared_by_date" /></li>
						<li>单据号码：<s:property value="entry_detials.document_number" /></li>
						<li>原始单号：<s:property value="entry_detials.original_invoice_number" /></li>
						<li>进货仓库：<s:property value="entry_detials.shipping_warehouse" /></li>
						<li>供应商：<s:property value="entry_detials.supplier" /></li>
					</ul>
				</div>
				<div id="material_information">
					<table id="material" border="1">
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
						<s:iterator value="entry_detials.materials" id="material">
						<tr>
							<td>1</td>
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


				<div id="form_information">
					<ul class="ul_nav">
						<li>合计金额:<s:property value="entry_detials.total_money" /></li>
						<li>数量小计:<s:property value="entry_detials.total_number" /></li>
					</ul>
				</div>
				
				<input type="submit" value="导出"/>
		</div>
	</div>
	
</body>
</html>