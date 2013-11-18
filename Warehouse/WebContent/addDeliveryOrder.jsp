<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="js/nav.js" ></script>
<script type="text/javascript" src="js/add_delete_td.js" ></script>
<link rel="stylesheet" type="text/css" href="css/main.css" />

<title>临时页面</title>

</head>

<body class="browserscripting">

	<div id="wrapper">

		<div id="navfirst" STYLE="border-style: solid; border-width: 5pt;">
			<%-- <jsp:include page="control/control_navfirst_entry.jsp" /> --%>
		</div>

		<div id="navsecond" STYLE="border-style:solid;border-width:5pt;">
			<jsp:include page="control/control_nav.jsp" />
		</div>

		<div id="maincontent" STYLE="border-style: solid; border-width: 5pt;">
			<h1>添加销售出库单</h1>
			<s:form action="add_WarehousingEntry" method="post" theme="simple" >
				<div class="base_information">
					<ul>
						<li>制单日期：<s:textfield id="prepared" name="entryBean.prepared_by_date" /><s:fielderror>
								<s:param>entryBean.prepared_by_date</s:param>
							</s:fielderror>
						</li>
						<li>单据号码：<s:textfield name="entryBean.document_number" /> <s:fielderror>
								<s:param>entryBean.document_number</s:param>
							</s:fielderror>
						</li>
						<li>原始单号：<s:textfield name="entryBean.original_invoice_number" /> <s:fielderror>
								<s:param>entryBean.original_invoice_number</s:param>
							</s:fielderror>
						</li>
						<li>进货仓库：<s:textfield name="entryBean.shipping_warehouse" />
							<s:fielderror>
								<s:param>entryBean.shipping_warehouse</s:param>
							</s:fielderror>
						</li>
						<li>供应商：<s:textfield name="entryBean.supplier" /> <s:fielderror>
								<s:param>entryBean.supplier</s:param>
							</s:fielderror>
						</li>
					</ul>
				</div>
				<div class="material_information">
					<table id="material" border="1">
						<tr>
							<th>选择</th>
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
						<tr>
							<td><input type=checkbox id="box1" /></td>
							<td><s:textfield type="text" name="materialBeans[0].coding" /></td>
							<td><s:textfield type="text" name="materialBeans[0].name" /></td>
							<td><s:textfield type="text" name="materialBeans[0].specification" /></td>
							<td><s:textfield type="text" name="materialBeans[0].unit" /></td>
							<td><s:textfield type="text" name="materialBeans[0].warehousing_price" /></td>
							<td><s:textfield type="text" name="materialBeans[0].sales_price" /></td>
							<td><s:textfield type="text" name="materialBeans[0].amount" /></td>
							<td><s:textfield type="text" name="materialBeans[0].money" /></td>
							<td><s:textfield type="text" name="materialBeans[0].remark" /></td>
						</tr>
					</table>
					
					<s:fielderror>
						<s:param>material_error</s:param>
					</s:fielderror>

					<table>
					<tr>
						<td>
							<input type="button" name="Submit" value="增加一行" onclick="javascript:AddRow();" />
							<input type="button" name="Submit" value="删除一行" onclick="javascript:DelRow();" />
						</td>								
					</tr>
					</table>
				</div>


				<div class="base_information">
					<ul>
						<li>合计金额:<s:textfield name="entryBean.total_money" /> <s:fielderror>
								<s:param>entryBean.total_money</s:param>
							</s:fielderror>
						</li>
						<li>数量小计:<s:textfield name="entryBean.total_number" /> <s:fielderror>
								<s:param>entryBean.total_number</s:param>
							</s:fielderror>
						</li>
					</ul>
				</div>
				<s:submit />
			</s:form>
		</div>
	</div>
	
</body>
</html>