package com.filesystem.springapp.entities;

public class Registration {
	
	private String userName;
	private long user_phno;
	private String user_mailid;
	private String user_passwd;
	private String confirm_pass;

	
	public Registration() {
		super();
	}


	public Registration(String userName, long user_phno, String user_mailid, String user_passwd, String confirm_pass) {
		super();
		this.userName = userName;
		this.user_phno = user_phno;
		this.user_mailid = user_mailid;
		this.user_passwd = user_passwd;
		this.confirm_pass = confirm_pass;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public long getUser_phno() {
		return user_phno;
	}


	public void setUser_phno(long user_phno) {
		this.user_phno = user_phno;
	}


	public String getUser_mailid() {
		return user_mailid;
	}


	public void setUser_mailid(String user_mailid) {
		this.user_mailid = user_mailid;
	}


	public String getUser_passwd() {
		return user_passwd;
	}


	public void setUser_passwd(String user_passwd) {
		this.user_passwd = user_passwd;
	}


	public String getConfirm_pass() {
		return confirm_pass;
	}


	public void setConfirm_pass(String confirm_pass) {
		this.confirm_pass = confirm_pass;
	}


	@Override
	public String toString() {
		return "Registration [userName=" + userName + ", user_phno=" + user_phno + ", user_mailid=" + user_mailid
				+ ", user_passwd=" + user_passwd + ", confirm_pass=" + confirm_pass + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((confirm_pass == null) ? 0 : confirm_pass.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((user_mailid == null) ? 0 : user_mailid.hashCode());
		result = prime * result + ((user_passwd == null) ? 0 : user_passwd.hashCode());
		result = prime * result + (int) (user_phno ^ (user_phno >>> 32));
		return result;
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
		if (confirm_pass == null) {
			if (other.confirm_pass != null)
				return false;
		} else if (!confirm_pass.equals(other.confirm_pass))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (user_mailid == null) {
			if (other.user_mailid != null)
				return false;
		} else if (!user_mailid.equals(other.user_mailid))
			return false;
		if (user_passwd == null) {
			if (other.user_passwd != null)
				return false;
		} else if (!user_passwd.equals(other.user_passwd))
			return false;
		if (user_phno != other.user_phno)
			return false;
		return true;
	}
	

}
