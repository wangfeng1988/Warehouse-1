package com.ssh.jutem.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ssh.jutem.edit.dao.IMaterialsRequisitionCollectDao;
import com.ssh.jutem.edit.dao.IMaterialsRequisitionDao;
import com.ssh.jutem.edit.dao.MaterialsRequisitionCollectDaoImp;
import com.ssh.jutem.edit.dao.MaterialsRequisitionDaoImp;
import com.ssh.jutem.edit.model.MaterialsRequisition;
import com.ssh.jutem.edit.model.MaterialsRequisitionCollect;
import com.ssh.jutem.edit.model.MaterialsRequisitionCollectDetail;

public class CreateRequisitionReference 
{
	public static boolean CreateCollectAndDetail(String year_month)
	{
		List<?> requisitions=requisitionDao.selectByYearMonth(year_month);
		
		/*上个月有入库单*/
		if(requisitions.size()!=0)
		{
			Set<MaterialsRequisitionCollectDetail> collectDetails=createCollectDetail(year_month,requisitions);
			MaterialsRequisitionCollect collect=createCollect(year_month,collectDetails);

			collectDao.add(collect);
			
			return true;
		}
		
		return false;
	}
	
	/*初始化明细表*/
	private static Set<MaterialsRequisitionCollectDetail> createCollectDetail(String year_month,List<?> requisitions)
	{
		System.out.println("this is selectDetial util");
		
		Set<MaterialsRequisitionCollectDetail> collectDetail=new HashSet<MaterialsRequisitionCollectDetail>();

		/*将entry根据供应商supplier进行归类*/
		for(Object e:requisitions)
		{
			MaterialsRequisition requisition=(MaterialsRequisition) e;
			int tag=0;
			
			/*已经存在*/
			for(MaterialsRequisitionCollectDetail detail:collectDetail)
			{
				if(detail.getRequisition_unit().equals(requisition.getRequisition_unit()))
				{
					detail.getRequisitions().add(requisition);
					detail.setTotal_money(detail.getTotal_money()+requisition.getTotal_money());
					break;
				}
				tag++;
			}
			
			/*还不存在*/
			if(tag==collectDetail.size())
			{
				MaterialsRequisitionCollectDetail rcd=new MaterialsRequisitionCollectDetail();
				rcd.setMaked_year_month(year_month);
				rcd.setRequisition_unit(requisition.getRequisition_unit());
				rcd.setTotal_money(requisition.getTotal_money());
				rcd.getRequisitions().add(requisition);
				collectDetail.add(rcd);
			}
		}
		
		return collectDetail;
	}
	
	/*初始化汇总表*/
	private static MaterialsRequisitionCollect createCollect(String year_month,Set<MaterialsRequisitionCollectDetail> requisitions_details)
	{
		MaterialsRequisitionCollect collect=new MaterialsRequisitionCollect();
		double total_money=0;
		
		for(MaterialsRequisitionCollectDetail ed:requisitions_details)
			total_money=total_money+ed.getTotal_money();

		collect.setMaked_year_month(year_month);
		collect.setTotal_money(total_money);
		collect.setRequisitionsdetail(requisitions_details);
		
		return collect;
	}
	
	private final static IMaterialsRequisitionCollectDao collectDao=new MaterialsRequisitionCollectDaoImp();
	private final static IMaterialsRequisitionDao requisitionDao=new MaterialsRequisitionDaoImp();
}
