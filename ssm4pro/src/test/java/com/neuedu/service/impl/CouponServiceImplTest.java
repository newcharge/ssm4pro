package com.neuedu.service.impl;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.po.Address;
import com.neuedu.po.Coupon;
import com.neuedu.service.AddressService;
import com.neuedu.service.CouponService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class CouponServiceImplTest {

	@Autowired
	CouponService couponService;
	
	
	@Test
	public void testShowAll() throws Exception {
		couponService.showAll(1).forEach(System.out::println);
	}

//	@Test
//	public void testShowAddress() throws Exception {
//		couponService.showAddress(1).forEach(System.out::println);
//		
//	}

}
