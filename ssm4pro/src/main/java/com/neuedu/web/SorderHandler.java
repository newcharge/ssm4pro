package com.neuedu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.po.Sorder;
import com.neuedu.po.Teacher;
import com.neuedu.service.SorderService;
import com.neuedu.vo.VInputRefund;
import com.neuedu.vo.VInputSorder;

@Controller
public class SorderHandler {
	private static final int pageSize = 10;
	@Autowired
	SorderService sorderService;

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
		
		if(vis.getStatus()=="")
			vis.setStatus(null);
		if(vis.getStartTime()=="")
			vis.setStartTime(null);
		if(vis.getEndTime()=="")
			vis.setEndTime(null);
		return sorderService.showSorderByOthers(vis);
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
	@RequestMapping(value = "order/showAllByPage.action")
	@ResponseBody
	public PageInfo<Sorder> showSorderPageByQid(int qid, int pageNum) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		return PageInfo.of(sorderService.showSorder(qid));
	}
}
