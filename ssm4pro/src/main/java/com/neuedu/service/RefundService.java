package com.neuedu.service;

import java.util.List;

import com.neuedu.po.Refund;

public interface RefundService {

	public boolean addRefund (Refund refund) throws Exception;
	public boolean deleteRefundbyOID (int oid)  throws Exception;
	public boolean editRefund (Refund refund) throws Exception;
	public List<Refund> showRefundbyOID(int oid) throws Exception;	
	
}
