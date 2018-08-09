package com.neuedu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.utils.SmsUtils;

import redis.clients.jedis.Jedis;

@Controller
public class LoginHandler {
	@RequestMapping(value = "login/sendCode.action")
	@ResponseBody
	public boolean sendCode(String tel) throws Exception {
		if(tel == null || tel.equals("")) return false;
		Jedis jedis = new Jedis("59.110.137.171", 6379);
		String entry = String.join("-", "openid", tel);
		if("".equals(jedis.get(entry))) {
			jedis.close();
			return false;
		}
		String code = SmsUtils.getCode(tel);
		System.out.println(code);
		jedis.set(entry, code);
		jedis.expire(entry, 30);
		jedis.close();
		return true;
	}
	
	@RequestMapping(value = "login/validate.action")
	@ResponseBody
	public boolean validate(String tel, String code) throws Exception {
		Jedis jedis = new Jedis("59.110.137.171", 6379);
		String entry = String.join("-", "openid", tel);
		String savedCode = jedis.get(entry);
		if(savedCode.equals(code)) {
			jedis.close();
			return true;
		} else {
			jedis.close();
			return false;
		}
	}
	
}
