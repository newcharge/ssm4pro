package com.neuedu.dao;

import java.util.List;

import com.neuedu.po.Freelistenbook;
import com.neuedu.vo.VInputFreelistenbook;

public interface FreelistenbookDao 
{
	//添加预约
	public boolean addFreelistenbook(Freelistenbook freelistenbook) throws Exception;
	//改变状态
	public boolean changeFreelistenbookState(Freelistenbook freelistenbook) throws Exception;
	//全部查询
	public List<Freelistenbook> showFreelistenbook(int qid) throws Exception;
	//三种带参查询
	public List<Freelistenbook> showFreelistenbookByOthers(VInputFreelistenbook vif) throws Exception;
}
