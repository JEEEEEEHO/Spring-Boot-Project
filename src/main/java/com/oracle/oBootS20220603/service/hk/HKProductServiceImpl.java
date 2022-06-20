package com.oracle.oBootS20220603.service.hk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.oBootS20220603.dao.hk.HKProductDao;
import com.oracle.oBootS20220603.model.Basket;
import com.oracle.oBootS20220603.model.Product;

@Service
public class HKProductServiceImpl implements HKProductService {
	
	@Autowired
	private HKProductDao pd;

	@Override
	public List<Product> selectBestProduct() {
		System.out.println("HKProductServiceImpl selectBestProduct Start...");
		List<Product> p_list = pd.selectBestProduct();
		
		return p_list;
	}

	@Override
	public Product selectOne(int prodno) {
		System.out.println("HKProductServiceImpl selectOne Start...");
		Product product = pd.selectOne(prodno);
		return product;
	}

	@Override
	public List<Product> selectBasketProduct(List<Basket> basket_list) {
		System.out.println("HKProductServiceImpl selectBasketProduct Start...");
		List<Product> p_list = pd.selectBasketProduct(basket_list);
		
		return p_list;
	}

	
}
