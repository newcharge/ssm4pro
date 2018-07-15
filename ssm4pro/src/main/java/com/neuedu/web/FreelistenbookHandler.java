package com.neuedu.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.po.Freelistenbook;
import com.neuedu.service.FreelistenbookService;
import com.neuedu.vo.VInputFreelistenbook;
@Controller
public class FreelistenbookHandler {
	@Autowired
	FreelistenbookService freelistenbookService;

	@RequestMapping(value = "book/bookFreeListen.action")
	@ResponseBody
	public boolean bookFreeListen(String jsonData) throws Exception {
		Freelistenbook freelistenbook = JsonUtils.jsonToPojo(jsonData, Freelistenbook.class);
		System.out.println(freelistenbook);
		return freelistenbookService.addFreelistenbook(freelistenbook);
	}
	
	@RequestMapping(value = "book/getFreeListen.action")
	@ResponseBody
	public List<Freelistenbook> getFreelistenbookByUsername(String jsonData) throws Exception {
		VInputFreelistenbook vif = JsonUtils.jsonToPojo(jsonData, VInputFreelistenbook.class);
		System.out.println(vif.getQid() + "_" + vif.getTel());
		List<Freelistenbook> list = freelistenbookService.showFreelistenbookByQidUser(vif);
		list.forEach(System.out::println);
		return list;
	}
}
