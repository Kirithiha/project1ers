package com.revature.ers.util;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.ers.entity.DesignationEntity;
import com.revature.ers.entity.TypeEntity;

public class SelectUtil {

	static public List<TypeEntity> getTypes(){
		List<TypeEntity> list = new ArrayList<TypeEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("typename");
		list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	static public List<DesignationEntity> getDesignation(){
		List<DesignationEntity> list = new ArrayList<DesignationEntity>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("designationname");
		list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
}

