package com.neuedu.po;

import org.apache.ibatis.type.Alias;

@Alias("Teacher")
public class Teacher {
	private int tid;
	private String tname;
	private String tphoto;
	private String introduction;
	private int qid;
	
	@Override
	public String toString() {
		return tid + "_" + tname + "_" + tphoto + "_" + introduction + "_" + qid;
	}
	
	public boolean equals(Teacher teacher) {
		boolean flag = true;
		if(tid != teacher.tid) flag = false;
		if(!tname.equals(teacher.tname)) flag = false;
		if(!tphoto.equals(teacher.tphoto)) flag = false;
		if(!introduction.equals(teacher.introduction)) flag = false;
		if(qid != teacher.qid) flag = false;
		return flag;
	}
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTphoto() {
		return tphoto;
	}
	public void setTphoto(String tphoto) {
		this.tphoto = tphoto;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
}
