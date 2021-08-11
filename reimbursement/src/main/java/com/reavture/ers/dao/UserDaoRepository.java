package com.reavture.ers.dao;

import java.util.List;

import com.revature.ers.dto.User;
import com.revature.ers.entity.UserEntity;

public interface UserDaoRepository {

	public int addUser(User u);
	public int validation(String email, String passwd);
	public List<UserEntity>  getUser(String email);
	public int updateUser(User u);
	public int deleteUser(String email);
	public List<UserEntity>  getAllUser();
	public int updateLogin(String email, String pass);
}

