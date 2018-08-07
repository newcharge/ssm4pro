package com.neuedu.service;

import java.util.List;

import com.neuedu.po.Coupon;

public interface CouponService {
	public List<Coupon> showAll(int qid) throws Exception;
	public List<Coupon> showCouponByOthers(Coupon vic) throws Exception;
	public boolean addCoupon(Coupon vic) throws Exception;
	public boolean editCoupon(Coupon vic) throws Exception;
	public boolean deleteCoupon(int cid) throws Exception;
	
}
