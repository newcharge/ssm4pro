package com.neuedu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.po.Sorder;
import com.neuedu.service.SorderService;
import com.neuedu.vo.VInputFreelistenbook;
import com.neuedu.vo.VInputSorder;
import com.neuedu.vo.VOutputFreelistenbook;

@Controller

public class SorderHandler {
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

}

