package com.dao;

public class UserDao {
	
	public boolean validate(String email , String password)
	{
		if(email.equals("admin@gmail.com")&&
		password.equals("admin123"))
		{
			return true;
		}
	
	
	return false;
	}

}
