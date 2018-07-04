package com.neuedu.dao;

import java.util.List;

import com.neuedu.po.User;

public interface UserDao {
	public List<User> findAll() throws Exception;
}
