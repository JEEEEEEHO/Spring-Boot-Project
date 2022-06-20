package com.oracle.oBootS20220603.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Coupon {
	
	private int coupno;
	private String id;
	private Date coup_start;
	private Date coup_end;
	private int coup_status;
	
	// 조회용
	private String coup_name;
	private int coup_type;
	private int coup_dc_rate;
	private int coup_dc_price;
	private int coup_req_price;
	
}
