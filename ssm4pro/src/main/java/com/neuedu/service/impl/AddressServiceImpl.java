package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.AddressDao;
import com.neuedu.po.Address;
import com.neuedu.service.AddressService;
import com.neuedu.vo.VInputAddress;
import com.neuedu.vo.VOutputAddress;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;
	
	@Override
	public boolean addAddress(VInputAddress via) throws Exception {
		// TODO Auto-generated method stub
		Address address = new Address();
		address.setQid(via.getQid());
		return addressDao.addAddress(address);
	}

	@Override
	public boolean deleteAddress(VInputAddress via) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editAddress(VInputAddress via) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<VOutputAddress> showAddress(int qid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
