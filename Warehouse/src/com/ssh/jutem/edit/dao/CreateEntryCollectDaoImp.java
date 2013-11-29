package com.ssh.jutem.edit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssh.jutem.edit.model.WarehousingEntryCollect;

public class CreateEntryCollectDaoImp implements ICreateEntryCollectDao 
{
	@Override
	public void add(WarehousingEntryCollect collect) 
	{
		System.out.println("this is collect");
		this.getSession().save(collect);
	}
	
	/*get(),set()*/
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() 
	{
		return sessionFactory.getCurrentSession();
	}	
	
	private SessionFactory sessionFactory;
}
