package com.neuedu.service;

import java.util.List;

import com.neuedu.po.Sign;

public interface SignService {
	public boolean addSign(Sign sign) throws Exception;
	public List<String> showAllByEle(Sign sign) throws Exception;
}
