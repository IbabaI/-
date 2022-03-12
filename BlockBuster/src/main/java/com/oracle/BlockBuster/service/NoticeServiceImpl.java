package com.oracle.BlockBuster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.BlockBuster.dao.NoticeDao;

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
	
}
