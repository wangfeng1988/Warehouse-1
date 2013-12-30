<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
</head>

<body>

	<div id="add" class="tabhidden">
	
		<h1>添加销售出库单</h1>

		<form id="my_delivery" action="add_DeliveryOrder" method="post">
			<div id="form_information">
				<ul class="ul_nav">
					<li>制单日期：<input type="text" id="prepared_date" name="deliveryBean.prepared_by_date" readonly="readonly" /></li>
					<li>单据号码：<input type="text" name="deliveryBean.document_number" /></li>
					<li>发货仓库：<input type="text" name="deliveryBean.shipping_warehouse" /></li>
					<li>客户名称：<input type="text" name="deliveryBean.customer_name" /></li>
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
							<th>入库单价</th>
							<th>销售单价</th>
							<th>需求数量</th>
							<th>金额</th>
							<th>备注</th>
						</tr>
					</table>
				</div>
				<div id="table_body">
					<table id="goal">

					</table>
				</div>
			</div>
			
			<div id="content_foot">
				<ul class="content_foot_button">
					<li><input type="button" name="Submit" value="删除"
						onclick="javascript:DelRow();" /></li>
					<li><input type="button" name="Submit" value="查询"
						onclick="openFormWin('selectMatForForm.jsp','selectMatForForm','930','450');" /></li>
				</ul>
				<ul class="ul_nav content_foot_ul">
					<li>合计金额:<input type="text" name="deliveryBean.total_money" /></li>
					<li>数量小计:<input type="text" name="deliveryBean.total_number" /></li>
				</ul>
				<input type="button" value="提交" class="submit_delivery"/>
			</div>

		</form>
	</div>
	
	 <script type="text/javascript">
		/* 提交结果，执行ajax */
		function btn_submit_delivery() {

			var $btn = $("input.submit_delivery");
			$btn.bind("click", function() {
				var goal_table =document.getElementById("goal");
				
				/*设置需求数量，金额，物料id*/
				for(var i=0;i<goal_table.rows.length;i++)
				{
					goal_table.rows[i].cells[7].getElementsByTagName('input')[0].setAttribute("name","deliveryMaterialBeans["+i+"].number");
					goal_table.rows[i].cells[8].getElementsByTagName('input')[0].setAttribute("name","deliveryMaterialBeans["+i+"].money");
					goal_table.rows[i].cells[10].getElementsByTagName('input')[0].setAttribute("name","materialBeans["+i+"].id");
				}
				
 				$('#my_delivery').ajaxSubmit(function (data) {
 					var d = eval("(" + data + ")");
 					alert(d["result"]);
 				});

 				return false;
			});
		}
	</script>
</body>
</html>