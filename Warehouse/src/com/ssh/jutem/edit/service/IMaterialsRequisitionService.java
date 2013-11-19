package com.ssh.jutem.edit.service;

import java.util.List;

import com.ssh.jutem.edit.model.Material;
import com.ssh.jutem.edit.model.MaterialsRequisition;
import com.ssh.jutem.edit.model.Requisition_Material;

public interface IMaterialsRequisitionService 
{
	public boolean add(MaterialsRequisition requisitionBean,List<Material> materialBeans,List<Requisition_Material> requisition_material);
	public boolean delete(MaterialsRequisition materials_requisition);
	public boolean modify(MaterialsRequisition materials_requisition);
	public List<MaterialsRequisition> select(String searchKey, String searchType);
	public MaterialsRequisition selectDetial(int id);

}
