package com.neuedu.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.service.UserService;
import com.neuedu.vo.VUser;

@Controller
public class UserHandler {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="usr/showAll.action")
	@ResponseBody
	public List<VUser> showAll() throws Exception {
		List<VUser> list = Arrays.asList();
		list = userService.findAll();
		return list;
	}
}
