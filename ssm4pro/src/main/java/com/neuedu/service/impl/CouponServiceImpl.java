package com.neuedu.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.CouponDao;
import com.neuedu.po.Coupon;
import com.neuedu.service.CouponService;
import com.neuedu.web.JsonUtils;

import redis.clients.jedis.Jedis;

@Service
public class CouponServiceImpl implements CouponService {
	@Autowired
	private CouponDao couponDao;
	
	@Override
	public List<Coupon> showAll(int qid) throws Exception {
		return couponDao.showAll(qid);
	}
	
	@Override
	public List<Coupon> showCouponByOthers(Coupon vic) throws Exception {
		return couponDao.showCouponByOthers(vic);
	}
	
	@Override
	public List<Coupon> showCouponByOpenid(Coupon vic) throws Exception{
		return couponDao.showCouponByOpenid(vic);
	}
	
	@Override
	public boolean addCoupon(Coupon vic) throws Exception {
		Jedis jedis = new Jedis("59.110.137.171", 6379);
		jedis.flushAll();
		jedis.close();
		return couponDao.addCoupon(vic);
	}
	
	@Override
	public boolean editCoupon(Coupon vic) throws Exception {
		Jedis jedis = new Jedis("59.110.137.171", 6379);
		jedis.flushAll();
		jedis.close();
		return couponDao.editCoupon(vic);
	}
	
	@Override
	public boolean deleteCoupon(int cid) throws Exception {
		Jedis jedis = new Jedis("59.110.137.171", 6379);
		jedis.flushAll();
		jedis.close();
		return couponDao.deleteCoupon(cid);
	}

	@Override
	public List<Coupon> showTopCoupon(Coupon coupon, int rank) throws Exception {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("59.110.137.171", 6379);
		String entry = String.join("-", Arrays.asList("coupon", coupon.getOpenid(), String.valueOf(coupon.getQid())));
		long count = jedis.llen(entry);
		List<Coupon> list;
		List<String> strList;
		if(count == 0) {
			list = couponDao.showCouponByOthers(coupon);
			for(Coupon couponi : list) {
				jedis.lpush(entry, JsonUtils.ObjectToJson(couponi));
			}
		}
		if(rank + 10 - 1 < count) {
			strList = jedis.lrange(entry, rank, rank + 10 - 1);
		} else if(rank < count) {
			strList = jedis.lrange(entry, rank, -1);
		} else {
			strList = Arrays.asList();
		}
		
		System.out.println(strList.size());
		list = new ArrayList<>();
		for(String couponStr : strList) {
			list.add(JsonUtils.jsonToPojo(couponStr, Coupon.class));
		}
		
		jedis.close();
		return list;
	}
}
