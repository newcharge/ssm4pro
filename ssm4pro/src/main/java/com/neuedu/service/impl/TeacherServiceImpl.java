package com.neuedu.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.TeacherDao;
import com.neuedu.po.Teacher;
import com.neuedu.service.TeacherService;
import com.neuedu.web.JsonUtils;

import redis.clients.jedis.Jedis;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherDao teacherDao;
	
	@Transactional
	@Override
	public boolean addTeacher(Teacher teacher) throws Exception {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("59.110.137.171", 6379);
		jedis.flushAll();
		jedis.close();
		return teacherDao.addTeacher(teacher);
	}

	@Transactional
	@Override
	public boolean deleteTeacher(int tid) throws Exception {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("59.110.137.171", 6379);
		jedis.flushAll();
		jedis.close();
		return teacherDao.deleteTeacher(tid);
	}

	@Transactional
	@Override
	public boolean editTeacher(Teacher teacher) throws Exception {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("59.110.137.171", 6379);
		jedis.flushAll();
		jedis.close();
		return teacherDao.editTeacher(teacher);
	}

	@Transactional
	@Override
	public List<Teacher> showTeacher(int qid) throws Exception {
		// TODO Auto-generated method stub
		return teacherDao.showTeacher(qid);
	}

	@Override
	public List<Teacher> showTopTeacher(int qid, int rank) throws Exception {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("59.110.137.171", 6379);
		String entry = String.join("-", Arrays.asList("teacher", String.valueOf(qid)));
		long count = jedis.llen(entry);
		List<Teacher> list;
		List<String> strList;
		if(count == 0) {
			list = teacherDao.showTeacher(qid);
			for(Teacher teacher : list) {
				jedis.lpush(entry, JsonUtils.ObjectToJson(teacher));
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
			list.add(JsonUtils.jsonToPojo(couponStr, Teacher.class));
		}
		
		jedis.close();
		return list;
	}

}
