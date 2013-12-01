package com.ssh.jutem.edit.dao;

import java.util.List;

import com.ssh.jutem.edit.model.MaterialsRequisitionCollect;

public interface IMaterialsRequisitionCollectDao 
{
	public void add(MaterialsRequisitionCollect collect);
	public List<?> selectAll();
	public Object selectById(int id);
}
