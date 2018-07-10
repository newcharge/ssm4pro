package com.neuedu.dao;

import java.util.List;

import com.neuedu.po.Sorder;
import com.neuedu.vo.VInputSorder;



public interface SorderDao {

	public boolean addSorder(Sorder sorder) throws Exception;
	public boolean changeSorderState(Sorder sorder) throws Exception;
	public List<Sorder> showSorder(int qid) throws Exception;
	public List<Sorder> showSorderByOthers(VInputSorder vis) throws Exception;
}
