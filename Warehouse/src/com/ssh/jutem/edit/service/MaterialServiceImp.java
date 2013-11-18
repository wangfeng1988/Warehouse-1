package com.ssh.jutem.edit.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.ssh.jutem.edit.dao.IMaterialDao;
import com.ssh.jutem.edit.model.Material;

public class MaterialServiceImp implements IMaterialService
{
	@Override
	public List<Material> select(String searchKey, String searchType) 
	{
		System.out.println("This is select material service");
		
		List<?> temp_all=selectAll();
		List<Material> result=new ArrayList<Material>();
		
		/*依次为货品编码，货品名称进行搜索*/
		/*货品编码唯一,所以break*/
		if(searchType.equals(SEARCH_TYPES[0]))
		{
			System.out.println("searchType=1");
			for(Object material:temp_all)
			{
				if(((Material) material).getCoding().equals(searchKey))
				{
					result.add((Material) material);
					break;
				}
			}
		}
		else if(searchType.equals(SEARCH_TYPES[1]))
		{
			System.out.println("searchType=2");
			for(Object material:temp_all)
			{
				if(((Material) material).getName().equals(searchKey))
					result.add((Material) material);
			}
		}
		
		return result;
	}

	private List<?> selectAll() 
	{
		if(!isCache)
		{
			System.out.println("not cache");
			
			allOfMaterial=materialDao.selectAll();			
			isCache=true;
		}
		else
		{
			System.out.println("cache");
		}
		
		return allOfMaterial;
	}
	
	/*get(),set()*/
	public static boolean isCache() {
		return isCache;
	}
	public static void setCache(boolean isCache) {
		MaterialServiceImp.isCache = isCache;
	}
	public IMaterialDao getMaterialDao() {
		return materialDao;
	}
	public void setMaterialDao(IMaterialDao materialDao) {
		this.materialDao = materialDao;
	}
	
	/*Material cache*/
	private static List<?> allOfMaterial;
	private static boolean isCache=false;
	
	@Resource
	private IMaterialDao materialDao;
	
	/*验证常量*/
	private static final String[] SEARCH_TYPES={"货品编码","货品名称"};
}
