package com.neuedu.dao;

import com.neuedu.po.Messagelike;

public interface MessagelikeDao {
	public boolean addLike(Messagelike like) throws Exception;
	public boolean deleteLike(Messagelike like) throws Exception;
	public boolean deleteLikeByMid(int mid) throws Exception;
	public boolean findAllByMid(int mid) throws Exception;
}
