package com.neuedu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.po.Sorder;
import com.neuedu.service.SorderService;
import com.neuedu.vo.VInputRefund;

@Controller
public class SorderHandler {
	
	@Autowired
	SorderService sorderService;
	
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
}
