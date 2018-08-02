package com.neuedu.vo;

import java.util.List;

public class VInputEnterprise 
{
	private int qid;
	private String name;
	private String videopath;
	private String introduction;
	private String jczs;
	private List<String> imgList;
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVideopath() {
		return videopath;
	}
	public void setVideopath(String videopath) {
		this.videopath = videopath;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getJczs() {
		return jczs;
	}
	public void setJczs(String jczs) {
		this.jczs = jczs;
	}
	public List<String> getImgList() {
		return imgList;
	}
	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}
}
