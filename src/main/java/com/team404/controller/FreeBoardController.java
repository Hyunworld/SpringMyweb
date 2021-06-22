package com.team404.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import org.apache.commons.beanutils.converters.BooleanArrayConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team404.command.FreeBoardVO;
import com.team404.freeboard.service.FreeBoardService;

@Controller
@RequestMapping("/freeBoard")
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeService;
	
	
	//리스트화면
	@RequestMapping("/freeList")
	public String freeList(Model model) {
		
		ArrayList<FreeBoardVO> list = freeService.getList();
		
		model.addAttribute("list", list); //화면에서 전달(여러값이라면 맵으로 가능)
		

		return "freeBoard/freeList";
	}
	
	
	//등록화면
	@RequestMapping("/freeRegist")
	public String freeRegist() {
		return "freeBoard/freeRegist";
	}
	
//	//상세화면
//	@RequestMapping("/freeDetail")
//	public String freeDetail(@RequestParam("bno") int bno, Model model) {
//		
//		//메서드이름 - getDetail();
//		//sql문을 이용해서 FreeBoardVO에 결과값을 반환받습니다.
//		//화면에서 사용할수 있도록 boardVO이름으로 model을 전달하고,화면에 처리
//		FreeBoardVO vo = freeService.getDetail(bno);
//		model.addAttribute("vo", vo);
//		
//		
//		return "freeBoard/freeDetail";
//	}
//	
//	//변경화면
//	@RequestMapping("/freeModify")
//	public String freeModify(@RequestParam("bno") int bno,
//							Model model) {
//		FreeBoardVO boardVO = freeService.getDetail(bno);
//		model.addAttribute("boardVO", boardVO);
//		
//		return "freeBoard/freeModify";
//	}
	
	//상세화면과 변경화면은 내용이 동일하기 때문에 하나로 묶어서 사용
	
	@RequestMapping({"/freeDetail", "/freeModify"})
	public void getDetail(@RequestParam("bno") int bno,
						Model model) {
		
		FreeBoardVO vo = freeService.getDetail(bno);
		model.addAttribute("vo", vo);
		
	}
	
	
	//등록요청
	@RequestMapping("/registForm")
	public String registForm(FreeBoardVO vo, RedirectAttributes RA) {
		
		int result = freeService.regist(vo);
		
		if(result == 1) {
			RA.addFlashAttribute("msg", "등록 처리 되었습니다");
		} else {
			RA.addFlashAttribute("msg", "등록에 실패했습니다. 다시 시도하세요.");
		}
		
		return "redirect:/freeBoard/freeList";
	}
	
	@RequestMapping("/freeUpdate")
	public String freeUpdate(FreeBoardVO vo, RedirectAttributes RA) {
		/*
		 * 1. form에서 넘어오는 값을 받습니다.
		 * 2. update()를 이용해서 게시글을 수정처리 합니다.
		 * 3. update()메서드는 성공 or 실패의 결과를 받아옵니다.
		 * 4. list화면으로 msg담아서 이동
		 */
		
		int result = freeService.Update(vo);
		
		if(result == 1) {
			RA.addFlashAttribute("msg", "수정완료");
		} else {
			RA.addFlashAttribute("msg", "@@@@ 수정오류 @@@@@");
		}
		
		return "redirect:/freeBoard/freeList";
	}
	
	@RequestMapping("/freeDelete")
	public String freeDelete(@RequestParam("bno") int bno, RedirectAttributes RA) {
		
		int result = freeService.delete(bno);
		
		if(result == 1) {
			RA.addFlashAttribute("msg", "삭제되었습니다");
		} else {
			RA.addFlashAttribute("msg", "삭제오류");
		}
		return "redirect:/freeBoard/freeList";
	}
	
	
	
}
