package com.ssh.jutem.edit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
