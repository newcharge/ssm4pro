package com.neuedu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.po.Sorder;
import com.neuedu.service.SorderService;
import com.neuedu.utils.JsonUtils;
import com.neuedu.vo.VInputRefund;
import com.neuedu.vo.VInputSorder;
import com.neuedu.service.*;
@Controller
public class SorderHandler {
	private static final int pageSize = 10;
	@Autowired
	SorderService sorderService;
	CouponService coupinservice;
	@RequestMapping(value = "sorder/showAll.action")
	@ResponseBody
	public Sorder fretoend(String jsonData) throws Exception {
		System.out.println();
		return JsonUtils.jsonToPojo(jsonData, Sorder.class);
	}
	
	@RequestMapping(value = "sorder/showSorder.action")
	@ResponseBody
	public List<Sorder> showSorder(int qid) throws Exception {
		System.out.println();
		return sorderService.showSorder(qid);
	}
	
	@RequestMapping(value = "sorder/showSorderByOthers.action")
	@ResponseBody
	public List<Sorder> showSorderByOthers(String jsonData) throws Exception {
		VInputSorder vis = JsonUtils.jsonToPojo(jsonData, VInputSorder.class);
		if(vis.getStatus() == "")
			vis.setStatus(null);
		if(vis.getStartTime() == "")
			vis.setStartTime(null);
		if(vis.getEndTime() == "")
			vis.setEndTime(null);
		return sorderService.showSorderByOthers(vis);
	}
	@RequestMapping(value = "sorder/showSorderByOthersByPage.action")
	@ResponseBody
	public PageInfo<Sorder> showSorderByOthers(String jsonData,int pageNum) throws Exception {
		VInputSorder vis = JsonUtils.jsonToPojo(jsonData, VInputSorder.class);
		System.out.println(vis);
		if(vis.getStatus()=="")
			vis.setStatus(null);
		if(vis.getStartTime()=="")
			vis.setStartTime(null);
		if(vis.getEndTime()=="")
			vis.setEndTime(null);
		System.out.println(vis.getOid());
		System.out.println(vis.getStatus());
		System.out.println(vis.getStartTime());
		System.out.println(vis.getEndTime());
		PageHelper.startPage(pageNum, pageSize);
		return PageInfo.of(sorderService.showSorderByOthers(vis));
	}
	
	@RequestMapping(value = "sorder/showHeXiao.action")
	@ResponseBody
	public List<Sorder> showHeXiao(int qid) throws Exception {
		System.out.println(qid);
		return sorderService.showHeXiao(qid);
	}
	
	@RequestMapping(value = "sorder/showHeXiaoByOthers.action")
	@ResponseBody
	public List<Sorder> showHeXiaoByOthers(String jsonData) throws Exception {
		VInputSorder vis = JsonUtils.jsonToPojo(jsonData, VInputSorder.class);
		if(vis.getStatus()=="")
			vis.setStatus(null);
		if(vis.getStartTime()=="")
			vis.setStartTime(null);
		if(vis.getEndTime()=="")
			vis.setEndTime(null);
		return sorderService.showHeXiaoByOthers(vis);
	}
	@RequestMapping(value = "sorder/showHeXiaoByOthersByPage.action")
	@ResponseBody
	public PageInfo<Sorder> showHeXiaoByOthers(String jsonData,int pageNum) throws Exception {
		VInputSorder vis = JsonUtils.jsonToPojo(jsonData, VInputSorder.class);
		System.out.println(jsonData);
		System.out.println(pageNum);
		if(vis.getStatus()=="")
			vis.setStatus(null);
		if(vis.getStartTime()=="")
			vis.setStartTime(null);
		if(vis.getEndTime()=="")
			vis.setEndTime(null);
		PageHelper.startPage(pageNum, pageSize);
		return PageInfo.of(sorderService.showHeXiaoByOthers(vis));
	}
	
	@RequestMapping(value = "sorder/dealHeXiao.action")
	@ResponseBody
	public boolean dealHeXiao(int id) throws Exception {
		System.out.println(id);
		//CouponService couponService=new CouponService();
		return sorderService.dealHeXiao(id);
	}
	
	@RequestMapping(value = "order/addOrder.action")
	@ResponseBody
	public boolean addOrder(String jsonData) throws Exception {
		Sorder sorder = JsonUtils.jsonToPojo(jsonData, Sorder.class);
		System.out.println(sorder);
		return sorderService.addSorder(sorder);
	}
	
	

	@RequestMapping(value = "order/showAllByOpenid.action")
	@ResponseBody
	public List<Sorder> showAllByOpenid(String jsonData) throws Exception {
		Sorder sorder = JsonUtils.jsonToPojo(jsonData, Sorder.class);
		System.out.println(sorder);
		return sorderService.showSorderByEle(sorder);
	}
	
	@RequestMapping(value = "order/payroll.action")
	@ResponseBody
	public boolean payroll(int oid) throws Exception {
		System.out.println(oid);
		return sorderService.payroll(oid);
	}
	
	@RequestMapping(value = "order/refund.action")
	@ResponseBody
	public boolean refund(String jsonData) throws Exception {
		VInputRefund vir = JsonUtils.jsonToPojo(jsonData, VInputRefund.class);
		System.out.println(vir.getRefundReason());
		return sorderService.createRefund(vir);
	}
	
	@RequestMapping(value = "order/cancel.action")
	@ResponseBody
	public boolean cancel(int oid) throws Exception {
		return sorderService.cancel(oid);
	}
	
	@RequestMapping(value = "order/showAllByPage.action")
	@ResponseBody
	public PageInfo<Sorder> showSorderPageByQid(int qid, int pageNum) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		return PageInfo.of(sorderService.showSorder(qid));
	}
	@RequestMapping(value = "order/showHexiaoByPage.action")
	@ResponseBody
	public PageInfo<Sorder> showHexiaoByPageByQid(int qid, int pageNum) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		return PageInfo.of(sorderService.showHeXiao(qid));
	}
}
