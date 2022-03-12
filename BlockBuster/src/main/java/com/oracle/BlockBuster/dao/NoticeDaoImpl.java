package com.oracle.BlockBuster.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
			System.out.println("NoticeDaoImpl total Exception: " + e.getMessage());
		}
		return tot;
	}

}
