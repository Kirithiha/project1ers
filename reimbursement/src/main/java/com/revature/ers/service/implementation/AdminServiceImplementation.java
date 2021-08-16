package com.revature.ers.service.implementation;

import org.apache.log4j.Logger;

import com.reavture.ers.dao.implementation.AdminDaoImplementation;
import com.revature.ers.dto.Designation;
import com.revature.ers.dto.Type;
import com.revature.ers.service.AdminServiceRepository;

public class AdminServiceImplementation implements AdminServiceRepository{

	AdminDaoImplementation ad = new AdminDaoImplementation();
	Logger log = Logger.getLogger("AdminServiceImplementation.class");
	
	// TO ADD TYPE.
	@Override
	public int addType(Type type) {
		log.info("Inside ADD TYPE SERVICE");
		return ad.addType(type);
	}

	// TO ADD DESIGNATION.
	@Override
	public int addDesignation(Designation des) {
		log.info("Inside ADD DESIGNATION SERVICE");
		return ad.addDesignation(des);
	}

}
