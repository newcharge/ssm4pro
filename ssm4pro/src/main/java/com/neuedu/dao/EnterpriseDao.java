package com.neuedu.dao;

import com.neuedu.po.Enterprise;

public interface EnterpriseDao {
	public Enterprise findByQid(int qid) throws Exception;
}
