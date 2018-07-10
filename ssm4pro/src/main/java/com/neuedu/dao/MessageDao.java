package com.neuedu.dao;

import java.util.List;

import com.neuedu.po.Message;
import com.neuedu.vo.VOutputMessage;

public interface MessageDao {
	public boolean addMessage(Message message) throws Exception;
	public boolean deleteMessage(int mid) throws Exception;
	public boolean editMessage(Message message) throws Exception;
	public List<VOutputMessage> findAllByQid(int qid) throws Exception;
}
