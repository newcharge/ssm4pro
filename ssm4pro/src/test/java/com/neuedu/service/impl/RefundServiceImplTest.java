package com.neuedu.service.impl;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.service.RefundService;
import com.neuedu.vo.VInputRefund;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})

public class RefundServiceImplTest {

	@Autowired
	RefundService refundService;

	@Ignore
	@Test
	public void testEditRefund() throws Exception {
		refundService.editRefund(64);
	}

	@Ignore
	@Test
	public void testShowRefundByOthers() throws Exception {
		VInputRefund vir = new VInputRefund();
		vir.setQid(1);
		vir.setStatus("待处理");
		vir.setStarttime("2018-05-26 00:00:01");
		vir.setEndtime("2018-05-26 23:00:01");
		refundService.showRefundByOthers(vir).forEach(System.out::println);
		
	}

}
