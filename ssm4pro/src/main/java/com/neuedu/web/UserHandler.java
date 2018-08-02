package com.neuedu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.po.User;
import com.neuedu.service.UserService;

@Controller
public class UserHandler {

	@Autowired
	UserService userService;

	@RequestMapping(value = "usr/showAll.action")
	@ResponseBody
	public boolean valid(User user) throws Exception {
		return userService.valid(user);
	}
}
