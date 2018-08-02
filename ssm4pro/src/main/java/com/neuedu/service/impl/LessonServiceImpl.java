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
import com.neuedu.vo.VInputLessonB;
import com.neuedu.vo.VOutputLesson;

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
		List<Integer> branches = vil.getBranches();
		if (lessonDao.addLesson(lesson)) {
			lessonbranchDao.deleteBranchesByLid(lesson.getLid());
			for (Integer branchid : branches) {
				Lessonbranch lessonbranch = new Lessonbranch();
				lessonbranch.setBranchid(branchid);
				lessonbranch.setLid(lesson.getLid());
				if(lessonbranchDao.insert(lessonbranch) == false) return false;
			}
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public boolean deleteLesson(int id) throws Exception {
		// TODO Auto-generated method stub
		// 记得补上完整性约束(R/N)，暂时(D)
		if(lessonDao.deleteLesson(id)) {
			if(lessonbranchDao.deleteBranchesByLid(id)) {
				return true;
			}
		}
		return false;
	}

	@Transactional
	@Override
	public boolean editLesson(VInputLesson vil) throws Exception {
		// TODO Auto-generated method stub
		Lesson lesson = vil.getLesson();
		List<Integer> branches = vil.getBranches();
		if (lessonDao.updateLesson(lesson)) {
			lessonbranchDao.deleteBranchesByLid(lesson.getLid());
			for (Integer branchid : branches) {
				Lessonbranch lessonbranch = new Lessonbranch();
				lessonbranch.setBranchid(branchid);
				lessonbranch.setLid(lesson.getLid());
				if(lessonbranchDao.insert(lessonbranch) == false) return false;
			}
			return true;
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
	public List<Lesson> showLessonByBranchId(int branchid) throws Exception {
		// TODO Auto-generated method stub
		return lessonDao.findAllByBranchid(branchid);
	}

	@Transactional
	@Override
	public List<Lesson> showLastThreeLesson(int qid) throws Exception {
		// TODO Auto-generated method stub
		return lessonDao.findLastThree(qid);
	}
	
	@Transactional
	@Override
	public VOutputLesson getLessonById(int id) throws Exception {
		// TODO Auto-generated method stub
		return lessonDao.findById(id);
	}
	
	@Transactional
	@Override
	public int showLessonAmount(int qid) throws Exception {
		return lessonDao.showLessonAmount(qid);
	}
}
