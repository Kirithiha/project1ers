package com.reavture.ers.dao.implementation;

import java.util.ArrayList;

import java.util.List;

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

	@Override
	public int addUser(User u) {
		
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
	public int addLogin(String email, String passwd) {
		
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
	@Override
	public int validation(String email, String passwd) {
		
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
		return flag;
	}
	
	@Override
	public List<UserEntity> getUser(String emailid) {
		
		int flag=0;
		List<UserEntity> list = new ArrayList<UserEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("userdetails");
		query.setParameter("email",emailid);  
		list = query.list();
		session.getTransaction().commit();
		return list;
	}
	
	@Override
	public int updateUser(User u) {
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

	@Override
	public int deleteUser(String email) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction(); 
		Query query=session.createQuery("delete from UserEntity where emailid=:id");  
		query.setParameter("id", email);
		int result = query.executeUpdate(); 
		session.getTransaction().commit();  
		session.close();
		return result;
	}

	@Override
	public List<UserEntity> getAllUser() {
		
		List<UserEntity> list = new ArrayList<UserEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("username");
		list = query.list();
		session.getTransaction().commit();
		return list;
	}
}
