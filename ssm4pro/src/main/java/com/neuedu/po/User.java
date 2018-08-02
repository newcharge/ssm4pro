 package com.neuedu.po;
import org.apache.ibatis.type.Alias;

@Alias("User")
public class User {

	private String username;
	private String userpassword;
	private int qid;
	private String jurisdiction;
	private int id;
	
	public String toString() {
		return  username  + "_" + userpassword + "_" +qid + "_" +jurisdiction+ "_" + id;
	} 
	
	public boolean equals(User user) {
		boolean flag = true;
		if (!username.equals(user.username)) flag=false ;
		if (!userpassword.equals(user.userpassword)) flag=false ;
		if (qid != user.qid) flag= false;
		if (!jurisdiction.equals(user.jurisdiction)) flag=false ;
		if (id != user.id) flag= false;
		return flag;
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
