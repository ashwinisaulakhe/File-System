package com.filesystem.springapp.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name= "user_reg", uniqueConstraints = @UniqueConstraint(columnNames = { "user_mailid" }))
public class Registration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "user_name")
	private String userName;
	
	@Column(name= "userphno")
	private String userPhno;
	
	@Column(name="user_mailid")
	private String userMailid;
	
	@Column(name="user_passwd")
	private String userPasswd;
	
	@ManyToMany(fetch =FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(
			name= "users_roles",
			joinColumns= @JoinColumn(
			name= "user_id", referencedColumnName ="id"),
			inverseJoinColumns= @JoinColumn(
					name="role_id", referencedColumnName="id"))
	private Collection<Role> role;

	
	public Registration() {
		super();
	}


	public Registration(String userName, String user_phno, String user_mailid, String user_passwd,
			Collection<Role> role) {
		super();
		this.userName = userName;
		this.userPhno = user_phno;
		this.userMailid = user_mailid;
		this.userPasswd = user_passwd;
		this.role = role;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public Collection<Role> getRole() {
		return role;
	}


	public void setRole(Collection<Role> role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Registration [id=" + id + ", userName=" + userName + ", user_phno=" + userPhno + ", user_mailid="
				+ userMailid + ", user_passwd=" + userPasswd + ", role=" + role + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registration other = (Registration) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userMailid == null) {
			if (other.userMailid != null)
				return false;
		} else if (!userMailid.equals(other.userMailid))
			return false;
		if (userPasswd == null) {
			if (other.userPasswd != null)
				return false;
		} else if (!userPasswd.equals(other.userPasswd))
			return false;
		if (userPhno != other.userPhno)
			return false;
		return true;
	}

	
}