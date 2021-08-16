package com.reavture.ers.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.reavture.ers.dao.ReimburseDaoRepository;
import com.revature.ers.dto.Reimburse;
import com.revature.ers.entity.ReimburseEntity;
import com.revature.ers.entity.UserEntity;
import com.revature.ers.mapper.ReimburseMapper;
import com.revature.ers.util.HibernateUtil;

public class ReimburseDaoImplementation implements ReimburseDaoRepository{

	Logger log = Logger.getLogger("ReimburseDaoImplementatiom.class");
	
	// TO ADD NEW REIMBURSE REQUEST BY EMPLOYEE.
	@Override
	public int addReimburse(Reimburse re) {
		
		log.info("Inside ADD REIMBURSE DAO");
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
	
	// TO UPDATE THE STATUS OF REIMBURSE REQUEST BY ADMIN
	@Override
	public int update(String status, String id) {
		
		log.info("Inside UPDATE REIMBURSE DAO");
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

	// TO GET REIMBURSE OF PARTICULAR ID ALONE.
	@Override
	public List<ReimburseEntity> getReimburseEntity(String email) {
		
		log.info("Inside GET REIMBURSE BY EMAILID DAO");
		List<ReimburseEntity> list = new ArrayList<ReimburseEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("reimbursedetails");
		query.setParameter("email", email);
		list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	// TO GET ALL REIMBURSE REQUEST.
	@Override
	public List<ReimburseEntity> getAll() {
		
		log.info("Inside GET ALL REIMBURSE DAO");
		List<ReimburseEntity> list = new ArrayList<ReimburseEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("reimburseall");
		list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	// TO GET PARTICULAR REIMBURSE BY ID.
	@Override
	public List<ReimburseEntity> getReimburseEntityById(String id) {
		
		log.info("Inside GET REIMBURSE BY ID DAO");
		List<ReimburseEntity> list = new ArrayList<ReimburseEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("reimburseid");
		query.setParameter("id", id);
		list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	// TO GET ALL THE APPROVED REQUEST.
	@Override
	public List<ReimburseEntity> approve() {
		
		log.info("Inside APPROVE ALL REIMBURSE DAO");
		List<ReimburseEntity> list = new ArrayList<ReimburseEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("approve");
		list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	// TO GET ALL THE PENDING REQUEST.
	@Override
	public List<ReimburseEntity> pending() {
		
		log.info("Inside PENDING ALL REIMBURSE DAO");
		List<ReimburseEntity> list = new ArrayList<ReimburseEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("pending");
		list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	// TO GET APPROVE REQUEST FOR PARTICULAR EMAIL ID ALONE.
	@Override
	public List<ReimburseEntity> approveById(String email) {
		
		log.info("Inside APPROVE REIMBURSE BY EMAILID DAO");
		List<ReimburseEntity> list = new ArrayList<ReimburseEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("approvebyid");
		query.setParameter("email", email);
		list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	// TO GET PENDING REQUEST FOR PARTICULAR EMAIL ID ALONE.
	@Override
	public List<ReimburseEntity> pendingById(String email) {
		
		log.info("Inside PENDING REIMBURSE BY ID DAO");
		List<ReimburseEntity> list = new ArrayList<ReimburseEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("pendingbyid");
		query.setParameter("email", email);
		list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

}
