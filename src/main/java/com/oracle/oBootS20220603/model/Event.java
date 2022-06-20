package com.oracle.oBootS20220603.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {
	
	private int evt_no;
	private String evt_name;
	private int dc_rate;
	private Date evt_start;
	private Date evt_end;
	private Date evt_regDate;
	private String evt_exp;
	private String evt_notice;
	private String evt_img;
	private int evt_sts;
	private int evt_type;
	
}
