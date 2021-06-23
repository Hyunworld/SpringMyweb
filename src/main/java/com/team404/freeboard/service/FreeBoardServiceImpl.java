package com.team404.freeboard.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team404.command.FreeBoardVO;
import com.team404.freeboard.mapper.FreeBoardMapper;
import com.team404.util.Criteria;

@Service("freeService") //componentscan
public class FreeBoardServiceImpl implements FreeBoardService {

	@Autowired
	private FreeBoardMapper freeMapper;
	
	@Override
	public int regist(FreeBoardVO vo) {
		return freeMapper.regist(vo);
	}

	@Override
	public ArrayList<FreeBoardVO> getList(Criteria cri) {
		
		return freeMapper.getList(cri);
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


	@Override
	public int getTotal(Criteria cri) {
		
		return freeMapper.getTotal(cri);
	}

	

}
