package com.domain;

public class UserVO {

	/*
	 * USER_ID VARCHAR2(18) NOT NULL , USER_PW VARCHAR2(18) NOT NULL , NAME
	 * VARCHAR2(8) , BIRTH_DATE DATE , PHONE VARCHAR2(11) , PRIMARY KEY (USER_ID) );
	 */

	private String userID;
	private String userPW;
	private String name;
	private String birth;
	private String phone;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPW() {
		return userPW;
	}

	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
