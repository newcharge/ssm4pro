package com.neuedu.dao;

import com.neuedu.po.Enterprise;

public interface EnterpriseDao {
	public Enterprise findByQid(int qid) throws Exception;
	public boolean editEnterprise(Enterprise enterprise) throws Exception;
	public boolean addEnterprise() throws Exception;
	
}
