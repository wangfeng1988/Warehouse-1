package com.ssh.jutem.edit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssh.jutem.edit.model.WarehousingEntry;

public class WarehousingEntryDaoImp implements IWarehousingEntryDao {

	@Override
	public boolean add(WarehousingEntry warehousing_entry) 
	{
		System.out.println(warehousing_entry.getPrepared_by_date());
		
		this.getSession().save(warehousing_entry);
		
		return false;
	}

	@Override
	public boolean delete(WarehousingEntry warehousing_entry)
	{
		System.out.println(warehousing_entry.getId());
		
		String hql = "delete from WarehousingEntry as model where model.id =:id ";
		this.getSession().createQuery(hql).setParameter("id", warehousing_entry.getId()).executeUpdate();

		return false;
	}

	@Override
	public boolean modify(WarehousingEntry warehousing_entry) 
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<?> selectAll()
	{
		System.out.println("this is selectAll");
		
		String queryString = "from WarehousingEntry";	
		return this.getSession().createQuery(queryString).list();	
	}
	
	@Override
	public Object selectById(int id) 
	{
		System.out.println("This is selectById");
		return this.getSession().get(LISTNAME, id);
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
	
	private static final String LISTNAME="com.ssh.jutem.edit.model.WarehousingEntry";
}
