package com.neuedu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.po.Address;
import com.neuedu.po.Teacher;
import com.neuedu.service.AddressService;

@Controller
public class AddressHandler {

	@Autowired
	AddressService addressService;
	
	@RequestMapping(value = "addr/showAll.action")
	@ResponseBody
	public List<Address> showAll(int qid) throws Exception {
		return addressService.showAddress(qid);
	}
	
	@RequestMapping(value = "addr/showAddressById.action")
	@ResponseBody
	public Address showAddressById(int id) throws Exception {
		return addressService.showAddressById(id);
	}
	
	@RequestMapping(value = "addr/editAddress.action")
	@ResponseBody
	public boolean editAddress(String jsonData) throws Exception {
		Address address = JsonUtils.jsonToPojo(jsonData, Address.class);

		return addressService.editAddress(address);
	}
	
	@RequestMapping(value = "addr/deleteAddress.action")
	@ResponseBody
	public boolean deleteAddress(int id) throws Exception {
		System.out.println(id);
		return addressService.deleteAddress(id);
	}
}
