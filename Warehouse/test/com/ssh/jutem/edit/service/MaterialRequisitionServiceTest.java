package com.ssh.jutem.edit.service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssh.jutem.edit.model.Material;
import com.ssh.jutem.edit.model.MaterialsRequisition;
import com.ssh.jutem.edit.model.Requisition_Material;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/applicationContext-*.xml")
public class MaterialRequisitionServiceTest extends AbstractTransactionalJUnit4SpringContextTests
{
	@Resource
	private IMaterialsRequisitionService requisitionService;

	@Test
	public void add()
	{
		List<Material> materialBeans=new ArrayList<Material>();
		MaterialsRequisition requisitionBean=new MaterialsRequisition();
		List<Requisition_Material> requisition_material=new ArrayList<Requisition_Material>();
		
		requisitionBean.setDocument_number(99999);
		Material material=new Material();
		material.setId(1);
		material.setMoney(5000);
		Requisition_Material rm=new Requisition_Material();
		rm.setNumber(10);
		
		materialBeans.add(material);
		requisition_material.add(rm);
		
		requisitionService.add(requisitionBean,materialBeans,requisition_material);
	}

	public IMaterialsRequisitionService getRequisitionService() {
		return requisitionService;
	}

	public void setRequisitionService(
			IMaterialsRequisitionService requisitionService) {
		this.requisitionService = requisitionService;
	}
}
