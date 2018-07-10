package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.FreelistenbookDao;
import com.neuedu.po.Freelistenbook;
import com.neuedu.service.FreelistenbookService;
import com.neuedu.vo.VInputFreelistenbook;

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
	public List<Freelistenbook> showFreelistenbook(int qid) throws Exception {
		// TODO Auto-generated method stub
		List<Freelistenbook> list;

		list = freelistenbookDao.showFreelistenbook(qid);
		return list;
	}

	@Transactional
	@Override
	public List<Freelistenbook> showFreelistenbookByOthers(VInputFreelistenbook vif) throws Exception {
		// TODO Auto-generated method stub
		List<Freelistenbook> list;

		list = freelistenbookDao.showFreelistenbookByOthers(vif);
		return list;
	}


}
