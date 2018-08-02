package com.neuedu.dao;

import java.util.List;

import com.neuedu.po.Messagelike;

public interface MessagelikeDao {
	public boolean addLike(Messagelike like) throws Exception;
	public boolean deleteLike(Messagelike like) throws Exception;
	public boolean deleteLikeByMid(int mid) throws Exception;
	public List<Messagelike> findAllByMid(int mid) throws Exception;
}
