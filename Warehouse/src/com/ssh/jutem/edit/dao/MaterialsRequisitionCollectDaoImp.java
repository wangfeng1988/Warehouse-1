package com.ssh.jutem.edit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.jutem.edit.model.MaterialsRequisitionCollect;

public class MaterialsRequisitionCollectDaoImp implements IMaterialsRequisitionCollectDao 
{
	@SuppressWarnings("resource")
	@Override
	/*这个方法为task服务，task似乎不能使用spring注入session*/
	public void add(MaterialsRequisitionCollect collect) 
	{
		System.out.println("this is add requisition collect");
		
		/*不要包含所有配置文件，否则会不停执行
		 * 因为可能包含到timer会不停开线程*/
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:config/applicationContext-common.xml");
		
		SessionFactory sessionFactory=(SessionFactory) ac.getBean("sessionFactory");
		Session s=sessionFactory.openSession();
		
		Transaction t=s.beginTransaction();
		
		s.save(collect);
		
		t.commit();
		
		s.close();
	}
	
	@Override
	public List<?> selectAll() 
	{
		System.out.println("this is selectAll");
		
		String queryString = "from MaterialsRequisitionCollect";	
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

	private static final String LISTNAME="com.ssh.jutem.edit.model.MaterialsRequisitionCollect";
}
