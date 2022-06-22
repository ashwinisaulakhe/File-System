package com.filesystem.springapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name= "userLogin", uniqueConstraints = @UniqueConstraint(columnNames = { "usermailid" }))
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="usermailid")
	private String userMailid;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	
	public User() {
		super();
	}


	public User(String username, String password) {
		super();
		
		this.username = username;
		this.password = password;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getUserMailid() {
		return userMailid;
	}


	public void setUserMailid(String userMailid) {
		this.userMailid = userMailid;
	}


	@Override
	public String toString() {
		return "UserLogin [id=" + id + ", userMailid=" + userMailid + ", username=" + username + ", password="
				+ password + "]";
	}


	public String getRole() {
		// TODO Auto-generated method stub
		return null;
	}


	


	
	
	
}
