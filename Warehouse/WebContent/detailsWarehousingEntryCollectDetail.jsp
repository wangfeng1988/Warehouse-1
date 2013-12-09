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
						<td><s:property value="entryCollect_details.maked_year_month" /></td><td>收货入库单明细表</td>
					</tr>
					
					<s:iterator value="entryCollect_details.entrysdetail" id="detail" status="supplier_index">
						<tr>
							<td>供应商</td><td><s:property value="#detail.supplier" /></td>
							<td>入库物料合计金额</td><td><s:property value="#detail.total_money" /></td>
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
						<s:iterator value="#entry.materials" id="material" status="material_index">
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
				
				<form action="selectDetails_WarehousingEntryCollect">
					<input type="hidden" value=<s:property value="entryCollect_details.id"/> name="id"/>
					<input type="hidden" value="3" name="tag" />
					<input type="submit" value="导出EXCEL"/>
				</form>
		</div>
	</div>
	
</body>
</html>