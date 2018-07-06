package com.neuedu.service.impl;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.service.SwiperService;
import com.neuedu.vo.VInputSwiper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class SwiperServiceImplTest {

	@Autowired
	SwiperService swiperService;
	
	@Test
	public void testShowSwiperByCategory() {
		VInputSwiper viswiper = new VInputSwiper();
		viswiper.setQid(1);
		viswiper.setCategory("A");
		List<String> result = swiperService.showSwiperByCategory(viswiper);
		result.forEach(System.out::println);
		assertTrue(true);
	}

}
