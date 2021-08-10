package com.revature.ers.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedNativeQueries({
	@NamedNativeQuery(
			name = "userdetails",
			query = "call userdetails(:email)",
			resultClass = UserEntity.class
	),
	@NamedNativeQuery(
			name = "updateuser",
			query = "call updateuser(:email, :phn, :act, :branch, :name, :ifsc)",
			resultClass = UserEntity.class
	),
	@NamedNativeQuery(
			name="username",
			query = "call username()",
			resultClass = UserEntity.class
	)
})
@Entity
@Table(name="User")
public class UserEntity {

	@Id
	private String emailid;
	
	@OneToMany(mappedBy = "user")
	private Set<ReimburseEntity> request;
	
	@Column(nullable=false)
	private String userName;
	
	private String accountNumber;
	private String branchName;
	private String ifscCode;
	
	@Column(nullable=false)
	private String phoneNumber;
	
	@Column(nullable=false)
	private String designation;

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<ReimburseEntity> getRequest() {
		return request;
	}

	public void setRequest(Set<ReimburseEntity> request) {
		this.request = request;
	}
	
}
