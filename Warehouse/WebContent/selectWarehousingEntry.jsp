<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="js/nav.js" ></script>
<script type="text/javascript" src="js/ajax_flush.js" ></script>
<script type="text/javascript" src="js/open_window.js" ></script>

<link rel="stylesheet" type="text/css" href="css/main.css" />

<title>临时页面</title>

</head>

<body class="browserscripting">
	<div id="wrapper">

		<div id="navfirst"  STYLE="border-style:solid;border-width:5pt;">

		</div>

		<div id="navsecond" STYLE="border-style:solid;border-width:5pt;">
			<jsp:include page="control/control_nav.jsp" />
		</div>

		<div id="maincontent" STYLE="border-style: solid; border-width: 5pt;">
		
			<div id="head">
				<h1>查询收货入库单</h1>
				<ul class="ul_nav">
					<li id="help"><button class="funcation">帮助</button></li>
					<li id="select"><button class="funcation">查询</button></li>
					<li id="modify"><button class="funcation">修改</button></li>
					<li id="delete"><button class="funcation">删除</button></li>
					<li id="add"><button class="funcation" onclick="openFormWin('addWarehousingEntry.jsp','addWarehousingEntry','930','450')">增加</button></li>
				</ul>
			</div>

			<div id="search_information">
				<form action="select_WarehousingEntry" method="post">
					<ul class="ul_nav">
						<li>关键字:<input type="text" name="searchKey" /></li>
						<li>搜索类型: 
						<select name="searchType">
								<option value="制单日期" selected="selected">制单日期</option>
								<option value="单据号码">单据号码</option>
								<option value="原始单号">原始单号</option>
								<option value="进货仓库">进货仓库</option>
								<option value="供应商">供应商</option>
						</select>
						</li>
						<li>
							<input type="submit" value="搜索"/>
						</li>
					</ul>
				</form>
			</div>

			<div id="select_result">				
					<table border="1">
						<tr>
							<th>序号</th>
							<th>制单日期</th>
							<th>单据号码</th>
							<th>原始单号</th>
							<th>进货仓库</th>
							<th>供应商</th>
							<th>合计数量</th>
							<th>合计金额</th>
							<th>备注</th>
						</tr>
						<s:iterator value="result" id="entry">
						<tr>
								<th class="spec">1</th>
								<td><s:property value="#entry.prepared_by_date" /></td>
								<td><s:property value="#entry.document_number" /></td>
								<td><s:property value="#entry.original_invoice_number" /></td>
								<td><s:property value="#entry.shipping_warehouse" /></td>
								<td><s:property value="#entry.supplier" /></td>
								<td><s:property value="#entry.total_number" /></td>
								<td><s:property value="#entry.total_money" /></td>
								<td><s:property value="#entry.remark" /></td>
						</tr>
						</s:iterator>
					</table>
				</div>			
		</div>
	</div>
	
</body>
</html>