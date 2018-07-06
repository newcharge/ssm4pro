package com.neuedu.service;

import java.util.List;

import com.neuedu.vo.VInputUser;
import com.neuedu.vo.VUser;

public interface UserService 
{
	public boolean valid(VInputUser viu);
	public List<VUser> findAll() throws Exception;
}
