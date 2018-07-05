package com.neuedu.service.impl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.service.AddressService;
import com.neuedu.vo.VInputAddress;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class AddressServiceImplTest {

	@Autowired
	AddressService addressService;
	
	@Test
	public void testAddAddress() throws Exception {
		VInputAddress via = new VInputAddress();
		via.setQid(1);
		System.out.println(addressService.addAddress(via));
	}

	@Test
	public void testDeleteAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowAddress() {
		fail("Not yet implemented");
	}

}
