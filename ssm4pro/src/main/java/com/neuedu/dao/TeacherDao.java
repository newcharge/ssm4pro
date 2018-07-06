package com.neuedu.dao;

import java.util.List;

import com.neuedu.po.Teacher;

public interface TeacherDao {
	
	public boolean addTeacher(Teacher teacher) throws Exception;//从xml文件中定义方法
	public boolean deleteTeacher(int tid) throws Exception;
    public boolean editTeacher(Teacher teacher) throws Exception;
	public List<Teacher> showTeacher(int qid) throws Exception;
    
}

