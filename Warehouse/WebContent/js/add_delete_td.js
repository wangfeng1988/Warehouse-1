/*deleteRow 存在bug：
 * 当只剩最后一行时
 * 不能正确提示最少要有一件货物
 * 错误提示为请选择你要删除的信息
 * */
function AddRow()
{
 // 添加一行
 var table=document.getElementById("material"); 
 // 除标题外的行数
 var rows=table.rows.length; 

 var newTr = table.insertRow();
 // 添加列
 
 var newTd0 = newTr.insertCell();
 var newTd1 = newTr.insertCell();
 var newTd2 = newTr.insertCell();
 var newTd3 = newTr.insertCell();
 var newTd4 = newTr.insertCell();
 var newTd5 = newTr.insertCell();
 var newTd6 = newTr.insertCell();
 var newTd7 = newTr.insertCell();
 var newTd8 = newTr.insertCell();
 var newTd9 = newTr.insertCell();

 // 设置列内容和属性
 newTd0.innerHTML = '<input type=checkbox name="box1" />';
 newTd1.innerHTML = '<input type="text" name="materialBeans['+rows+'].coding" />';
 newTd2.innerHTML = '<input type="text" name="materialBeans['+rows+'].name" />';
 newTd3.innerHTML = '<input type="text" name="materialBeans['+rows+'].specification" />';
 newTd4.innerHTML = '<input type="text" name="materialBeans['+rows+'].unit" />';
 newTd5.innerHTML = '<input type="text" name="materialBeans['+rows+'].warehousing_price" />';
 newTd6.innerHTML = '<input type="text" name="materialBeans['+rows+'].sales_price" />';
 newTd7.innerHTML = '<input type="text" name="materialBeans['+rows+'].amount" />';
 newTd8.innerHTML = '<input type="text" name="materialBeans['+rows+'].money" />';
 newTd9.innerHTML = '<input type="text" name="materialBeans['+rows+'].remark" />';
}

function DelRow()
{
//删除一行
  var table=document.getElementById("material");
  var shu=0;
  var cheCou=document.getElementsByName("box1");/*all("box1");*/
  
   for(var i=0;i<cheCou.length;i++)
   {
    if (cheCou[i].checked==true)
    {
      shu++;
    }
   }
   if(shu==cheCou.length)
   {
     alert('最少要有一件货物');
     
     alert(shu);
     alert(cheCou.length);
     return;
   }
   else  if(shu==0)
   {
     alert('请选择你要删除的信息');
     
     alert(shu);
     alert(cheCou.length);
     return;
   }
   else if(shu==1)
   {
     for(var i=0;i<cheCou.length;i++)
     {
       if(cheCou[i].checked==true)
       {
        table.deleteRow(i);
       }
     }
   }
   else if(shu>1)
   {
     for(var a=0;a<shu;a++)
     {
         for(var i=0;i<cheCou.length;i++)
      {
        if(cheCou[i].checked==true)
        {
         table.deleteRow(i);
         break;
        }
      }
     }
   }
   table.getElementsByTagName("tr")[0].getElementsByTagName("td")[0].setAttribute("class","short");
}