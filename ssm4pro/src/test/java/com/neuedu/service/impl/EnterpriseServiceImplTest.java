package com.neuedu.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.service.EnterpriseService;
import com.neuedu.vo.VInputEnterprise;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class EnterpriseServiceImplTest {

	@Autowired
	EnterpriseService enterpriseService;
	
	@Test
	public void testShowEnterprise() throws Exception {
		System.out.println(enterpriseService.showEnterprise(1));
	}
	
	@Test
	public void testeditEnterprise() throws Exception {
		VInputEnterprise vie=new VInputEnterprise();
		vie.setQid(2);
		vie.setVideopath("aaa");
		vie.setIntroduction("bbb");
		vie.setJczs("aaa");
		vie.setName("zzz");
		System.out.println(enterpriseService.editEnterprise(vie));
	}

}
