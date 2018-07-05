package com.neuedu.po;

import org.apache.ibatis.type.Alias;

@Alias("Messagelike")
public class Messagelike {

	private int id;
	private int mid;
	private String nickname;
	private String stime;//数据库类型datetime；
	
	public String toString() {
		return id + "_" + mid + "_" + nickname + "_" + stime;
	}
	
	public boolean equals(Messagelike messagelike) {
		boolean flag = true;
		if(id != messagelike.id) flag = false;
		if(mid != messagelike.mid) flag = false;
		if(!nickname.equals(messagelike.nickname)) flag = false;
		if(!stime.equals(messagelike.stime)) flag = false;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	
	
}
