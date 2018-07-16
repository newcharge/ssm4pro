package com.neuedu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.po.Address;
import com.neuedu.service.AddressService;

@Controller
public class AddressHandler {

	@Autowired
	AddressService addressService;
	
	@RequestMapping(value = "address/showAddress.action")
	@ResponseBody
	public List<Address> showAddress(int qid) throws Exception {
		return addressService.showAddress(qid);
	}
}
