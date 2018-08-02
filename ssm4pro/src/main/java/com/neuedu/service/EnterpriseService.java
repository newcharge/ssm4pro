package com.neuedu.service;

import com.neuedu.vo.VInputEnterprise;
import com.neuedu.vo.VOutputEnterprise;

public interface EnterpriseService 
{
	public VOutputEnterprise showEnterprise(int qid) throws Exception;
	public boolean editEnterprise(VInputEnterprise vie) throws Exception;
}
