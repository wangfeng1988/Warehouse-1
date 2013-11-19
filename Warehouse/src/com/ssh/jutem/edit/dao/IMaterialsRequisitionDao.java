package com.ssh.jutem.edit.dao;

import java.util.List;

import com.ssh.jutem.edit.model.Material;
import com.ssh.jutem.edit.model.MaterialsRequisition;

public interface IMaterialsRequisitionDao 
{
	public boolean add(MaterialsRequisition requisitionBean,List<Material> materialBeans);
	public boolean delete(MaterialsRequisition materials_requisition);
	public boolean modify(MaterialsRequisition materials_requisition);
	public List<?> selectAll();
	public Object selectById(int id);

}
