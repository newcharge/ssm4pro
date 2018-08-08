package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.PointDao;
import com.neuedu.dao.SignDao;
import com.neuedu.po.Point;
import com.neuedu.po.Sign;
import com.neuedu.service.SignService;

@Service
public class SignServiceImpl implements SignService {

	@Autowired
	SignDao signDao;
	
	@Autowired
	PointDao pointDao;
	
	
	@Override
	public boolean addSign(Sign sign) throws Exception {
		// TODO Auto-generated method stub
		if(signDao.addSign(sign)) {
			Point point = new Point();
			point.setQid(sign.getQid());
			point.setOpenid(sign.getOpenid());
			point = pointDao.showPointByOpenid(point);
			point.setCount(point.getCount() + 20);
			return pointDao.editPoint(point);
		} else return false;
	}

	@Override
	public List<String> showAllByEle(Sign sign) throws Exception {
		// TODO Auto-generated method stub
		return signDao.showAllByEle(sign);
	}

}
