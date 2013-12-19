<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/prepared.js"></script>
<script type="text/javascript" src="js/open_window.js"></script>
<script type="text/javascript" src="js/makeForm.js"></script>
<script type="text/javascript" src="js/tableTotable.js"></script>



<link rel="stylesheet" type="text/css" href="css/main.css" />

<title>临时页面</title>

</head>

<body>

	<div id="add" class="tabhidden">
	
		<h1>添加领料出库单</h1>

		<form id="requisition_form" action="add_MaterialsRequisition" method="post">
			<div id="form_information">
				<ul class="ul_nav">
					<li>制单日期：<input type="text" id="prepared_date" name="requisitionBean.prepared_by_date" readonly="readonly" /></li>
					<li>单据号码：<input type="text" name="requisitionBean.document_number" /></li>
					<li>原始单号：<input type="text" name="requisitionBean.original_invoice_number" /></li>
					<li>发货仓库：<input type="text" name="requisitionBean.shipping_warehouse" /></li>
					<li>领料单位：<input type="text" name="requisitionBean.requisition_unit" /></li>
				</ul>
			</div>
			<div id="content_table">
				<div id="table_head">
					<table>
						<tr>
							<th class="first short" >选择</th>
							<th>物料编码</th>
							<th>物料名称</th>
							<th>物料规格</th>
							<th>单位</th>
							<th>单价</th>
							<th>需求数量</th>
							<th>金额</th>
							<th>金额</th>
							<th>备注</th>
						</tr>
					</table>
				</div>
				<div id="table_body">
					<table id="material">
						<tr>
							<td class="short"><input type=checkbox name="box1" /></td>
							<td><input type="text" name="materialBeans[0].coding" /></td>
							<td><input type="text" name="materialBeans[0].name" /></td>
							<td><input type="text" name="materialBeans[0].specification" /></td>
							<td><input type="text" name="materialBeans[0].unit" /></td>
							<td><input type="text" name="materialBeans[0].warehousing_price" /></td>
							<td><input type="text" name="materialBeans[0].sales_price" /></td>
							<td><input type="text" name="materialBeans[0].amount" /></td>
							<td><input type="text" name="materialBeans[0].money" /></td>
							<td><input type="text" name="materialBeans[0].remark" /></td>
						</tr>
					</table>
				</div>
			</div>
			
			<div id="content_foot">
				<ul class="content_foot_button">
					<li><input type="button" name="Submit" value="删除"
						onclick="javascript:DelRow();" /></li>
					<li><input type="button" name="Submit" value="查询"
						onclick="openFormWin('selectMatForReq.jsp','selectMatForReq','930','450');" /></li>
				</ul>
				<ul class="ul_nav content_foot_ul">
					<li>合计金额:<input type="text" name="requisitionBean.total_money" /></li>
					<li>数量小计:<input type="text" name="requisitionBean.total_number" /></li>
				</ul>
				<input type="button" value="提交" class="submit_entry"/>
			</div>

		</form>
	</div>
</body>
</html>

<%-- <div id="material_information">
				<input type="hidden" id="box" />
				<table id="goal_table" border="1">
					<tr>
						<th>选择</th>
						<th>物料编码</th>
						<th>物料名称</th>
						<th>物料规格</th>
						<th>单位</th>
						<th>单价</th>
						<th>需求数量</th>
						<th>金额</th>
						<th>备注</th>
					</tr>
				</table>

				<s:fielderror>
					<s:param>material_error</s:param>
				</s:fielderror>

				<ul class="ul_nav">
					<li><input type="button" value="查询"
						onclick="openFormWin('selectMatForReq.jsp','selectMatForReq','930','450')" />
					</li>
					<li><input type="button" value="删除" onclick="delMaterial()" />
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
			<input type="submit" value="提交" onclick="makeRequisition()" />
		</form>
	</div> --%>