<%-- <%@ page language="java"
	import="java.util.*,com.page.wash.giveclothing.*" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加表格信息</title>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<script language="javascript" type="text/javascript">  
function AddRow()
{
 //添加一行
 var i =tab1.rows.length;
 var Nam="'div1'";
 var Cod="fuJ"+i;
 var newTr = tab1.insertRow();
 //添加列
 var newTd0 = newTr.insertCell();
 var newTd1 = newTr.insertCell();
 var newTd2 = newTr.insertCell();
 var newTd3 = newTr.insertCell();
 //设置列内容和属性
 newTd0.innerHTML = '<input type="checkbox" id="box1" onClick="GetRow()"/ /><input type="hidden" name="fuJ" id='+Cod+' />'; 
 newTd1.innerHTML = " 衣服尺码";
 newTd2.innerHTML = " 衣服花色";
 newTd3.innerHTML = " 处理类型";
}
function DelRow()
{
//删除一行
  var shu=0;
  var cheCou=document.all("box1");
   for(var i=0;i<cheCou.length;i++)
   {
    if (cheCou[i].checked==true)
    {
      shu++;
    }
   }
   if(shu==cheCou.length)
   {
     alert('最少要添加一件衣服');
     return;
   }
   else  if(shu==0)
   {
     alert('请选择你要删除的信息');
     return;
   }
   else if(shu==1)
   {
     for(var i=0;i<cheCou.length;i++)
     {
       if(cheCou[i].checked==true)
       {
        tab1.deleteRow(i+1);
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
         tab1.deleteRow(i+1);
         break;
        }
      }
     }
   }
}
function GetRow()
{
  //获得行索引
  //两个parentElement分别是TD和TR哟，rowIndex是TR的属性
  //this.parentElement.parentElement.rowIndex
  cGetRow=window.event.srcElement.parentElement.parentElement.rowIndex; 
}
</script>
</head>
<body>
	<form name="form1"
		action="${pageContext.request.contextPath}/giveClothing.do?method=FuJiaFei"
		method="post">
		<center>
			<fieldset>
				<legend>
					<strong>动态添加一行表格</strong>
				</legend>
				<input type=hidden id="hid" name="hid" / />
				<table id="tab1" align="center" border="1" cellPadding="4"
					cellSpacing="0" borderColorLight="#999999"
					borderColorDark="#ffffff" style="width: 95%; word-break: break-all">
					<thead>
						<tr>
							<th align="center" width="10%">选择</th>
							<th align="center" width="15%">衣服尺码</th>
							<th align="center" width="15%">衣服花色</th>
							<th align="center" width="15%">处理类别</th>
						</tr>
					</thead>
					<tr>
						<td><input type=checkbox id="box1" onClick="GetRow()" /> <input
							type="hidden" name="fuJ" id="fuJ1" /></td>
						<td>衣服尺码</td>
						<td>衣服花色</td>
						<td>处理类别</td>
					</tr>

				</table>
				<table align="center" border="1" cellPadding="4" cellSpacing="0"
					borderColorLight="#999999" borderColorDark="#ffffff"
					style="width: 95%; word-break: break-all">
					<tr>
						<td align="right"><input type="button" name="Submit"
							value="增加一行" onclick="javascript:AddRow();" /> <input
							type="button" name="Submit" value="删除一行"
							onclick="javascript:DelRow();" /></td>
					</tr>
				</table>
	</form>
</body>

</html>
 --%>