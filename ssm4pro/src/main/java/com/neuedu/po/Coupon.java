package com.neuedu.po;


import org.apache.ibatis.type.Alias;

@Alias("Coupon")
public class Coupon {
	private int cid;
	private int qid;
	private String category;
	private int money;
	private int total;
	private int get;
	private String deadline;//数据库date类型
	
	@Override
	public String toString() {
		
		return cid + "_" + qid + "_" + category + "_" + money + "_" + total + "_" +get + "_" + deadline;
	}
	
	public boolean equals(Coupon coupon) {
		boolean flag = true;
		if (cid!= coupon.cid) flag=false;
		if (qid!= coupon.qid) flag=false;
		if (!category.equals(coupon.category)) flag=false;
		if (money!= coupon.money) flag=false;
		if (total!= coupon.total) flag=false;
		if (get!= coupon.get) flag=false;
		if (!deadline.equals(coupon.deadline)) flag=false;
		return flag;
	
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getGet() {
		return get;
	}
	public void setGet(int get) {
		this.get = get;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	

}
