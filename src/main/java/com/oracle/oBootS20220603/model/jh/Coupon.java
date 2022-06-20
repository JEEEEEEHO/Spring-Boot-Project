package com.oracle.oBootS20220603.model.jh;

import java.sql.Date;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coupon {
	private int coupno;
	private String id;
	private Date coup_start;
	private Date coup_end;
	private int coup_status;

}
