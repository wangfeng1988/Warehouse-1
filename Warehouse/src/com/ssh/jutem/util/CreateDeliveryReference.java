package com.ssh.jutem.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ssh.jutem.edit.dao.DeliveryOrderCollectDaoImp;
import com.ssh.jutem.edit.dao.DeliveryOrderDaoImp;
import com.ssh.jutem.edit.dao.IDeliveryOrderCollectDao;
import com.ssh.jutem.edit.dao.IDeliveryOrderDao;
import com.ssh.jutem.edit.model.DeliveryOrder;
import com.ssh.jutem.edit.model.DeliveryOrderCollect;
import com.ssh.jutem.edit.model.DeliveryOrderCollectDetail;

public class CreateDeliveryReference 
{
	public static boolean CreateCollectAndDetail(String year_month)
	{
		List<?> deliverys=deliveryDao.selectByYearMonth(year_month);
		
		/*上个月有入库单*/
		if(deliverys.size()!=0)
		{
			Set<DeliveryOrderCollectDetail> collectDetails=createCollectDetail(year_month,deliverys);
			DeliveryOrderCollect collect=createCollect(year_month,collectDetails);

			collectDao.add(collect);
			
			return true;
		}
		
		return false;
	}
	
	/*初始化明细表*/
	private static Set<DeliveryOrderCollectDetail> createCollectDetail(String year_month,List<?> deliverys)
	{
		System.out.println("this is selectDetial util");
		
		Set<DeliveryOrderCollectDetail> collectDetail=new HashSet<DeliveryOrderCollectDetail>();

		/*将entry根据供应商supplier进行归类*/
		for(Object e:deliverys)
		{
			DeliveryOrder delivery=(DeliveryOrder) e;
			int tag=0;
			
			/*已经存在*/
			for(DeliveryOrderCollectDetail detail:collectDetail)
			{
				if(detail.getCustomer_name().equals(delivery.getCustomer_name()))
				{
					detail.getDeliverys().add(delivery);
					detail.setTotal_money(detail.getTotal_money()+delivery.getTotal_money());
					break;
				}
				tag++;
			}
			
			/*还不存在*/
			if(tag==collectDetail.size())
			{
				DeliveryOrderCollectDetail rcd=new DeliveryOrderCollectDetail();
				rcd.setMaked_year_month(year_month);
				rcd.setCustomer_name(delivery.getCustomer_name());
				rcd.setTotal_money(delivery.getTotal_money());
				rcd.getDeliverys().add(delivery);
				collectDetail.add(rcd);
			}
		}
		
		return collectDetail;
	}
	
	/*初始化汇总表*/
	private static DeliveryOrderCollect createCollect(String year_month,Set<DeliveryOrderCollectDetail> deliverys_details)
	{
		DeliveryOrderCollect collect=new DeliveryOrderCollect();
		double total_money=0;
		
		for(DeliveryOrderCollectDetail ed:deliverys_details)
			total_money=total_money+ed.getTotal_money();

		collect.setMaked_year_month(year_month);
		collect.setTotal_money(total_money);
		collect.setDeliverysdetail(deliverys_details);
		
		return collect;
	}
	
	private final static IDeliveryOrderCollectDao collectDao=new DeliveryOrderCollectDaoImp();
	private final static IDeliveryOrderDao deliveryDao=new DeliveryOrderDaoImp();
}
