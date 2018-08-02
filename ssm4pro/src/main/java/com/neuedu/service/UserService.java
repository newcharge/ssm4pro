package com.neuedu.service;

import com.neuedu.po.User;

public interface UserService 
{
	public Integer valid(User user) throws Exception;
	public boolean register(User user) throws Exception;
	
}
