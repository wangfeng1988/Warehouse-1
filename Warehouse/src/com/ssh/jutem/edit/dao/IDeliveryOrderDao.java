package com.ssh.jutem.edit.dao;

import java.util.List;

import com.ssh.jutem.edit.model.Material;
import com.ssh.jutem.edit.model.DeliveryOrder;

public interface IDeliveryOrderDao 
{
	public boolean add(DeliveryOrder deliveryBean,List<Material> materialBeans);
	public boolean delete(DeliveryOrder delivery_order);
	public boolean modify(DeliveryOrder delivery_order);
	public List<?> selectAll();
	public Object selectById(int id);
	public List<?> selectByYearMonth(String year_month);
}
