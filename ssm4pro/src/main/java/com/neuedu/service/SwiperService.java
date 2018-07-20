package com.neuedu.service;

import java.util.List;

import com.neuedu.po.Swiper;

public interface SwiperService 
{
	public List<String> showSwiperByCategory(Swiper swiper) throws Exception;
	//添加首页图片功能待添加 201807061000
	public boolean addSwiper(Swiper swiper) throws Exception;
}
