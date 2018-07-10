package com.neuedu.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.service.EnterpriseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class EnterpriseServiceImplTest {

	@Autowired
	EnterpriseService enterpriseService;
	
	@Test
	public void testShowEnterprise() throws Exception {
		System.out.println(enterpriseService.showEnterprise(1));
	}

}
