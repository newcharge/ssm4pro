package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.SignDao;
import com.neuedu.po.Sign;
import com.neuedu.service.SignService;

@Service
public class SignServiceImpl implements SignService {

	@Autowired
	SignDao signDao;
	
	@Override
	public boolean addSign(Sign sign) throws Exception {
		// TODO Auto-generated method stub
		return signDao.addSign(sign);
	}

	@Override
	public List<String> showAllByEle(Sign sign) throws Exception {
		// TODO Auto-generated method stub
		return signDao.showAllByEle(sign);
	}

}
