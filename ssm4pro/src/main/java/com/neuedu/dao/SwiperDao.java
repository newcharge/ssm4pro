package com.neuedu.dao;

import java.util.List;

import com.neuedu.po.Swiper;

public interface SwiperDao {
	public List<String> findAllByEle(Swiper swiper);
}
