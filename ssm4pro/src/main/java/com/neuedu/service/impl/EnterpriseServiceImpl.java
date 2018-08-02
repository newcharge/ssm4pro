package com.neuedu.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.EnterpriseDao;
import com.neuedu.dao.SwiperDao;
import com.neuedu.po.Enterprise;
import com.neuedu.po.Swiper;
import com.neuedu.service.EnterpriseService;
import com.neuedu.vo.VInputEnterprise;
import com.neuedu.vo.VOutputEnterprise;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

	@Autowired
	EnterpriseDao enterpriseDao;
	
	@Autowired
	SwiperDao swiperDao;
	
	@Transactional
	@Override
	public VOutputEnterprise showEnterprise(int qid) throws Exception {
		// TODO Auto-generated method stub
		
		//还用另一种解决方法，就是只传swiper的po，然后join两表直接输出VO（可选，不过collection多参数有点吃不准）
		VOutputEnterprise voenterprise = new VOutputEnterprise();
		
		Swiper swiper = new Swiper();
		swiper.setQid(qid);
		swiper.setCategory("A");//目前只用A，应该是别的字母常量？
		
		Enterprise enterprise = enterpriseDao.findByQid(qid);
		List<String> imgList = swiperDao.findAllByCategory(swiper);
		
		voenterprise.setEnterprise(enterprise);
		voenterprise.setImgurl(imgList);
		
		return voenterprise;
	}
	
	@Transactional
	@Override
	public boolean editEnterprise(VInputEnterprise vie) throws Exception {
		Enterprise enterprise = new Enterprise();
		enterprise.setQid(vie.getQid());
		enterprise.setName(vie.getName());
		enterprise.setVideopath(vie.getVideopath());
		enterprise.setIntroduction(vie.getIntroduction());
		enterprise.setJczs(vie.getJczs());
		
		List<String> imgUrls = vie.getImgList();
		List<Swiper> imgList;
		imgList = imgUrls.stream().map(eleUrl -> {
			Swiper sImg = new Swiper();
			sImg.setQid(enterprise.getQid());
			sImg.setImgurl(eleUrl);
			sImg.setCategory("A");
			return sImg;
		}).collect(Collectors.toList());
		
		imgList.forEach(img -> img.setQid(enterprise.getQid()));
		if(enterpriseDao.editEnterprise(enterprise)) {
			boolean flag = true;
			swiperDao.deleteAByQid(enterprise.getQid());
			for(Swiper s: imgList) {
				swiperDao.addSwiper(s);
			}
			if(flag)
				return true;
		}
		
//		imgList.forEach(img -> img.setMid(message.getMid()));
//		if(messageDao.editMessage(message)) {
//			boolean flag = true;
//			messageimgDao.deleteImgByMid(message.getMid());
//			for(Messageimg img : imgList) {
//				messageimgDao.addImg(img);
//			}
//			if(flag) return true;
//		}
		
		return false;
		
	}

}
