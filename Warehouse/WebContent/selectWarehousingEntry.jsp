<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="js/nav.js" ></script>
<script type="text/javascript" src="js/open_window.js" ></script>
<script type="text/javascript" src="js/tablecloth.js"></script>

<link rel="stylesheet" type="text/css" href="css/tablecloth.css" media="screen" />
<link rel="stylesheet" type="text/css" href="css/main.css" />

<title>查询收货入库单</title>

</head>

<body class="browserscripting">
	<div id="wrapper">

		<div id="navfirst">
			<div id="logo">
				<h1>邮政部门商品管理系统</h1>	
				<h4>winter is coming</h4>
				<ul id="welcome">	
					<li><a href="#">设置</a></li>
					<li><a href="#">登出</a></li>
					<li>欢迎</li>
				</ul>
			</div>
		</div>

		<div id="navsecond">
			<jsp:include page="control/control_nav.jsp" />
		</div>

		<div id="maincontent" >
			<div id="navthird">
				<ul class="navform">
					<li id="navactive"><a href="#" title="查询表单">查询表单</a></li>
					<li><a href="#" title="增加表单">增加表单</a></li>
					<li><a href="#" title="汇总查询">汇总查询</a></li>
					<li><a href="#" title="帮助查询">帮助查询</a></li>
				</ul>
			</div>
			
			<h1>查询收货入库单</h1>						

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

			<div id="search_table">
				<div id="table_head">
					<table>
						<tr>
							<!-- <th class="first">序号</th> -->
							<th>制单日期</th>
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

				<div id="table_result">
					<table>
						<s:iterator value="result" id="entry" status="index">
							<tr>
								<%-- <th class="first"><s:property value="#index.index" /></th> --%>
								<td><s:property value="#entry.prepared_by_date" /></td>
								<td><s:property value="#entry.document_number" /></td>
								<td><s:property value="#entry.original_invoice_number" /></td>
								<td><s:property value="#entry.shipping_warehouse" /></td>
								<td><s:property value="#entry.supplier" /></td>
								<td><s:property value="#entry.total_number" /></td>
								<td><s:property value="#entry.total_money" /></td>
								<td>
									<form>
										<input type="submit" value="详情"
											onclick="openFormWin('transferToDetEntry.jsp'+'?id=<s:property value="#entry.id" />','detailsWarehousingEntry','930','450')" />
									</form>
								</td>
							</tr>
						</s:iterator>
					</table>
				</div>
			</div>

		</div>
		
		<div id="footer">
		</div>
	</div>
	
</body>
</html>