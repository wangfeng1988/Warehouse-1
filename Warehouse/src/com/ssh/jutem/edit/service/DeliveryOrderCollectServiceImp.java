package com.ssh.jutem.edit.service;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.ssh.jutem.edit.dao.IDeliveryOrderCollectDao;
import com.ssh.jutem.edit.model.DeliveryOrderCollect;

public class DeliveryOrderCollectServiceImp implements IDeliveryOrderCollectService 
{	
	public DeliveryOrderCollectServiceImp()
	{
		super();
	}
	
	@Override
	public List<DeliveryOrderCollect> select(String searchKey, String searchType) 
	{
		System.out.println("This is select delivery service");
		
		List<?> temp_all=selectAll();
		List<DeliveryOrderCollect> result=new ArrayList<DeliveryOrderCollect>();
		
		/*依次为按月份查询进行搜索*/
		if(searchType.equals(SEARCH_TYPES[0]))
		{
			System.out.println("searchType=1");
			for(Object deliveryCollect:temp_all)
			{
				if(((DeliveryOrderCollect) deliveryCollect).getMaked_year_month().equals(searchKey))
					result.add((DeliveryOrderCollect) deliveryCollect);
			}
		}
		return result;
	}

	@Override
	/*因为用了延迟加载所以这里不用缓存里的数据*/
	public DeliveryOrderCollect selectDetial(int id) 
	{	
		System.out.println("this is selectDetial service");
		return (DeliveryOrderCollect) deliveryCollectDao.selectById(id);
	}
	
	private List<?> selectAll() 
	{
		if(!isCache)
		{
			System.out.println("not cache");
			
			allOfDeliveryCollect=deliveryCollectDao.selectAll();
			isCache=true;	
		}
		else
		{
			System.out.println("cache");
		}
		
		return allOfDeliveryCollect;
	}
	
	/*get(),set()*/
	public IDeliveryOrderCollectDao getDeliveryCollectDao() {
		return deliveryCollectDao;
	}

	public void setDeliveryCollectDao(IDeliveryOrderCollectDao deliveryCollectDao) {
		this.deliveryCollectDao = deliveryCollectDao;
	}
	
	/*requisition cache*/
	private static List<?> allOfDeliveryCollect;

	private static boolean isCache=false;
	
	@Resource
	private IDeliveryOrderCollectDao deliveryCollectDao;
	
	/*验证常量*/
	private static final String[] SEARCH_TYPES={"制单年月"};

}
