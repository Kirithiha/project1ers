package com.reavture.ers.dao.implementation;

import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.reavture.ers.dao.UserDaoRepository;
import com.revature.ers.dto.User;
import com.revature.ers.entity.LoginEntity;
import com.revature.ers.entity.UserEntity;
import com.revature.ers.mapper.LoginMapper;
import com.revature.ers.mapper.UserMapper;
import com.revature.ers.util.HibernateUtil;

public class UserDaoImplementation implements UserDaoRepository {

	Logger log = Logger.getLogger("UserDaoImplementation.class");
	
	// TO ADD NEW EMPLOYEE.
	@Override
	public int addUser(User u) {
		
		log.info("Inside ADD USER DAO");
		int flag=0;
		try {	
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			String result = null;
			result = (String) session.save(UserMapper.mapUser(u));
			System.out.print(result);
			session.getTransaction().commit();
			//session.flush();
			session.close();
			if(result!=null) {
				flag = addLogin(u.getEmailid(),u.getPassword());
			}
					
		} catch (Exception e1) {
			flag = 2;
			e1.printStackTrace();
		}
		
		return flag;
	}
	// TO ADD LOGIN.
	public int addLogin(String email, String passwd) {
		
		log.info("Inside ADD LOGIN DAO");
		int flag=0;
		try {
			String login = null;
			Session session1 = HibernateUtil.getSessionFactory().openSession();
			session1.beginTransaction();
			login = (String) session1.save(LoginMapper.mapLogin(email,passwd));
			if(login!=null)
				flag = 1;
			session1.getTransaction().commit();
			//session.flush();
			session1.close();
		} catch(Exception e) {
			flag = 2;
			e.printStackTrace();
		}
		return flag;
	}
	
	// TO VALIDATE EMALID AND PASSWORD IN LOGIN ENTITY.
	@Override
	public int validation(String email, String passwd) {
		
		log.info("Inside VALIDATE LOGIN DAO");
		int flag=0;
		List<LoginEntity> list = new ArrayList<LoginEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("logindetails");
		query.setParameter("email", email);  
		list = query.list();
		session.getTransaction().commit();
		if(list.isEmpty())
			flag = 0;
		else {
			if(passwd.equals(list.get(0).getPassword())) {
				if(list.get(0).getRole().equals("employee"))
					flag = 1;
				else 
					flag = 3;
			}
			else
				flag = 2;
		}
		session.close();
		return flag;
	}
	
	// TO GET USER BY EMAILID.
	@Override
	public List<UserEntity> getUser(String emailid) {
		
		log.info("Inside GET USER BY EMAILID DAO");
		List<UserEntity> list = new ArrayList<UserEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("userdetails");
		query.setParameter("email",emailid);  
		list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	//TO UPDATE USER BY EMAILID.
	@Override
	public int updateUser(User u) {
		
		log.info("Inside UPDATE USER DAO");
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		Query q=session.getNamedQuery("updateuser");
		q.setParameter("email",u.getEmailid());  
		q.setParameter("phn", u.getPhnNo());
		q.setParameter("act", u.getAccountNumber());
		q.setParameter("branch", u.getBranchName());
		q.setParameter("name",u.getUserName()); 
		q.setParameter("ifsc", u.getIfscCode());
		int status=q.executeUpdate();  
		session.getTransaction().commit();
		session.close();
		System.out.println(status);
		return status;
	}

	// TO DELETE EMPLOYEE BY ID.
	@Override
	public int deleteUser(String email) {
		
		log.info("Inside DELETE USER DAO");
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		Query query=session.createQuery("delete from UserEntity where emailid=:id");  
		query.setParameter("id", email);
		int result = query.executeUpdate(); 
		session.getTransaction().commit();  
		session.close();
		return result;
	}

	// TO GET ALL USER.
	@Override
	public List<UserEntity> getAllUser() {
		
		log.info("Inside GET ALL USER DAO");
		List<UserEntity> list = new ArrayList<UserEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("username");
		list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	// TO UPDATE LOGIN BY EMAILID. FORGET PASSWORD
	@Override
	public int updateLogin(String email, String pass) {
		
		log.info("Inside UPDATE LOGIN DAO");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query q=session.getNamedQuery("updatelogin");
		q.setParameter("email",email);  
		q.setParameter("passwd", pass);
		int status=q.executeUpdate();  
		session.getTransaction().commit();
		session.close();
		System.out.println(status);
		return status;
	}
	
}
