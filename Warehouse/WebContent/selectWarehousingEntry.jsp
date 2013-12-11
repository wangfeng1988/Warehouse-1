<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
</head>

<body>
	<div id="select" class="tabactive">
	
		<h1>查询收货入库单</h1>

		<div id="content_head">
			<form action="select_WarehousingEntry" method="post">
				<ul class="ul_nav">
					<li>关键字:<input type="text" name="searchKey" /></li>
					<li>搜索类型: <select name="searchType">
							<option value="制单日期" selected="selected">制单日期</option>
							<option value="单据号码">单据号码</option>
							<option value="原始单号">原始单号</option>
							<option value="进货仓库">进货仓库</option>
							<option value="供应商">供应商</option>
					</select>
					</li>
					<li><input class="button" type="submit" value="搜索" /></li>
				</ul>
			</form>
		</div>

		<div id="content_table">
			<div id="table_head">
				<table>
					<tr>
						<th class="first">制单日期</th>
						<th>单据号码</th>
						<th>原始单号</th>
						<th>进货仓库</th>
						<th>供应商</th>
						<th>合计数量</th>
						<th>合计金额</th>
						<th>详情</th>
					</tr>
				</table>
			</div>

			<div id="table_body">
				<table>
					<s:iterator value="result" id="entry" status="index">
						<tr>
							<td><s:property value="#entry.prepared_by_date" /></td>
							<td><s:property value="#entry.document_number" /></td>
							<td><s:property value="#entry.original_invoice_number" /></td>
							<td><s:property value="#entry.shipping_warehouse" /></td>
							<td><s:property value="#entry.supplier" /></td>
							<td><s:property value="#entry.total_number" /></td>
							<td><s:property value="#entry.total_money" /></td>
							<td>
								<form>
									<input class="button" type="submit" value="详情"
										onclick="openFormWin('transferToDetEntry.jsp'+'?id=<s:property value="#entry.id" />','detailsWarehousingEntry','930','450')" />
								</form>
							</td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
