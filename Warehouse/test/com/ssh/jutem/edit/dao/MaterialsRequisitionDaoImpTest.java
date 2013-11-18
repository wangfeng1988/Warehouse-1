package com.ssh.jutem.edit.dao;

import static org.junit.Assert.fail;

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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/applicationContext-*.xml")
public class MaterialsRequisitionDaoImpTest extends AbstractTransactionalJUnit4SpringContextTests
{
	@Resource
	private IMaterialsRequisitionDao requisitionDao;
	
	@Test
	public void test() 
	{
		Set<Material> materials=new HashSet<Material>();
		Material material=new Material();
		material.setCoding("1234");
		
		
		/*requisitionDao.add(requisition);*/
		
		fail("Not yet implemented");
	}
	
	@Test
	public void updateMaterial()
	{
		MaterialsRequisition mr=new MaterialsRequisition();
		List<Material> materials=new ArrayList<Material>();
		
		Material material=new Material();
		material.setId(1);
		material.setName("test");
		
		materials.add(material);
			
		requisitionDao.add(mr, materials);
	}

	public IMaterialsRequisitionDao getRequisitionDao() {
		return requisitionDao;
	}

	public void setRequisitionDao(IMaterialsRequisitionDao requisitionDao) {
		this.requisitionDao = requisitionDao;
	}
}
