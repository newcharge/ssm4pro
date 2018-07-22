package com.neuedu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.service.MessageService;
import com.neuedu.vo.VInputMessage;
import com.neuedu.vo.VOutputFreelistenbook;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.po.Message;
import com.neuedu.po.Messagelike;
import com.neuedu.po.Messagereply;
import com.neuedu.vo.VOutputMessage;

@Controller
public class MessageHandler {
	private static final int pageSize = 10;
	@Autowired
	MessageService messageService;
	
	@RequestMapping(value = "msg/editMessage.action")
	@ResponseBody
	public boolean editMessage(VInputMessage vim) throws Exception {
		return messageService.editMessage(vim);
	}
	
	@RequestMapping(value = "msg/deleteMessage.action")
	@ResponseBody
	public boolean deleteMessage(int mid) throws Exception {
		System.out.println(mid);
		return messageService.deleteMessage(mid);
	}
	
	@RequestMapping(value = "msg/addMessage.action")
	@ResponseBody
	public boolean addMessage(VInputMessage vim) throws Exception {
		return messageService.addMessage(vim);
	}

	@RequestMapping(value = "msg/showMessage.action")
	@ResponseBody
	public List<VOutputMessage> showMessage(int qid) throws Exception {
		//System.out.println(qid);
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
	
	@RequestMapping(value = "msg/deleteReply.action")
	@ResponseBody
	public boolean deleteReply(int id) throws Exception {
		
		return messageService.deleteReply(id);
	}
	@RequestMapping(value = "msg/showAllByPage.action")
	@ResponseBody
	public PageInfo<VOutputMessage> showAllByPage(int qid, int pageNum) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		return PageInfo.of(messageService.showMessageByQid(qid));
	}
}
