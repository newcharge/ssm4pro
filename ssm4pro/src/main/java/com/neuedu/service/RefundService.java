package com.neuedu.service;

import java.util.List;

import com.neuedu.po.Refund;
import com.neuedu.po.Sorder;
import com.neuedu.vo.VInputRefund;

public interface RefundService {

	public boolean editRefund (int oid) throws Exception;
	public List<Refund> showRefundByOthers(VInputRefund vir) throws Exception;	
	public Refund showByOid(int oid) throws Exception;
	public List<Sorder> showRefund(int qid) throws Exception;
}
