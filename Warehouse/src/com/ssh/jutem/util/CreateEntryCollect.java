package com.ssh.jutem.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.TimerTask;

import com.ssh.jutem.edit.dao.IWarehousingEntryCollectDao;
import com.ssh.jutem.edit.dao.IWarehousingEntryDao;
import com.ssh.jutem.edit.dao.WarehousingEntryCollectDaoImp;
import com.ssh.jutem.edit.dao.WarehousingEntryDaoImp;
import com.ssh.jutem.edit.model.WarehousingEntry;
import com.ssh.jutem.edit.model.WarehousingEntryCollect;

public class CreateEntryCollect extends TimerTask
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
			
			List<?> entrys=entryDao.selectByYearMonth(year_month);
			
			/*上个月有入库单*/
			if(entrys.size()!=0)
			{
				WarehousingEntryCollect collect=createCollect(year_month,entrys);
				collectDao.add(collect);
			}

		}
	
		System.out.println(new Date(System.currentTimeMillis()));
	}
	
	private WarehousingEntryCollect createCollect(String year_month,List<?> entrys)
	{
		WarehousingEntryCollect collect=new WarehousingEntryCollect();
		double total_money=0;
		List<WarehousingEntry> transfer_entrys=new ArrayList<WarehousingEntry>();
		
		for(Object e:entrys)
		{
			total_money=total_money+((WarehousingEntry)e).getTotal_money();
			transfer_entrys.add((WarehousingEntry)e);
		}

		collect.setMaked_year_month(year_month);
		collect.setTotal_money(total_money);
		collect.setEntrys(new HashSet<WarehousingEntry>(transfer_entrys));
		
		return collect;
	}
	
	private IWarehousingEntryCollectDao collectDao=new WarehousingEntryCollectDaoImp();
	private IWarehousingEntryDao entryDao=new WarehousingEntryDaoImp();
	
}
