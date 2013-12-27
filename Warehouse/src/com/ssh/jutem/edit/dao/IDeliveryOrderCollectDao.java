package com.ssh.jutem.edit.dao;

import java.util.List;

import com.ssh.jutem.edit.model.DeliveryOrderCollect;

public interface IDeliveryOrderCollectDao 
{
	public void add(DeliveryOrderCollect collect);
	public List<?> selectAll();
	public Object selectById(int id);
}
