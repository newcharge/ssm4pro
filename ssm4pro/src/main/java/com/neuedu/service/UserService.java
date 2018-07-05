package com.neuedu.service;

import java.util.List;

import com.neuedu.vo.VUser;

public interface UserService {
	public List<VUser> findAll() throws Exception;
}
