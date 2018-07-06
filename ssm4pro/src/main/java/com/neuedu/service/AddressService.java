package com.neuedu.service;

import java.util.List;

import com.neuedu.po.Address;

public interface AddressService {
	public boolean addAddress(Address address) throws Exception;
	public boolean deleteAddress(int id) throws Exception;
	public boolean editAddress(Address address) throws Exception;
	public List<Address> showAddress(int qid) throws Exception;
}
