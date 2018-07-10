package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.SorderDao;
import com.neuedu.po.Sorder;
import com.neuedu.service.SorderService;
import com.neuedu.vo.VInputSorder;

@Service
public class SorderServiceImpl implements SorderService{

	@Autowired
	SorderDao sorderDao;
	@Transactional
	@Override
	public boolean addSorder(Sorder sorder) throws Exception {
		// TODO Auto-generated method stub
		return sorderDao.addSorder(sorder);
	}

	@Transactional
	@Override
	public boolean changeSorderState(Sorder sorder) throws Exception {
		// TODO Auto-generated method stub
		return sorderDao.changeSorderState(sorder);
	}
	
	
	@Transactional
	@Override
	public List<Sorder> showSorder(int qid) throws Exception {
		// TODO Auto-generated method stub
		return sorderDao.showSorder(qid);
	}
	
	@Transactional
	@Override
	public List<Sorder> showSorderByOthers(VInputSorder vis) throws Exception {
		// TODO Auto-generated method stub
		return sorderDao.showSorderByOthers(vis);
	}

	

}
