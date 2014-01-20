<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="js/insert_material.js"></script>
<script type="text/javascript" src="js/prepared.js"></script>
<link rel="stylesheet" type="text/css" href="css/main.css" />

<title>临时页面</title>

</head>

<body class="browserscripting" onload="load()">

	<div id="wrapper">
		<div id="maincontent" STYLE="border-style: solid; border-width: 5pt;">
			<h1>添加领料出库单</h1>
			<form action="add_MaterialsRequisition" method="post">
				<div id="form_information">
					<ul class="ul_nav">
						<li>制单日期：<input id="prepared_date" name="requisitionBean.prepared_by_date" />
							<s:fielderror>
								<s:param>requisitionBean.prepared_by_date</s:param>
							</s:fielderror>
						</li>
						<li>单据号码：<input name="requisitionBean.document_number" /> 
							<s:fielderror>
								<s:param>requisitionBean.document_number</s:param>
							</s:fielderror>
						</li>
						<li>原始单号：<input name="requisitionBean.original_invoice_number" /> 
							<s:fielderror>
								<s:param>requisitionBean.original_invoice_number</s:param>
							</s:fielderror>
						</li>
						<li>进货仓库：<input name="requisitionBean.shipping_warehouse" />
							<s:fielderror>
								<s:param>requisitionBean.shipping_warehouse</s:param>
							</s:fielderror>
						</li>
						<li>领料单位：<input name="requisitionBean.requisition_unit" /> 
							<s:fielderror>
								<s:param>requisitionBean.supplier</s:param>
							</s:fielderror>
						</li>
					</ul>
				</div>

				<div class="material_information">
					<table id="material_information" border="1">
						<tr>
							<th>选择</th>
							<th>物料编码</th>
							<th>物料名称</th>
							<th>单价</th>
							<th>数量</th>
							<th>金额</th>
						</tr>
					</table>

					<s:fielderror>
						<s:param>material_error</s:param>
					</s:fielderror>
				</div>
				
				<div id="form_information">
					<ul class="ul_nav">
						<li>合计金额:<input name="requisitionBean.total_money" /> <s:fielderror>
								<s:param>requisitionBean.total_money</s:param>
							</s:fielderror>
						</li>
						<li>数量小计:<input name="requisitionBean.total_number" /> <s:fielderror>
								<s:param>requisitionBean.total_number</s:param>
							</s:fielderror>
						</li>
					</ul>
				</div>								
				<input type="submit" value="提交" />
			</form>

			<div id="search_information">
				<h1>搜索货品</h1>
				<form action="select_Material" method="post">
					<ul class="ul_nav">
						<li>关键字:<s:textfield name="searchKey" /></li>
						<li>搜索类型: <select name="searchType">
								<option value="货品编码" selected="selected">货品编码</option>
								<option value="货品名称">货品名称</option>
						</select>
						</li>
						<li>
							<input type="submit" value="搜索" />
						</li>
					</ul>
				</form>
			</div>


			<div id="material_information">
				<table border="1" id="search_materialInformation">
					<tr>
						<th>选择</th>
						<th>货品编码</th>
						<th>货品名称</th>
						<th>货品规格</th>
						<th>单位</th>
						<th>入库单价</th>
						<th>销售单价</th>
						<th>库存</th>
						<th>金额</th>
						<th>备注</th>
						<th>需求数量</th>
					</tr>
					
					<tr>
						<td><input type=checkbox id="box2" /></td>				
					</tr>
					
					<s:iterator value="result" id="material">
						<tr>
							<td><input type=checkbox id="box2" /></td>
							<td><s:property value="#material.coding" /></td>
							<td><s:property value="#material.name" /></td>
							<td><s:property value="#material.specification" /></td>
							<td><s:property value="#material.unit" /></td>
							<td><s:property value="#material.warehousing_price" /></td>
							<td><s:property value="#material.sales_price" /></td>
							<td><s:property value="#material.stock" /></td>
							<td><s:property value="#material.money" /></td>
							<td><s:property value="#material.remark" /></td>
							<td><input type="text" /></td>
							<td><input type="hidden" value=<s:property value="#material.id" /> /></td>
						</tr>
					</s:iterator>
				</table>

				<input type="button" name="Submit" value="确定"
					onclick="insertMaterialInformation();" />
			</div>
		</div>
	</div>

</body>
</html>