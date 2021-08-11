package com.revature.ers.service.implementation;


import java.util.List;

import com.reavture.ers.dao.implementation.UserDaoImplementation;
import com.revature.ers.dto.User;
import com.revature.ers.entity.UserEntity;
import com.revature.ers.service.UserServiceRepository;

public class UserServiceImplementation implements UserServiceRepository {

	UserDaoImplementation u_impl = new UserDaoImplementation();
	@Override
	public int addUser(User u) {
		
		return u_impl.addUser(u);
	}
	
	@Override
	public int validation(String email, String passwd) {
		return u_impl.validation(email, passwd);
	}

	@Override
	public List<UserEntity> getUser(String email) {
		
		return u_impl.getUser(email);
	}

	@Override
	public int updateUser(User u) {
		return u_impl.updateUser(u);
	}

	@Override
	public int deleteUser(String email) {
		
		return u_impl.deleteUser(email);
	}

	@Override
	public List<UserEntity> getAllUser() {
		
		return u_impl.getAllUser();
	}

	@Override
	public int updateLogin(String email, String pass) {
		
		return u_impl.updateLogin(email, pass);
	}

}
