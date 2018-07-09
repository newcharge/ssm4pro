package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.LessonDao;
import com.neuedu.dao.LessonbranchDao;
import com.neuedu.po.Lesson;
import com.neuedu.po.Lessonbranch;
import com.neuedu.service.LessonService;
import com.neuedu.vo.VInputLesson;

@Service
public class LessonServiceImpl implements LessonService {

	@Autowired
	LessonDao lessonDao;

	@Autowired
	LessonbranchDao lessonbranchDao;

	
	@Transactional
	@Override
	public boolean addLesson(VInputLesson vil) throws Exception {
		// TODO Auto-generated method stub
		Lesson lesson = vil.getLesson();
		Lessonbranch lessonbranch = new Lessonbranch();
		lessonbranch.setBranchid(vil.getBranchId());
		if(lessonDao.addLesson(lesson)) {
			lessonbranch.setLid(lesson.getId());
			if(lessonbranchDao.insert(lessonbranch)) {
				return true;
			}
		}
		return false;
	}

	@Transactional
	@Override
	public boolean deleteLesson(int id) throws Exception {
		// TODO Auto-generated method stub
		//记得补上完整性约束(R/N)
		return lessonDao.deleteLesson(id);
	}

	@Transactional
	@Override
	public boolean editLesson(VInputLesson vil) throws Exception {
		// TODO Auto-generated method stub
		Lesson lesson = vil.getLesson();
		Lessonbranch lessonbranch = new Lessonbranch();
		lessonbranch.setBranchid(vil.getBranchId());
		lessonbranch.setId(lesson.getId());
		if(lessonDao.updateLesson(lesson)) {
			if(lessonbranchDao.update(lessonbranch)) {
				return true;
			}
		}
		return false;
	}

	@Transactional
	@Override
	public List<Lesson> showLesson(int qid) throws Exception {
		// TODO Auto-generated method stub
		return lessonDao.findAllByQid(qid);
	}

	@Transactional
	@Override
	public List<Lesson> showLessonByBranchId(VInputLesson vil) throws Exception {
		// TODO Auto-generated method stub
		return null;
		//待实现
	}

}
