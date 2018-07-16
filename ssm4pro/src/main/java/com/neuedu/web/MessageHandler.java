package com.neuedu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.po.Messagelike;
import com.neuedu.po.Messagereply;
import com.neuedu.service.MessageService;
import com.neuedu.vo.VOutputMessage;

@Controller
public class MessageHandler {
	@Autowired
	MessageService messageService;
	
	@RequestMapping(value = "msg/showMessage.action")
	@ResponseBody
	public List<VOutputMessage> showMessage(int qid) throws Exception {
		System.out.println(qid);
		return messageService.showMessageByQid(qid);
	}
	
	@RequestMapping(value = "msg/addLike.action")
	@ResponseBody
	public boolean addLike(String jsonData) throws Exception {
		Messagelike like = JsonUtils.jsonToPojo(jsonData, Messagelike.class);
		return messageService.addLike(like);
	}
	
	@RequestMapping(value = "msg/deleteLike.action")
	@ResponseBody
	public boolean deleteLike(String jsonData) throws Exception {
		Messagelike like = JsonUtils.jsonToPojo(jsonData, Messagelike.class);
		return messageService.deleteLike(like);
	}
	
	@RequestMapping(value = "msg/addReply.action")
	@ResponseBody
	public boolean addReply(String jsonData) throws Exception {
		Messagereply reply = JsonUtils.jsonToPojo(jsonData, Messagereply.class);
		return messageService.addReply(reply);
	}
}
