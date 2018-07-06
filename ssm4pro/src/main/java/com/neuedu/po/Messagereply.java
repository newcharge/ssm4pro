package com.neuedu.po;

import org.apache.ibatis.type.Alias;

@Alias("Messagereply")
public class Messagereply {

	private int id;
	private int mid;
	private String content;
	private String nickname;
	private String stime;//数据库中的datetime类型
	
	public String toString() {
		return id + "_" + mid + "_" + content + "_" + nickname + "_" + stime;
	}
	
	public boolean equals(Messagereply messagereply) {
		boolean flag = true;
		if(id != messagereply.id) flag = false;
		if(mid != messagereply.mid) flag = false;
		if(!content.equals(messagereply.content)) flag = false;
		if(!nickname.equals(messagereply.nickname)) flag = false;
		if(!stime.equals(messagereply.stime)) flag = false;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
