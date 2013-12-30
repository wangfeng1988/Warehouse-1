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

<title>汇总页面</title>

</head>

<body class="browserscripting" >

	<div class="detail_div">
	
		<h1>销售出库单汇总详情</h1>
	
		<div id="content_head">
			<ul class="ul_nav">
				<li><input type="text"
					value=<s:property value="deliveryCollect_details.maked_year_month" />
					readonly="readonly" />领料出库单汇总</li>
			</ul>
		</div>
		
		<div>
			<div id="table_head">
				<table>
					<tr>
						<th class="short">序号</th>
						<th>顾客姓名</th>
						<th>销售金额</th>
						<th>备注</th>
					</tr>
				</table>
			</div>
			<div id="table_body">
				<table id="material">
					<s:iterator value="deliveryCollect_details.deliverysdetail" id="detail" status="index">
						<tr>
							<td class="short"><s:property value="#index.index" /></td>
							<td><s:property value="#detail.customer_name" /></td>
							<td><s:property value="#detail.total_money" /></td>
							<td><s:property value="#detail.remark" /></td>
						</tr>
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
				<input type="hidden" value=<s:property value="deliveryCollect_details.id"/> name="id"/>
				<input type="hidden" value="1" name="tag" />
				<input type="submit" value="导出EXCEL"/>
			</form>
		</div>			
	</div>
	
</body>
</html>