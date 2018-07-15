package com.neuedu.service.impl;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.po.Teacher;
import com.neuedu.service.TeacherService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})

public class TeacherServiceImplTest {

	@Autowired
	TeacherService teacherService;
	
	@Ignore
	@Test
	public void testAddTeacher() throws Exception {
		Teacher teacher = new Teacher();
		teacher.setTname("zzz");
		teacher.setTphoto("zzz1.jpg");
		teacher.setIntroduction("intro1");
		teacher.setQid(1);
		
		teacherService.addTeacher(teacher);
	}

	@Ignore
	@Test
	public void testDeleteTeacher() throws Exception {
		teacherService.deleteTeacher(4);
	}
	
	@Ignore
	@Test
	public void testEditTeacher() throws Exception {
		Teacher teacher = new Teacher();
		teacher.setTid(5);
		teacher.setTname("zzzchanged");
		teacher.setTphoto("zzz1changed.jpg");
		teacher.setIntroduction("intro1changed");
		teacher.setQid(1);
		
		teacherService.editTeacher(teacher);
	}

	@Ignore
	@Test
	public void testShowTeacher() throws Exception {
		teacherService.showTeacher(1).forEach(System.out::println);
	}

}
