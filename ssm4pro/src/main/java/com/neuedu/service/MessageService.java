package com.neuedu.service;

import java.util.List;

import com.neuedu.vo.VInputLike;
import com.neuedu.vo.VInputMessage;
import com.neuedu.vo.VInputReply;
import com.neuedu.vo.VOutputMessage;

public interface MessageService 
{
	public boolean addMessage(VInputMessage vim);
	public boolean addReply(VInputReply vir);
	public boolean addLike(VInputLike vil);
	
	public boolean deleteMessage(VInputMessage vim);
	public boolean deleteReply(VInputReply vir);
	
	public boolean editMessage(VInputMessage vim);
	
	public List<VOutputMessage> showMessage(int qid);
	
}
