/* 将搜索到的信息且被选择的数据插入到另一个表格 
 * source_table隐藏了一行，用来声明box
 * */
function insertMaterialsToReq()
{
	var source_table = document.getElementById("result_table");
	var goal_table = window.opener.document.getElementById("goal_table");
	var checkbox = document.all("box");
	
	/*没有删除一行的情况下，这么做*/
	for ( var i = 0; i < checkbox.length; i++) 
	{
		if (checkbox[i].checked == true)
		{	
			/*检测goal_table中是否已经存在这个物料*/
			var j=1;
			for(;j<goal_table.rows.length;j++)
			{
				/*如果goal已经有source中要添加的物料，就修改goal中已经存在的物料的需求数量和金额*/
				if(eval(goal_table.rows[j].cells[9].getElementsByTagName('input')[0].value-source_table.rows[i].cells[10].getElementsByTagName('input')[0].value)==0)
				{
					goal_table.rows[j].cells[6].innerHTML=eval(goal_table.rows[j].cells[6].innerHTML+"+"+source_table.rows[i].cells[9].getElementsByTagName('input')[0].value);
					goal_table.rows[j].cells[7].innerHTML=eval(goal_table.rows[j].cells[5].innerHTML*goal_table.rows[j].cells[6].innerHTML);
					break;
				}
			}

			if(j==goal_table.rows.length)
			{
				var newTr=goal_table.insertRow();
				var newTd0=newTr.insertCell();
				var newTd1=newTr.insertCell();
				var newTd2=newTr.insertCell();
				var newTd3=newTr.insertCell();
				var newTd4=newTr.insertCell();
				var newTd5=newTr.insertCell();
				var newTd6=newTr.insertCell();
				var newTd7=newTr.insertCell();
				var newTd8=newTr.insertCell();
				var newTd9=newTr.insertCell();
				
				/*依次为选择，货品编码，货品名称，货品规格,单位,单价，需求数量，金额，备注，货品ID*/
				newTd0.innerHTML='<input type="checkbox" id="box" />';
				newTd1.innerHTML=source_table.rows[i].cells[1].innerHTML;
				newTd2.innerHTML=source_table.rows[i].cells[2].innerHTML;
				newTd3.innerHTML=source_table.rows[i].cells[3].innerHTML;
				newTd4.innerHTML=source_table.rows[i].cells[4].innerHTML;
				newTd5.innerHTML=source_table.rows[i].cells[5].innerHTML;
				newTd6.innerHTML=source_table.rows[i].cells[9].getElementsByTagName('input')[0].value;
				newTd7.innerHTML=eval(newTd6.innerHTML*newTd5.innerHTML);
				newTd8.innerHTML=source_table.rows[i].cells[8].innerHTML;
				newTd9.innerHTML="<input value="+source_table.rows[i].cells[10].getElementsByTagName('input')[0].value+" />";
			}
			
			/*更新现在的库存*/
			source_table.rows[i].cells[7].innerHTML=eval(source_table.rows[i].cells[7].innerHTML-source_table.rows[i].cells[9].getElementsByTagName('input')[0].value);
		}
	}
}

/*一次删除多行还不行
 * checkbox.length和table.rows的长度动态变化
 * 删除完成后修改查询物料页面的值无法完成，因为在打开新窗口的情况下
 * 无法确认哪个窗口为需要修改的子窗口
 * 所以需要稍微修改方案
 * */
function delMaterial()
{
	var goal_table=document.getElementById("goal_table");
	var checkbox=document.all("box");
	var checked=0;
	/*删除选中行*/
	for(var i=0;i<checkbox.length;i++)
	{
		if(checkbox[i].checked==true)
			checked++;
	}
	for(var j=0;j<checked;j++)
	{
		for(var i=0;i<checkbox.length;i++)
		{
			if(checkbox[i].checked==true)
			{
				goal_table.deleteRow(i);
				break;
			}
		}
	}
	
	
}

function submitSearch()
{
	document.getElementById("select_form").commit;
}

/*搜索以后修正stock*/
function checkStock()
{
	var source_table = document.getElementById("result_table");
	var goal_table = window.opener.document.getElementById("goal_table");
	
	alert("hello123");
	alert(source_table.rows.length);
	/*检测是否已经添加过该物料*/
	for(var i=0;i<source_table.rows.length;i++)
		for(var j=0;j<goal_table.rows.length;j++)
		{
			/*比较id,相同就修改stock*/
			if(eval(goal_table.rows[j].cells[9].getElementsByTagName('input')[0].value-source_table.rows[i].cells[10].getElementsByTagName('input')[0].value)==0)
			{
				alert("hello2");
				source_table.rows[i].cells[7].innerHTML=eval(source_table.rows[i].cells[7].innerHTML-goal_table.rows[j].cells[6].innerHTML);
			}			
		}
}