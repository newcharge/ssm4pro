package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.SwiperDao;
import com.neuedu.po.Swiper;
import com.neuedu.service.SwiperService;

@Service
public class SwiperServiceImpl implements SwiperService {

	@Autowired
	SwiperDao swiperDao;
	
	@Transactional
	@Override
	public List<String> showSwiperByCategory(Swiper swiper) throws Exception {
		// TODO Auto-generated method stub
		return swiperDao.findAllByCategory(swiper);
	}
	
	@Transactional
	@Override
	public boolean addSwiper(Swiper swiper) throws Exception {
		// TODO Auto-generated method stub
		return swiperDao.addSwiper(swiper);
	}
	
	

}
