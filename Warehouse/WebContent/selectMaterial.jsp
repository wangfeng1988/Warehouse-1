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

<title>选择物料</title>

</head>

<body>
	<div id="select" class="tabactive">
		<h1>查询物料单</h1>

		<div id="content_head">
			<form action="#" method="post">
				<ul class="ul_nav">
					<li>关键字:<input type="text" name="MaterialsearchKey" /></li>
					<li>搜索类型: <select name="MaterialsearchType">
							<option value="货品编码" selected="selected">货品编码</option>
							<option value="货品名称">货品名称</option>
					</select>
					</li>
					<li><input type="button" value="搜索" class="search_requisition" /></li>
				</ul>
			</form>
		</div>
		
		<div id="content_table">
			<div id="table_head">
				<table>
					<tr>
						<th class="first">货品编码</th>
						<th>货品名称</th>
						<th>货品规格</th>
						<th>单位</th>
						<th>入库单价</th>
						<th>销售单价</th>
						<th>入库数量</th>
						<th>现有数量</th>
						<th>入库金额</th>
						<th>备注</th>
					</tr>
				</table>
			</div>

			<div id="table_body">
				<table id="material_table">

				</table>
			</div>
		</div>	
	</div>
	
	<script type="text/javascript">
		/* 提交结果，执行ajax */
		function btn_search_material() {

			var $btn = $("input.search_requisition");
			$btn.bind("click", function() {
					
				$.ajax({
					type : "post",
					url : "select_Material",
					data : 
					{
						searchKey : $("input[name=MaterialsearchKey]").val(),
						searchType : $("select[name=MaterialsearchType]").val() 
					},
					dataType : "json",
					success : function(data) {
						var d = eval("(" + data + ")");
						
						$("#requisition_table").empty();
						
						$.each(d,function(i,result)
						{
							$.each(result,function(j,item)
							{
								var row="<tr><td>"+item['coding']+"</td>"+"<td>"+item['name']+"</td>"+
								"<td>"+item['specification']+"</td>"+"<td>"+item['unit']+"</td>"+
								"<td>"+item['warehousing_price']+"</td>"+"<td>"+item['sales_price']+"</td>"+"<td>"+item['amount']+"</td>"+
								"<td>"+item['stock']+"</td>"+"<td>"+item['money']+"</td>"+"<td>"+item['remark']+"</td>"+
								"</tr>";
								
								$("#material_table").append(row);
							});			
						});
					},
 					error : function() {
						alert("系统异常，请稍后重试！");
					}
				});
				
				return false;
			});
		}
	</script>
</body>
</html>