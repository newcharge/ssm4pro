package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.CouponDao;
import com.neuedu.po.Coupon;
import com.neuedu.service.CouponService;
import com.neuedu.vo.VInputCoupon;
import com.neuedu.vo.VOutputCoupon;

@Service
public class CouponServiceImpl implements CouponService {
	@Autowired
	private CouponDao couponDao;
	
	@Override
	public List<Coupon> showAll(int qid) throws Exception {
		return couponDao.showAll(qid);
	}
	
	@Override
	public List<Coupon> showCouponByOthers(Coupon vic) throws Exception {
		return couponDao.showCouponByOthers(vic);
	}
	
	@Override
	public boolean addCoupon(Coupon vic) throws Exception {
		return couponDao.addCoupon(vic);
	}
	
	@Override
	public boolean editCoupon(Coupon vic) throws Exception {
		return couponDao.editCoupon(vic);
	}
	
	@Override
	public boolean deleteCoupon(int cid) throws Exception {
		return couponDao.deleteCoupon(cid);
	}
}
