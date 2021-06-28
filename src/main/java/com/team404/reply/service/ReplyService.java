package com.team404.reply.service;

import java.util.ArrayList;

import com.team404.command.FreeReplyVO;
import com.team404.util.Criteria;

public interface ReplyService {
	public int regist(FreeReplyVO vo);
//	public ArrayList<FreeReplyVO> getList(int bno);
	public ArrayList<FreeReplyVO> getList(int bno, Criteria cri);
	public int pwCheck(FreeReplyVO vo); //비밀번호확인
	public int update(FreeReplyVO vo);
	public int delete(FreeReplyVO vo);
	public int getTotal(int bno); //전체 댓글 수
}
