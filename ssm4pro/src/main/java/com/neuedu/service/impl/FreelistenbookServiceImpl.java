package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.FreelistenbookDao;
import com.neuedu.po.Freelistenbook;
import com.neuedu.service.FreelistenbookService;
import com.neuedu.vo.VInputFreelistenbook;
import com.neuedu.vo.VOutputFreelistenbook;

@Service
public class FreelistenbookServiceImpl implements FreelistenbookService {
	@Autowired
	FreelistenbookDao freelistenbookDao;
	
	@Transactional
	@Override
	public boolean addFreelistenbook(Freelistenbook freelistenbook) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = freelistenbookDao.addFreelistenbook(freelistenbook);
		
		return flag;
	}

	@Transactional
	@Override
	public boolean changeFreelistenbookState(Freelistenbook freelistenbook) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = freelistenbookDao.changeFreelistenbookState(freelistenbook);
		
		return flag;
	}

	@Transactional
	@Override
	public List<VOutputFreelistenbook> showFreelistenbook(int qid) throws Exception {
		// TODO Auto-generated method stub
		List<VOutputFreelistenbook> list;

		list = freelistenbookDao.showFreelistenbook(qid);
		return list;
	}

	@Transactional
	@Override
	public List<VOutputFreelistenbook> showFreelistenbookByOthers(VInputFreelistenbook vif) throws Exception {
		// TODO Auto-generated method stub
		List<VOutputFreelistenbook> list;

		list = freelistenbookDao.showFreelistenbookByOthers(vif);
		return list;
	}


}
