package com.neuedu.service;

import java.util.List;

import com.neuedu.po.Teacher;

public interface TeacherService {
	public boolean addTeacher(Teacher teacher) throws Exception;
	public boolean deleteTeacher(int tid) throws Exception;
	public boolean editTeacher(Teacher teacher) throws Exception;
	public List<Teacher> showTeacher(int qid) throws Exception;
	public List<Teacher> showTopTeacher(int qid, int rank) throws Exception;
}
