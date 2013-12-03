package com.ssh.jutem.edit.dao;

import java.util.List;

import com.ssh.jutem.edit.model.WarehousingEntryCollect;

public interface IWarehousingEntryCollectDao 
{
	public void add(WarehousingEntryCollect collect);
	public List<?> selectAll();
	public Object selectById(int id);
}
