package com.Email.Model;

public class EmailResponce {
	

	String token;

	public EmailResponce(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	@Override
	public String toString() {
		return "EmailResponce [token=" + token + "]";
	}
	

}
