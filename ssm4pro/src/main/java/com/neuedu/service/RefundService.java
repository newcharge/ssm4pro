package com.neuedu.service;

import java.util.List;

import com.neuedu.po.Refund;
import com.neuedu.vo.VInputRefund;

public interface RefundService {

	public boolean editRefund (Refund refund) throws Exception;
	public List<Refund> showRefundByOthers(VInputRefund vir) throws Exception;	
	
}
