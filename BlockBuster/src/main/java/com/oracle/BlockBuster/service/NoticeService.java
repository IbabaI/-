package com.oracle.BlockBuster.service;

import java.util.List;

import com.oracle.BlockBuster.model.NoticeDto;

public interface NoticeService {
	int 					total();
	List<NoticeDto> 		listNotice(NoticeDto noticeDto);
	NoticeDto 				noticeDetail(int n_no);  
}
