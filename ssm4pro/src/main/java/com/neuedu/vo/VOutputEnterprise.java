package com.neuedu.vo;

import java.util.List;

public class VOutputEnterprise 
{
	private int qid;
	private String name;
	private List<VOutputSwiper> vos;
	private String videopath;
	private String introduction;
	private String jczs;
	
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
	public List<VOutputSwiper> getVos() {
		return vos;
	}
	public void setVos(List<VOutputSwiper> vos) {
		this.vos = vos;
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
	

}
