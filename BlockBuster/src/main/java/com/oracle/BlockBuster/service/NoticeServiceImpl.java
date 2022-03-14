package com.oracle.BlockBuster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.BlockBuster.dao.NoticeDao;
import com.oracle.BlockBuster.model.NoticeDto;

@Service
public class NoticeServiceImpl implements NoticeService {

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
		System.out.println("NoticeServiceImpl Start noticeDetail...");
		NoticeDto noticeDto = null;
		noticeDto = nd.noticeDetail(n_no);
		
		return noticeDto;
	}
	
}
