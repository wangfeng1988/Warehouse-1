package com.ssh.jutem.edit.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import com.ssh.jutem.edit.dao.IMaterialsRequisitionDao;
import com.ssh.jutem.edit.model.Material;
import com.ssh.jutem.edit.model.MaterialsRequisition;
import com.ssh.jutem.edit.model.Requisition_Material;

public class MaterialsRequisitionServiceImp implements IMaterialsRequisitionService 
{
	public MaterialsRequisitionServiceImp()
	{
		super();
	}
	
	@Override
	public boolean add(MaterialsRequisition requisitionBean,
			List<Material> materialBeans,
			List<Requisition_Material> requisition_material) 
	{
		System.out.println("This is material requisition add service");
		
		/*设置实体之间的导航*/
		requisitionBean.setRequisition_material(new HashSet<Requisition_Material>(requisition_material));
		for(int i=0;i<materialBeans.size();i++)
		{
			/*在页面中添加删除行的时候可能会导致带之前下标项被删除，导致出现空项*/
			if(materialBeans.get(i)==null || requisition_material.get(i)==null)
				continue;
			materialBeans.get(i).setRequisition_material(new HashSet<Requisition_Material>(requisition_material));
			requisition_material.get(i).setMaterial(materialBeans.get(i));
			requisition_material.get(i).setRequisition(requisitionBean);
		}
		
		/*修改物料库存
		 *提交领料单必须进行查询物料，所以已经做过缓存*/
		List<?> materials=MaterialServiceImp.getAllOfMaterial();
		for(int i=0;i<materialBeans.size();i++)
		{
			/*在页面中添加删除行的时候可能会导致带之前下标项被删除，导致出现空项*/
			if(materialBeans.get(i)==null || requisition_material.get(i)==null)
				continue;
			for(int j=0;j<materials.size();j++)
			{
				if(materialBeans.get(i).getId()==((Material)materials.get(j)).getId())
				{
					double stock=((Material)materials.get(j)).getStock();
					double need=requisition_material.get(i).getNumber();
					
					System.out.println("stock:"+stock+"need:"+need);
					
					materialBeans.get(i).setStock(stock-need);
				}
			}
		}

		requisitionDao.add(requisitionBean,materialBeans);
		
		/*添加完以后，如果要查询则再从数据库查询*/
		isCache=false;
		/*添加领料单会改变物料表，所以修改物料表缓存状态*/
		MaterialServiceImp.setCache(false);
		
		return false;
	}

	@Override
	public boolean delete(MaterialsRequisition materials_requisition) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(MaterialsRequisition materials_requisition) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<MaterialsRequisition> select(String searchKey, String searchType) 
	{
		System.out.println("This is select requisition service");
		
		List<?> temp_all=selectAll();
		List<MaterialsRequisition> result=new ArrayList<MaterialsRequisition>();
		
		/*依次为按制单时间，单据号码，原始单号，发货仓库，领料单位进行搜索*/
		if(searchType.equals(SEARCH_TYPES[0]))
		{
			System.out.println("searchType=1");
			for(Object requisition:temp_all)
			{
				if(((MaterialsRequisition) requisition).getPrepared_by_date().equals(searchKey))
					result.add((MaterialsRequisition) requisition);
			}
		}
		/*单据号码唯一，所以break*/
		else if(searchType.equals(SEARCH_TYPES[1]))
		{
			System.out.println("searchType=2");
			for(Object requisition:temp_all)
			{
				if(Integer.toString(((MaterialsRequisition) requisition).getDocument_number()).equals(searchKey))
				{
					result.add((MaterialsRequisition) requisition);
					break;
				}
			}
		}
		/*原始单据唯一,所以break*/
		else if(searchType.equals(SEARCH_TYPES[2]))
		{
			System.out.println("searchType=3");
			for(Object requisition:temp_all)
			{
				if(Integer.toString(((MaterialsRequisition) requisition).getOriginal_invoice_number()).equals(searchKey))
				{
					result.add((MaterialsRequisition) requisition);
					break;
				}
			}
		}
		else if(searchType.equals(SEARCH_TYPES[3]))
		{
			System.out.println("searchType=4");
			for(Object requisition:temp_all)
			{
				if(((MaterialsRequisition) requisition).getShipping_warehouse().equals(searchKey))
					result.add((MaterialsRequisition) requisition);
			}
		}
		else if(searchType.equals(SEARCH_TYPES[4]))
		{
			System.out.println("searchType=5");
			for(Object requisition:temp_all)
			{
				if(((MaterialsRequisition) requisition).getRequisition_unit().equals(searchKey))
					result.add((MaterialsRequisition) requisition);
			}
		}
		
		return result;
	}
	
	@Override
	public MaterialsRequisition selectDetial(int id)
	{
		System.out.println("this is selectDetial service");
		return (MaterialsRequisition) requisitionDao.selectById(id);
	}
	
	private List<?> selectAll() 
	{
		if(!isCache)
		{
			System.out.println("not cache");
			
			allOfRequisition=requisitionDao.selectAll();
			isCache=true;	
		}
		else
		{
			System.out.println("cache");
		}
		
		return allOfRequisition;
	}
	
	/*get(),set()*/
	public IMaterialsRequisitionDao getRequisitionDao() {
		return requisitionDao;
	}

	public void setRequisitionDao(IMaterialsRequisitionDao requisitionDao) {
		this.requisitionDao = requisitionDao;
	}

	/*requisition cache*/
	private static List<?> allOfRequisition;
	private static boolean isCache=false;
	
	@Resource
	private IMaterialsRequisitionDao requisitionDao;
	
	/*验证常量*/
	private static final String[] SEARCH_TYPES={"制单日期","单据号码","原始单号","发货仓库","领料单位"};

}
