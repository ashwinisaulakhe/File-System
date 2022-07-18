package com.filesystem.springapp.entities;

import javax.persistence.Entity;

@Entity
public class ResponseMessage {

	private String message;

	  public ResponseMessage(String message) {
	    this.message = message;
	  }

	  public String getMessage() {
	    return message;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }
}
