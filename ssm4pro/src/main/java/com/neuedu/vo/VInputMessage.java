package com.neuedu.vo;

import java.util.List;

import com.neuedu.po.Message;
import com.neuedu.po.Messageimg;

public class VInputMessage 
{
	private Message message;
	private List<Messageimg> imgList;
	
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public List<Messageimg> getImgList() {
		return imgList;
	}
	public void setImgList(List<Messageimg> imgList) {
		this.imgList = imgList;
	}
	
}
