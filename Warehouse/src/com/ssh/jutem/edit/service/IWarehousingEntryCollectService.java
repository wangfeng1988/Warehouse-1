package com.ssh.jutem.edit.service;

import java.util.List;

import com.ssh.jutem.edit.model.WarehousingEntryCollect;

public interface IWarehousingEntryCollectService 
{
	public List<WarehousingEntryCollect> select(String searchKey, String searchType);
	public WarehousingEntryCollect selectDetial(int id);
}
