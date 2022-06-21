package com.filesystem.springapp.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@SuppressWarnings("serial")
@Entity
@Table(name= "user_reg",uniqueConstraints = @UniqueConstraint(columnNames = { "usermMailid" }))
public class UserRegistration implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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
	
	
	public UserRegistration() {
		super();
	}


	public UserRegistration(Long id, String userName, String userPhno, String userMailid, String userPasswd, String confirmPass
			) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPhno = userPhno;
		this.userMailid = userMailid;
		this.userPasswd = userPasswd;
		this.confirmPass= confirmPass;
		
	}
	

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUser_phno() {
		return userPhno;
	}


	public void setUser_phno(String user_phno) {
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
	
	public String getConfirmPass() {
		return confirmPass;
	}


	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}



	@Override
	public String toString() {
		return "Registration [id=" + id + ", userName=" + userName + ", user_phno=" + userPhno + ", user_mailid="
				+ userMailid + ", user_passwd=" + userPasswd + " + "+" confirm_pass= "+" ]";
	}


	


	
}