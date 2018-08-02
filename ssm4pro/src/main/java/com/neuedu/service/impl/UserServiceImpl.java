package com.neuedu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.EnterpriseDao;
import com.neuedu.dao.UserDao;
import com.neuedu.po.User;
import com.neuedu.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	@Autowired
	EnterpriseDao enterpriseDao;

	@Transactional
	@Override
	public Integer valid(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.valid(user);
	}
	
	@Transactional
	@Override
	public boolean register(User user) throws Exception {
		boolean flag = (enterpriseDao.addEnterprise() && userDao.register(user));
		
		return flag;
	}
}
