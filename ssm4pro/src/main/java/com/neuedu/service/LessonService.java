package com.neuedu.service;

import java.util.List;

import com.neuedu.po.Lesson;
import com.neuedu.vo.VInputLesson;

public interface LessonService {
	public boolean addLesson(VInputLesson vil) throws Exception;
	public boolean deleteLesson(int id) throws Exception;
	public boolean editLesson(VInputLesson vil) throws Exception;
	public List<Lesson> showLesson(int qid) throws Exception;
	public List<Lesson> showLessonByBranchId(VInputLesson vil) throws Exception;//之前的注释是乱码
}
