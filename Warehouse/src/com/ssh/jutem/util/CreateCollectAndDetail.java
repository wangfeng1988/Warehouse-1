package com.ssh.jutem.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

public class CreateCollectAndDetail extends TimerTask
{
	@Override
	public void run() 
	{
		Calendar today=Calendar.getInstance();
		
		/*如果为一号就生成上一个月的入库单汇总表*/
		if(today.get(Calendar.DAY_OF_MONTH)==1)
		{	
			System.out.println("this is  create");
			
			int last_year=today.get(Calendar.YEAR);
			int last_month=today.get(Calendar.MONTH);//0-11
			/*如果为一月就生成去年十二月的汇总表*/
			if(today.get(Calendar.MONTH)==0)
			{
				last_year=last_year-1;
				last_month=12;
			}
			
			/*拼装日期字符串*/
			String year_month=Integer.toString(last_year);
			if(last_month<10)
				year_month=year_month+"-0"+Integer.toString(last_month);
			else
				year_month=year_month+"-"+Integer.toString(last_month);
			
			System.out.println(year_month);
			
			if(CreateEntryReference.CreateCollectAndDetail(year_month))
				System.out.println("create entry collect and detail success");
			if(CreateRequisitionReference.CreateCollectAndDetail(year_month))
				System.out.println("create requisition collect and detail success");
		}
			
		System.out.println(new Date(System.currentTimeMillis()));
	}
}
