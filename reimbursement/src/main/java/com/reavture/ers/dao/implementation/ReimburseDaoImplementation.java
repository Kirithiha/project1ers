package com.reavture.ers.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.reavture.ers.dao.ReimburseDaoRepository;
import com.revature.ers.dto.Reimburse;
import com.revature.ers.entity.ReimburseEntity;
import com.revature.ers.entity.UserEntity;
import com.revature.ers.mapper.ReimburseMapper;
import com.revature.ers.util.HibernateUtil;

public class ReimburseDaoImplementation implements ReimburseDaoRepository{

	@Override
	public int addReimburse(Reimburse re) {
		
		int flag=0;
		try {	
			System.out.println(re.getReason());
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			int result = 0;
			result = (Integer) session.save(ReimburseMapper.mapReimburse(re));
			System.out.print(result);
			session.getTransaction().commit();
			//session.flush();
			session.close();
			if(result!=0) 
				flag = 1;	
		} catch (Exception e1) {
			flag = 2;
			e1.printStackTrace(); 	
		}
		
		return flag;
	}

	@Override
	public int update(String status, String id) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		Query q=session.getNamedQuery("updatereimburse");
		q.setParameter("id", id);
		q.setParameter("status", status);
		int result=q.executeUpdate();  
		session.getTransaction().commit();
		session.close();
		System.out.println(result);
		return result;
	}

	@Override
	public int delete(String emailid) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		Query query=session.createQuery("delete from ReimburseEntity where emailid=:id");  
		query.setParameter("id", emailid);
		int result = query.executeUpdate(); 
		session.getTransaction().commit();  
		session.close();
		return result;
	}

	@Override
	public List<ReimburseEntity> getReimburseEntity(String email) {
		
		List<ReimburseEntity> list = new ArrayList<ReimburseEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("reimbursedetails");
		query.setParameter("email", email);
		list = query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public List<ReimburseEntity> getAll() {
		
		List<ReimburseEntity> list = new ArrayList<ReimburseEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("reimburseall");
		list = query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public List<ReimburseEntity> getReimburseEntityById(String id) {
		
		List<ReimburseEntity> list = new ArrayList<ReimburseEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("reimburseid");
		query.setParameter("id", id);
		list = query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public List<ReimburseEntity> approve() {
		List<ReimburseEntity> list = new ArrayList<ReimburseEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("approve");
		list = query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public List<ReimburseEntity> pending() {
		List<ReimburseEntity> list = new ArrayList<ReimburseEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("pending");
		list = query.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public List<ReimburseEntity> approveById(String email) {
		
		List<ReimburseEntity> list = new ArrayList<ReimburseEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("approvebyid");
		query.setParameter("email", email);
		list = query.list();
		session.getTransaction().commit();
		return list;
	}

}
