package com.neuedu.po;

import org.apache.ibatis.type.Alias;

@Alias("Refund")
public class Refund {

	private int oid;
	private String refundreason;
	private String refundtime;
	private String status;
	
	public String toString() {
		return oid + "_" + refundreason + "_" + refundtime + "_" + status;
	}
	
	public boolean equals(Refund refund) {
		boolean flag = true;
		if (oid != refund.oid) flag= false;
		if (!refundreason.equals(refund.refundreason)) flag=false;
		if(!refundtime.equals(refund.refundtime)) flag=false;
		if (!status.equals(refund.status)) flag=false;
		return flag;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getRefundreason() {
		return refundreason;
	}
	public void setRefundreason(String refundreason) {
		this.refundreason = refundreason;
	}
	public String getRefundtime() {
		return refundtime;
	}
	public void setRefundtime(String refundtime) {
		this.refundtime = refundtime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
