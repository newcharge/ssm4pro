package com.neuedu.service.impl;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.po.Address;
import com.neuedu.service.AddressService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class AddressServiceImplTest {

	@Autowired
	AddressService addressService;
	
	@Ignore
	@Test
	public void testAddAddress() throws Exception {
		Address address = new Address();
		address.setQid(1);
		address.setBranch("zzz1");
		address.setAddress("add1");
		address.setTel("110");
		address.setLongitude(1.1111);
		address.setLatitude(2.2222);
		System.out.println(addressService.addAddress(address));
	}

	@Ignore
	@Test
	public void testDeleteAddress() throws Exception {
		System.out.println(addressService.deleteAddress(4));

	}

	@Ignore
	@Test
	public void testEditAddress() throws Exception {
		Address address = new Address();
		address.setId(5);
		address.setQid(1);
		address.setBranch("zzz1c");
		address.setAddress("add1c");
		address.setTel("110c");
		address.setLongitude(1.1111);
		address.setLatitude(2.2222);
		System.out.println(addressService.editAddress(address));
		
	}

	@Ignore
	@Test
	public void testShowAddress() throws Exception {
		addressService.showAddress(1).forEach(System.out::println);
		
	}

}
