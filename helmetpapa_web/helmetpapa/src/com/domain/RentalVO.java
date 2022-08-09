package com.domain;

public class RentalVO {
	
	private String no;
	private String userID;
	private String rent_time;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getRent_time() {
		return rent_time;
	}
	public void setRent_time(String rent_time) {
		this.rent_time = rent_time;
	}
	
	@Override
	public String toString() {
		return "RentalVO [no=" + no + ", userID=" + userID + ", rent_time=" + rent_time + "]";
	}
	
}
