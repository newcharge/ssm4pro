package com.neuedu.service;

import java.util.List;

import com.neuedu.vo.VInputAddress;
import com.neuedu.vo.VOutputAddress;

public interface AddressService {
	public boolean addAddress(VInputAddress via);
	public boolean deleteAddress(VInputAddress via);
	public boolean editAddress(VInputAddress via);
	public List<VOutputAddress> showAddress(int qid);
}
