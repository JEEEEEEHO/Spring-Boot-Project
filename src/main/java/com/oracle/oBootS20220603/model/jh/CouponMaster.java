package com.oracle.oBootS20220603.model.jh;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CouponMaster {
	private int coupno;
	private String coup_name;
	private int coup_type;
	private int coup_dc_rate;
	private int coup_dc_price;
	private int coup_req_price;
	private int coup_expdate;
	
	// 조회용
	private int payno;
	private int org_amount;

}
