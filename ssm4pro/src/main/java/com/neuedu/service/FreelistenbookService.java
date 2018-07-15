
package com.neuedu.service;

import java.util.List;

import com.neuedu.po.Freelistenbook;
import com.neuedu.vo.VInputFreelistenbook;
import com.neuedu.vo.VOutputFreelistenbook;

public interface FreelistenbookService 
{
	//添加预约
	public boolean addFreelistenbook(Freelistenbook freelistenbook) throws Exception;
	//改变状态
	public boolean changeFreelistenbookState(Freelistenbook freelistenbook) throws Exception;
	//全部查询
	public List<VOutputFreelistenbook> showFreelistenbook(int qid) throws Exception;
	//三种带参查询
	public List<VOutputFreelistenbook> showFreelistenbookByOthers(VInputFreelistenbook vif) throws Exception;

	public List<Freelistenbook> showFreelistenbookByQidUser(VInputFreelistenbook vif) throws Exception;
}
