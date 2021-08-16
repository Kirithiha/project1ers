package com.revature.ers.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@NamedNativeQueries({
	@NamedNativeQuery(
			name = "reimbursedetails",
			query = "call reimbursedetails(:email)",
			resultClass = ReimburseEntity.class
	),
	@NamedNativeQuery(
			name = "pending",
			query = "call reimbursepending()",
			resultClass = ReimburseEntity.class
	),
	@NamedNativeQuery(
			name = "pendingbyid",
			query = "call pendingreimbursebyid(:email)",
			resultClass = ReimburseEntity.class
	),
	@NamedNativeQuery(
			name = "approve",
			query = "call approvereimburse()",
			resultClass = ReimburseEntity.class
	),
	@NamedNativeQuery(
			name = "approvebyid",
			query = "call approvereimbursebyid(:email)",
			resultClass = ReimburseEntity.class
	),
	@NamedNativeQuery(
			name = "reimburseid",
			query = "call reimbursebyid(:id)",
			resultClass = ReimburseEntity.class
	),
	@NamedNativeQuery(
			name = "updatereimburse",
			query = "call updatestatusid(:id, :status)",
			resultClass = ReimburseEntity.class
	),
	@NamedNativeQuery(
			name="reimburseall",
			query = "call reimburseall()",
			resultClass = ReimburseEntity.class
	)
})
@Entity
@Table(name="Reimburse")
public class ReimburseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reimburseId;
	
	@Column(nullable = false)
	private String reason;
	
	@Column(nullable = false)
	private String purchasedDate;
	
	private LocalDate appliedDate;
	
	@Column(nullable = false)
	private Double amount;
	
	private String type;
	
	private String status;
	
	@ManyToOne
	@JoinColumn(name="emailid", nullable=false)
	private UserEntity user;
	
	public int getReimburseId() {
		return reimburseId;
	}
	
	public void setReimburseId(int reimburseId) {
		this.reimburseId = reimburseId;
	}
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getPurchasedDate() {
		return purchasedDate;
	}
	
	public void setPurchasedDate(String date) {
		
		this.purchasedDate = date;
	}
	
	public LocalDate getAppliedDate() {
		return appliedDate;
	}
	
	public void setAppliedDate() {
		
		LocalDate date = LocalDate.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String dateText = date.format(format);
		this.appliedDate = LocalDate.parse(dateText, format);
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus() {
		this.status = "pending";
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
}
