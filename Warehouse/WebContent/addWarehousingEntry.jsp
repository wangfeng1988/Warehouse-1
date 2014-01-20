<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
</head>

<body>
	<div id="add" class="tabhidden">
	
		<h1>添加收货入库单</h1>

		<form action="add_WarehousingEntry" method="post" id="my_entry">
			<div id="content_head">
				<ul class="ul_nav">
					<li>制单日期：<input type="text" id="prepared_date" name="entryBean.prepared_by_date" readonly="readonly" /></li>
					<li>单据号码：<input type="text" name="entryBean.document_number" /></li>
					<li>原始单号：<input type="text" name="entryBean.original_invoice_number" /></li>
					<li>进货仓库：<input type="text" name="entryBean.shipping_warehouse" /></li>
					<li>供应商&nbsp;&nbsp;&nbsp;：<input type="text" name="entryBean.supplier" /></li>
				</ul>
			</div>
			<div id="content_table">
				<div id="table_head">
					<table>
						<tr>
							<th class="first short" >选择</th>
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
					</table>
				</div>
				<div id="table_body">
					<table id="goal">
						<tr>
							<td class="short"><input type=checkbox name="box" /></td>
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
					<li><input type="button" name="Submit" value="增加"
						onclick="javascript:AddRow();" /></li>
				</ul>
				<ul class="ul_nav content_foot_ul">
					<li>合计金额:<input type="text" name="entryBean.total_money" /></li>
					<li>数量小计:<input type="text" name="entryBean.total_number" /></li>
				</ul>
				<input type="button" value="提交" class="submit_entry"/>
			</div>

		</form>
	</div>
	
 	<script type="text/javascript">
		/* 提交结果，执行ajax */
		function btn_submit_entry() {
			
			var $btn = $("input.submit_entry");
			$btn.bind("click", function() {

/* 				if(!validate_form($('#my_entry')))
				{
					alert("请输入完整信息");
					return false;
				}  */
				
  				$("#my_entry").ajaxSubmit(function (data) {
 					var d = eval("(" + data + ")");
 					alert(d["result"]);
 				}); 
				
				return false;
			});
		}
		
/* 
		 function validate_form(thisform)
		{
			with (thisform)
			{
				
				if(!validate_required("entryBean.document_number"))
				{
					alert("aaa");
					return false;
				}

				if(!validate_required("entryBean.original_invoice_number"))
				{
					alert("bb");
					return false;
				}
				if(!validate_required("entryBean.shipping_warehouse"))
				{
					alert("cc");
					return false;
				}		
				if(!validate_required("entryBean.supplier"))
				{
					alert("dd");
					return false;
				}
				if(!validate_required("entryBean.total_money"))
				{
					alert("ee");
					return false;
				}
				if(!validate_required("entryBean.total_number"))
				{
					alert("ff");
					return false;
				}

			}
		}
		
		function validate_required(field)
		{
			alert("hello");
			with(field)
			{
				alert("in");
				if(field.value==null || field.value=="")
				{
					alert("out");
					return false;
				}
				else
					return true;
			}
		} */
	</script>
	
</body>
</html>


