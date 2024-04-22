package com.etour.securityconfig;

import org.springframework.stereotype.Repository;

import com.etour.entities.Customers;

@Repository
public class JwtRepository
{
	public boolean findUser(Customers myuser)
	   {
		System.out.println("inside findUser method");
		String uname=myuser.getUsername();
		String pwd=myuser.getPassword();
		return uname.equalsIgnoreCase("etour") && pwd.equals("tour");
		
	   }
}
