package com.neuedu.service.impl;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.po.Message;
import com.neuedu.po.Messageimg;
import com.neuedu.po.Messagelike;
import com.neuedu.po.Messagereply;
import com.neuedu.service.MessageService;
import com.neuedu.vo.VInputMessage;
import com.neuedu.vo.VOutputMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class MessageServiceImplTest {

	@Autowired
	MessageService messageService;
	
	@Ignore
	@Test
	public void testAddMessage() throws Exception {
		Message message = new Message();
		message.setMtitle("test-title");
		message.setQid(1);
		Messageimg img_1 = new Messageimg();
		img_1.setImgurl("test-url-1");
		Messageimg img_2 = new Messageimg();
		img_2.setImgurl("test-url-2");
		Messageimg img_3 = new Messageimg();
		img_3.setImgurl("test-url-3");
		List<Messageimg> imgList = Arrays.asList(img_1, img_2, img_3);
		VInputMessage vimessage = new VInputMessage();
		vimessage.setMessage(message);
		vimessage.setImgList(imgList);
		assertTrue(messageService.addMessage(vimessage));
	}

	@Ignore
	@Test
	public void testAddReply() throws Exception {
		Messagereply reply = new Messagereply();
		reply.setNickname("test-name");
		reply.setContent("test-content");
		reply.setMid(3);
		assertTrue(messageService.addReply(reply));
	}

	@Ignore
	@Test
	public void testAddLike() throws Exception {
		Messagelike like = new Messagelike();
		like.setNickname("test-name");
		like.setMid(3);
		assertTrue(messageService.addLike(like));
	}

	@Ignore
	@Test
	public void testDeleteMessage() throws Exception {
		assertTrue(messageService.deleteMessage(3));
	}

	@Ignore
	@Test
	public void testDeleteReply() throws Exception {
		assertTrue(messageService.deleteReply(4));
	}

	@Ignore
	@Test
	public void testEditMessage() throws Exception {
		VInputMessage vimessage = new VInputMessage();
		Message message = new Message();
		Messageimg img_1 = new Messageimg();
		img_1.setImgurl("test1-png");
		Messageimg img_2 = new Messageimg();
		img_2.setImgurl("test2-png");
		List<Messageimg> imgList = Arrays.asList(img_1, img_2);
		message.setMid(3);
		message.setMtitle("test-another-title");
		vimessage.setMessage(message);
		
		imgList.forEach(System.out::println);
		vimessage.setImgList(imgList);
		messageService.editMessage(vimessage);
	}

	@Test
	public void testShowMessageByQid() throws Exception {
		List<VOutputMessage> messageList = messageService.showMessageByQid(1);
		messageList.forEach(msg -> {
			System.out.println(String.join("_", String.valueOf(msg.getMid()), String.valueOf(msg.getQid()), msg.getMtime(), msg.getMtitle()));
			msg.getImgList().forEach(System.out::println);
			msg.getLikeList().forEach(System.out::println);
			msg.getReplyList().forEach(System.out::println);
		});
		assertTrue(true);
	}

}
