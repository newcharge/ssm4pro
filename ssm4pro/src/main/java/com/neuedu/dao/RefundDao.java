package com.neuedu.dao;

import java.util.List;

import com.neuedu.po.Refund;

public interface RefundDao {

	public boolean addRefund (Refund refund) throws Exception;
	public boolean deleteRefundbyOID (int oid)  throws Exception;
	public boolean editRefund (Refund refund) throws Exception;
	public List<Refund> showRefundbyOID(int oid) throws Exception;	
}
