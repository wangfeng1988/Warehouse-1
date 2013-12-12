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
			<!-- "select_WarehousingEntryCollect" -->
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
				<table>
					<s:iterator value="result" id="entryCollect" status="index">
						<tr>
							<td><s:property value="#entryCollect.maked_year_month" /></td>
							<td><s:property value="#entryCollect.total_money" /></td>
							<td>
								<form>
									<input type="submit" value="详情"
										onclick="openFormWin('transferToDetEntryCollect.jsp'+'?id=<s:property value="#entryCollect.id" />','detailsWarehousingEntryCollect','930','450')" />
								</form>
							</td>

							<td>
								<form>
									<input type="submit" value="明细"
										onclick="openFormWin('transferToDetEntryCollectDetail.jsp'+'?id=<s:property value="#entryCollect.id" />','detailsWarehousingEntryCollectDetail','930','450')" />
								</form>
							</td>
						</tr>
					</s:iterator>
				</table>
			</div>			
		</div>
		
		<input type="text" id="test" />
	</div>

	<script type="text/javascript">
		/* 提交结果，执行ajax */
		function btn() {

			var $btn = $("input.search_collect");
			$btn.bind("click", function() {
				
				alert($("input[name=CollectsearchKey]").val());
				alert($("select[name=CollectsearchType]").val());
						
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
						
						alert(""+d.result[0].id+"");
						
						/* $("#test").text(""+d.result+""); */
						
/* 						$("#s_name").text("" + d.name + "");
						$("#s_age").text("" + d.age + "");
						$("#s_position").text("" + d.position + ""); */

					},
 					error : function() {
						alert("系统异常，请稍后重试！");
					}
				});
				
				return false;
			});
		}

		/* 页面加载完成，绑定事件 */
		$(document).ready(function() {
			btn();
		});
	</script>
	
</body>
</html>