package com.neuedu.service;

import java.util.List;

import com.neuedu.po.User;

public interface UserService 
{
	public boolean valid(User user) throws Exception ;
	public List<User> findAll() throws Exception;
}
