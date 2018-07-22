package com.neuedu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.po.Sorder;
import com.neuedu.po.Teacher;
import com.neuedu.service.TeacherService;

@Controller
public class TeacherHandler {
	
	private static final int pageSize = 10;
	
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping(value = "teacher/showAll.action")
	@ResponseBody
	public List<Teacher> showTeacherByQid(int qid) throws Exception {
		return teacherService.showTeacher(qid);
	}
	
	@RequestMapping(value = "teacher/showAllByPage.action")
	@ResponseBody
	public PageInfo<Teacher> showTeacherPageByQid(int qid, int pageNum) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		return PageInfo.of(teacherService.showTeacher(qid));
	}
	
	@RequestMapping(value = "teacher/addTeacher.action")
	@ResponseBody
	public boolean addTeacher(String jsonData) throws Exception {
		Teacher teacher = JsonUtils.jsonToPojo(jsonData, Teacher.class);
//		System.out.println(teacher.getTname());
//		System.out.println(teacher.getTphoto());
//		System.out.println(teacher.getIntroduction());

		return teacherService.addTeacher(teacher);
	}
	
	@RequestMapping(value = "teacher/editTeacher.action")
	@ResponseBody
	public boolean editTeacher(String jsonData) throws Exception {
		Teacher teacher = JsonUtils.jsonToPojo(jsonData, Teacher.class);
		System.out.println(teacher.getTname());
		System.out.println(teacher.getTphoto());
		System.out.println(teacher.getIntroduction());

		return teacherService.editTeacher(teacher);
	}
	
	@RequestMapping(value = "teacher/deleteTeacher.action")
	@ResponseBody
	public boolean deleteTeacher(int tid) throws Exception {
		return teacherService.deleteTeacher(tid);
	}
}
