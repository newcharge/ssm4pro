package com.neuedu.service;

import java.util.List;

import com.neuedu.po.Coupon;

public interface CouponService {
	public List<Coupon> showAll(int qid) throws Exception;
	public List<Coupon> showCouponByOthers(Coupon coupon) throws Exception;
	public boolean addCoupon(Coupon coupon) throws Exception;
	public boolean editCoupon(Coupon coupon) throws Exception;
	public boolean deleteCoupon(int cid) throws Exception;
	public List<Coupon> showTopCoupon(Coupon coupon, int rank) throws Exception;
}
