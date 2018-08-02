package com.neuedu.vo;

import java.util.List;

import com.neuedu.po.Message;
import com.neuedu.po.Messageimg;

public class VInputMessage 
{
	private int qid;
	private Message message;
	private List<Messageimg> imgList;
	
	public int getQid() {
		return qid;
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
	public List<Messageimg> getImgList() {
		return imgList;
	}
	public void setImgList(List<Messageimg> imgList) {
		this.imgList = imgList;
	}
	
}
