package com.revature.ers.service.implementation;


import java.util.List;

import org.apache.log4j.Logger;

import com.reavture.ers.dao.implementation.UserDaoImplementation;
import com.revature.ers.dto.User;
import com.revature.ers.entity.UserEntity;
import com.revature.ers.service.UserServiceRepository;

public class UserServiceImplementation implements UserServiceRepository {

	UserDaoImplementation u_impl = new UserDaoImplementation();
	Logger log = Logger.getLogger("UserServiceImplementation.class");
	
	// TO ADD USER.
	@Override
	public int addUser(User u) {
		
		log.info("Inside ADD USER SERVICE");
		return u_impl.addUser(u);
	}
	
	// TO VALIDATE LOGIN DETAILS.
	@Override
	public int validation(String email, String passwd) {
		
		log.info("Inside VALIDATE USER SERVICE");
		return u_impl.validation(email, passwd);
	}

	// TO GET USER BY EMAILID.
	@Override
	public List<UserEntity> getUser(String email) {
		
		log.info("Inside GET USER BY ID SERVICE");
		return u_impl.getUser(email);
	}

	// TO UPDATE USER.
	@Override
	public int updateUser(User u) {
		
		log.info("Inside UPDATE USER SERVICE");
		return u_impl.updateUser(u);
	}

	// TO DELETE USER BY EMAILID.
	@Override
	public int deleteUser(String email) {
		
		log.info("Inside DELETE USER BY EMAILID SERVICE");
		return u_impl.deleteUser(email);
	}

	// TO GET ALL USER.
	@Override
	public List<UserEntity> getAllUser() {
		
		log.info("Inside GET ALL USER SERVICE");
		return u_impl.getAllUser();
	}

	// TO UPDATE LOGIN BY EMAILID.
	@Override
	public int updateLogin(String email, String pass) {
		
		log.info("Inside UPDATE LOGIN OF USER SERVICE");
		return u_impl.updateLogin(email, pass);
	}

}
