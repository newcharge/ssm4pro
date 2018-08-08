package com.neuedu.service.impl;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.po.Coupon;
import com.neuedu.service.CouponService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class CouponServiceImplTest {

	@Autowired
	CouponService couponService;
	@Ignore
	@Test
	public void testShowAll() throws Exception{
		couponService.showAll(1).forEach(System.out::println);
	}
	@Ignore
	@Test
	public void testshowCouponByOthers() throws Exception{
		Coupon vic=new Coupon();
		vic.setOpenid("zzz");
		couponService.showCouponByOthers(vic).forEach(System.out::println);
	}
	
	@Ignore
	@Test
	public void testaddCoupon() throws Exception{
		Coupon vic=new Coupon();
		vic.setQid(1);
		System.out.println(couponService.addCoupon(vic));
	}
	@Ignore
	@Test
	public void testdeleteCoupon() throws Exception{
		Coupon vic=new Coupon();
		vic.setQid(1);
		vic.setCid(12);
		System.out.println(couponService.addCoupon(vic));
	}
	@Ignore
	@Test
	public void testeditCoupon() throws Exception{
		Coupon vic=new Coupon();
		vic.setQid(1);
		vic.setCid(12);
		System.out.println(couponService.addCoupon(vic));
	}
	
	

}
