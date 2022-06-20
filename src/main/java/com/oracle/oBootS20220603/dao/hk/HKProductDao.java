package com.oracle.oBootS20220603.dao.hk;

import java.util.List;

import com.oracle.oBootS20220603.model.Basket;
import com.oracle.oBootS20220603.model.Product;

public interface HKProductDao {

	List<Product> selectBestProduct();

	Product selectOne(int prodno);

	List<Product> selectBasketProduct(List<Basket> basket_list);

	
}
