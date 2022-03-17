package com.oracle.BlockBuster.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.BlockBuster.model.NoticeDto;



@Repository
public class NoticeDaoImpl implements NoticeDao {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeDao.class);
	
	/* ------------------- SQL session 연결 ------------------- */
	@Autowired
	private SqlSession session;
	
	/* ------------------- total ------------------- */
	@Override
	public int total() {
		int tot = 0;
		/* System.out.println("NoticeDaoImpl Start total..."); */
		logger.info("NoticeDaoImpl Start total...");
		
		try {					//mapper ID
			tot = session.selectOne("cbNoticeTotal");
			/* System.out.println("NoticeDaoImpl total tot =>"+ tot); */
			logger.info("NoticeDaoImpl total tot =>" + tot);
		}catch (Exception e) {
			/* System.out.println("NoticeDaoImpl total Exception : " + e.getMessage()); */
			logger.info("NoticeDaoImpl total Exception : " + e.getMessage());
		}
		return tot;
	}
	
	/* ------------------- paging ------------------- */
	@Override
	public List<NoticeDto> listNotice(NoticeDto noticeDto) {
		List<NoticeDto>	noticeList = null;
		/* System.out.println("NoticeDaoImpl noticeList Start...."); */
		logger.info("NoticeDaoImpl noticeList Start....");
		try {
			// Naming Rule                  Map Id       parameter
			noticeList = session.selectList("cbNoticeList", noticeDto);
			/* System.out.println("NoticeDaoImpl noticeList =>>" + noticeList); */
			logger.info("NoticeDaoImpl noticeList =>>" + noticeList);
		}catch (Exception e) {
			/* System.out.println("NoticeDaoImpl listNotice Exception :" + e.getMessage()); */
			logger.info("NoticeDaoImpl listNotice Exception :" + e.getMessage());
		}
		
		return noticeList;
	}
	
	/* ------------------- 상세보기 ------------------- */
	@Override
	public NoticeDto noticeDetail(int n_no) {
		
		logger.info("NoticeDaoImpl noticeDetail Start..");
		NoticeDto noticeDto = new NoticeDto();
		
		try {
			noticeDto = session.selectOne("cbNoticeDetail", n_no);
			logger.info("NoticeDaoImpl noticeDetail noticeDto.getN_no() =>>>" + noticeDto.getN_no());
			
		}catch (Exception e) {
			
			logger.info("NoticeDaoImpl noticeDetail Exception =>>>>" + e.getMessage());
		}
		
		return noticeDto;
	}
	/* ------------------- 수정 ------------------- */
	@Override
	public NoticeDto noticeContent(int n_no) {
		logger.info("NoticeDaoImpl noticeContent Start..");
		NoticeDto noticeDto = new NoticeDto();
		
		try {
			noticeDto = session.selectOne("cbNoticeContent", n_no);
			logger.info("NoticeDaoImpl noticeContent + noticeDto.getN_no() =>" + noticeDto.getN_no());
			
		}catch (Exception e) {
			logger.info("NoticeDaoImpl noticeContent Exception =>>>" + e.getMessage());
		}
		logger.info("NoticeDaoImpl noticeContent + noticeDto.getN_title() =>>>>>" + noticeDto.getN_title());
		
		return noticeDto;
	}
	/* ------------------- 수정-저장하기 ------------------- */
	@Override
	public int noticeUpdate(NoticeDto noticeDto) {
		logger.info("NoticeDaoImpl noticeUpdate Start..");
		int aaa = 0;
		try {
			aaa = session.update("cbNoticeUpdate", noticeDto);
			logger.info("NoticeDaoImpl noticeUpdate + aaa =>" + aaa);
		}catch (Exception e) {
			logger.info("NoticeDaoImpl noticeUpdate Exception =>>>" + e.getMessage());
		}
		
		return aaa;
	}
	
	
	
	
	
	
	
	
	

}
