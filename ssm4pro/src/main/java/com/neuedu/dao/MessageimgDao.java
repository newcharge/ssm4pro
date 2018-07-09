package com.neuedu.dao;

import com.neuedu.po.Messageimg;

public interface MessageimgDao {
	public boolean addImg(Messageimg img) throws Exception;
	public boolean deleteImg(int id) throws Exception;
	public boolean deleteImgByMid(int mid) throws Exception;
	public boolean findAllByMid(int mid) throws Exception;
}
