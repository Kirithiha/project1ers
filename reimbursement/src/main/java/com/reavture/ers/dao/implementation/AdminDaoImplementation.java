package com.reavture.ers.dao.implementation;

import org.hibernate.Session;


import com.reavture.ers.dao.AdminDaoRepository;
import com.revature.ers.dto.Designation;
import com.revature.ers.dto.Type;
import com.revature.ers.mapper.TypeMapper;
import com.revature.ers.mapper.DesignationMapper;
import com.revature.ers.util.HibernateUtil;

public class AdminDaoImplementation implements AdminDaoRepository {

	@Override
	public int addType(Type type) {
		int flag=0;
		try {	
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			String result = null;
			result = (String) session.save(TypeMapper.mapType(type));
			System.out.print(result);
			if(result!=null)
				flag = 1;
			session.getTransaction().commit();
			//session.flush();
			session.close();
					
		} catch (Exception e1) {
			flag = 2;
			e1.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public int addDesignation(Designation des) {
		
		int flag=0;
		try {	
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			String result = null;
			result = (String) session.save(DesignationMapper.mapDesignation(des));
			System.out.print(result);
			if(result!=null)
				flag = 1;
			session.getTransaction().commit();
			//session.flush();
			session.close();
					
		} catch (Exception e1) {
			flag = 2;
			e1.printStackTrace();
		}
		
		return flag;
	}

}
