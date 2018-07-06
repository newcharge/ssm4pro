package com.neuedu.po;

import org.apache.ibatis.type.Alias;

@Alias("Enterprise")
public class Enterprise {

	private int qid;
	private String name;
	private String videopath;
	private String introduction;	
	private String jczs; //数据库中的text类型
	
	@Override
	public String toString() {
		return qid + "_" + name + "_" + videopath + "_" + introduction + "_" + jczs;
	}
	 
	public boolean equals(Enterprise enterprise) {
		boolean flag = true;
		if (qid!= enterprise.qid) flag=false;
		if (name.equals(enterprise.name)) flag=false;
		if (videopath.equals(enterprise.videopath)) flag=false;
		if (introduction.equals(enterprise.introduction)) flag=false;
		if (jczs.equals(enterprise.jczs)) flag=false;
		return flag;
		
	}
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
	
	
	
	
}
