package com.ssh.jutem.edit.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import com.ssh.jutem.edit.dao.IDeliveryOrderDao;
import com.ssh.jutem.edit.model.DeliveryOrder;
import com.ssh.jutem.edit.model.Delivery_Material;
import com.ssh.jutem.edit.model.Material;

public class DeliveryOrderServiceImp implements IDeliveryOrderService 
{
	public DeliveryOrderServiceImp()
	{
		super();
	}
	
	@Override
	public boolean add(DeliveryOrder deliveryBean,
			List<Material> materialBeans,
			List<Delivery_Material> delivery_material) 
	{
		System.out.println("This is material delivery add service");
		
		/*设置实体之间的导航*/
		deliveryBean.setDelivery_material(new HashSet<Delivery_Material>(delivery_material));
		for(int i=0;i<materialBeans.size();i++)
		{
			/*在页面中添加删除行的时候可能会导致带之前下标项被删除，导致出现空项*/
			if(materialBeans.get(i)==null || delivery_material.get(i)==null)
				continue;
			materialBeans.get(i).setDelivery_material(new HashSet<Delivery_Material>(delivery_material));
			delivery_material.get(i).setMaterial(materialBeans.get(i));
			delivery_material.get(i).setDelivery(deliveryBean);
		}
		
		/*修改物料库存
		 *提交销售单必须进行查询物料，所以已经做过缓存*/
		List<?> materials=MaterialServiceImp.getAllOfMaterial();
		for(int i=0;i<materialBeans.size();i++)
		{
			/*在页面中添加删除行的时候可能会导致带之前下标项被删除，导致出现空项*/
			if(materialBeans.get(i)==null || delivery_material.get(i)==null)
				continue;
			for(int j=0;j<materials.size();j++)
			{
				if(materialBeans.get(i).getId()==((Material)materials.get(j)).getId())
				{
					double stock=((Material)materials.get(j)).getStock();
					double need=delivery_material.get(i).getNumber();
					
					System.out.println("stock:"+stock+"need:"+need);
					
					materialBeans.get(i).setStock(stock-need);
				}
			}
		}

		deliveryDao.add(deliveryBean,materialBeans);
		
		/*添加完以后，如果要查询则再从数据库查询*/
		isCache=false;
		/*添加销售单会改变物料表，所以修改物料表缓存状态*/
		MaterialServiceImp.setCache(false);
		
		return false;
	}

	@Override
	public boolean delete(DeliveryOrder delivery_order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(DeliveryOrder delivery_order) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<DeliveryOrder> select(String searchKey, String searchType) 
	{
		System.out.println("This is select delivery service");
		
		List<?> temp_all=selectAll();
		List<DeliveryOrder> result=new ArrayList<DeliveryOrder>();
		
		/*依次为按制单时间，单据号码，发货仓库，客户名进行搜索*/
		if(searchType.equals(SEARCH_TYPES[0]))
		{
			System.out.println("searchType=1");
			for(Object delivery:temp_all)
			{
				if(((DeliveryOrder) delivery).getPrepared_by_date().equals(searchKey))
					result.add((DeliveryOrder) delivery);
			}
		}
		/*单据号码唯一，所以break*/
		else if(searchType.equals(SEARCH_TYPES[1]))
		{
			System.out.println("searchType=2");
			for(Object delivery:temp_all)
			{
				if(Integer.toString(((DeliveryOrder) delivery).getDocument_number()).equals(searchKey))
				{
					result.add((DeliveryOrder) delivery);
					break;
				}
			}
		}
		else if(searchType.equals(SEARCH_TYPES[2]))
		{
			System.out.println("searchType=3");
			for(Object delivery:temp_all)
			{
				if(((DeliveryOrder) delivery).getShipping_warehouse().equals(searchKey))
					result.add((DeliveryOrder) delivery);
			}
		}
		else if(searchType.equals(SEARCH_TYPES[3]))
		{
			System.out.println("searchType=4");
			for(Object delivery:temp_all)
			{
				if(((DeliveryOrder) delivery).getCustomer_name().equals(searchKey))
					result.add((DeliveryOrder) delivery);
			}
		}
		
		return result;
	}
	
	@Override
	public DeliveryOrder selectDetial(int id)
	{
		System.out.println("this is selectDetial service");
		return (DeliveryOrder) deliveryDao.selectById(id);
	}
	
	private List<?> selectAll() 
	{
		if(!isCache)
		{
			System.out.println("not cache");
			
			allOfDelivery=deliveryDao.selectAll();
			isCache=true;	
		}
		else
		{
			System.out.println("cache");
		}
		
		return allOfDelivery;
	}
	
	/*get(),set()*/
	public IDeliveryOrderDao getDeliveryDao() {
		return deliveryDao;
	}

	public void setDeliveryDao(IDeliveryOrderDao deliveryDao) {
		this.deliveryDao = deliveryDao;
	}

	/*requisition cache*/
	private static List<?> allOfDelivery;

	private static boolean isCache=false;
	
	@Resource
	private IDeliveryOrderDao deliveryDao;
	
	/*验证常量*/
	private static final String[] SEARCH_TYPES={"制单日期","单据号码","发货仓库","客户名"};

}
