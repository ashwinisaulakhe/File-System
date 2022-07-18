package com.filesystem.springapp.dao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@Entity
public class UserData implements Serializable {

	
	@NotEmpty(message = "First name can not be empty")
	@ApiModelProperty(notes="name of user", name="firstName", required=true, value="ashwini")
	private String firstName;
	
	@NotEmpty(message = "Last name can not be empty")
	@ApiModelProperty(notes="name of user", name="Lastname", required=true, value="saulakhe")
	private String LastName;
	
	@NotEmpty(message = "Email can not be empty")
    @Email(message = "Please provide a valid email id")
	@ApiModelProperty(notes="email of user", name="email", required=true, value="ashwinis@123")
	private String email;
	
	@NotEmpty(message = "phone number can not be empty")
	@ApiModelProperty(notes="phone number of user", name="phoneNumber", required=true, value="8329646584")
	private String phoneNumber;
	
	@NotEmpty(message = "Password can not be empty")
	@ApiModelProperty(notes="password of user", name="password", required=true, value="@#$12345")
	private String password;
	
	@NotEmpty(message = " confirm Password can not be empty")
	private String confirmPassword;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
