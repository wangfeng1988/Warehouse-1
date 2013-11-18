package com.ssh.jutem.edit.service;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssh.jutem.edit.model.Material;
import com.ssh.jutem.edit.model.WarehousingEntry;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/applicationContext-*.xml")
public class WarehousingEntryServiceTest extends AbstractTransactionalJUnit4SpringContextTests
{
	@Resource
	private IMaterialsRequisitionService requisitionService;

	@Test
	public void add()
	{
		/*WarehousingEntry提供默认值*/
		WarehousingEntry entry=new WarehousingEntry();
		
		/*Material提供默认值*/
		Set<Material> materials=new HashSet<Material>();
		materials.add(new Material());
		
		entry.setMaterials(materials);
		
	/*	entryService.add(entry);*/		
	}

	public IMaterialsRequisitionService getRequisitionService() {
		return requisitionService;
	}

	public void setRequisitionService(
			IMaterialsRequisitionService requisitionService) {
		this.requisitionService = requisitionService;
	}
}
