package com.neuedu.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.po.User;
import com.neuedu.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class UserServiceImplTest {
	
	@Autowired
	UserService userService;
	
	@Test
	public void valid() throws Exception {
		User user = new User();
		user.setUsername("feiyy");
		user.setUserpassword("123456");
		System.out.println(user);
		System.out.println(userService.valid(user));
		
	}

}
