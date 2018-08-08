package com.neuedu.service;

import java.util.List;

import com.neuedu.po.Lesson;
import com.neuedu.vo.VInputLesson;
import com.neuedu.vo.VOutputLesson;

public interface LessonService {
	public boolean addLesson(VInputLesson vil) throws Exception;
	public boolean deleteLesson(int id) throws Exception;
	public boolean editLesson(VInputLesson vil) throws Exception;
	public List<Lesson> showLesson(int qid) throws Exception;
	public List<Lesson> showLessonByBranchId(int branchid) throws Exception;//之前的注释是乱码
	public List<Lesson> showLastThreeLesson(int qid) throws Exception;
	public VOutputLesson getLessonById(int id) throws Exception;
	public int showLessonAmount(int qid) throws Exception;
	public List<Lesson> showTopLesson(int qid, int rank, int range) throws Exception;
}
