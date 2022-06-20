package com.oracle.oBootS20220603.model;

//유진작성
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Review {
	private int 	rvno;
	private int 	prodno;
	private String 	writer_id;
	private String 	rv_content;
	private Date 	rv_date;
	private int 	ref;
	private int 	re_step;
	private int 	re_level;
	private int 	re_stars;
	private String 	rv_img;
	

}
