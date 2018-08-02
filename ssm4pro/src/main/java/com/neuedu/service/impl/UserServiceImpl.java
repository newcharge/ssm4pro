package com.neuedu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.UserDao;
import com.neuedu.po.User;
import com.neuedu.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Transactional
	@Override
	public boolean valid(User user) throws Exception {
		// TODO Auto-generated method stub
		if(userDao.valid(user) == null)
			return false;
		else
			return true;
			
	}
	

}
