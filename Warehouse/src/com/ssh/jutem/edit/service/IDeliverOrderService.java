package com.ssh.jutem.edit.service;

import com.ssh.jutem.edit.model.DeliveryOrder;

public interface IDeliverOrderService 
{
	public boolean add(DeliveryOrder delivery_order);
	public boolean delete(DeliveryOrder delivery_order);
	public boolean modify(DeliveryOrder delivery_order);
}
