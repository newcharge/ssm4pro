package com.neuedu.utils;

import org.junit.Test;

public class SmsUtilsTest {

	@Test
	public void testGetCode() {
		String testPhone = "17824942001";
		System.out.println(SmsUtils.getCode(testPhone));
	}

}
