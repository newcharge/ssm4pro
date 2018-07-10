package com.neuedu.service.impl;

import static org.junit.Assert.fail;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.po.Freelisten;
import com.neuedu.service.FreelistenService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class FreelistenServiceImplTest 
{

	@Autowired
	FreelistenService freelistenService;
	
	@Ignore
	@Test
	public void testAddFreelisten() throws Exception {
		Freelisten freelisten = new Freelisten();
		freelisten.setTitle("题目1");
		freelisten.setImgurl("test1.jpg");
		freelisten.setFdesc("fdesc1");
		freelisten.setStatus("status1");
		freelisten.setQid(1);
		freelisten.setBranchid(3);
		String s = "1111-11-11 11:11:11";
		Timestamp time = Timestamp.valueOf(s);
		freelisten.setPubtime(time.toString());
		
		freelistenService.addFreelisten(freelisten);
	}
	
	@Ignore
	@Test
	public void testEditFreelisten() throws Exception {
		Freelisten freelisten = new Freelisten();
		freelisten.setId(5);
		freelisten.setTitle("题目3");
		freelisten.setImgurl("test3.jpg");
		freelisten.setFdesc("fdesc3");
		freelisten.setStatus("status3");
		freelisten.setQid(3);
		freelisten.setBranchid(3);
		String s = "1111-11-11 11:11:11";
		Timestamp time = Timestamp.valueOf(s);
		System.out.println(freelisten);
		freelisten.setPubtime(time.toString());
		
		freelistenService.editFreelisten(freelisten);
	}

	@Ignore
	@Test
	public void testDeleteFreelisten() throws Exception {
		freelistenService.deleteFreelisten(5);
		
	}
	
	@Ignore
	@Test
	public void testShowFreelisten() throws Exception {
		freelistenService.showFreelisten(1).forEach(System.out::println);

	}

	@Ignore
	@Test
	public void testShowFreelistenByBranchId() throws Exception {
		Freelisten freelisten = new Freelisten();
		freelisten.setQid(1);
		freelisten.setBranchid(1);
		freelistenService.showFreelistenByBranchId(freelisten).forEach(System.out::println);
	}

}
