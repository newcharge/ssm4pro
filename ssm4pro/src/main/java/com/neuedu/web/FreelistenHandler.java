package com.neuedu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.po.Freelisten;
import com.neuedu.service.FreelistenService;

@Controller
public class FreelistenHandler {

	@Autowired
	FreelistenService freelistenService;
	
	@RequestMapping(value = "freelisten/showFreelisten.action")
	@ResponseBody
	public List<Freelisten> showFreelisten(int qid) throws Exception {
		return freelistenService.showLastThreeFreelisten(qid);
	}
	
	@RequestMapping(value = "freelisten/getFreelisten.action")
	@ResponseBody
	public Freelisten getFreelisten(int id) throws Exception {
		return freelistenService.showFreelistenById(id);
	}
}
