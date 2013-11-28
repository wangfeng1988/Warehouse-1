/*使用strustBean，提交表单*/
function makeRequisition()
{
	var goal_table =document.getElementById("goal_table");
	
	/*设置需求数量，金额，物料id*/
	for(var i=1;i<goal_table.rows.length;i++)
	{
		goal_table.rows[i].cells[6].innerHTML="<input name='requisitionMaterialBeans["+(i-1)+"].number' value='"+goal_table.rows[i].cells[6].innerHTML+"' />";
		goal_table.rows[i].cells[7].innerHTML="<input name='requisitionMaterialBeans["+(i-1)+"].money' value='"+goal_table.rows[i].cells[7].innerHTML+"' />";
		goal_table.rows[i].cells[9].innerHTML="<input name='materialBeans["+(i-1)+"].id' value='"+goal_table.rows[i].cells[9].getElementsByTagName('input')[0].value+"' />";
	}
	
	document.getElementById("requisition_form").submit;
}
