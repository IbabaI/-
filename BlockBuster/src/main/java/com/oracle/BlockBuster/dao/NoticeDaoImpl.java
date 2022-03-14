package com.oracle.BlockBuster.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.BlockBuster.model.NoticeDto;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	
	/* ------------------- SQL session 연결 ------------------- */
	@Autowired
	private SqlSession session;
	
	/* ------------------- total ------------------- */
	@Override
	public int total() {
		int tot = 0;
		System.out.println("NoticeDaoImpl Start total...");
		
		try {					//mapper ID
			tot = session.selectOne("cbNoticeTotal");
			System.out.println("NoticeDaoImpl total tot =>"+ tot);
		}catch (Exception e) {
			System.out.println("NoticeDaoImpl total Exception : " + e.getMessage());
		}
		return tot;
	}
	
	/* ------------------- paging ------------------- */
	@Override
	public List<NoticeDto> listNotice(NoticeDto noticeDto) {
		List<NoticeDto>	noticeList = null;
		System.out.println("NoticeDaoImpl noticeList Start....");
		
		try {
			// Naming Rule                  Map Id       parameter
			noticeList = session.selectList("cbNoticeList", noticeDto);
			System.out.println("NoticeDaoImpl noticeList =>>" + noticeList);
		}catch (Exception e) {
			System.out.println("NoticeDaoImpl listNotice Exception :" + e.getMessage());
		}
		
		return noticeList;
	}
	
	/* ------------------- 상세보기 ------------------- */
	@Override
	public NoticeDto noticeDetail(int n_no) {
		System.out.println("NoticeDaoImpl noticeDetail Start..");
		NoticeDto noticeDto = new NoticeDto();
		
		try {
			noticeDto = session.selectOne("cbNoticeDetail", n_no);
			System.out.println("NoticeDaoImpl noticeDetail  =>>>" + noticeDto.getId());
		}catch (Exception e) {
			System.out.println("NoticeDaoImpl noticeDetail Exception =>>>>" +e.getMessage());
		}
		
		return noticeDto;
	}
	
	
	
	
	
	
	
	
	

}
