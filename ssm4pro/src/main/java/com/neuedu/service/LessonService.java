package com.neuedu.service;

import java.util.List;

import com.neuedu.vo.VInputLesson;
import com.neuedu.vo.VOutputLesson;

public interface LessonService 
{
	public boolean addLesson(VInputLesson vil);
	public boolean deleteLesson(VInputLesson vil);
	public boolean editLesson(VInputLesson vil);
	public List<VOutputLesson> showLesson(int qid);
	public List<VOutputLesson> showLessonByBranchId(VInputLesson vil);//∂‡±Ì≤È—Ø
}
