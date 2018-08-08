package com.neuedu.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.po.Point;
import com.neuedu.service.PointService;

@Controller
public class PointHandler {
	private static final int pageSize = 10;
	@Autowired
	PointService pointService;
	
	@RequestMapping(value = "point/showAll.action")
	@ResponseBody
	public List<Point> showAll(int qid) throws Exception {
		return pointService.showAll(qid);
	}
	
	@RequestMapping(value = "point/showAllByPage.action")
	@ResponseBody
	public PageInfo<Point> showAllByPage(int qid,int pageNum) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		return PageInfo.of(pointService.showAll(qid));
	}
	
	@RequestMapping(value = "point/showPointByOpenid.action")
	@ResponseBody
	public Point showPointByOpenid(String jsonData) throws Exception {
		Point point = JsonUtils.jsonToPojo(jsonData, Point.class);
		if(point.getOpenid()=="")
			point.setOpenid(null);
		return pointService.showPointByOpenid(point);
	}
	
	@RequestMapping(value = "point/showPointByOpenidByPage.action")
	@ResponseBody
	public PageInfo<Point> showPointByOpenidByPage(String jsonData,int pageNum) throws Exception {
		Point point = JsonUtils.jsonToPojo(jsonData, Point.class);
		if(point.getOpenid()=="")
			point.setOpenid(null);
		PageHelper.startPage(pageNum, pageSize);
		return PageInfo.of(Arrays.asList(pointService.showPointByOpenid(point)));
	}
	
	@RequestMapping(value = "point/editPoint.action")
	@ResponseBody
	public boolean editPoint(String jsonData) throws Exception {
		Point point = JsonUtils.jsonToPojo(jsonData, Point.class);

		return pointService.editPoint(point);
	}
	
	@RequestMapping(value = "point/deletePoint.action")
	@ResponseBody
	public boolean deletePoint(int id) throws Exception {
		System.out.println(id);
		return pointService.deletePoint(id);
	}
	
	@RequestMapping(value = "point/addPoint.action")
	@ResponseBody
	public boolean addPoint(String jsonData) throws Exception {
		Point point = JsonUtils.jsonToPojo(jsonData, Point.class);

		return pointService.addPoint(point);
	}
	
	@RequestMapping(value = "point/exchange.action")
	@ResponseBody
	public boolean exchange(String openid, int qid, int cost, int couponAmount) throws Exception {
		return pointService.exchange(openid, qid, cost, couponAmount);
	}
	
	@RequestMapping(value = "point/initPoint.action")
	@ResponseBody
	public boolean initPoint(String jsonData) throws Exception {
		Point point = JsonUtils.jsonToPojo(jsonData, Point.class);
		Point pointbef = pointService.showPointByOpenid(point);
		if(pointbef == null || pointbef.getId() == 0) {
			return pointService.addPoint(point);
		} else {
			return false;
		}
	}
}
