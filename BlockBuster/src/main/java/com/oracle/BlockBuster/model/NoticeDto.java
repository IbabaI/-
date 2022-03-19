package com.oracle.BlockBuster.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class NoticeDto {

	private int n_no;
	private String id;
	private String n_title;
	private String n_content;
	private Timestamp n_date;
	private String n_img;
	private int n_hit;
	
	
	//조회용
	private String nickName;
	private int start;
	private int end;
	private int commentCnt;
	private int totalGood;
	private int good;
}
