package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.dao.MessageDao;
import com.neuedu.dao.MessageimgDao;
import com.neuedu.dao.MessagelikeDao;
import com.neuedu.dao.MessagereplyDao;
import com.neuedu.po.Message;
import com.neuedu.po.Messageimg;
import com.neuedu.po.Messagelike;
import com.neuedu.po.Messagereply;
import com.neuedu.service.MessageService;
import com.neuedu.vo.VInputMessage;
import com.neuedu.vo.VOutputMessage;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageDao messageDao;

	@Autowired
	MessageimgDao messageimgDao;

	@Autowired
	MessagelikeDao messagelikeDao;

	@Autowired
	MessagereplyDao messagereplyDao;

	/*
	 * (non-Javadoc)
	 * @see com.neuedu.service.MessageService#addMessage(com.neuedu.po.Message)
	 * 目前已经修改完成了
	 */
	@Transactional
	@Override
	public boolean addMessage(VInputMessage vimessage) throws Exception {
		// TODO Auto-generated method stub
		Message message = vimessage.getMessage();
		List<Messageimg> imgList = vimessage.getImgList();
		if(messageDao.addMessage(message)) {
			imgList.forEach(ele -> ele.setMid(message.getMid()));
			boolean flag = true;
			for(Messageimg img : imgList) {
				if(!messageimgDao.addImg(img)) {
					flag = false;
				}
			}
			if(flag) return true;
		}
		return false;
	}

	@Transactional
	@Override
	public boolean addReply(Messagereply reply) throws Exception {
		// TODO Auto-generated method stub
		return messagereplyDao.addReply(reply);
	}

	@Transactional
	@Override
	public boolean addLike(Messagelike like) throws Exception {
		// TODO Auto-generated method stub
		return messagelikeDao.addLike(like);
	}

	@Transactional
	@Override
	public boolean deleteMessage(int id) throws Exception {
		// TODO Auto-generated method stub
		if(messageimgDao.deleteImgByMid(id)) {
			if(messagelikeDao.deleteLikeByMid(id)) {
				if(messagereplyDao.deleteReplyByMid(id)) {
					if(messageDao.deleteMessage(id)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Transactional
	@Override
	public boolean deleteReply(int id) throws Exception {
		// TODO Auto-generated method stub
		return messagereplyDao.deleteReplyById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.neuedu.service.MessageService#deleteLike(int)
	 * 暂未实现:删除添加的点赞应该不是用id作为参考的...?
	 */
	@Transactional
	@Override
	public boolean deleteLike(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.neuedu.service.MessageService#editMessage(com.neuedu.po.Message)
	 * 目前已经修改完成了
	 */
	@Transactional
	@Override
	public boolean editMessage(VInputMessage vimessage) throws Exception {
		// TODO Auto-generated method stub
		Message message = vimessage.getMessage();
		List<Messageimg> imgList = vimessage.getImgList();
		imgList.forEach(img -> img.setMid(message.getMid()));
		if(messageDao.editMessage(message)) {
			boolean flag = true;
			messageimgDao.deleteImgByMid(message.getMid());
			for(Messageimg img : imgList) {
				messageimgDao.addImg(img);
			}
			if(flag) return true;
		}
		return false;
	}

	@Transactional
	@Override
	public List<VOutputMessage> showMessageByQid(int qid) throws Exception {
		// TODO Auto-generated method stub
		return messageDao.findAllByQid(qid);
	}
}
