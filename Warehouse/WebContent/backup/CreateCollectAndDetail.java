package com.ssh.jutem.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimerTask;

import com.ssh.jutem.edit.dao.IWarehousingEntryCollectDao;
import com.ssh.jutem.edit.dao.IWarehousingEntryDao;
import com.ssh.jutem.edit.dao.WarehousingEntryCollectDaoImp;
import com.ssh.jutem.edit.dao.WarehousingEntryDaoImp;
import com.ssh.jutem.edit.model.WarehousingEntry;
import com.ssh.jutem.edit.model.WarehousingEntryCollect;
import com.ssh.jutem.edit.model.WarehousingEntryCollectDetail;

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
			
			List<?> entrys=entryDao.selectByYearMonth(year_month);
			
			/*上个月有入库单*/
			if(entrys.size()!=0)
			{
				Set<WarehousingEntryCollectDetail> collectDetails=createCollectDetail(year_month,entrys);
				WarehousingEntryCollect collect=createCollect(year_month,collectDetails);

				collectDao.add(collect);
			}

		}
		
		System.out.println(new Date(System.currentTimeMillis()));
	}
	
	/*初始化明细表*/
	private Set<WarehousingEntryCollectDetail> createCollectDetail(String year_month,List<?> entrys)
	{
		System.out.println("this is selectDetial util");
		
		Set<WarehousingEntryCollectDetail> collectDetail=new HashSet<WarehousingEntryCollectDetail>();

		/*将entry根据供应商supplier进行归类*/
		for(Object e:entrys)
		{
			WarehousingEntry entry=(WarehousingEntry) e;
			int tag=0;
			
			/*已经存在*/
			for(WarehousingEntryCollectDetail detail:collectDetail)
			{
				if(detail.getSupplier().equals(entry.getSupplier()))
				{
					detail.getEntrys().add(entry);
					detail.setTotal_money(detail.getTotal_money()+entry.getTotal_money());
					break;
				}
				tag++;
			}
			
			/*还不存在*/
			if(tag==collectDetail.size())
			{
				WarehousingEntryCollectDetail ecd=new WarehousingEntryCollectDetail();
				ecd.setMaked_year_month(year_month);
				ecd.setSupplier(entry.getSupplier());
				ecd.setTotal_money(entry.getTotal_money());
				ecd.getEntrys().add(entry);
				collectDetail.add(ecd);
			}
		}
		
		return collectDetail;
	}
	
	/*初始化汇总表*/
	private WarehousingEntryCollect createCollect(String year_month,Set<WarehousingEntryCollectDetail> entrys_details)
	{
		WarehousingEntryCollect collect=new WarehousingEntryCollect();
		double total_money=0;
		
		for(WarehousingEntryCollectDetail ed:entrys_details)
			total_money=total_money+ed.getTotal_money();

		collect.setMaked_year_month(year_month);
		collect.setTotal_money(total_money);
		collect.setEntrysdetail(entrys_details);
		
		return collect;
	}
	
	
	private IWarehousingEntryCollectDao collectDao=new WarehousingEntryCollectDaoImp();
	private IWarehousingEntryDao entryDao=new WarehousingEntryDaoImp();
	
}
