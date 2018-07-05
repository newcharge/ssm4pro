package com.neuedu.po;

import org.apache.ibatis.type.Alias;

@Alias("Weixin")
public class Weixin {
	
	private int qid;
	private String appid; 
	private String appsecret;
	private String partner;
	private String partnerkey;
	private String weixinpaycallback;
	
	@Override
	public String toString() {
		return qid + "_" + appid + "_" + appsecret + "_" + partner + "_" + partnerkey + "_" + weixinpaycallback ;
	}
	
	public boolean equals(Weixin weixin) {
		boolean flag = true;
		if(qid!=weixin.qid) flag = false;
		if(!appid.equals(weixin.appid)) flag = false ;
		if(!appsecret.equals(weixin.appsecret)) flag = false ;
		if(!partner.equals(weixin.partner)) flag = false ;
		if(!partnerkey.equals(weixin.partnerkey)) flag = false ;
		if(!weixinpaycallback.equals(weixin.weixinpaycallback)) flag = false ;
		return flag;
	}
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getAppsecret() {
		return appsecret;
	}
	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getPartnerkey() {
		return partnerkey;
	}
	public void setPartnerkey(String partnerkey) {
		this.partnerkey = partnerkey;
	}
	public String getWeixinpaycallback() {
		return weixinpaycallback;
	}
	public void setWeixinpaycallback(String weixinpaycallback) {
		this.weixinpaycallback = weixinpaycallback;
	}
	
	
	

}
