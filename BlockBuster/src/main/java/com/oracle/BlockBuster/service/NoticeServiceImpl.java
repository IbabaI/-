package com.oracle.BlockBuster.service;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.BlockBuster.dao.NoticeDao;
import com.oracle.BlockBuster.model.NoticeDto;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeService.class);

	/*----------------- Dao연결 -----------------*/
	@Autowired
	private NoticeDao nd;
	
	/*-----------------총 개수-----------------*/
	@Override
	public int total() {
		System.out.println("NoticeServiceImpl Start total...");
		int totCnt = nd.total();
		System.out.println("NoticeServiceImpl start totCnt =>" + totCnt);
		
		return totCnt;
	}
	
	/*----------------- paging -----------------*/
	@Override
	public List<NoticeDto> listNotice(NoticeDto noticeDto) {
		List<NoticeDto> noticeList = null;
		System.out.println("NoticeServiceImpl Start list...");
		noticeList = nd.listNotice(noticeDto);
		System.out.println("NoticeServiceImpl Start noticeList.size() =>" + noticeList.size());
		
		return noticeList;
	}
	/*----------------- 상세보기 -----------------*/
	@Override
	public NoticeDto noticeDetail(int n_no) {
		logger.info("NoticeServiceImpl noticeDetail 상세보기시작");
		/* System.out.println("NoticeServiceImpl Start noticeDetail..."); */
		NoticeDto noticeDto = null;
		noticeDto = nd.noticeDetail(n_no);
		logger.info("NoticeServiceImpl noticeDetail  noticeDto.getN_no() =>>>" + noticeDto.getN_no());
		
		return noticeDto;
	}
	/* ------------------- 조회수 증가 ------------------- */
//	@Override
//	public void NoticeHit(int n_no) {
//		logger.info("NoticeServiceImpl NoticeHit 조회수 증가시작");
//		
//		nd.NoticeHit(n_no);
//		
//	}

	/* ------------------- 수정 ------------------- */
	@Override
	public NoticeDto noticeContent(int n_no) {
		logger.info("NoticeServiceImpl noticeContent 수정시작");
		NoticeDto noticeDto = null;
		noticeDto = nd.noticeContent(n_no);
		logger.info("NoticeServiceImpl noticeContent  noticeDto.getN_no() =>>>" + noticeDto.getN_no());
				
		return noticeDto;
	}
	/* ------------------- 수정-저장하기 ------------------- */
	@Override
	public int noticeUpdate(NoticeDto noticeDto) {
		logger.info("NoticeServiceImpl noticeUpdate 수정완료시작 ");
		int aaa = 0;
		aaa = nd.noticeUpdate(noticeDto);
		
		return aaa;
	}
	
	/* ------------------- 쓰기-저장하기 ------------------- */
	@Override
	public int insert(NoticeDto noticeDto) {
		int result = 0;
		logger.info("NoticeServiceImpl insert 쓰기 저장 시작");
		result = nd.insert(noticeDto);
		System.out.println("=================NoticeServiceImpl insert  + result" + result);
		
		return result;
	}
	
	/* ------------------- 삭제 ------------------- */
	@Override
	public int noticeDelete(int n_no) {
		int result = 0;
		logger.info("NoticeServiceImpl noticeDelete 삭제시작 ");
		result = nd.noticeDelete(n_no);
		return result;
	}

	

	
	
	
}
