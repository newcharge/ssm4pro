package com.neuedu.vo;

import java.util.List;

import com.neuedu.po.Messageimg;
import com.neuedu.po.Messagelike;
import com.neuedu.po.Messagereply;

public class VOutputMessage 
{
	private int mid;
	private int qid;
	private String mtitle;
	private String mtime;
	private List<Messageimg> imgList;
	private List<Messagelike> likeList;
	private List<Messagereply> replyList;
	
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
	public List<Messageimg> getImgList() {
		return imgList;
	}
	public void setImgList(List<Messageimg> imgList) {
		this.imgList = imgList;
	}
	public List<Messagelike> getLikeList() {
		return likeList;
	}
	public void setLikeList(List<Messagelike> likeList) {
		this.likeList = likeList;
	}
	public List<Messagereply> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<Messagereply> replyList) {
		this.replyList = replyList;
	}
}
