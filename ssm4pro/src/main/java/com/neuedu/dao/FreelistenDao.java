package com.neuedu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.po.Freelisten;

public interface FreelistenDao 
{
	public boolean addFreelisten(Freelisten freelisten) throws Exception;
	public boolean editFreelisten(Freelisten freelisten) throws Exception;
	public boolean deleteFreelisten(int id) throws Exception;
	public Freelisten showFreelistenById(int id) throws Exception;
	public List<Freelisten> showFreelisten(int qid) throws Exception;
	public List<Freelisten> findLastThree(int qid) throws Exception;
	public List<Freelisten> showFreelistenByBranchId(Freelisten freelisten) throws Exception;
	public int showFreelistenAmount(int qid) throws Exception;
}
