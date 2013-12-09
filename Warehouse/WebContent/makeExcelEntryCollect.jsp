<%@ page contentType="application/vnd.ms-excel; charset=utf-8"%>
<%
response.setHeader("Content-disposition","attachment; filename=entryCollect.xls");
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
			<td>收货入库单汇总</td>
		</tr>

		<tr>
			<th>序号</th>
			<th>供应商</th>
			<th>合计金额</th>
			<th>备注</th>
		</tr>

		<s:iterator value="entryCollect_details.entrysdetail" id="detail"
			status="index">
			<tr>
				<td><s:property value="#index.index" /></td>
				<td><s:property value="#detail.supplier" /></td>
				<td><s:property value="#detail.total_money" /></td>
				<td><s:property value="#detail.remark" /></td>
			</tr>
		</s:iterator>

		<tr>
			<td>合计金额:</td>
			<td><s:property value="entryCollect_details.total_money" /></td>
		</tr>
	</table>

</body>
</html>