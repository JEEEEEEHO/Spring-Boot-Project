package com.oracle.oBootS20220603.service.dh;

import java.util.List;

import com.oracle.oBootS20220603.model.Product;

public interface DhProdServiceA {

	int            totalC();   // 전체 상품 수 
	int            totalS();   // 판매중인 상품 개수
	int            totalSO();  // 품절된 상품개수
	int            totalST();  // 판매중지 상품개수
	int            total();    // 상품 총 개수(페이징)_지아 
	List<Product>  listProd(Product product);  // 상품리스트_지아
	List<Product>  listProduct(Product product); // keyword 조회 _상품명, 상품번호
	int            keywordtotal(Product product);
	Product        prodDetail(int prodno);  // 상품 뷰 이동
	int            delete(int prodno);      // 상품 삭제
//	int            prodUpdate(Product product);  // 상품 수정
	int           adminProdDelAJAX(Product product);  // 관리자 상품리스트에서 상품삭제

	
	
}
