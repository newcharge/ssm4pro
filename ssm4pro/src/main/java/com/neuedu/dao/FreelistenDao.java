package com.neuedu.dao;

import java.util.List;

import com.neuedu.po.Freelisten;

public interface FreelistenDao 
{
	public boolean addFreelisten(Freelisten freelisten) throws Exception;
	public boolean editFreelisten(Freelisten freelisten) throws Exception;
	public boolean deleteFreelisten(int id) throws Exception;
	public Freelisten showFreelistenById(int id) throws Exception;
	public List<Freelisten> showFreelisten(int qid) throws Exception;
	public List<Freelisten> findLastThree(int qid) throws Exception;
	public List<Freelisten> showFreelistenByBranchId(int branchid) throws Exception;

}
