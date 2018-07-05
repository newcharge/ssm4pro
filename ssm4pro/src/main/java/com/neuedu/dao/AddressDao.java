package com.neuedu.dao;

import java.util.List;

import com.neuedu.po.Address;

public interface AddressDao {
	public boolean addAddress(Address address) throws Exception;
	public boolean deleteAddress(Address address) throws Exception;
	public boolean editAddress(Address address) throws Exception;
	public List<Address> findAllByQid(int qid) throws Exception;
}
