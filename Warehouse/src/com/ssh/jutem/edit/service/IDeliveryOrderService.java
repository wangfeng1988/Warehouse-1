package com.ssh.jutem.edit.service;

import java.util.List;

import com.ssh.jutem.edit.model.DeliveryOrder;
import com.ssh.jutem.edit.model.Delivery_Material;
import com.ssh.jutem.edit.model.Material;

public interface IDeliveryOrderService 
{
	public boolean add(DeliveryOrder deliveryBean,List<Material> materialBeans,List<Delivery_Material> delivery_material);
	public boolean delete(DeliveryOrder deilivery_order);
	public boolean modify(DeliveryOrder deilivery_order);
	public List<DeliveryOrder> select(String searchKey, String searchType);
	public DeliveryOrder selectDetial(int id);
}
