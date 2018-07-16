package com.neuedu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.po.Refund;
import com.neuedu.service.RefundService;

@Controller
public class RefundHandler {
	@Autowired
	RefundService refundService;
	
	@RequestMapping(value = "refund/showRefundByOid.action")
	@ResponseBody
	public Refund showRefundByOid(int oid) throws Exception {
		System.out.println(oid);
		return refundService.showByOid(oid);
	}
}
