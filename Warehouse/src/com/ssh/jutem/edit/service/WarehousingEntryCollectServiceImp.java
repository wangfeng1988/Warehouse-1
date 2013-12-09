package com.ssh.jutem.edit.service;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.ssh.jutem.edit.dao.IWarehousingEntryCollectDao;
import com.ssh.jutem.edit.model.WarehousingEntryCollect;

public class WarehousingEntryCollectServiceImp implements IWarehousingEntryCollectService 
{	
	public WarehousingEntryCollectServiceImp()
	{
		super();
	}
	
	@Override
	public List<WarehousingEntryCollect> select(String searchKey, String searchType) 
	{
		System.out.println("This is selec entry service");
		
		List<?> temp_all=selectAll();
		List<WarehousingEntryCollect> result=new ArrayList<WarehousingEntryCollect>();
		
		/*依次为按月份查询进行搜索*/
		if(searchType.equals(SEARCH_TYPES[0]))
		{
			System.out.println("searchType=1");
			for(Object entryCollect:temp_all)
			{
				if(((WarehousingEntryCollect) entryCollect).getMaked_year_month().equals(searchKey))
					result.add((WarehousingEntryCollect) entryCollect);
			}
		}
		return result;
	}

	@Override
	/*因为用了延迟加载所以这里不用缓存里的数据*/
	public WarehousingEntryCollect selectDetial(int id) 
	{	
		System.out.println("this is selectDetial service");
		return (WarehousingEntryCollect) entryCollectDao.selectById(id);
	}
	
	private List<?> selectAll() 
	{
		if(!isCache)
		{
			System.out.println("not cache");
			
			allOfEntryCollect=entryCollectDao.selectAll();
			isCache=true;	
		}
		else
		{
			System.out.println("cache");
		}
		
		return allOfEntryCollect;
	}
	
	/*get(),set()*/
	public IWarehousingEntryCollectDao getEntryCollectDao() {
		return entryCollectDao;
	}

	public void setEntryCollectDao(IWarehousingEntryCollectDao entryCollectDao) {
		this.entryCollectDao = entryCollectDao;
	}
	
	/*entry cache*/
	private static List<?> allOfEntryCollect;
	private static boolean isCache=false;
	
	@Resource
	private IWarehousingEntryCollectDao entryCollectDao;
	
	/*验证常量*/
	private static final String[] SEARCH_TYPES={"制单年月"};

}
