package com.neuedu.vo;

import java.util.List;
import java.util.stream.Collectors;

public class VOutputLesson {
	private int lid;
	private String lname;
	private String imgurl;
	private double lprice;
	private String ldesc;//数据库中的text类型
	private String category;
	private int qid;
	private String pubtime;//数据库中的datetime类型
	private List<Integer> branches;
	
	@Override
	public String toString() {
		return String.join("_",
				String.valueOf(lid),
				lname, imgurl,
				String.valueOf(lprice),
				ldesc, category,
				String.valueOf(qid),
				pubtime,
				String.join(", ", branches.stream()
						.map(num -> String.valueOf(num))
						.collect(Collectors.toList())
						)
				);
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
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

	public List<Integer> getBranches() {
		return branches;
	}

	public void setBranches(List<Integer> branches) {
		this.branches = branches;
	}

}
