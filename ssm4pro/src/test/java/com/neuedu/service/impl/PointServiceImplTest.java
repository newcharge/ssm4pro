package com.neuedu.service.impl;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.po.Point;
import com.neuedu.service.PointService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})

public class PointServiceImplTest {

	@Autowired
	PointService pointService;
	
	@Ignore
	@Test
	public void testShowAll() throws Exception {
		pointService.showAll(1).forEach(System.out::println);
	}

	@Ignore
	@Test
	public void testShowPointByOpenid() throws Exception {
		Point point = new Point();
		point.setQid(1);
		point.setOpenid("vsdvsdvsd");
		pointService.showPointByOpenid(point);
	}

	@Ignore
	@Test
	public void testDeletePoint() throws Exception {
		System.out.println(pointService.deletePoint(5));
	}

	@Ignore
	@Test
	public void testEditPoint() throws Exception {
		Point point = new Point();
		point.setQid(1);
		point.setOpenid("zzz");
		point.setCount(222);
		point.setId(2);
		System.out.println(pointService.editPoint(point));
	}

	@Ignore
	@Test
	public void testAddPoint() throws Exception {
		Point point = new Point();
		point.setQid(1);
		point.setOpenid("zzzz");
		point.setCount(2222);
		System.out.println(pointService.addPoint(point));
	}

}
