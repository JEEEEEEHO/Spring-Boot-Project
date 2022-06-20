package com.oracle.oBootS20220603.model.jh;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
	private int prodno;
	private int category;
	private String brand_name;
	private String prod_name;
	private int prod_price;
	private int stock;
	private int sale_qty;
	private Date prod_reg;
	private int prod_poststs;
	private int prod_salests;
	private String th_img;
	private String main_img1;
	private String main_img2;
	private String main_img3;
	private String main_img4;
	private String prod_info;
	
	// 조회용
	private String search3; // 검색어 (상품명, 상품번호) select 
	private String keyword3; // option 
	
}
