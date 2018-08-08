package com.neuedu.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.FreelistenDao;
import com.neuedu.po.Freelisten;
import com.neuedu.service.FreelistenService;
import com.neuedu.web.JsonUtils;

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
		Jedis jedis = new Jedis("59.110.137.171", 6379);
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
		Jedis jedis = new Jedis("59.110.137.171", 6379);
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
		Jedis jedis = new Jedis("59.110.137.171", 6379);
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

	@Override
	public List<Freelisten> showTopLesson(int qid, int rank) throws Exception {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("59.110.137.171", 6379);
		String entry = String.join("-", Arrays.asList("freelisten", String.valueOf(qid)));
		long count = jedis.llen(entry);
		List<Freelisten> list;
		List<String> strList;
		if(count == 0) {
			list = freelistenDao.showFreelisten(qid);
			for(Freelisten freelisten : list) {
				jedis.lpush(entry, JsonUtils.ObjectToJson(freelisten));
			}
		}
		if(rank + 5 - 1 < count) {
			strList = jedis.lrange(entry, rank, rank + 5 - 1);
		} else if(rank < count) {
			strList = jedis.lrange(entry, rank, -1);
		} else {
			strList = Arrays.asList();
		}
		
		System.out.println(strList.size());
		list = new ArrayList<>();
		for(String couponStr : strList) {
			list.add(JsonUtils.jsonToPojo(couponStr, Freelisten.class));
		}
		
		jedis.close();
		return list;
	}
}
