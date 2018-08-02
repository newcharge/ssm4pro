package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.RefundDao;
import com.neuedu.dao.SorderDao;
import com.neuedu.po.Refund;
import com.neuedu.po.Sorder;
import com.neuedu.service.RefundService;
import com.neuedu.vo.VInputRefund;

@Service
public class RefundServiceImpl implements RefundService {

	@Autowired
	RefundDao refundDao;
	
	@Autowired
	SorderDao sorderDao;

	@Transactional
	@Override
	public boolean editRefund(int oid) throws Exception {
		// TODO Auto-generated method stub
		Sorder sorder = new Sorder();
		sorder.setOid(oid);
		sorder.setStatus("已退款");
		sorderDao.changeSorderState(sorder);
		return refundDao.editRefund(oid);
	}

	@Transactional
	@Override
	public List<Refund> showRefundByOthers(VInputRefund vir) throws Exception {
		// TODO Auto-generated method stub
		return refundDao.showRefundByOthers(vir);
	}

	@Transactional
	@Override
	public Refund showByOid(int oid) throws Exception {
		// TODO Auto-generated method stub
		return refundDao.showRefundByOid(oid);
	}

	@Transactional
	@Override
	public List<Sorder> showRefund(int qid) throws Exception {
		// TODO Auto-generated method stub
		return refundDao.showRefund(qid);
	}

}
