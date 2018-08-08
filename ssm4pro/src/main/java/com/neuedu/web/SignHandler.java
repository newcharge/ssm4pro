package com.neuedu.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.po.Sign;
import com.neuedu.service.SignService;
import com.neuedu.utils.DateInfo;
import com.neuedu.utils.SignUtil;

@Controller
public class SignHandler {
	
	@Autowired
	private SignService signService;
	
	@RequestMapping(value = "sign/showCalendar.action")
	@ResponseBody
	public List<List<DateInfo>> showCalendar(String openid, int qid) throws Exception {
		Sign sign = new Sign();
		sign.setSdate(LocalDate.now().toString());
		sign.setOpenid(openid);
		sign.setQid(qid);
		System.out.println(sign);
		List<String> list = signService.showAllByEle(sign);
		System.out.println(list);
		return SignUtil.getCalendarTable(list, LocalDate.now().toString());
	}
	
	@RequestMapping(value = "sign/signToday.action")
	@ResponseBody
	public boolean signToday(String openid, int qid) throws Exception {
		Sign sign = new Sign();
		sign.setSdate(LocalDate.now().toString());
		sign.setOpenid(openid);
		sign.setQid(qid);
		return signService.addSign(sign);
	}
}
