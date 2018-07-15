package com.neuedu.service;

import java.util.List;

import com.neuedu.po.Freelisten;

public interface FreelistenService 
{
	public boolean addFreelisten(Freelisten freelisetn) throws Exception;
	public boolean editFreelisten(Freelisten freelisetn) throws Exception;
	public boolean deleteFreelisten(int id) throws Exception;
	public List<Freelisten> showFreelisten(int qid) throws Exception;
	public Freelisten showFreelistenById(int id) throws Exception;
	public List<Freelisten> showFreelistenByBranchId(int branchid) throws Exception;
}
