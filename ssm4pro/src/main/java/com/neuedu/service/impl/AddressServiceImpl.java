package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.AddressDao;
import com.neuedu.po.Address;
import com.neuedu.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;
	
	@Override
	public boolean addAddress(Address address) throws Exception {
		// TODO Auto-generated method stub
		return addressDao.addAddress(address);
	}

	@Override
	public boolean deleteAddress(int id) throws Exception {
		// TODO Auto-generated method stub
		return addressDao.deleteAddress(id);
	}

	@Override
	public boolean editAddress(Address address) throws Exception {
		// TODO Auto-generated method stub
		return addressDao.editAddress(address);
	}

	@Override
	public Address showAddressById(int id) throws Exception {
		// TODO Auto-generated method stub
		return addressDao.showAddressById(id);
	}

	@Override
	public List<Address> showAddress(int qid) throws Exception {
		// TODO Auto-generated method stub
		return addressDao.showAddress(qid);
	}
}
