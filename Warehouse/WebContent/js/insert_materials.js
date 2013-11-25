/* 将搜索到的信息且被选择的数据插入到另一个表格 */
function insertMaterialsToReq()
{
	var source_table = document.getElementById("result_table");
	var goal_table = window.opener.document.getElementById("goal_table");
	var checkbox = document.all("box");

	alert(checkbox.length);
	
	/*没有删除一行的情况下，这么做*/
	for ( var i = 0; i < checkbox.length; i++) 
	{
		if (checkbox[i].checked == true)
		{
			//除标题行外，现有行数(添加行数之前)
			var rows=goal_table.rows.length-1;
			
			var newTr=goal_table.insertRow();
			var newTd0=newTr.insertCell();
			var newTd1=newTr.insertCell();
			var newTd2=newTr.insertCell();
			var newTd3=newTr.insertCell();
			var newTd4=newTr.insertCell();
			var newTd5=newTr.insertCell();
			var newTd6=newTr.insertCell();
			var newTd7=newTr.insertCell();
			
			/*依次为选择，货品编码，货品名称，单价，提取数量，金额，货品ID，货品现有数量*/
			newTd0.innerHTML='<input type=checkbox id="box1" />';
			newTd1.innerHTML=source_table.rows[i+1].cells[1].innerHTML;
			newTd2.innerHTML=source_table.rows[i+1].cells[2].innerHTML;
			newTd3.innerHTML=source_table.rows[i+1].cells[5].innerHTML;
			newTd4.innerHTML='<input type="hidden" name="requisitionMaterialBeans['+rows+'].number" value='+source_table.rows[i+1].cells[10].getElementsByTagName("input")[0].value+' readonly />';	
			newTd5.innerHTML=eval(newTd3.innerHTML*newTd4.getElementsByTagName("input")[0].value);
			newTd6.innerHTML='<input type="hidden" name="materialBeans['+rows+'].id" value='+source_table.rows[i+1].cells[11].getElementsByTagName('input')[0].value+' readonly />';
			newTd7.innerHTML='<input type="hidden" name="materialBeans['+rows+'].amount" value='+eval(source_table.rows[i+1].cells[7].innerHTML-newTd4.getElementsByTagName('input')[0].value)+' readonly />';
		}
	}
}