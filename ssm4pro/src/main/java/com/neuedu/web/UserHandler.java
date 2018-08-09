package com.neuedu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.po.User;
import com.neuedu.service.UserService;
import com.neuedu.utils.JsonUtils;

@Controller
public class UserHandler {

	@Autowired
	UserService userService;

	@RequestMapping(value = "usr/login.action")
	@ResponseBody
	public Integer valid(String jsonData) throws Exception {
		User user = JsonUtils.jsonToPojo(jsonData, User.class);
		System.out.println(user);
		System.out.println("fanhui:"+userService.valid(user));
		int back;
		if(userService.valid(user)==null)
		{
			back = 0;
		}
		else
			back = userService.valid(user);
		return back;
	}
	
	@RequestMapping(value = "usr/register.action")
	@ResponseBody
	public boolean register(String jsonData) throws Exception {
		User user = JsonUtils.jsonToPojo(jsonData, User.class);
		System.out.println(user);
		boolean flag = userService.register(user);
		System.out.println("fanhui:" + flag);
		
		return flag;
	}
}
