package com.neuedu.service;

import java.util.List;

import com.neuedu.vo.VInputSwiper;
import com.neuedu.vo.VOutputSwiper;

public interface SwiperService 
{
	public List<VOutputSwiper> showSwiperByCategory(VInputSwiper vis);
	
}
