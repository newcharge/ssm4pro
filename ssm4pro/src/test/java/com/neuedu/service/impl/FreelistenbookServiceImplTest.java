package com.neuedu.service.impl;

import java.sql.Timestamp;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.po.Freelistenbook;
import com.neuedu.service.FreelistenbookService;
import com.neuedu.vo.VInputFreelistenbook;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})

public class FreelistenbookServiceImplTest {
	
	@Autowired
	FreelistenbookService freelistenbookService;
	
	@Ignore
	@Test
	public void testAddFreelistenbook() throws Exception {
		Freelistenbook freelistenbook = new Freelistenbook();
		freelistenbook.setFid(50);
		freelistenbook.setUsername("zzz50");
		freelistenbook.setTel("50");
		String s = "1111-11-11 11:11:11";
		Timestamp time = Timestamp.valueOf(s);
		freelistenbook.setBooktime(time.toString());
		freelistenbook.setStatus("status50");
		freelistenbook.setComment("comment50");
		freelistenbook.setOpenid("openid50");
		System.out.println(freelistenbook);
		
		freelistenbookService.addFreelistenbook(freelistenbook);
	}

	@Ignore
	@Test
	public void testChangeFreelistenbookState() throws Exception {
		Freelistenbook freelistenbook = new Freelistenbook();
		freelistenbook.setId(24);
		freelistenbook.setStatus("changed");
		freelistenbookService.changeFreelistenbookState(freelistenbook);

	}

	@Ignore
	@Test
	public void testShowFreelistenbook() throws Exception {
		freelistenbookService.showFreelistenbook(1).forEach(System.out::println);

	}

	@Ignore
	@Test
	public void testShowFreelistenbookByOthers() throws Exception {
		VInputFreelistenbook vif = new VInputFreelistenbook();
		vif.setQid(1);
		vif.setId(9);
		vif.setStatus("待处理");
		vif.setStarttime("2018-05-26 00:00:01");
		vif.setEndtime("2018-05-26 23:00:01");
		freelistenbookService.showFreelistenbookByOthers(vif).forEach(System.out::println);


	}

}
