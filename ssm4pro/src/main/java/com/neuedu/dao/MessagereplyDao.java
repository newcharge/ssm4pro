package com.neuedu.dao;

import com.neuedu.po.Messagereply;

public interface MessagereplyDao {
	public boolean addReply(Messagereply reply) throws Exception;
	public boolean deleteReplyById(int  id) throws Exception;
	public boolean deleteReplyByMid(int mid) throws Exception;
	public boolean findAllByMid(int mid) throws Exception;
}
