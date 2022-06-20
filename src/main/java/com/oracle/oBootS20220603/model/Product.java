package com.oracle.oBootS20220603.model;

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
	private String prod_info;
	
	
	// 조회용
	private int dc_rate;
	private int sale_price;
	// 상품 view 바로구매 수량
	private int quantity;
	// 장바구니 구매 수량
	private int bas_qty;
	
	private String memberId; // 임시 회원 아이디 가져오기
	
	private String search3; // 검색어 (상품명, 상품번호) select 
	private String keyword3; // option 
	
	
	
	////// 다희 것 
	// cursor in put 조회용 
	private String id;
	
	// cursor out put 조회용 
	private int oprodno;
	private String oid;
	private int obas_qty;
	private  String oth_img;
	private String oprod_name;
	
	private int start;
	private int end;
	
	private String keyword1;
	private String keyword2;
	private String search;
	
	
}
