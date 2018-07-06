package com.neuedu.service;

import java.util.List;

import com.neuedu.po.Freelisten;
import com.neuedu.vo.VOutputFreelisten;

public interface FreelistenService 
{
	public boolean addFreelisten(Freelisten freelisetn) throws Exception;
	public boolean editFreelisten(Freelisten freelisetn) throws Exception;
	public boolean deleteFreelisten(int id) throws Exception;
	public List<Freelisten> showFreelisten(int qid) throws Exception;
	public List<Freelisten> showFreelistenByBranchId(Freelisten freelisetn) throws Exception;
}
