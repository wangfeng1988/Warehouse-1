package com.ssh.jutem.edit.dao;

import java.util.List;

import com.ssh.jutem.edit.model.WarehousingEntry;

public interface IWarehousingEntryDao 
{
	public boolean add(WarehousingEntry warehousing_entry);
	public boolean delete(WarehousingEntry warehousing_entry);
	public boolean modify(WarehousingEntry warehousing_entry);
	public List<?> selectAll();
	public Object selectById(int id);
	public List<?> selectByYearMonth(String year_month);
}
