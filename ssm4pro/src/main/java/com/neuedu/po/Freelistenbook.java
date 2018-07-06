package com.neuedu.po;

import org.apache.ibatis.type.Alias;

@Alias("Freelistenbook")
public class Freelistenbook {

	private int id;
	private int fid;
	private String username;
	private String tel;
	private String booktime;//数据库中的datetime类型
	private String status;
	private String comment;
	private String openid;
	
	@Override
	public String toString() {
		return id + "_" + fid + "_" + username + "_" + tel + "_" + booktime + "_" + status +  "_" + comment + "_" + openid;
	}
	
	public boolean equals(Freelistenbook freelistenbook) {
		boolean flag = true;
		if(id != freelistenbook.id) flag = false;
		if(fid != freelistenbook.fid) flag = false;
		if(!username.equals(freelistenbook.username)) flag = false;
		if(!tel.equals(freelistenbook.tel)) flag = false;
		if(!booktime.equals(freelistenbook.booktime)) flag = false;
		if(!status.equals(freelistenbook.status)) flag = false;
		if(!comment.equals(freelistenbook.comment)) flag = false;
		if(!openid.equals(freelistenbook.openid)) flag = false;
		return flag;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBooktime() {
		return booktime;
	}
	public void setBooktime(String booktime) {
		this.booktime = booktime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	
}
