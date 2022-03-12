package com.oracle.BlockBuster.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.BlockBuster.model.NoticeDto;
import com.oracle.BlockBuster.service.NoticeService;

@Controller
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	/* ------------------- service 연결 ------------------- */
	@Autowired
	private NoticeService ns;
	
	
	/* ------------------- total, list, paging ------------------- */
	@RequestMapping(value = "Notice/listNotice")
	public String listNotice(NoticeDto noticeDto, String currentPage, Model model) {
		logger.info("NoticeController listNotice 시작");
		int total = ns.total();
		logger.info("NoticeController total =>" + total);
		model.addAttribute("total", total);
		
		return "Notice/listNotice";
	}
	
	/* -------------------  ------------------- */
	
	
}
