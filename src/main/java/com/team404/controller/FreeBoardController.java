package com.team404.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freeBoard")
public class FreeBoardController {
	
	//리스트화면
	@RequestMapping("/freeList")
	public String freeList() {
		return "freeBoard/freeList";
	}
	
	
	//등록화면
	@RequestMapping("/freeRegist")
	public String freeRegist() {
		return "freeBoard/freeRegist";
	}
	
	//상세화면
	@RequestMapping("/freeDetail")
	public String freeDetail() {
		return "freeBoard/freeDetail";
	}
	
	//변경화면
	@RequestMapping("/freeModify")
	public String freeModify() {
		return "freeBoard/freeModify";
	}
}
