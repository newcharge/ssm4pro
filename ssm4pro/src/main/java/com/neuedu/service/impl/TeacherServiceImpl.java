package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.TeacherDao;
import com.neuedu.po.Teacher;
import com.neuedu.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherDao teacherDao;
	
	@Transactional
	@Override
	public boolean addTeacher(Teacher teacher) throws Exception {
		// TODO Auto-generated method stub
		return teacherDao.addTeacher(teacher);
	}

	@Transactional
	@Override
	public boolean deleteTeacher(int tid) throws Exception {
		// TODO Auto-generated method stub
		return teacherDao.deleteTeacher(tid);
	}

	@Transactional
	@Override
	public boolean editTeacher(Teacher teacher) throws Exception {
		// TODO Auto-generated method stub
		return teacherDao.editTeacher(teacher);
	}

	@Transactional
	@Override
	public List<Teacher> showTeacher(int qid) throws Exception {
		// TODO Auto-generated method stub
		return teacherDao.showTeacher(qid);
	}

}
