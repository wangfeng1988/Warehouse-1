package com.ssh.jutem.edit.service;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.ssh.jutem.edit.dao.IMaterialsRequisitionCollectDao;
import com.ssh.jutem.edit.model.MaterialsRequisitionCollect;

public class MaterialsRequisitionCollectServiceImp implements IMaterialsRequisitionCollectService 
{	
	public MaterialsRequisitionCollectServiceImp()
	{
		super();
	}
	
	@Override
	public List<MaterialsRequisitionCollect> select(String searchKey, String searchType) 
	{
		System.out.println("This is select requisition service");
		
		List<?> temp_all=selectAll();
		List<MaterialsRequisitionCollect> result=new ArrayList<MaterialsRequisitionCollect>();
		
		/*依次为按月份查询进行搜索*/
		if(searchType.equals(SEARCH_TYPES[0]))
		{
			System.out.println("searchType=1");
			for(Object requisitonCollect:temp_all)
			{
				if(((MaterialsRequisitionCollect) requisitonCollect).getMaked_year_month().equals(searchKey))
					result.add((MaterialsRequisitionCollect) requisitonCollect);
			}
		}
		return result;
	}

	@Override
	/*因为用了延迟加载所以这里不用缓存里的数据*/
	public MaterialsRequisitionCollect selectDetial(int id) 
	{	
		System.out.println("this is selectDetial service");
		return (MaterialsRequisitionCollect) requisitionCollectDao.selectById(id);
	}
	
	private List<?> selectAll() 
	{
		if(!isCache)
		{
			System.out.println("not cache");
			
			allOfEntryCollect=requisitionCollectDao.selectAll();
			isCache=true;	
		}
		else
		{
			System.out.println("cache");
		}
		
		return allOfEntryCollect;
	}
	
	/*get(),set()*/
	public IMaterialsRequisitionCollectDao getRequisitionCollectDao() {
		return requisitionCollectDao;
	}

	public void setRequisitionCollectDao(
			IMaterialsRequisitionCollectDao requisitionCollectDao) {
		this.requisitionCollectDao = requisitionCollectDao;
	}
	
	/*requisition cache*/
	private static List<?> allOfEntryCollect;
	private static boolean isCache=false;
	
	@Resource
	private IMaterialsRequisitionCollectDao requisitionCollectDao;
	
	/*验证常量*/
	private static final String[] SEARCH_TYPES={"制单年月"};

}
