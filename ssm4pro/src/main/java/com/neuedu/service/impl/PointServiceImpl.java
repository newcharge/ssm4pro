package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.PointDao;
import com.neuedu.po.Point;
import com.neuedu.service.PointService;


@Service
public class PointServiceImpl implements PointService {

	@Autowired
	PointDao pointDao;


	@Transactional
	@Override
	public List<Point> showAll(int qid) throws Exception {
		// TODO Auto-generated method stub
		return pointDao.showAll(qid);
	}
	
	@Transactional
	@Override
	public List<Point> showPointByOpenid(Point point) throws Exception {
		return pointDao.showPointByOpenid(point);
	}
	
	@Transactional
	@Override
	public boolean deletePoint(int id) throws Exception {
		return pointDao.deletePoint(id);
	}
	
	@Transactional
	@Override
	public boolean editPoint(Point point) throws Exception {
		return pointDao.editPoint(point);
	}
	
	@Transactional
	@Override
	public boolean addPoint(Point point) throws Exception {
		return pointDao.addPoint(point);
	}
}
