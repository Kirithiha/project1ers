package com.revature.ers.mapper;

import com.revature.ers.entity.LoginEntity;

public class LoginMapper {

	public static LoginEntity mapLogin(String emailid, String password) {
		LoginEntity l = new LoginEntity();
		l.setEmailid(emailid);
		l.setPassword(password);
		l.setRole();
		return l;
	}
}
