package com.neuedu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.service.MessageService;
import com.neuedu.vo.VInputMessage;
import com.neuedu.vo.VOutputMessage;

@Controller
public class MessageHandler {

	@Autowired
	MessageService messageService;

	@RequestMapping(value = "message/showMessage.action")
	@ResponseBody
	public List<VOutputMessage> showMessage(int qid) throws Exception {
		return messageService.showMessageByQid(qid);
	}
	
	@RequestMapping(value = "message/editMessage.action")
	@ResponseBody
	public boolean editMessage(VInputMessage vim) throws Exception {
		return messageService.editMessage(vim);
	}
	
	@RequestMapping(value = "message/deleteMessage.action")
	@ResponseBody
	public boolean deleteMessage(int id) throws Exception {
		return messageService.deleteMessage(id);
	}
	
	@RequestMapping(value = "message/addMessage.action")
	@ResponseBody
	public boolean addMessage(VInputMessage vim) throws Exception {
		return messageService.addMessage(vim);
	}
}
