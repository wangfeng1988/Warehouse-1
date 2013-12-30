<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
</head>

<body>
	<div id="select" class="tabactive">
	
		<h1>查询销售出库单</h1>

		<div id="content_head">
			<form action="#" method="post">
				<ul class="ul_nav">
					<li>关键字:<input type="text" name="DeliverysearchKey" /></li>
					<li>搜索类型: <select name="DeliverysearchType">
							<option value="制单日期" selected="selected">制单日期</option>
							<option value="单据号码">单据号码</option>
							<option value="发货仓库">发货仓库</option>
							<option value="客户名">客户名</option>
					</select>
					</li>
					<li><input type="button" value="搜索" class="search_delivery" /></li>
				</ul>
			</form>
		</div>

		<div id="content_table">
			<div id="table_head">
				<table>
					<tr>
						<th class="first">制单日期</th>
						<th>单据号码</th>
						<th>发货仓库</th>
						<th>客户名称</th>
						<th>合计数量</th>
						<th>合计金额</th>
						<th>备注</th>
						<th>详情</th>
					</tr>
				</table>
			</div>

			<div id="table_body">
				<table id="delivery_table">

				</table>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		/* 提交结果，执行ajax */
		function btn_search_delivery() {

			var $btn = $("input.search_delivery");
			$btn.bind("click", function() {
					
				var searchKey=$("input[name=DeliverysearchKey]").val();
				
				if(searchKey=="")
				{
					alert("请填写关键字");
					return false;
				}
				
				$.ajax({
					type : "post",
					url : "select_DeliveryOrder",
					data : 
					{
						searchKey : $("input[name=DeliverysearchKey]").val(),
						searchType : $("select[name=DeliverysearchType]").val() 
					},
					dataType : "json",
					success : function(data) {
						var d = eval("(" + data + ")");
						
						if(d["result"]=="")
						{
							alert("查询没有结果");
							return false;
						}
						
						$("#delivery_table").empty();
						
						$.each(d,function(i,result)
						{
							$.each(result,function(j,item)
							{
								var row="<tr><td>"+item['prepared_by_date']+"</td>"+"<td>"+item['document_number']+"</td>"+
								"<td>"+item['shipping_warehouse']+"</td>"+"<td>"+item['customer_name']+"</td>"+
								"<td>"+item['total_number']+"</td>"+"<td>"+item['total_money']+"</td>"+
								"<td>"+item['remark']+"</td>"+
								"<td><input type='button' value='详情' onclick=openFormWin('transferToDetDelivery.jsp?id="+item["id"]+"','detailsDeliveryOrder','930','500') /></td>"+
								"</tr>";
								
								$("#delivery_table").append(row);
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