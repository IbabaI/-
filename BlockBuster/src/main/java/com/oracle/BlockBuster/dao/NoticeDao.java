package com.oracle.BlockBuster.dao;

import java.util.List;

import com.oracle.BlockBuster.model.NoticeDto;

public interface NoticeDao {
	int					total(); 

	List<NoticeDto> 	listNotice(NoticeDto noticeDto);

	NoticeDto 			noticeDetail(int n_no);

	NoticeDto 			noticeContent(int n_no);

	int 				noticeUpdate(NoticeDto noticeDto);

//	void 				NoticeHit(int n_no);

	int 				noticeDelete(int n_no);

	int 				insert(NoticeDto noticeDto); 
}
