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
		return lessonService.showLastThreeLesson(qid);
	}
	
	@RequestMapping(value = "lesson/showAll.action")
	@ResponseBody
	public List<Lesson> showAll(int qid) throws Exception {
		return lessonService.showLesson(qid);
	}
	
	@RequestMapping(value = "lesson/showLessonById.action")
	@ResponseBody
	public VOutputLesson showLessonById(int lid) throws Exception {
		System.out.println(lid);
		return lessonService.getLessonById(lid);
	}
}
