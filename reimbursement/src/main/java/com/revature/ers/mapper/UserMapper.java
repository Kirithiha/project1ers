package com.revature.ers.mapper;

import com.revature.ers.dto.User;
import com.revature.ers.entity.UserEntity;

public class UserMapper {

	public static UserEntity mapUser(User u) {
		UserEntity ue = new UserEntity();
		ue.setEmailid(u.getEmailid());
		ue.setDesignation(u.getDesignation());
		ue.setUserName(u.getUserName());
		ue.setAccountNumber(u.getAccountNumber());
		ue.setBranchName(u.getBranchName());
		ue.setIfscCode(u.getIfscCode());
		ue.setPhoneNumber(u.getPhnNo());
		return ue;
	}
}
