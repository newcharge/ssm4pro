package com.neuedu.utils;

import org.junit.Test;

public class SmsUtilsTest {

	@Test
	public void testGetCode() {
		String testPhone = "13889377203";
		System.out.println(SmsUtils.getCode(testPhone));
	}

}
