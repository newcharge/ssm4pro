package com.neuedu.service;

import java.util.List;

import com.neuedu.vo.VInputFreelisten;
import com.neuedu.vo.VOutputFreelisten;

public interface FreelistenService 
{
	public boolean addFreelisten(VInputFreelisten vif);
	public boolean editFreelisten(VInputFreelisten vif);
	public boolean deleteFreelisten(VInputFreelisten vif);
	public List<VOutputFreelisten> showFreelisten(int qid);
}
