package com.neuedu.service;

import java.util.List;

import com.neuedu.po.Point;
import com.neuedu.po.Refund;
import com.neuedu.po.Sorder;
import com.neuedu.vo.VInputRefund;

public interface PointService {
	public List<Point> showAll(int qid) throws Exception;
	public List<Point> showPointByOpenid(Point point) throws Exception;
	public boolean deletePoint(int id) throws Exception;
	public boolean editPoint(Point point) throws Exception;
	public boolean addPoint(Point point) throws Exception;
}
