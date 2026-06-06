package com.bean;

import com.dao.UserDao;

public class LoginBean {
	
	private String email;
	private String password;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validateUser()
	{
		UserDao dao = new UserDao();
		return dao.validate(email, password);
	}
	
	
	

}
