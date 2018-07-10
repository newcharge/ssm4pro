package com.neuedu.service.impl;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.dao.LessonDao;
import com.neuedu.po.Lesson;
import com.neuedu.service.LessonService;
import com.neuedu.vo.VInputLesson;
import com.neuedu.vo.VOutputLesson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class LessonServiceImplTest {

	@Autowired
	LessonService lessonService;

	@Autowired
	LessonDao lessonDao;

	@Ignore
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
		vilesson.setBranches(Arrays.asList(1, 2, 3));
		System.out.println(vilesson);
		assertTrue(lessonService.addLesson(vilesson));
	}

	@Test
	public void testDeleteLesson() throws Exception {
		assertTrue(lessonService.deleteLesson(26));
	}

	@Ignore
	@Test
	public void testEditLesson() throws Exception {
		VOutputLesson volesson = lessonService.getLessonById(26);
		VInputLesson vilesson = new VInputLesson();
		Lesson lesson = new Lesson();
		lesson.setLid(volesson.getLid());
		lesson.setLname(volesson.getLname() + "-another");
		lesson.setImgurl(volesson.getImgurl());
		lesson.setLprice(volesson.getLprice());
		lesson.setLdesc(volesson.getLdesc());
		lesson.setCategory(volesson.getCategory());
		lesson.setQid(volesson.getQid());
		lesson.setPubtime(volesson.getPubtime());
		vilesson.setLesson(lesson);
		vilesson.setBranches(Arrays.asList(5, 6, 7));
		System.out.println(volesson.toString());
		System.out.println(vilesson.toString());
		lessonService.editLesson(vilesson);
	}

	@Ignore
	@Test
	public void testShowLesson() throws Exception {
		lessonService.showLesson(1).forEach(System.out::println);
	}

	@Ignore
	@Test
	public void testShowLessonByBranchId() throws Exception {
		lessonService.showLessonByBranchId(1).forEach(System.out::println);
	}

	@Ignore
	@Test
	public void testGetLessonById() throws Exception {
		System.out.println(lessonService.getLessonById(26));
	}

}
