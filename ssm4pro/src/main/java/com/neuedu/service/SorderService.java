package com.neuedu.service;

import java.util.List;

import com.neuedu.vo.VInputSorder;
import com.neuedu.vo.VOutputSorder;

public interface SorderService 
{
	public boolean addSorder(VInputSorder vis);
	
	public boolean changeSorderState(VInputSorder vis);
	
	public List<VOutputSorder> showSorder(int qid);
	public VOutputSorder showSorderById(VInputSorder vis);
	public List<VOutputSorder> showSorderByState(VInputSorder vis);
	public List<VOutputSorder> showSorderByPubtime(VInputSorder vis);
}
