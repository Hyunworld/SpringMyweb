package com.team404.freeboard.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team404.command.FreeBoardVO;
import com.team404.freeboard.mapper.FreeBoardMapper;

@Service("freeService") //componentscan
public class FreeBoardServiceImpl implements FreeBoardService {

	@Autowired
	private FreeBoardMapper freeMapper;
	
	@Override
	public int regist(FreeBoardVO vo) {
		return freeMapper.regist(vo);
	}

	@Override
	public ArrayList<FreeBoardVO> getList() {
		
		return freeMapper.getList();
	}

	@Override
	public FreeBoardVO getDetail(int bno) {
		
		return freeMapper.getDetail(bno);
	}

	@Override
	public int Update(FreeBoardVO vo) {
		return freeMapper.Update(vo);
	}

	@Override
	public int delete(int bno) {
		
		return freeMapper.delete(bno);
	}

	

}
