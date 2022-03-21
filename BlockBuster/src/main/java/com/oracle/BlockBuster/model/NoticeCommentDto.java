package com.oracle.BlockBuster.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeCommentDto {
	
	private int n_no;
	private int nc_no;
	private String id;
	private String nc_content;
	private Timestamp nc_date;
	
	//조회용
	private String nickName;
	private int start;
	private int end;
}
