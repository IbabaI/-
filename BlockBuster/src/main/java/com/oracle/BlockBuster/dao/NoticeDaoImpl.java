package com.oracle.BlockBuster.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.BlockBuster.model.NoticeCommentDto;
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
		logger.info("NoticeDaoImpl total 토탈시작");
		
		try {					//mapper ID
			tot = session.selectOne("cbNoticeTotal");
			/* System.out.println("NoticeDaoImpl total tot =>"+ tot); */
			logger.info("NoticeDaoImpl total tot =>" + tot);
		}catch (Exception e) {
			/* System.out.println("NoticeDaoImpl total Exception : " + e.getMessage()); */
			logger.info("NoticeDaoImpl total Exception 발생 : " + e.getMessage());
		}
		return tot;
	}
	
	/* ------------------- paging ------------------- */
	@Override
	public List<NoticeDto> listNotice(NoticeDto noticeDto) {
		List<NoticeDto>	noticeList = null;
		/* System.out.println("NoticeDaoImpl noticeList Start...."); */
		logger.info("NoticeDaoImpl noticeList 리스트시작");
		try {
			// Naming Rule                  Map Id       parameter
			noticeList = session.selectList("cbNoticeList", noticeDto);
			/* System.out.println("NoticeDaoImpl noticeList =>>" + noticeList); */
			logger.info("NoticeDaoImpl noticeList =>>" + noticeList);
		}catch (Exception e) {
			/* System.out.println("NoticeDaoImpl listNotice Exception :" + e.getMessage()); */
			logger.info("NoticeDaoImpl listNotice Exception 발생 :" + e.getMessage());
		}
		
		return noticeList;
	}
	
	/* ------------------- 상세보기 ------------------- */
	@Override
	public NoticeDto noticeDetail(int n_no) {
		
		logger.info("NoticeDaoImpl noticeDetail 상세보기 시작");
		NoticeDto noticeDto = new NoticeDto();
		
		try {
			noticeDto = session.selectOne("cbNoticeDetail", n_no);
			logger.info("NoticeDaoImpl noticeDetail noticeDto.getN_no() =>>>" + noticeDto.getN_no());
			
		}catch (Exception e) {
			
			logger.info("NoticeDaoImpl noticeDetail Exception발생 =>>>>" + e.getMessage());
		}
		
		return noticeDto;
	}
	
	/* ------------------- 조회수 증가 ------------------- */
//	@Override
//	public void NoticeHit(int n_no) {
//		logger.info("NoticeDaoImpl NoticeHit 조회수 증가 시작");
//		
//		try {
//			session.update("cbNoticeHit", n_no);
//		}catch (Exception e) {
//			logger.info("NoticeDaoImpl NoticeHit Exception발생 =>>>>" + e.getMessage());
//		}
//		
//	}
	
	/* ------------------- 수정 ------------------- */
	@Override
	public NoticeDto noticeContent(int n_no) {
		logger.info("NoticeDaoImpl noticeContent 수정폼 시작");
		NoticeDto noticeDto = new NoticeDto();
		
		try {
			noticeDto = session.selectOne("cbNoticeContent", n_no);
			logger.info("NoticeDaoImpl noticeContent + noticeDto.getN_no() =>" + noticeDto.getN_no());
			
		}catch (Exception e) {
			logger.info("NoticeDaoImpl noticeContent Exception 발생 =>>>" + e.getMessage());
		}
		logger.info("NoticeDaoImpl noticeContent + noticeDto.getN_title() =>>>>>" + noticeDto.getN_title());
		
		return noticeDto;
	}
	/* ------------------- 수정-저장하기 ------------------- */
	@Override
	public int noticeUpdate(NoticeDto noticeDto) {
		logger.info("NoticeDaoImpl noticeUpdate 수정완료하기 시작");
		int aaa = 0;
		try {
			aaa = session.update("cbNoticeUpdate", noticeDto);
			logger.info("NoticeDaoImpl noticeUpdate + aaa =>" + aaa);
		}catch (Exception e) {
			logger.info("NoticeDaoImpl noticeUpdate Exception 발생 =>>>" + e.getMessage());
		}
		logger.info("NoticeDaoImpl noticeUpdate + aaa =>>>>>" + aaa);
		return aaa;
	}
	
	/* ------------------- 쓰기 - 저장하기 ------------------- */
	@Override
	public int insert(NoticeDto noticeDto) {
		int result = 0;
		logger.info("NoticeDaoImpl insert 쓰기 저장하기 시작");
		
		try {
			result = session.insert("cbNoticeWrite", noticeDto);
		} catch (Exception e) {
			logger.info("NoticeDaoImpl insert Exception 발생 =>>>" + e.getMessage());
		}
		
		return result;
	}
	
	/* ------------------- 삭제 ------------------- */
	@Override
	public int noticeDelete(int n_no) {
		logger.info("NoticeDaoImpl noticeDelete 삭제시작 ");
		int result = 0;
		
		try {
			result = session.delete("cbNoticeDelete",n_no);
		}catch (Exception e) {
			logger.info("NoticeDaoImpl noticeDelete Exception 발생 =>>>" + e.getMessage());
		}
		return result;
	}

	
	/* ------------------- 댓글문의 ------------------- */
	@Override
	public int noticeComment(NoticeCommentDto noticeCommentDto) {
		logger.info("NoticeDaoImpl noticeComment 댓글문의 시작========");
		
		int commentResult = 0;
		
		try {
			commentResult = session.insert("cbNoticeComment", noticeCommentDto);
		} catch (Exception e) {
			logger.info("NoticeDaoImpl noticeComment Exception 발생 =>>>" + e.getMessage());
		}
		
		return commentResult;
	}

	

	
	
	
	
	
	
	
	
	
	
	

}
