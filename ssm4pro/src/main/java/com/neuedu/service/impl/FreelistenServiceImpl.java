package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.FreelistenDao;
import com.neuedu.po.Freelisten;
import com.neuedu.service.FreelistenService;

import redis.clients.jedis.Jedis;

@Service
public class FreelistenServiceImpl implements FreelistenService {

	@Autowired
	FreelistenDao freelistenDao;
	
	@Transactional
	@Override
	public boolean addFreelisten(Freelisten freelisten) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		flag = freelistenDao.addFreelisten(freelisten);
		Jedis jedis = new Jedis();
		jedis.flushAll();
		jedis.close();
		return flag;
	}

	@Transactional
	@Override
	public boolean editFreelisten(Freelisten freelisten) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		flag = freelistenDao.editFreelisten(freelisten);
		Jedis jedis = new Jedis();
		jedis.flushAll();
		jedis.close();
		return flag;
	}

	@Transactional
	@Override
	public boolean deleteFreelisten(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;

		flag = freelistenDao.deleteFreelisten(id);
		Jedis jedis = new Jedis();
		jedis.flushAll();
		jedis.close();
		return flag;
	}

	@Transactional
	@Override
	public List<Freelisten> showFreelisten(int qid) throws Exception {
		// TODO Auto-generated method stub
		List<Freelisten> list;

		list = freelistenDao.showFreelisten(qid);
		return list;
	}
	
	@Transactional
	@Override
	public Freelisten showFreelistenById(int id) throws Exception {
		// TODO Auto-generated method stub

		return freelistenDao.showFreelistenById(id);
	}
	
	@Transactional
	@Override
	public List<Freelisten> showFreelistenByBranchId(int branchid) throws Exception {
		// TODO Auto-generated method stub
		List<Freelisten> list;

		list = freelistenDao.showFreelistenByBranchId(branchid);
		return list;
		
	}

	@Transactional
	@Override
	public List<Freelisten> showLastThreeFreelisten(int qid) throws Exception {
		// TODO Auto-generated method stub
		return freelistenDao.findLastThree(qid);
	}
	
	@Transactional
	@Override
	public int showFreelistenAmount(int qid) throws Exception {
		return freelistenDao.showFreelistenAmount(qid);
	}
}
