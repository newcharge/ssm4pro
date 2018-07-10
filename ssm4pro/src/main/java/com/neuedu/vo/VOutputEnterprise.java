package com.neuedu.vo;

import java.util.List;

import com.neuedu.po.Enterprise;

public class VOutputEnterprise 
{
	private Enterprise enterprise;
	private List<String> imgurl;
	
	@Override
	public String toString() {
		return String.join("_", enterprise.toString(), String.join(",", imgurl));
	}
	
	public Enterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	public List<String> getImgurl() {
		return imgurl;
	}
	public void setImgurl(List<String> imgurl) {
		this.imgurl = imgurl;
	}
	
}
