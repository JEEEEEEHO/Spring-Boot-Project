package com.oracle.oBootS20220603.dao.hk;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.oBootS20220603.model.Basket;

@Repository
public class HKBasketDaoImpl implements HKBasketDao {
	
	@Autowired
	private SqlSession session;

	@Override
	public List<Basket> selectAll(String id) {
		System.out.println("HKBasketDaoImpl selectAll Start...");
		List<Basket> b_list = null;
		
		try {
			b_list = session.selectList("HKBasketSelectAll", id);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return b_list;
	}
	
}
