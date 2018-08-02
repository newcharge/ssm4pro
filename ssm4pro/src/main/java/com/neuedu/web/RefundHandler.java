package com.neuedu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.po.Refund;
import com.neuedu.po.Sorder;
import com.neuedu.service.RefundService;
import com.neuedu.service.SorderService;
import com.neuedu.vo.VInputFreelistenbook;
import com.neuedu.vo.VInputSorder;
import com.neuedu.vo.VOutputFreelistenbook;

@Controller
public class RefundHandler {
	@Autowired
	RefundService refundService;
	
	@Autowired
	SorderService sorderService;
	
	@RequestMapping(value = "refund/showRefundByOid.action")
	@ResponseBody
	public Refund showRefundByOid(int oid) throws Exception {
		System.out.println(oid);
		return refundService.showByOid(oid);
	}
	
	@RequestMapping(value = "refund/showRefund.action")
	@ResponseBody
	public List<Sorder> showRefund(int qid) throws Exception {
		return refundService.showRefund(qid);
	}
	
	@RequestMapping(value = "refund/showRefundByOthers.action")
	@ResponseBody
	public List<Sorder> showRefundByOthers(String jsonData) throws Exception {
		VInputSorder vis = JsonUtils.jsonToPojo(jsonData, VInputSorder.class);
		
		if(vis.getStatus()=="")
			vis.setStatus(null);
		if(vis.getStartTime()=="")
			vis.setStartTime(null);
		if(vis.getEndTime()=="")
			vis.setEndTime(null);
		return sorderService.showRefundByOthers(vis);
	}
	
	@RequestMapping(value = "refund/dealRefund.action")
	@ResponseBody
	public boolean dealRefund(int oid) throws Exception {
		return refundService.editRefund(oid);
	}
}
