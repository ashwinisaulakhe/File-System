package com.filesystem.springapp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name= "user_reg",uniqueConstraints = @UniqueConstraint(columnNames = { "usermMailid" }))
public class UserData implements Serializable {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 4419553432988763833L;

	@NotEmpty(message = "Username can not be empty")
    private String userName;
	
    @NotEmpty(message = "Phone number can not be empty")
	private String userPhno;
	
    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Please provide a valid email id")
	private String userMailid;
	
    @NotEmpty(message = "Password can not be empty")
	private String userPasswd;
	
    @NotEmpty(message = "Password can not be empty")
	private String confirmPass;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhno() {
		return userPhno;
	}

	public void setUserPhno(String userPhno) {
		this.userPhno = userPhno;
	}

	public String getUserMailid() {
		return userMailid;
	}

	public void setUserMailid(String userMailid) {
		this.userMailid = userMailid;
	}

	public String getUserPasswd() {
		return userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}
    
    
}
