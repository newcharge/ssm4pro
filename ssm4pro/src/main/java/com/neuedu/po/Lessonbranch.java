package com.neuedu.po;

import org.apache.ibatis.type.Alias;

@Alias("Lessonbranch")
public class Lessonbranch {
	private int id;
	private int lid;
	private int branchid;
	
	@Override
	public String toString() {
		return id + "_" + lid + "_" + branchid;
	}
	
	public boolean equals(Lessonbranch lessonbranch) {
		boolean flag=true;
		if(id != lessonbranch.id) flag = false;
		if(lid != lessonbranch.lid) flag = false;
		if(branchid != lessonbranch.branchid) flag = false;
		return flag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getBranchid() {
		return branchid;
	}
	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}
	
	

}
