package com.oracle.BlockBuster.dao;

import java.util.List;

import com.oracle.BlockBuster.model.NoticeDto;

public interface NoticeDao {
	int					total(); 

	List<NoticeDto> 	listNotice(NoticeDto noticeDto);

	NoticeDto 			noticeDetail(int n_no); 
}
