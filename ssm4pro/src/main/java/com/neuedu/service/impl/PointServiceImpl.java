package com.neuedu.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.CouponDao;
import com.neuedu.dao.PointDao;
import com.neuedu.po.Coupon;
import com.neuedu.po.Point;
import com.neuedu.service.PointService;


@Service
public class PointServiceImpl implements PointService {

	@Autowired
	PointDao pointDao;

	@Autowired
	CouponDao couponDao;

	@Transactional
	@Override
	public List<Point> showAll(int qid) throws Exception {
		// TODO Auto-generated method stub
		return pointDao.showAll(qid);
	}
	
	@Transactional
	@Override
	public Point showPointByOpenid(Point point) throws Exception {
		return pointDao.showPointByOpenid(point);
	}
	
	@Transactional
	@Override
	public boolean deletePoint(int id) throws Exception {
		return pointDao.deletePoint(id);
	}
	
	@Transactional
	@Override
	public boolean editPoint(Point point) throws Exception {
		return pointDao.editPoint(point);
	}
	
	@Transactional
	@Override
	public boolean addPoint(Point point) throws Exception {
		return pointDao.addPoint(point);
	}

	@Override
	public boolean exchange(String openid, int qid, int cost, int couponAmount) throws Exception {
		// TODO Auto-generated method stub
		Point point = new Point();
		point.setQid(qid);
		point.setOpenid(openid);
		point = pointDao.showPointByOpenid(point);
		if(point.getCount() < cost) return false;
		else {
			point.setCount(point.getCount() - cost);
			if(pointDao.editPoint(point)) {
				Coupon coupon = new Coupon();
				coupon.setQid(qid);
				coupon.setMoney(couponAmount);
				coupon.setOpenid(openid);
				coupon.setDeadline(LocalDate.now().toString());
				return couponDao.addCoupon(coupon);
			} else return false;
		}
	}
}
