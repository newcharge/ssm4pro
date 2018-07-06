package com.neuedu.vo;

import java.util.List;

public class VOutputMessage 
{
	private int mid;
	private int qid;
	private String mtitle;
	private String mtime;
	private List<VOutputImg> vop;
	private List<VOutputReply> vor;
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
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
	public List<VOutputImg> getVop() {
		return vop;
	}
	public void setVop(List<VOutputImg> vop) {
		this.vop = vop;
	}
	public List<VOutputReply> getVor() {
		return vor;
	}
	public void setVor(List<VOutputReply> vor) {
		this.vor = vor;
	}
	
	
}
