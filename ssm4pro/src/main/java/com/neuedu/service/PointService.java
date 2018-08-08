package com.neuedu.service;

import java.util.List;

import com.neuedu.po.Point;

public interface PointService {
	public List<Point> showAll(int qid) throws Exception;
	public Point showPointByOpenid(Point point) throws Exception;
	public boolean deletePoint(int id) throws Exception;
	public boolean editPoint(Point point) throws Exception;
	public boolean addPoint(Point point) throws Exception;
	public boolean exchange(String openid, int qid, int cost, int couponAmount) throws Exception;
}
