package com.neuedu.po;


import org.apache.ibatis.type.Alias;

@Alias("Coupon")
public class Coupon {
	private Integer cid;
	private int qid;
	private String category;
	private int money;
	private String deadline;//数据库中的date类型
	private String openid;
	private String gettime;
	
	@Override
	public String toString() {
		
		return cid + "_" + qid + "_" + category + "_" + money + "_" + "_" + deadline;
	}
	
	public boolean equals(Coupon coupon) {
		boolean flag = true;
		if (cid!= coupon.cid) flag=false;
		if (qid!= coupon.qid) flag=false;
		if (!category.equals(coupon.category)) flag=false;
		if (money!= coupon.money) flag=false;
		if (!deadline.equals(coupon.deadline)) flag=false;
		return flag;
	
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
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

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getGettime() {
		return gettime;
	}

	public void setGettime(String gettime) {
		this.gettime = gettime;
	}

	
	
	
	

}
