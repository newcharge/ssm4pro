package com.neuedu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.po.Freelisten;
import com.neuedu.service.FreelistenService;
import com.neuedu.vo.VInputLesson;

@Controller
public class FreelistenHandler {

	@Autowired
	FreelistenService freelistenService;

	@RequestMapping(value = "freelisten/addFreelisten.action")
	@ResponseBody
	public boolean addFreelisten(String jsonData) throws Exception {
		Freelisten freelisten = JsonUtils.jsonToPojo(jsonData, Freelisten.class);
		System.out.println(freelisten);
		return freelistenService.addFreelisten(freelisten);
	}
	
	@RequestMapping(value = "freelisten/editFreelisten.action")
	@ResponseBody
	public boolean editFreelisten(String jsonData) throws Exception {
		Freelisten freelisten = JsonUtils.jsonToPojo(jsonData, Freelisten.class);
		System.out.println(freelisten);
		return freelistenService.editFreelisten(freelisten);
	}
	
	
	@RequestMapping(value = "freelisten/showFreelisten.action")
	@ResponseBody
	public List<Freelisten> showFreelisten(int qid) throws Exception {
		return freelistenService.showFreelisten(qid);
	}
	
	@RequestMapping(value = "freelisten/showFreelistenByBranch.action")
	@ResponseBody
	public List<Freelisten> showFreelistenByBranch(int branchid) throws Exception {
		System.out.println(branchid);
		return freelistenService.showFreelistenByBranchId(branchid);
	}
	
	@RequestMapping(value = "freelisten/showFreelistenById.action")
	@ResponseBody
	public Freelisten showFreelistenById(int id) throws Exception {
		System.out.println(id);
		return freelistenService.showFreelistenById(id);
	}
	
	@RequestMapping(value = "freelisten/deleteFreelisten.action")
	@ResponseBody
	public boolean deleteFreelisten(int id) throws Exception {
		return freelistenService.deleteFreelisten(id);
	}

	@RequestMapping(value = "freelisten/showLastThreeFreelisten.action")
	@ResponseBody
	public List<Freelisten> showLastThreeFreelisten(int qid) throws Exception {
		return freelistenService.showLastThreeFreelisten(qid);
	}

}
