package com.neuedu.vo;

import java.util.List;

import com.neuedu.po.Message;
import com.neuedu.po.Messageimg;

public class VInputMessage 
{
	private int qid;
	private Message message;
	private List<String> imgList;
	
	public int getQid() {
		return qid;
	}
	public List<String> getImgList() {
		return imgList;
	}
	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
	
}
