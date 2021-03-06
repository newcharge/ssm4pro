package com.neuedu.service;

import java.util.List;

import com.neuedu.po.Sorder;
import com.neuedu.vo.VInputRefund;
import com.neuedu.vo.VInputSorder;

public interface SorderService 
{
	public boolean addSorder(Sorder sorder) throws Exception;
	public boolean createRefund(VInputRefund vir) throws Exception;
	public List<Sorder> showSorder(int qid) throws Exception;
	public List<Sorder> showSorderByOthers(VInputSorder vis) throws Exception;
}
