package com.neuedu.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.UserDao;
import com.neuedu.po.User;
import com.neuedu.service.UserService;
import com.neuedu.vo.VInputUser;
import com.neuedu.vo.VUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Transactional
	@Override
	public List<VUser> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<VUser> list = Arrays.asList();
		list = userDao.findAll().stream().map(ele -> toVUser(ele)).collect(Collectors.toList());
		return list;
	}

	@Override
	public boolean valid(VInputUser viu) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private VUser toVUser(User user) {
		VUser vUser = new VUser();
		vUser.setId(user.getId());
		vUser.setUsername(user.getUsername());
		vUser.setUserpassword(user.getUserpassword());
		vUser.setJurisdiction(user.getJurisdiction());
		vUser.setQid(user.getQid());
		return vUser;
	}
}
