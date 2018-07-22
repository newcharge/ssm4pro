package com.neuedu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.po.Lesson;
import com.neuedu.po.Teacher;
import com.neuedu.service.LessonService;
import com.neuedu.vo.VInputLesson;
import com.neuedu.vo.VOutputLesson;

@Controller
public class LessonHandler {
	private static final int pageSize = 10;

	@Autowired
	LessonService lessonService;
	
	@RequestMapping(value = "lesson/addLesson.action")
	@ResponseBody
	public boolean addLesson(String jsonData) throws Exception {
		VInputLesson vil = JsonUtils.jsonToPojo(jsonData, VInputLesson.class);
		System.out.println(vil);
		
		return lessonService.addLesson(vil);
	}
	
	@RequestMapping(value = "lesson/editLesson.action")
	@ResponseBody
	public boolean editLesson(String jsonData) throws Exception {
		VInputLesson vil = JsonUtils.jsonToPojo(jsonData, VInputLesson.class);
		System.out.println(vil);
		
		return lessonService.editLesson(vil);
	}


	@RequestMapping(value = "lesson/deleteLesson.action")
	@ResponseBody
	public boolean deleteLesson(int id) throws Exception {
		System.out.println(id);
		return lessonService.deleteLesson(id);
	}
	
	@RequestMapping(value = "lesson/showLastThreeLesson.action")
	@ResponseBody
	public List<Lesson> showLastThreeLesson(int qid) throws Exception {
		return lessonService.showLastThreeLesson(qid);
	}
	
	@RequestMapping(value = "lesson/showAll.action")
	@ResponseBody
	public List<Lesson> showAll(int qid) throws Exception {
		return lessonService.showLesson(qid);
	}
	
	@RequestMapping(value = "lesson/showLessonById.action")
	@ResponseBody
	public VOutputLesson showLessonById(int id) throws Exception {
		System.out.println(id);
		return lessonService.getLessonById(id);
	}
	
	@RequestMapping(value = "lesson/showLessonByBranch.action")
	@ResponseBody
	public List<Lesson> showLessonByBranch(int branchid) throws Exception {
		System.out.println(branchid);
		return lessonService.showLessonByBranchId(branchid);
	}
	@RequestMapping(value = "lesson/showAllByPage.action")
	@ResponseBody
	public PageInfo<Lesson> showTeacherPageByQid(int qid, int pageNum) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		return PageInfo.of(lessonService.showLesson(qid));
	}
}
