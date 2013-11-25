<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="js/prepared.js"></script>
<script type="text/javascript" src="js/open_window.js"></script>
<script type="text/javascript" src="js/add_delete_td.js"></script>

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

				<div id="material_information">
					<table id="goal_table" border="1">
						<tr>
							<th>选择</th>
							<th>物料编码</th>
							<th>物料名称</th>
							<th>单位</th>
							<th>单价</th>
							<th>数量</th>
							<th>金额</th>
							<th>备注</th>
						</tr>
					</table>
					
					<s:fielderror>
						<s:param>material_error</s:param>
					</s:fielderror>
					
					<ul class="ul_nav">
						<li>
							<input type="button" value="查询" onclick="openFormWin('selectMatForReq.jsp','selectMatForReq','930','450')" />
						</li>	
						<li>
							<input type="button" value="删除" onclick="javascript:DelRow();" />
						</li>							
					</ul>
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
		</div>
	</div>

</body>
</html>