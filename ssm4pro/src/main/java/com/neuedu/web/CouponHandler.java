package com.neuedu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.po.Coupon;
import com.neuedu.service.CouponService;

@Controller
public class CouponHandler {
	private static final int pageSize = 10;
	@Autowired
	CouponService couponService;
	
	@RequestMapping(value = "coupon/showAll.action")
	@ResponseBody
	public List<Coupon> showAll(int qid) throws Exception {
		return couponService.showAll(qid);
	}
	
	@RequestMapping(value = "coupon/showAllByPage.action")
	@ResponseBody
	public PageInfo<Coupon> showAllByPage(int qid,int pageNum) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		return PageInfo.of(couponService.showAll(qid));
	}
	
	@RequestMapping(value = "coupon/showCouponByOthers.action")
	@ResponseBody
	public List<Coupon> showCouponByOthers(String jsonData) throws Exception {
		Coupon coupon = JsonUtils.jsonToPojo(jsonData, Coupon.class);
		return couponService.showCouponByOthers(coupon);
	}
	
	@RequestMapping(value = "coupon/showCouponByOpenid.action")
	@ResponseBody
	public List<Coupon> showCouponByOpenid(String jsonData) throws Exception {
		Coupon vic = JsonUtils.jsonToPojo(jsonData, Coupon.class);
		return couponService.showCouponByOpenid(vic);
	}
	
	@RequestMapping(value = "coupon/showCouponByOthersByPage.action")
	@ResponseBody
	public PageInfo<Coupon> showCouponByOthersByPage(String jsonData,int pageNum) throws Exception {
		Coupon coupon = JsonUtils.jsonToPojo(jsonData, Coupon.class);
		
		if(coupon.getOpenid()=="")
			coupon.setOpenid(null);;
		if(coupon.getCategory()=="")
			coupon.setCategory(null);
		System.out.println(coupon.getQid());
		System.out.println(coupon.getCid());
		System.out.println(coupon.getOpenid());
		System.out.println(coupon.getCategory());
		PageHelper.startPage(pageNum, pageSize);
		return PageInfo.of(couponService.showCouponByOthers(coupon));
	}
	
	@RequestMapping(value = "coupon/editCoupon.action")
	@ResponseBody
	public boolean editCoupon(String jsonData) throws Exception {
		Coupon vic = JsonUtils.jsonToPojo(jsonData, Coupon.class);
		System.out.println(vic.getQid());
		System.out.println(vic.getCid());
		System.out.println(vic.getCategory());
		System.out.println(vic.getMoney());
		System.out.println(vic.getDeadline());
		System.out.println(vic.getOpenid());
		
		return couponService.editCoupon(vic);
	}
	
	@RequestMapping(value = "coupon/deleteCoupon.action")
	@ResponseBody
	public boolean deleteCoupon(int cid) throws Exception {
		System.out.println(cid);
		return couponService.deleteCoupon(cid);
	}
	
	@RequestMapping(value = "coupon/addCoupon.action")
	@ResponseBody
	public boolean addCoupon(String jsonData) throws Exception {
		Coupon vic = JsonUtils.jsonToPojo(jsonData, Coupon.class);
		System.out.println(vic.getQid());
		System.out.println(vic.getCategory());
		System.out.println(vic.getMoney());
		System.out.println(vic.getDeadline());
		System.out.println(vic.getOpenid());
		
		return couponService.addCoupon(vic);
	}
	
	@RequestMapping(value = "coupon/showTopCoupon.action")
	@ResponseBody
	public List<Coupon> showTopCoupon(String jsonData, int rank) throws Exception {
		Coupon coupon = JsonUtils.jsonToPojo(jsonData, Coupon.class);
		
		return couponService.showTopCoupon(coupon, rank);
	}
}
