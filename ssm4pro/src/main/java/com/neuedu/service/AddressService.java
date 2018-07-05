package com.neuedu.service;

import java.util.List;

import com.neuedu.vo.VInputAddress;
import com.neuedu.vo.VOutputAddress;

public interface AddressService {
	public boolean addAddress(VInputAddress via) throws Exception;
	public boolean deleteAddress(VInputAddress via) throws Exception;
	public boolean editAddress(VInputAddress via) throws Exception;
	public List<VOutputAddress> showAddress(int qid) throws Exception;
}
