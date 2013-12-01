package com.ssh.jutem.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ssh.jutem.edit.dao.IWarehousingEntryCollectDao;
import com.ssh.jutem.edit.dao.IWarehousingEntryDao;
import com.ssh.jutem.edit.dao.WarehousingEntryCollectDaoImp;
import com.ssh.jutem.edit.dao.WarehousingEntryDaoImp;
import com.ssh.jutem.edit.model.WarehousingEntry;
import com.ssh.jutem.edit.model.WarehousingEntryCollect;
import com.ssh.jutem.edit.model.WarehousingEntryCollectDetail;

public class CreateEntryReference 
{
	public static boolean CreateCollectAndDetail(String year_month)
	{
		List<?> entrys=entryDao.selectByYearMonth(year_month);
		
		/*上个月有入库单*/
		if(entrys.size()!=0)
		{
			Set<WarehousingEntryCollectDetail> collectDetails=createCollectDetail(year_month,entrys);
			WarehousingEntryCollect collect=createCollect(year_month,collectDetails);

			collectDao.add(collect);
			
			return true;
		}
		
		return false;
	}
	
	/*初始化明细表*/
	private static Set<WarehousingEntryCollectDetail> createCollectDetail(String year_month,List<?> entrys)
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
	private static WarehousingEntryCollect createCollect(String year_month,Set<WarehousingEntryCollectDetail> entrys_details)
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
	
	private final static IWarehousingEntryCollectDao collectDao=new WarehousingEntryCollectDaoImp();
	private final static IWarehousingEntryDao entryDao=new WarehousingEntryDaoImp();
}
