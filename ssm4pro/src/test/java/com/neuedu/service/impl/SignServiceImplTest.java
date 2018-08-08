package com.neuedu.service.impl;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.po.Sign;
import com.neuedu.service.SignService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })

public class SignServiceImplTest {

	@Autowired
	SignService signService;
	
	@Ignore
	@Test
	public void testAddSign() throws Exception {
		Sign sign = new Sign();
		sign.setOpenid("18640552750");
		sign.setQid(1);
		sign.setSdate(LocalDate.of(2018, 6, 1).toString());
		System.out.println(signService.addSign(sign));
	}

	
	@Test
	public void testShowAllByEle() throws Exception {
		Sign sign = new Sign();
		sign.setOpenid("18640552750");
		sign.setQid(1);
		sign.setSdate(LocalDate.of(2018, 6, 1).toString());
		signService.showAllByEle(sign).forEach(System.out::println);;
	}

}
