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
						<td>制单日期：</td><td><s:property value="entry_detials.prepared_by_date" /></td>
						<td>单据号码：</td><td><s:property value="entry_detials.document_number" /></td>
						<td>原始单号：</td><td><s:property value="entry_detials.original_invoice_number" /></td>
					</tr>
					<tr>
						<td>进货仓库：</td><td><s:property value="entry_detials.shipping_warehouse" /></td>
						<td>供应商：</td><td><s:property value="entry_detials.supplier" /></td>
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
					
					<tr>
						<td>合计金额:</td><td><s:property value="entry_detials.total_money" /></td>
						<td>数量小计:</td><td><s:property value="entry_detials.total_number" /></td>
					</tr>
				</table>
				
				<form action="toExcel_WarehousingEntry">
					<input type="hidden" value=<s:property value="entry_detials.id"/> name="toExcel_id"/>
					<input type="submit" value="hello"/>
				</form>
				
<%-- 				<script>			
					//这里理论上应该是用document.appenChild(a)的，直接write会覆盖整个文档,但是很奇怪现在反而要这么写
					document.write("<a href='MakeExcel.jsp?table1="+document.getElementById("details").innerHTML+"'>导出excel</a>"); 
				</script> --%>
		</div>
	</div>
	
</body>
</html>