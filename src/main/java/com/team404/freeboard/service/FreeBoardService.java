package com.team404.freeboard.service;

import java.util.ArrayList;

import com.team404.command.FreeBoardVO;
import com.team404.util.Criteria;

public interface FreeBoardService {
	public int regist(FreeBoardVO vo); //등록
//	public ArrayList<FreeBoardVO> getList(); //조회
	public int getTotal(Criteria cri);
	public ArrayList<FreeBoardVO> getList(Criteria cri);
	
	public FreeBoardVO getDetail(int bno); //상세
	public int Update(FreeBoardVO vo); //수정
	public int delete(int bno); //삭제
	
}
