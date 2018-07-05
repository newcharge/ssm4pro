package com.neuedu.po;

import org.apache.ibatis.type.Alias;

@Alias("Lesson")
public class Lesson {

	private int id;
	private String lname;
	private String imgurl;
	private double lprice;
	private String ldesc;//数据库中text类型
	private String category;
	private int qid;
	private String pubtime;//数据库中datetime类型
	
	@Override
	public String toString() {
		return id + "_" + lname + "_" + imgurl + "_" + lprice + "_" + ldesc + "_" + category +  "_" + qid + "_" + pubtime;
	}
	
	public boolean equals(Lesson lesson) {
		boolean flag = true;
		if(id != lesson.id) flag = false;
		if(!lname.equals(lesson.lname)) flag = false;
		if(!imgurl.equals(lesson.imgurl)) flag = false;
		if(lprice != lesson.lprice) flag = false;
		if(!ldesc.equals(lesson.ldesc)) flag = false;
		if(!category.equals(lesson.category)) flag = false;
		if(qid != lesson.qid) flag = false;
		if(!pubtime.equals(lesson.pubtime)) flag = false;
		return flag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public double getLprice() {
		return lprice;
	}
	public void setLprice(double lprice) {
		this.lprice = lprice;
	}
	public String getLdesc() {
		return ldesc;
	}
	public void setLdesc(String ldesc) {
		this.ldesc = ldesc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getPubtime() {
		return pubtime;
	}
	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}
	
	
}
