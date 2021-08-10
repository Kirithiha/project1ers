package com.revature.ers.service;

import java.util.List;

import com.revature.ers.dto.User;
import com.revature.ers.entity.UserEntity;

public interface UserServiceRepository {

	public int addUser(User u);
	public int validation(String email, String passwd);
	public List<UserEntity>  getUser(String email);
	public int updateUser(User u);
	public int deleteUser(String email);
	public List<UserEntity>  getAllUser();
}