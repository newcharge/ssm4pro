package com.neuedu.po;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class User {
	private String username;
	private String userpassword;
	private int qid;
	private String jurisdiction;
	private int id;
	
	@Override
	public String toString() {
		return username + "_" + userpassword+ "_" + qid + "_" + jurisdiction;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getJurisdiction() {
		return jurisdiction;
	}
	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
