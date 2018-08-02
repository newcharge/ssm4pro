package com.neuedu.dao;

import com.neuedu.po.User;

public interface UserDao {
	public Integer valid(User user) throws Exception;
	public boolean register(User user) throws Exception;
}
