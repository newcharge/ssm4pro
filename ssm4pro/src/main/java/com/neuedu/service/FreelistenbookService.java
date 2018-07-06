
package com.neuedu.service;

import java.util.List;

import com.neuedu.vo.VInputFreelistenbook;
import com.neuedu.vo.VOutputFreelistenbook;

public interface FreelistenbookService 
{
	public boolean addFreelistenbook(VInputFreelistenbook vif);
	
	public boolean changeFreelistenbookState(VInputFreelistenbook vif);
	
	public List<VOutputFreelistenbook> showFreelistenbook(int qid);
	public VOutputFreelistenbook showFreelistenbookById(VInputFreelistenbook vif);
	public List<VOutputFreelistenbook> showFreelistenbookByState(VInputFreelistenbook vif);
	public List<VOutputFreelistenbook> showFreelistenbookByPubtime(VInputFreelistenbook vif);
}
