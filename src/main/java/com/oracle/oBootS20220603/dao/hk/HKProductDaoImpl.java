package com.oracle.oBootS20220603.dao.hk;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.oBootS20220603.model.Basket;
import com.oracle.oBootS20220603.model.Product;

@Repository
public class HKProductDaoImpl implements HKProductDao {

	@Autowired
	private SqlSession session;
	
	public List<Product> selectBestProduct() {
		System.out.println("HKProductDaoImpl selectBestProduct Start...");
		List<Product> p_list = null;
		
		try {
			p_list = session.selectList("HKSelectBestProduct");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return p_list;
	}

	@Override
	public Product selectOne(int prodno) {
		System.out.println("HKProductDaoImpl selectOne Start...");
		Product product = null;
		
		try {
			product = session.selectOne("HKSelectOne", prodno);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return product;
	}

	@Override
	public List<Product> selectBasketProduct(List<Basket> basket_list) {
		System.out.println("HKProductDaoImpl selectBasketProduct Start...");
		List<Product> p_list = null;
		
		try {
			p_list = session.selectList("HKSelectBasketProduct", basket_list);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return p_list;
	}

	
}
