package com.neuedu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.po.Teacher;
import com.neuedu.service.EnterpriseService;
import com.neuedu.vo.VInputEnterprise;
import com.neuedu.vo.VOutputEnterprise;

@Controller
public class EnterpriseHandler {
	@Autowired
	EnterpriseService enterpriseService;

	@RequestMapping(value = "enterprise/showEnterprise.action")
	@ResponseBody
	public VOutputEnterprise showEnterprise(int qid) throws Exception {
		return enterpriseService.showEnterprise(qid);
	}
	
	@RequestMapping(value = "enterprise/editEnterprise.action")
	@ResponseBody
	public boolean editEnterprise(String jsonData) throws Exception {
		VInputEnterprise vie = JsonUtils.jsonToPojo(jsonData, VInputEnterprise.class);
		System.out.println(vie.getQid());
		System.out.println(vie.getName());
		System.out.println(vie.getVideopath());
		System.out.println(vie.getIntroduction());
		System.out.println(vie.getJczs());
		System.out.println(vie.getImgList());
		return enterpriseService.editEnterprise(vie);
	}
	
}
