package com.reavture.ers.dao.implementation;

import org.apache.log4j.Logger;
import org.hibernate.Session;


import com.reavture.ers.dao.AdminDaoRepository;
import com.revature.ers.dto.Designation;
import com.revature.ers.dto.Type;
import com.revature.ers.mapper.TypeMapper;
import com.revature.ers.mapper.DesignationMapper;
import com.revature.ers.util.HibernateUtil;

public class AdminDaoImplementation implements AdminDaoRepository {

	Logger log = Logger.getLogger("AdminDaoImplementation.class");
	
	// TO ADD TYPE.
	@Override
	public int addType(Type type) {
		
		log.info("Inside ADD TYPE DAO");
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

	// TO ADD DESIGNATION.
	@Override
	public int addDesignation(Designation des) {
		
		log.info("Inside ADD DESIGNATION DAO");
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
