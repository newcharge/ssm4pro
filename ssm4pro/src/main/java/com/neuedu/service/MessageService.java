package com.neuedu.service;

import java.util.List;

import com.neuedu.po.Messagelike;
import com.neuedu.po.Messagereply;
import com.neuedu.vo.VInputMessage;
import com.neuedu.vo.VOutputMessage;

public interface MessageService 
{
	public boolean addMessage(VInputMessage vimessage) throws Exception;
	public boolean addReply(Messagereply reply) throws Exception;
	public boolean addLike(Messagelike like) throws Exception;
	
	public boolean deleteMessage(int id) throws Exception;
	public boolean deleteReply(int id) throws Exception;
	public boolean deleteLike(Messagelike like) throws Exception;
	
	public boolean editMessage(VInputMessage vimessage) throws Exception;
	public List<Messagelike> findAllLikeByMid(int mid) throws Exception;
	public List<VOutputMessage> showMessageByQid(int qid) throws Exception;
	
}
