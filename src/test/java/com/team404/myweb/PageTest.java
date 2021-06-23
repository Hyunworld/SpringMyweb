package com.team404.myweb;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team404.command.FreeBoardVO;
import com.team404.freeboard.mapper.FreeBoardMapper;
import com.team404.util.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/DB-context.xml")
public class PageTest {
	
	@Autowired
	FreeBoardMapper boardMapper;
	
	@Test
	public void pageTest() {
		
		Criteria cri = new Criteria(2, 10);
		
		ArrayList<FreeBoardVO> list = boardMapper.getList(cri);
		System.out.println(list.toString());
		System.out.println(list.size());
		
	}
	
}
