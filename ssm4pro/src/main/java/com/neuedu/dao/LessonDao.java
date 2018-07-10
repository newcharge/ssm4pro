package com.neuedu.dao;

import java.util.List;

import com.neuedu.po.Lesson;

public interface LessonDao {
	public boolean addLesson(Lesson lesson) throws Exception;
	public boolean deleteLesson(int id) throws Exception;
	public boolean updateLesson(Lesson lesson) throws Exception;
	public List<Lesson> findAllByQid(int qid) throws Exception;
	public List<Lesson> findAllByEle(Lesson lesson) throws Exception;
}
