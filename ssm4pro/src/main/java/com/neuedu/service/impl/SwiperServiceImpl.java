package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.SwiperDao;
import com.neuedu.po.Swiper;
import com.neuedu.service.SwiperService;
import com.neuedu.vo.VInputSwiper;

@Service
public class SwiperServiceImpl implements SwiperService {

	@Autowired
	SwiperDao swiperDao;
	
	@Override
	public List<String> showSwiperByCategory(VInputSwiper vis) {
		// TODO Auto-generated method stub
		List<String> list;
		Swiper swiper = new Swiper();
		swiper.setQid(vis.getQid());
		swiper.setCategory(vis.getCategory());
		list = swiperDao.findAllByEle(swiper);
		return list;
	}

}
