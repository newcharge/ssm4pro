package com.neuedu.po;

import org.apache.ibatis.type.Alias;

@Alias("Freelisten")
public class Freelisten {

	private int id;
	private String title;
	private String imgurl;
	private String fdesc;
	private String status;
	private int qid;
	private int branchid;
	private String pubtime;//数据库中datetime类型
	
	@Override
	public String toString() {
		return id + "_" + title + "_" + imgurl + "_" + fdesc + "_" + qid + "_" + branchid +  "_" + pubtime;
	}
	
	public boolean equals(Freelisten freelisten) {
		boolean flag = true;
		if(id != freelisten.id) flag = false;
		if(!title.equals(freelisten.title)) flag = false;
		if(!imgurl.equals(freelisten.imgurl)) flag = false;
		if(!fdesc.equals(freelisten.fdesc)) flag = false;
		if(!status.equals(freelisten.status)) flag = false;
		if(qid != freelisten.qid) flag = false;
		if(branchid != freelisten.branchid) flag = false;
		if(!pubtime.equals(freelisten.pubtime)) flag = false;
		return flag;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getFdesc() {
		return fdesc;
	}
	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public int getBranchid() {
		return branchid;
	}
	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}
	public String getPubtime() {
		return pubtime;
	}
	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}
	
	
	
	
	
}
