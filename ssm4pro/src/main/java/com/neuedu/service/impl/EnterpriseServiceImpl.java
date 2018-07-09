package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.EnterpriseDao;
import com.neuedu.dao.SwiperDao;
import com.neuedu.po.Enterprise;
import com.neuedu.po.Swiper;
import com.neuedu.service.EnterpriseService;
import com.neuedu.vo.VOutputEnterprise;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

	@Autowired
	EnterpriseDao enterpriseDao;
	
	@Autowired
	SwiperDao swiperDao;
	
	@Override
	public VOutputEnterprise showEnterprise(int qid) throws Exception {
		// TODO Auto-generated method stub
		
		//还用另一种解决方法，就是只传swiper的po，然后join两表直接输出VO（可选，不过collection多参数有点吃不准）
		VOutputEnterprise voenterprise = new VOutputEnterprise();
		
		Swiper swiper = new Swiper();
		swiper.setQid(qid);
		swiper.setCategory("A");//目前只用A，应该是别的字母常量？
		
		Enterprise enterprise = enterpriseDao.findByQid(qid);
		List<String> imgList = swiperDao.findAllByEle(swiper);
		
		voenterprise.setEnterprise(enterprise);
		voenterprise.setImgurl(imgList);
		
		return voenterprise;
	}

}
