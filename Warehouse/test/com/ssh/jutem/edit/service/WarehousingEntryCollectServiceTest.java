package com.ssh.jutem.edit.service;
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/applicationContext-*.xml")
public class WarehousingEntryCollectServiceTest extends AbstractTransactionalJUnit4SpringContextTests
{
	@Resource
	private IWarehousingEntryCollectService entryCollectService;

	@Test
	public void add()
	{
		entryCollectService.add(2013,6);
	}

	public IWarehousingEntryCollectService getEntryCollectService() {
		return entryCollectService;
	}

	public void setEntryCollectService(
			IWarehousingEntryCollectService entryCollectService) {
		this.entryCollectService = entryCollectService;
	}
}
