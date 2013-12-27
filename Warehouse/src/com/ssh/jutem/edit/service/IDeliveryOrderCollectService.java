package com.ssh.jutem.edit.service;

import java.util.List;

import com.ssh.jutem.edit.model.DeliveryOrderCollect;

public interface IDeliveryOrderCollectService 
{
	public List<DeliveryOrderCollect> select(String searchKey, String searchType);
	public DeliveryOrderCollect selectDetial(int id);
}
