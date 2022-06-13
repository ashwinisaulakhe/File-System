package com.filesystem.springapp.web.dto;

public class UserRegistrationDto {

	private String userName;
	private long userPhno;
	private String userMailid;
	private String userPasswd;
	
	
	public UserRegistrationDto(String userName, long user_phno, String user_mailid, String user_passwd) {
		super();
		this.userName = userName;
		this.userPhno = user_phno;
		this.userMailid = user_mailid;
		this.userPasswd = user_passwd;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getUser_phno() {
		return userPhno;
	}
	public void setUser_phno(long user_phno) {
		this.userPhno = user_phno;
	}
	public String getUser_mailid() {
		return userMailid;
	}
	public void setUser_mailid(String user_mailid) {
		this.userMailid = user_mailid;
	}
	public String getUser_passwd() {
		return userPasswd;
	}
	public void setUser_passwd(String user_passwd) {
		this.userPasswd = user_passwd;
	}


	
	
	
}
