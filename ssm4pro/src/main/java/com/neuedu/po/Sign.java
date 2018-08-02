package com.neuedu.po;

import org.apache.ibatis.type.Alias;

@Alias("Sign")
public class Sign {
	private int id;
	private String openid;
	private int qid;
	private String sdate;
	
	@Override
	public String toString() {
		return String.join("_", String.valueOf(id), openid, String.valueOf(qid), sdate);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
}
