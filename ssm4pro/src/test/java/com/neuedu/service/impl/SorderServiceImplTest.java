package com.neuedu.service.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.po.Sorder;
import com.neuedu.service.SorderService;
import com.neuedu.vo.VInputRefund;
import com.neuedu.vo.VInputSorder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class SorderServiceImplTest {

	@Autowired
	SorderService sorderService;
	
	@Ignore
	@Test
	public void testAddSorder() throws Exception {
		Sorder sorder = new Sorder();
		sorder.setLid(100);
		sorder.setOpenid("100");
		sorder.setTotal(100);
		sorder.setCid("100");
		sorder.setActual(100);
		
		
		sorder.setQid(100);
		sorder.setTransactionid("100");
		sorder.setNickname("zzz100");
		sorder.setTel("100");
		sorderService.addSorder(sorder);
		
	}

	@Ignore
	@Test
	public void testCreateRefund() throws Exception {
		VInputRefund vir = new VInputRefund();
		vir.setOid(64);
		vir.setRefundReason("你管我");
		assertTrue(sorderService.createRefund(vir));
	}

	@Ignore
	@Test
	public void testShowSorder() throws Exception {
		sorderService.showSorder(1).forEach(System.out::println);
		
	}

	@Ignore
	@Test
	public void testShowSorderByOthers() throws Exception {
		VInputSorder vis = new VInputSorder();
		vis.setQid(1);
		//vis.setOid(9);
		vis.setStatus("待付款");
		vis.setStartTime("2018-05-26 00:00:01");
		vis.setEndTime("2018-05-26 23:00:01");
		sorderService.showSorderByOthers(vis).forEach(System.out::println);

	}

}
