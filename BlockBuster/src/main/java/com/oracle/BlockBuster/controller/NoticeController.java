package com.oracle.BlockBuster.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.BlockBuster.model.NoticeDto;
import com.oracle.BlockBuster.service.NoticeService;
import com.oracle.BlockBuster.service.Paging;

@Controller
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	/* ------------------- service 연결 ------------------- */
	@Autowired
	private NoticeService ns;
	
	
	/* ------------------- total, list ------------------- */
	@RequestMapping(value = "Notice/listNotice")
	public String list(NoticeDto noticeDto, String currentPage, Model model) {
		logger.info("NoticeController listNotice 시작");
		int total = ns.total();
		logger.info("NoticeController total =>" + total);
		model.addAttribute("total", total);
		
		/* ------------------- paging ------------------- */
		
		logger.info("NoticeController currentPage=>>" + currentPage);
		Paging pg = new Paging(total, currentPage);
		
		noticeDto.setStart(pg.getStart()); //시작시 1
		noticeDto.setEnd(pg.getEnd());     //시작시 10
		
		List<NoticeDto> listNotice = ns.listNotice(noticeDto);
		logger.info("NoticeController listNotice.size() =>>>" + listNotice.size());
		
		model.addAttribute("listNotice", listNotice);
		model.addAttribute("pg", pg);
		
		return "Notice/listNotice";
	}
	
	/* ------------------- 게시글 상세보기 ------------------- */
	@GetMapping(value = "Notice/noticeDetail")
	public String noticeDetail(int n_no, Model model) {
		logger.info("NoticeController noticeDetail 시작");
		NoticeDto noticeDto = ns.noticeDetail(n_no);
		model.addAttribute("noticeDto", noticeDto);
		
		return "Notice/noticeDetail";
	}
	
	
}
