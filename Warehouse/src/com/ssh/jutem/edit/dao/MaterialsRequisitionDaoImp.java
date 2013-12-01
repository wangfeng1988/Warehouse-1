package com.ssh.jutem.edit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.jutem.edit.model.Material;
import com.ssh.jutem.edit.model.MaterialsRequisition;

public class MaterialsRequisitionDaoImp implements IMaterialsRequisitionDao 
{
	@Override
	public boolean add(MaterialsRequisition requisitionBean,
			List<Material> materialBeans) 
	{
		System.out.println(requisitionBean.getPrepared_by_date());
		
		Session s=this.getSession();
		
		/*保存领料入库但*/
		s.save(requisitionBean);
		
		/*更新物料表数量*/
		String hql="update Material m set m.stock=:stock where m.id=:id";
		for(Material m:materialBeans)
		{
			if(m==null)
				continue;
			Query q=s.createQuery(hql);
			q.setParameter("stock", m.getStock());
			q.setParameter("id", m.getId());
			q.executeUpdate();
		}
		
		return false;
	}

	@Override
	public boolean delete(MaterialsRequisition materials_requisition) 
	{
		System.out.println(materials_requisition.getId());
		
		String hql = "delete from MaterialsRequisition as model where model.id =:id ";
		this.getSession().createQuery(hql).setParameter("id", materials_requisition.getId()).executeUpdate();

		return false;
	}

	@Override
	public boolean modify(MaterialsRequisition materials_requisition) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<?> selectAll() 
	{
		System.out.println("this is selectAll");
		
		String queryString = "from MaterialsRequisition";	
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
	public List<?> selectByYearMonth(String year_month) 
	{
		System.out.println("This is select by year month");
		
		/*不要包含所有配置文件，否则会不停执行
		 * 因为可能包含到timer会不停开线程*/
		ApplicationContext ac =new ClassPathXmlApplicationContext("classpath:config/applicationContext-common.xml");
		
		SessionFactory sessionFactory=(SessionFactory) ac.getBean("sessionFactory");
		Session s=sessionFactory.openSession();
		
		Transaction t=s.beginTransaction();
		
		String hql = "from MaterialsRequisition as model where model.prepared_by_date like :date";
		
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

	private static final String LISTNAME="com.ssh.jutem.edit.model.MaterialsRequisition";
}
