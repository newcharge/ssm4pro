package com.neuedu.dao;

import java.util.List;

import com.neuedu.po.Lessonbranch;

public interface LessonbranchDao {
	public boolean insert(Lessonbranch lessonbranch) throws Exception;
	public boolean delete(int id) throws Exception;
	public boolean deleteBranchesByLid(int lid) throws Exception;
	public boolean update(Lessonbranch lessonbranch) throws Exception;
	public Lessonbranch findById(int id) throws Exception;
	public List<Integer> findBranchidByLid(int lid) throws Exception;
}
