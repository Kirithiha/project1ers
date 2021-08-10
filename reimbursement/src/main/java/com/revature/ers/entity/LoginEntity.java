package com.revature.ers.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@NamedNativeQuery(
		name = "logindetails",
		query = "call logindetails(:email)",
		resultClass = LoginEntity.class
)
@Entity
@Table(name="Login")
public class LoginEntity {
	
	@Id 
	private String emailid;
	private String password;
	private String role;
	
	public String getEmailid() {
		return emailid;
	}
	
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole() {
		this.role = "employee";
	}
	
	
}
