package com.neuedu.dao;

import java.util.List;

import com.neuedu.po.Refund;
import com.neuedu.vo.VInputRefund;

public interface RefundDao {

	public boolean addRefund (Refund refund) throws Exception;
	public boolean editRefund (Refund refund) throws Exception;
	public List<Refund> showRefundByOthers(VInputRefund vir) throws Exception;	
}
