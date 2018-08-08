package com.neuedu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
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
	@Ignore
	@Test
	public void testShowEnterprise() throws Exception {
		System.out.println(enterpriseService.showEnterprise(1));
	}

	@Ignore
	@Test
	public void testeditEnterprise() throws Exception {
		VInputEnterprise vie=new VInputEnterprise();
		List<String> imgList = new ArrayList<String>();
		imgList.add("zzz.jpg");
		vie.setImgList(imgList);
		vie.setQid(3);
		vie.setName("zzz");
		vie.setVideopath("zzz");
		vie.setIntroduction("zzz");
		vie.setJczs("zzz");
		System.out.println(enterpriseService.editEnterprise(vie));
	}

}
