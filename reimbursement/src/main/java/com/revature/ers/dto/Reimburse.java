package com.revature.ers.dto;

public class Reimburse {

	private String type;
	private String reason;
	private String date;
	private String amount;
	private String emailid;
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getAmount() {
		return amount;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getEmailid() {
		return emailid;
	}
	
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
}
