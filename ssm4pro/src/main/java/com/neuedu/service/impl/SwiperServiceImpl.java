package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.SwiperDao;
import com.neuedu.po.Swiper;
import com.neuedu.service.SwiperService;

@Service
public class SwiperServiceImpl implements SwiperService {

	@Autowired
	SwiperDao swiperDao;
	
	@Override
	public List<String> showSwiperByCategory(Swiper swiper) {
		// TODO Auto-generated method stub

		return swiperDao.findAllByCategory(swiper);
	}

}
