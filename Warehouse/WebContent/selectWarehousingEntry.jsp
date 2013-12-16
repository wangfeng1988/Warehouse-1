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
			<form action="#" method="post">
				<ul class="ul_nav">
					<li>关键字:<input type="text" name="EntrysearchKey" /></li>
					<li>搜索类型: <select name="EntrysearchType">
							<option value="制单日期" selected="selected">制单日期</option>
							<option value="单据号码">单据号码</option>
							<option value="原始单号">原始单号</option>
							<option value="进货仓库">进货仓库</option>
							<option value="供应商">供应商</option>
					</select>
					</li>
					<li><input type="button" value="搜索" class="search_entry" /></li>
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
				<table id="entry_table">
				
				</table>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		/* 提交结果，执行ajax */
		function btn_search_entry() {

			var $btn = $("input.search_entry");
			$btn.bind("click", function() {
					
				$.ajax({
					type : "post",
					url : "select_WarehousingEntry",
					data : 
					{
						searchKey : $("input[name=EntrysearchKey]").val(),
						searchType : $("select[name=EntrysearchType]").val() 
					},
					dataType : "json",
					success : function(data) {
						var d = eval("(" + data + ")");
						
						$("#entry_table").empty();
						
						$.each(d,function(i,result)
						{
							$.each(result,function(j,item)
							{
								var row="<tr><td>"+item['prepared_by_date']+"</td>"+"<td>"+item['document_number']+"</td>"+
								"<td>"+item['original_invoice_number']+"</td>"+"<td>"+item['shipping_warehouse']+"</td>"+
								"<td>"+item['supplier']+"</td>"+"<td>"+item['total_number']+"</td>"+"<td>"+item['total_money']+"</td>"+
								"<td><input type='button' value='详情' onclick=openFormWin('transferToDetEntry.jsp?id="+item["id"]+"','detailsWarehousing','930','500') /></td>"+
								"</tr>";
								
								$("#entry_table").append(row);
							});			
						});
						/*重新加载tablecloth*/
/* 						window.onload = tablecloth;
						alert("hello"); */
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
