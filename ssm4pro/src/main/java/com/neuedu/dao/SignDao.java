package com.neuedu.dao;

import java.util.List;

import com.neuedu.po.Sign;

public interface SignDao {
	public boolean addSign(Sign sign) throws Exception;
	public List<String> showAllByEle(Sign sign) throws Exception;
}

