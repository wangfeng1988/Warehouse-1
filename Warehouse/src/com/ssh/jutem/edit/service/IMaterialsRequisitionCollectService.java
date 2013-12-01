package com.ssh.jutem.edit.service;

import java.util.List;

import com.ssh.jutem.edit.model.MaterialsRequisitionCollect;

public interface IMaterialsRequisitionCollectService 
{
	public List<MaterialsRequisitionCollect> select(String searchKey, String searchType);
	public MaterialsRequisitionCollect selectDetial(int id);
}
