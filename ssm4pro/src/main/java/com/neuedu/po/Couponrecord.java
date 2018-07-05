package com.neuedu.po;

import org.apache.ibatis.type.Alias;

@Alias("Couponrecord")
public class Couponrecord {
	
	private int id;
	private int cid;
	private String openid;
	private String gettime;//数据库中datetime类型
	
    public String toString() {
		return id + "_" + cid + "_" + openid + "_" + gettime;
	}
    
	public boolean equals(Couponrecord couponrecord) {
		boolean flag = true;
		if (id!= couponrecord.id) flag=false;
		if (cid!= couponrecord.cid) flag=false;
		if (openid.equals(couponrecord.openid)) flag=false;
		if (gettime.equals(couponrecord.gettime)) flag=false;
		return flag;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getGettime() {
		return gettime;
	}
	public void setGettime(String gettime) {
		this.gettime = gettime;
	}
	
	

}
