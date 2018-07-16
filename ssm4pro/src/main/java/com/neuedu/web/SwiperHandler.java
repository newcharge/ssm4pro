package com.neuedu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.po.Swiper;
import com.neuedu.service.SwiperService;

@Controller
public class SwiperHandler {
	
	@Autowired
	SwiperService swiperService;
	
	@RequestMapping(value = "swiper/showSwiper.action")
	@ResponseBody
	public List<String> showSwiper(Swiper swiper) {
		System.out.println(swiper);
		return swiperService.showSwiperByCategory(swiper);
	}
}
