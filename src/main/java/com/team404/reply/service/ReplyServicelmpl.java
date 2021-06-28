package com.team404.reply.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team404.command.FreeReplyVO;
import com.team404.reply.mapper.ReplyMapper;
import com.team404.util.Criteria;

@Service("replyService")
public class ReplyServicelmpl implements ReplyService {

	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public int regist(FreeReplyVO vo) {
		
		return replyMapper.regist(vo);
	}

	@Override
	public ArrayList<FreeReplyVO> getList(int bno, Criteria cri) {
		
		return replyMapper.getList(bno, cri);
	}

	@Override
	public int pwCheck(FreeReplyVO vo) {
		
		return replyMapper.pwCheck(vo);
	}

	@Override
	public int update(FreeReplyVO vo) {
		
		return replyMapper.update(vo);
	}

	@Override
	public int delete(FreeReplyVO vo) {
		
		return replyMapper.delete(vo);
	}

	@Override
	public int getTotal(int bno) {
		
		return replyMapper.getTotal(bno);
	}

}
