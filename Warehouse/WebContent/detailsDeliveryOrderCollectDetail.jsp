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

<title>明细页面</title>

</head>

<body class="browserscripting" >
	
	<div class="detail_div">
	
		<h1>销售出库单明细</h1>
	
		<div id="content_head">
			<ul class="ul_nav">
				<li><input type="text"
					value=<s:property value="deliveryCollect_details.maked_year_month" />
					readonly="readonly" />销售出库单明细</li>
			</ul>
		</div>
		
		<div>
			<div id="table_body">
				<table>
				<s:iterator value="deliveryCollect_details.deliverysdetail" id="detail" status="customer_index">
						<tr>
							<th>客户名</th><th><s:property value="#detail.customer_name" /></th>
							<th>合计金额</th><th><s:property value="#detail.total_money" /></th>
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

					<s:iterator value="#detail.deliverys" id="delivery" status="delivery_index">
						<s:iterator value="#delivery.delivery_material" id="rm" status="rm_index">
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
								<td><s:property value="#delivery.document_number"/>
							</tr>
						</s:iterator>
					</s:iterator>

				</s:iterator>
				</table>
			</div>
		</div>

		<div id="content_foot">
			<ul class="ul_nav content_foot_ul">
				<li>合计金额:<input type="text"
					value=<s:property value="deliveryCollect_details.total_money" />
					readonly="readonly" /></li>
			</ul>

			<form action="selectDetails_DeliveryOrderCollect">
				<input type="hidden"
					value=<s:property value="deliveryCollect_details.id"/> name="id" /> <input
					type="hidden" value="3" name="tag" /> <input type="submit"
					value="导出EXCEL" />
			</form>
		</div>			
	</div>	
</body>
</html>