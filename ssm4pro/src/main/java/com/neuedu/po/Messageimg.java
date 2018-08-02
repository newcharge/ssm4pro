package com.neuedu.po;

import org.apache.ibatis.type.Alias;

@Alias("Messageimg")
public class Messageimg {

	private int id;
	private int mid;
	private String imgurl;
	
	public Messageimg(){}
	
	public String toString() {
		return id + "_" + mid + "_" + imgurl;
	}
	
	public boolean equals(Messageimg messageimg) {
		boolean flag=true;
		if(id != messageimg.id) flag = false;
		if(mid != messageimg.mid) flag = false;
		if(!imgurl.equals(messageimg.imgurl)) flag = false;
		return flag;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	
}
