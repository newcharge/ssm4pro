package com.neuedu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.service.FreelistenService;
import com.neuedu.service.FreelistenbookService;
import com.neuedu.service.LessonService;
import com.neuedu.service.SorderService;

@Controller
public class ShouyeHandler {

	@Autowired
	SorderService sorderService;
	@Autowired
	LessonService lessonService;
	@Autowired
	FreelistenbookService freelistenbookService;
	@Autowired
	FreelistenService freelistenService;
	
	@RequestMapping(value = "shouye/showSorderAmount.action")
	@ResponseBody
	public int showSorderAmount(int qid) throws Exception {
		return sorderService.showSorderAmount(qid);
	}
	
	@RequestMapping(value = "shouye/showLessonAmount.action")
	@ResponseBody
	public int showLessonAmount(int qid) throws Exception {
		return lessonService.showLessonAmount(qid);
	}
	
	@RequestMapping(value = "shouye/showPaidFee.action")
	@ResponseBody
	public double showPaidFee(int qid) throws Exception {
		return sorderService.showPaidFee(qid);
	}
	
	@RequestMapping(value = "shouye/showPayingFee.action")
	@ResponseBody
	public double showPayingFee(int qid) throws Exception {
		return sorderService.showPayingFee(qid);
	}
	
	@RequestMapping(value = "shouye/showFreelistenbookAmount.action")
	@ResponseBody
	public int showFreelistenbookAmount(int qid) throws Exception {
		return freelistenbookService.showFreelistenbookAmount(qid);
	}
	
	@RequestMapping(value = "shouye/showFreelistenAmount.action")
	@ResponseBody
	public int showFreelistenAmount(int qid) throws Exception {
		return freelistenService.showFreelistenAmount(qid);
	}
}
