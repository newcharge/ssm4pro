package com.neuedu.po;

import org.apache.ibatis.type.Alias;

@Alias("Message")
public class Message {
   
	private int mid;
	private String mtitle;
	private String mtime;
	private int qid;
	
	@Override
	public String toString() {
		return mid + "_" + mtitle + "_" + mtime + "_" + qid;
	}
	
	public boolean equals(Message message) {
		boolean flag=true;
		if(mid != message.mid) flag = false;
		if(!mtitle.equals(message.mtitle)) flag = false;
		if(!mtime.equals(message.mtime)) flag = false;
		if(qid != message.qid) flag = false;
		return flag;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMtitle() {
		return mtitle;
	}

	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}

	public String getMtime() {
		return mtime;
	}

	public void setMtime(String mtime) {
		this.mtime = mtime;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}
	
	
	
}
