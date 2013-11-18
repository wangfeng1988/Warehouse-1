package com.ssh.jutem.edit.dao;

import static org.junit.Assert.fail;

import java.sql.Date;
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
public class WarehousingEntryDaoImpTest extends AbstractTransactionalJUnit4SpringContextTests
{
	@Resource
	private IWarehousingEntryDao entryDao;
	
	@Test
/*	public void test() 
	{
		Set<Material> materials=new HashSet<Material>();
		Date date=new Date(2014-10-1);
		
		materials.add(new Material("0","0","0","9",1,1,"0"));
		materials.add(new Material("1","1","1","1",3,3,"123"));
		
		WarehousingEntry warehousing_entry=new WarehousingEntry(date,0,0,"0","0",0,0,"abc",materials);
		
		System.out.println(warehousing_entry);
		
		entryDao.add(warehousing_entry);
		
		fail("Not yet implemented");
	}
*/
	public IWarehousingEntryDao getEntryDao() {
		return entryDao;
	}

	public void setEntryDao(IWarehousingEntryDao entryDao) {
		this.entryDao = entryDao;
	}
}
