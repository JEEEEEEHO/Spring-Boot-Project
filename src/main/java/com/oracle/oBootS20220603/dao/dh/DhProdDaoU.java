package com.oracle.oBootS20220603.dao.dh;

import java.util.List;

import com.oracle.oBootS20220603.model.Product;
import com.oracle.oBootS20220603.model.Wishlist;
import com.oracle.oBootS20220603.model.Basket;
import com.oracle.oBootS20220603.model.Member;

public interface DhProdDaoU {
	int total();
	
	int cateTotal(String cg);
	
	String category(String cg);

	List<Product> listProd();

	List<Product> listCateProd(String cg);

	Product       prodDetail(Product product);
	int           sh_insert(Basket basket);
	List<Product> listcart(Product product);
	int           cartDelete(Product product);
	int           prodDetailCount(Product product3); //상단 장바구니 조회 -접근권한

//	int           prodDetailCount(Product product2); //장바구니 값 넣기 -접근권한


	// 위시리스트용 
	int wishCount(Wishlist wishlist);
	int emptyToFill(Wishlist wishlist);
	int fillToEmpty(Wishlist wishlist);
	List<Product> wishList(String id);


}
