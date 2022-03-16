package com.qa.api.gorest.pojo;

public class Credentials {
	// class variables
	private String username;
	private String password;
	
	// constructor
	public Credentials(String username, String password) {
		this.username = username;
		this.password = password;
	}

	// getter & setter methods
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
}
