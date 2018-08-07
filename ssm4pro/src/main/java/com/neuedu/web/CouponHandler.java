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
	public PageInfo<Coupon> showAllByPage(int qid) throws Exception {
		return PageInfo.of(couponService.showAll(qid));
	}
	
	@RequestMapping(value = "coupon/showCouponByOthers.action")
	@ResponseBody
	public List<Coupon> showCouponByOthers(String jsonData) throws Exception {
		Coupon vic = JsonUtils.jsonToPojo(jsonData, Coupon.class);
		return couponService.showCouponByOthers(vic);
	}
	
	@RequestMapping(value = "coupon/showCouponByOthersByPage.action")
	@ResponseBody
	public PageInfo<Coupon> showCouponByOthersByPage(String jsonData,int pageNum) throws Exception {
		Coupon vic = JsonUtils.jsonToPojo(jsonData, Coupon.class);
		
		if(vic.getOpenid()=="")
			vic.setOpenid(null);;
		if(vic.getCategory()=="")
			vic.setCategory(null);
		System.out.println(vic.getQid());
		System.out.println(vic.getCid());
		System.out.println(vic.getOpenid());
		System.out.println(vic.getCategory());
		PageHelper.startPage(pageNum, pageSize);
		return PageInfo.of(couponService.showCouponByOthers(vic));
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
}
