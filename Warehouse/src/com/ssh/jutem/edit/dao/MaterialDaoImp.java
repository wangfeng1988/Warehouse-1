package com.ssh.jutem.edit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MaterialDaoImp implements IMaterialDao 
{
	@Override
	public List<?> selectAll() 
	{
		System.out.println("this is selectAll");
		
		String queryString = "from Material";	
		return this.getSession().createQuery(queryString).list();	
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
