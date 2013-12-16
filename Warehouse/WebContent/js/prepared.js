function load(tag)
{
	var date=new Date();
	var day = date.getDate();//查询日期（1-31）
	var month = date.getMonth();//查询月份（0-11）
	var year = date.getFullYear();//查询年份
	
	//格式处理
	if(day<10)
		day="0"+day;
	if(month<9)
		month="0"+(month+1);
	else 
		month=month+1;
	document.getElementById("prepared_date").value=year+"-"+month+"-"+day;
	
	/*初始化左边导航兰状态*/
	switch(tag)
	{
	case '1':
		document.getElementById("form").getElementsByTagName("li")[0].setAttribute("id","selected");
		break;
	case '2':
		document.getElementById("form").getElementsByTagName("li")[1].setAttribute("id","selected");
		break;
	default:
		break;
	}
}