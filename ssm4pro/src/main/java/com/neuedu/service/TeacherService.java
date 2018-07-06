package com.neuedu.service;

import java.util.List;

import com.neuedu.vo.VInputTeacher;
import com.neuedu.vo.VOutputTeacher;

public interface TeacherService {
	public boolean addTeacher(VInputTeacher vit);
	public boolean deleteTeacher(VInputTeacher vit);
	public boolean editTeacher(VInputTeacher vit);
	public List<VOutputTeacher> showTeacher(int qid);
	
	

}
