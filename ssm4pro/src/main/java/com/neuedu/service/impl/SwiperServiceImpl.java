package com.neuedu.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.SwiperDao;
import com.neuedu.po.Swiper;
import com.neuedu.service.SwiperService;
import com.neuedu.utils.JedisAPI;

import redis.clients.jedis.Jedis;

@Service
public class SwiperServiceImpl implements SwiperService {

	@Autowired
	SwiperDao swiperDao;
	
	@Transactional
	@Override
	public List<String> showSwiperByCategory(Swiper swiper) throws Exception {
		// TODO Auto-generated method stub
		Jedis jedis = JedisAPI.getRedisApi().getRedis("192.168.52.134", 6379);
		String entry = String.join("-", "swiper", String.valueOf(swiper.getQid()), swiper.getCategory());
		Set<String> result = jedis.smembers(entry);
		List<String> list;
		if(result != null && !result.isEmpty()) {
			JedisAPI.getRedisApi().closeRedis(jedis);
			list = result.stream().collect(Collectors.toList());
			System.out.println("调用缓存");
		} else {
			list = swiperDao.findAllByCategory(swiper);
			System.out.println(list);
			list.forEach(ele -> {
				jedis.sadd(entry, ele);
				jedis.expire(entry, 30);
			});
		}
		return list;
	}
	
	@Transactional
	@Override
	public boolean addSwiper(Swiper swiper) throws Exception {
		// TODO Auto-generated method stub
		return swiperDao.addSwiper(swiper);
	}
	
	

}
