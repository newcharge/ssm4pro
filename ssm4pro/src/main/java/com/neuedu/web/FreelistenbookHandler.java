package com.neuedu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.po.Freelistenbook;
import com.neuedu.po.Lesson;
import com.neuedu.service.FreelistenbookService;
import com.neuedu.vo.VInputFreelistenbook;
import com.neuedu.vo.VOutputFreelistenbook;

@Controller
public class FreelistenbookHandler {
	private static final int pageSize = 10;
	@Autowired
	FreelistenbookService freelistenbookService;

	@RequestMapping(value = "freelistenbook/showFreelistenbook.action")
	@ResponseBody
	public PageInfo<VOutputFreelistenbook> showFreelistenbook(int qid) throws Exception {
		return PageInfo.of(freelistenbookService.showFreelistenbook(qid));
	}
	
	@RequestMapping(value = "freelistenbook/showFreelistenbookByOthers.action")
	@ResponseBody
	public PageInfo<VOutputFreelistenbook> showFreelistenbookByOthers(String jsonData,int pageNum) throws Exception {
		VInputFreelistenbook vif = JsonUtils.jsonToPojo(jsonData, VInputFreelistenbook.class);

		if(vif.getStatus()=="")
			vif.setStatus(null);
		if(vif.getStarttime()=="")
			vif.setStarttime(null);
		if(vif.getEndtime()=="")
			vif.setEndtime(null);

		System.out.println(vif.getId());
		System.out.println(vif.getStatus());
		System.out.println(vif.getStarttime());
		System.out.println(vif.getEndtime());
		PageHelper.startPage(pageNum, pageSize);
		return PageInfo.of(freelistenbookService.showFreelistenbookByOthers(vif));
	}
	
	@RequestMapping(value = "freelistenbook/dealFreelistenbook.action")
	@ResponseBody
	public boolean dealFreelistenbook(int id) throws Exception {
		Freelistenbook freelistenbook = new Freelistenbook();
		freelistenbook.setId(id);
		freelistenbook.setStatus("已处理");
		return freelistenbookService.changeFreelistenbookState(freelistenbook);
	}

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
	@RequestMapping(value = "freelistenbook/showAllByPage.action")
	@ResponseBody
	public PageInfo<VOutputFreelistenbook> showAllByPage(int qid, int pageNum) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		return PageInfo.of(freelistenbookService.showFreelistenbook(qid));
	}
}
