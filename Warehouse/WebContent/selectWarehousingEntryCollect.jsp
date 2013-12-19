<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
</head>

<body>
	<div id="collect" class="tabhidden">
	
		<h1>查询收货入库单汇总</h1>
		
		<div id="content_head">
			<form action="#" method="post">
				<ul class="ul_nav">
					<li>关键字:<input type="text" name="CollectsearchKey" /></li>
					<li>搜索类型:<select name="CollectsearchType">
							<option value="制单年月" selected="selected">制单年月</option>
					</select>
					</li>
					<li><input type="button" value="搜索" class="search_collect" /></li>
				</ul>
			</form>
		</div>

		<div id="content_table">
			<div id="table_head">
				<table>
					<tr>
						<th>制单年月</th>
						<th>合计金额</th>
						<th>详情</th>
						<th>明细</th>
					</tr>
				</table>
			</div>
			
			<div id="table_body">
				<table id="collect_table">

				</table>
			</div>			
		</div>
	</div>

	<script type="text/javascript">
		/* 提交结果，执行ajax */
		function btn_collect() {

			var $btn = $("input.search_collect");
			$btn.bind("click", function() {
						
				$.ajax({
					type : "post",
					url : "select_WarehousingEntryCollect",
					data : 
					{
						searchKey : $("input[name=CollectsearchKey]").val(),
						searchType : $("select[name=CollectsearchType]").val() 
					},
					dataType : "json",
					success : function(data) {
						var d = eval("(" + data + ")");
						
						$("#collect_table").empty();
						
						$.each(d,function(i,result)
						{
							$.each(result,function(j,item)
							{
								var row="<tr><td>"+item['maked_year_month']+"</td>"+"<td>"+item['total_money']+"</td>"+
								"<td><input type='button' value='详情' onclick=openFormWin('transferToDetEntryCollect.jsp?id="+item["id"]+"','detailsWarehousingEntryCollect','930','500') /></td>"+
								"<td><input type='button' value='明细' onclick=openFormWin('transferToDetEntryCollectDetail.jsp?id="+item["id"]+"','detailsWarehousingEntryCollectDetail','930','500') /></td>"+
								"</tr>";
								
								$("#collect_table").append(row);
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