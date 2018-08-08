package com.neuedu.po;

import org.apache.ibatis.type.Alias;

@Alias("Sorder")
public class Sorder {

	private int oid;
	private int lid;
	private String openid;
	private double total;
	private int cid;
	private double actual;
	private String status;
	private String ordertime;//数据库中的datetime类型
	private int qid;
	private String transactionid;
	private String nickname;
	private String tel;
	
	public String toString() {
		return oid + "_" + lid + "_" + openid + "_" + total + "_" + cid + "_" + actual + "_" + status + "_" + ordertime + "_" + qid+ "_" + transactionid+ "_" + nickname+ "_" + tel;
	} 
	
	public boolean equals(Sorder sorder) {
		boolean flag = true;
		if (oid != sorder.oid) flag= false;
		if (lid != sorder.lid) flag= false;
		if (!openid.equals(sorder.openid)) flag=false;
		if (total != sorder.total) flag= false;
		if (cid!=sorder.cid) flag=false;
		if (actual != sorder.actual) flag= false;
		if (!status.equals(sorder.status)) flag=false;
		if (!ordertime.equals(sorder.ordertime)) flag=false;
		if (qid != sorder.qid) flag= false;
		if (!transactionid.equals(sorder.transactionid)) flag=false;
		if (!nickname.equals(sorder.nickname)) flag=false;
		if (!tel.equals(sorder.tel)) flag=false;
		return flag;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public double getActual() {
		return actual;
	}
	public void setActual(double actual) {
		this.actual = actual;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
