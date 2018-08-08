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

	
	@Test
	public void testEditRefund() throws Exception {
		System.out.println(refundService.editRefund(12));
	}

	@Ignore
	@Test
	public void testShowRefundByOthers() throws Exception {
		VInputRefund vir = new VInputRefund();
		vir.setQid(1);
		vir.setOid(null);
		vir.setStatus(null);
		vir.setStarttime(null);
		vir.setEndtime(null);
		refundService.showRefundByOthers(vir).forEach(System.out::println);
		
	}
	
	@Ignore
	@Test
	public void showByOid() throws Exception {
		System.out.println(refundService.showByOid(11));
		
	}

}
