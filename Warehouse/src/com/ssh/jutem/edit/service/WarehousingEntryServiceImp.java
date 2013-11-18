package com.ssh.jutem.edit.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import com.ssh.jutem.edit.dao.IWarehousingEntryDao;
import com.ssh.jutem.edit.model.Material;
import com.ssh.jutem.edit.model.WarehousingEntry;

public class WarehousingEntryServiceImp implements IWarehousingEntryService 
{	
	public WarehousingEntryServiceImp()
	{
		super();
	}
	
	@Override
	public boolean add(WarehousingEntry entryBean, List<Material> materialBeans)
	{
		System.out.println("This is warehousing entry add service");
		
		/*设置实体之间的导航*/
		entryBean.setMaterials(new HashSet<Material>(materialBeans));
		for(Material m:entryBean.getMaterials())
		{
			/*在页面中添加删除行的时候可能会导致带之前下标项被删除，导致出现空项*/
			if(m==null)
				continue;
			m.setEntry(entryBean);
		}
		
		entryDao.add(entryBean);
		
		/*添加完以后，如果要查询则再从数据库查询*/
		isCache=false;
		/*添加入库单会改变物料表，所以修改物料表缓存状态*/
		MaterialServiceImp.setCache(false);
		
		return false;
	}

	@Override
	public boolean delete(WarehousingEntry warehousing_entry) 
	{
		System.out.println("This is warehousing entry delete service");
		entryDao.delete(warehousing_entry);
		return false;
	}

	@Override
	public boolean modify(
			com.ssh.jutem.edit.model.WarehousingEntry warehousing_entry) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<WarehousingEntry> select(String searchKey, String searchType) 
	{
		System.out.println("This is selec entry service");
		
		List<?> temp_all=selectAll();
		List<WarehousingEntry> result=new ArrayList<WarehousingEntry>();
		
		/*依次为按制单时间，单据号码，原始单号，进货仓库，供应商进行搜索*/
		if(searchType.equals(SEARCH_TYPES[0]))
		{
			System.out.println("searchType=1");
			for(Object entry:temp_all)
			{
				if(((WarehousingEntry) entry).getPrepared_by_date().equals(searchKey))
					result.add((WarehousingEntry) entry);
			}
		}
		/*单据号码唯一，所以break*/
		else if(searchType.equals(SEARCH_TYPES[1]))
		{
			System.out.println("searchType=2");
			for(Object entry:temp_all)
			{
				if(Integer.toString(((WarehousingEntry) entry).getDocument_number()).equals(searchKey))
				{
					result.add((WarehousingEntry) entry);
					break;
				}
			}
		}
		/*原始单据唯一,所以break*/
		else if(searchType.equals(SEARCH_TYPES[2]))
		{
			System.out.println("searchType=3");
			for(Object entry:temp_all)
			{
				if(Integer.toString(((WarehousingEntry) entry).getOriginal_invoice_number()).equals(searchKey))
				{
					result.add((WarehousingEntry) entry);
					break;
				}
			}
		}
		else if(searchType.equals(SEARCH_TYPES[3]))
		{
			System.out.println("searchType=4");
			for(Object entry:temp_all)
			{
				if(((WarehousingEntry) entry).getShipping_warehouse().equals(searchKey))
					result.add((WarehousingEntry) entry);
			}
		}
		else if(searchType.equals(SEARCH_TYPES[4]))
		{
			System.out.println("searchType=5");
			for(Object entry:temp_all)
			{
				if(((WarehousingEntry) entry).getSupplier().equals(searchKey))
					result.add((WarehousingEntry) entry);
			}
		}
		
		return result;
	}

	private List<?> selectAll() 
	{
		if(!isCache)
		{
			System.out.println("not cache");
			
			allOfEntry=entryDao.selectAll();
			isCache=true;	
		}
		else
		{
			System.out.println("cache");
		}
		
		return allOfEntry;
	}
	
	/*get(),set()*/
	public IWarehousingEntryDao getEntryDao() 
	{
		return entryDao;
	}

	public void setEntryDao(IWarehousingEntryDao entryDao) 
	{
		this.entryDao = entryDao;
	}
	
	/*entry cache*/
	private static List<?> allOfEntry;
	private static boolean isCache=false;
	
	@Resource
	private IWarehousingEntryDao entryDao;
	
	/*验证常量*/
	private static final String[] SEARCH_TYPES={"制单日期","单据号码","原始单号","进货仓库","供应商"};
}
