package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.RefundDao;
import com.neuedu.po.Refund;
import com.neuedu.service.RefundService;

@Service
public class RefundServiceImpl implements RefundService {

	@Autowired
	RefundDao refundDao;
	@Transactional
	@Override
	public boolean addRefund(Refund refund) throws Exception {
		// TODO Auto-generated method stub
		return refundDao.addRefund(refund);
	}

	@Transactional
	@Override
	public boolean deleteRefundbyOID(int oid) throws Exception {
		// TODO Auto-generated method stub
		return refundDao.deleteRefundbyOID(oid);
	}

	@Transactional
	@Override
	public boolean editRefund(Refund refund) throws Exception {
		// TODO Auto-generated method stub
		return refundDao.editRefund(refund);
	}

	@Transactional
	@Override
	public List<Refund> showRefundbyOID(int oid) throws Exception {
		// TODO Auto-generated method stub
		return refundDao.showRefundbyOID(oid);
	}

}
