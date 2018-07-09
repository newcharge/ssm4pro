package com.neuedu.service.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.dao.LessonDao;
import com.neuedu.po.Lesson;
import com.neuedu.service.LessonService;
import com.neuedu.vo.VInputLesson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class LessonServiceImplTest {

	@Autowired
	LessonService lessonService;
	
	@Autowired
	LessonDao lessonDao;
	
	@Test
	public void testAddLesson() throws Exception {
		VInputLesson vilesson = new VInputLesson();
		Lesson lesson = new Lesson();
		lesson.setImgurl("test-url");
		lesson.setLdesc("test-desc");
		lesson.setLname("test-name");
		lesson.setLprice(0.02);
		lesson.setQid(1);
		lesson.setCategory("C++");
		vilesson.setLesson(lesson);
		vilesson.setBranchId(1);
		assertTrue(lessonService.addLesson(vilesson));
	}

	@Test
	public void testDeleteLesson() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditLesson() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowLesson() throws Exception {
		lessonService.showLesson(1).forEach(System.out::println);
	}

	@Test
	public void testShowLessonByBranchId() {
		fail("Not yet implemented");
	}

}
