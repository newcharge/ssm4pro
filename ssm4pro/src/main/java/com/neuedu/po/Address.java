package com.neuedu.po;

import org.apache.ibatis.type.Alias;

@Alias("Address")
public class Address {
	
private int id;
private int qid;
private String branch;
private String address;
private String tel;
private double longitude;
private double latitude;

@Override
public String toString() {
	return id + "_" + qid + "_" + branch + "_" + address + "_" + tel + "_" +longitude + "_" + latitude;
}

public boolean equals(Address address) {
	boolean flag = true;
	if(id!=address.id) flag = false;
	if(qid!=address.qid) flag = false;
	if(!branch.equals(address.branch)) flag = false ;
	if(!this.address.equals(address.address)) flag = false;
	if(!tel.equals(address.tel)) flag = false;
	if(longitude!=address.longitude) flag = false;
	if(latitude!=address.latitude) flag = false;
	return flag;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getQid() {
	return qid;
}
public void setQid(int qid) {
	this.qid = qid;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public double getLongitude() {
	return longitude;
}
public void setLongitude(double longitude) {
	this.longitude = longitude;
}
public double getLatitude() {
	return latitude;
}
public void setLatitude(double latitude) {
	this.latitude = latitude;
}

}
