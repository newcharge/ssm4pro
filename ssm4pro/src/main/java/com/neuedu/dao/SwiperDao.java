package com.neuedu.dao;

import java.util.List;

import com.neuedu.po.Swiper;

public interface SwiperDao {
	public List<String> findAllByCategory(Swiper swiper) throws Exception;
	public boolean addSwiper(Swiper swiper) throws Exception;
	public void deleteAByQid(int qid) throws Exception;
}
