package com.ssh.jutem.edit.service;


import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import com.ssh.jutem.edit.dao.IWarehousingEntryCollectDao;
import com.ssh.jutem.edit.model.WarehousingEntry;
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
/*		System.out.println("This is selec entry service");
		
		List<?> temp_all=selectAll();
		List<WarehousingEntry> result=new ArrayList<WarehousingEntry>();
		
		依次为按月份查询进行搜索
		if(searchType.equals(SEARCH_TYPES[0]))
		{
			System.out.println("searchType=1");
			for(Object entry:temp_all)
			{
				if(((WarehousingEntry) entry).getPrepared_by_date().equals(searchKey))
					result.add((WarehousingEntry) entry);
			}
		}
		return result;*/
		return null;
	}

	@Override
	public WarehousingEntryCollect selectDetial(int id) 
	{	
/*		System.out.println("this is selectDetial service");
		return (WarehousingEntry) entryDao.selectById(id);*/
		return null;
	}
	
	private List<?> selectAll() 
	{
/*		if(!isCache)
		{
			System.out.println("not cache");
			
			allOfEntry=entryDao.selectAll();
			isCache=true;	
		}
		else
		{
			System.out.println("cache");
		}
		
		return allOfEntry;*/
		return null;
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
	private static final String[] SEARCH_TYPES={"月份"};

}
