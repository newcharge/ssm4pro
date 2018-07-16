package com.neuedu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.po.Lesson;
import com.neuedu.service.LessonService;
import com.neuedu.vo.VOutputLesson;

@Controller
public class LessonHandler {

	@Autowired
	LessonService lessonService;

	@RequestMapping(value = "lesson/showLesson.action")
	@ResponseBody
	public List<Lesson> showLesson(int qid) throws Exception {
		System.out.println(qid);
		return lessonService.showLesson(qid);
	}
	
	@RequestMapping(value = "lesson/deleteLesson.action")
	@ResponseBody
	public boolean deleteLesson(int id) throws Exception {
		System.out.println(id);
		return lessonService.deleteLesson(id);
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
}
