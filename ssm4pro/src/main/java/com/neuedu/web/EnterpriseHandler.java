package com.neuedu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.service.EnterpriseService;
import com.neuedu.vo.VOutputEnterprise;

@Controller
public class EnterpriseHandler {
	@Autowired
	EnterpriseService enterpriseService;

	@RequestMapping(value = "enterprise/showEnterprise.action")
	@ResponseBody
	public VOutputEnterprise showEnterprise(int qid) throws Exception {
		System.out.println(qid);
		return enterpriseService.showEnterprise(qid);
	}
}
