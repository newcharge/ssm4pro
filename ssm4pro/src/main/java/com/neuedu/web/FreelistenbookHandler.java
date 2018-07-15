package com.neuedu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.po.Freelistenbook;
import com.neuedu.service.FreelistenbookService;
import com.neuedu.vo.VInputFreelistenbook;
import com.neuedu.vo.VOutputFreelistenbook;

@Controller
public class FreelistenbookHandler {

	@Autowired
	FreelistenbookService freelistenbookService;

	@RequestMapping(value = "freelistenbook/showFreelistenbook.action")
	@ResponseBody
	public List<VOutputFreelistenbook> showFreelistenbook(int qid) throws Exception {
		return freelistenbookService.showFreelistenbook(qid);
	}
	
	@RequestMapping(value = "freelistenbook/showFreelistenbookByOthers.action")
	@ResponseBody
	public List<VOutputFreelistenbook> showFreelistenbookByOthers(String jsonData) throws Exception {
		VInputFreelistenbook vif = JsonUtils.jsonToPojo(jsonData, VInputFreelistenbook.class);
		System.out.println(vif.getId());
		System.out.println(vif.getStatus());
		System.out.println(vif.getStarttime());
		System.out.println(vif.getEndtime());

		if(vif.getStatus()=="")
			vif.setStatus(null);
		if(vif.getStarttime()=="")
			vif.setStarttime(null);
		if(vif.getEndtime()=="")
			vif.setEndtime(null);


		return freelistenbookService.showFreelistenbookByOthers(vif);
	}
	
	@RequestMapping(value = "freelistenbook/dealFreelistenbook.action")
	@ResponseBody
	public boolean dealFreelistenbook(int id) throws Exception {
		Freelistenbook freelistenbook = new Freelistenbook();
		freelistenbook.setId(id);
		freelistenbook.setStatus("已处理");
		return freelistenbookService.changeFreelistenbookState(freelistenbook);
	}

}
