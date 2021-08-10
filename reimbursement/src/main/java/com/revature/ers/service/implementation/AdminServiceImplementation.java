package com.revature.ers.service.implementation;

import com.reavture.ers.dao.implementation.AdminDaoImplementation;
import com.revature.ers.dto.Designation;
import com.revature.ers.dto.Type;
import com.revature.ers.service.AdminServiceRepository;

public class AdminServiceImplementation implements AdminServiceRepository{

	AdminDaoImplementation ad = new AdminDaoImplementation();
	
	@Override
	public int addType(Type type) {
		return ad.addType(type);
	}

	@Override
	public int addDesignation(Designation des) {
		return ad.addDesignation(des);
	}

}
