package com.oracle.BlockBuster.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		
		logger.debug("NoticeController noticeDetail +noticeDto.getN_content() =>> " + noticeDto.getN_content());
		model.addAttribute("noticeDto", noticeDto);
		
	/* ------------------- 조회수 증가 ------------------- */
//		logger.info("NoticeController NoticeHit 시작");
//		n_no = noticeDto.getN_no();
//		ns.NoticeHit(n_no);	
		
		return "Notice/noticeDetail";
	}
	
	/* ------------------- 수정 ------------------- */
	@GetMapping(value = "Notice/updateFormNotice")
	public String noticeUpdateForm(int n_no, Model model) {
		logger.info("NoticeController noticeUpdateForm 시작");
		NoticeDto noticeDto = ns.noticeContent(n_no);
		
		logger.info("NoticeController noticeUpdateForm noticeDto.getN_content() =>>" + noticeDto.getN_content());
		model.addAttribute("noticeDto", noticeDto);
		
		return "Notice/updateFormNotice";
	}
	
	/* ------------------- 수정-저장하기 ------------------- */
	@PostMapping(value = "Notice/noticeUpdate")
	public String noticeUpdate(NoticeDto noticeDto, Model model ) {
		logger.info("NoticeController noticeUpdate 시작");
		
		int upNoti = ns.noticeUpdate(noticeDto);
		logger.info("NoticeController + upNoti =>> " + upNoti);
		model.addAttribute("upNoti", upNoti );
		
		return"forward:listNotice";
	}
	
	/* ------------------- 쓰기 ------------------- */
	@RequestMapping(value = "Notice/writeFormNotice")
	public String writeFormNotice(Model model) {
		logger.info("NoticeController writeFormNotice 쓰기시작");
		
		return "Notice/writeFormNotice";
	}
	
	/* ------------------- 쓰기-저장하기 ------------------- */
	@RequestMapping(value = "Notice/writeNotice", method = RequestMethod.POST)
	public String writeNotice(NoticeDto noticeDto, Model model) {
		logger.info("NoticeController writeNotice 쓰기 저장 시작");
		int result = ns.insert(noticeDto);
		System.out.println("==============게시글 작성 반영 결과 : " + result);
		if(result > 0) {
			return "redirect:listNotice";
		}
			model.addAttribute("입력 실패 - 확인해보세요");
			return "forward:Notice/writeFormNotice";
	}
	
	/* ------------------- 삭제 ------------------- */
	@RequestMapping(value = "Notice/noticeDelete")
	public String noticeDelete(int n_no, Model model) {
		logger.info("NoticeController noticeDelete 시작");
		int result = ns.noticeDelete(n_no);
		Integer integer = result;
		
		return "redirect:listNotice";
	}
	
	
	
	
	
	
}
