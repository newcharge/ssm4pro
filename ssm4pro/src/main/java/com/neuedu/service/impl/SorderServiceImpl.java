package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.RefundDao;
import com.neuedu.dao.SorderDao;
import com.neuedu.po.Refund;
import com.neuedu.po.Sorder;
import com.neuedu.service.SorderService;
import com.neuedu.vo.VInputRefund;
import com.neuedu.vo.VInputSorder;

@Service
public class SorderServiceImpl implements SorderService{

	@Autowired
	SorderDao sorderDao;
	
	@Autowired
	RefundDao refundDao;
	
	@Transactional
	@Override
	public boolean addSorder(Sorder sorder) throws Exception {
		// TODO Auto-generated method stub
		return sorderDao.addSorder(sorder);
	}

	@Transactional
	@Override
	public boolean createRefund(VInputRefund vir) throws Exception {
		// TODO Auto-generated method stub
		Sorder sorder = new Sorder();
		sorder.setOid(vir.getOid());
		sorder.setStatus("退款中");
		
		Refund refund = new Refund();
		refund.setOid(vir.getOid());
		refund.setRefundreason(vir.getRefundReason());
		refundDao.addRefund(refund);
		return sorderDao.changeSorderState(sorder);
	}
	
	@Transactional
	@Override
	public boolean payroll(int oid) throws Exception {
		// TODO Auto-generated method stub
		Sorder sorder = new Sorder();
		sorder.setOid(oid);
		sorder.setStatus("已付款");
		return sorderDao.changeSorderState(sorder);
	}
	
	@Transactional
	@Override
	public List<Sorder> showSorder(int qid) throws Exception {
		// TODO Auto-generated method stub
		return sorderDao.showSorder(qid);
	}
	
	@Transactional
	@Override
	public List<Sorder> showSorderByOthers(VInputSorder vis) throws Exception {
		// TODO Auto-generated method stub
		return sorderDao.showSorderByOthers(vis);
	}

	@Transactional
	@Override
	public List<Sorder> showSorderByEle(Sorder sorder) throws Exception {
		// TODO Auto-generated method stub
		return sorderDao.showSorderByEle(sorder);
	}



	

}
