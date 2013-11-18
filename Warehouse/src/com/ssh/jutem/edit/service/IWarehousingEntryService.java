package com.ssh.jutem.edit.service;

import java.util.List;

import com.ssh.jutem.edit.model.Material;
import com.ssh.jutem.edit.model.WarehousingEntry;

public interface IWarehousingEntryService 
{
	public boolean add(WarehousingEntry entryBean, List<Material> materialBeans);
	public boolean delete(WarehousingEntry warehousing_entry);
	public boolean modify(WarehousingEntry warehousing_entry);
	public List<WarehousingEntry> select(String searchKey, String searchType);
}
