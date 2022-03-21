package com.oracle.BlockBuster.service;
 
import java.util.List;

import com.oracle.BlockBuster.model.NoticeCommentDto;
import com.oracle.BlockBuster.model.NoticeDto;

public interface NoticeService {
	// 공지사항
	int 					total();
	List<NoticeDto> 		listNotice(NoticeDto noticeDto);
	NoticeDto 				noticeDetail(int n_no);
	NoticeDto 				noticeContent(int n_no);
	int 					noticeUpdate(NoticeDto noticeDto);
//	void 					NoticeHit(int n_no);
	int 					noticeDelete(int n_no);
	int 					insert(NoticeDto noticeDto);
	
	// 댓글문의
	int 					noticeComment(NoticeCommentDto noticeCommentDto);

}
