package com.team404.freeboard.mapper;

import java.util.ArrayList;

import com.team404.command.FreeBoardVO;

public interface FreeBoardMapper {
	
	public int regist(FreeBoardVO vo);
	public ArrayList<FreeBoardVO> getList(); 
	public FreeBoardVO getDetail(int bno);
	public int Update(FreeBoardVO vo);
	public int delete(int bno);
	
}
