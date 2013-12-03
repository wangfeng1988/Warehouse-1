package com.ssh.jutem.edit.service;

import java.util.List;
import java.util.Map;

import com.ssh.jutem.edit.model.WarehousingEntryCollect;

public interface IWarehousingEntryCollectService 
{
	public List<WarehousingEntryCollect> select(String searchKey, String searchType);
	public Map<String,Object> selectDetial(int id);
}
