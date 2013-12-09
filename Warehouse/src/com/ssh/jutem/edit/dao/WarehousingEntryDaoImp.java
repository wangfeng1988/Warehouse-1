package com.ssh.jutem.edit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	
	@SuppressWarnings("resource")
	@Override
	/*这个方法为task(Timmer)服务，task似乎不能使用spring注入session*/
	public List<?> selectByYearMonth(String year_month) 
	{
		System.out.println("This is select by year month");
		
		/*不要包含所有配置文件，否则会不停执行
		 * 因为可能包含到timer会不停开线程*/
		ApplicationContext ac =new ClassPathXmlApplicationContext("classpath:config/applicationContext-common.xml");
		
		SessionFactory sessionFactory=(SessionFactory) ac.getBean("sessionFactory");
		Session s=sessionFactory.openSession();
		
		Transaction t=s.beginTransaction();
		
		String hql = "from WarehousingEntry as model where model.prepared_by_date like :date";
		
		//test
		System.out.println(year_month);
		
		List<?> result=s.createQuery(hql).setParameter("date", year_month+"%").list();	
		
		t.commit();
		s.close();
		
		return result;
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
