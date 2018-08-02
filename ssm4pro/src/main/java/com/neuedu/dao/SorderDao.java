package com.neuedu.dao;

import java.util.List;

import com.neuedu.po.Sorder;
import com.neuedu.vo.VInputSorder;



public interface SorderDao {

	public boolean addSorder(Sorder sorder) throws Exception;
	public boolean changeSorderState(Sorder sorder) throws Exception;
	public List<Sorder> showSorder(int qid) throws Exception;
	public List<Sorder> showSorderByOthers(VInputSorder vis) throws Exception;
	public List<Sorder> showSorderByEle(Sorder sorder) throws Exception;
	public List<Sorder> showHeXiao(int qid) throws Exception;
	public List<Sorder> showHeXiaoByOthers(VInputSorder vis) throws Exception;
	public List<Sorder> showRefund(int qid) throws Exception;
	public List<Sorder> showRefundByOthers(VInputSorder vis) throws Exception;
	public boolean dealHeXiao(int oid) throws Exception;
	public int showSorderAmount(int qid) throws Exception;
	public double showPaidFee(int qid) throws Exception;
	public double showPayingFee(int qid) throws Exception;
}
