package com.oracle.oBootS20220603.service.hk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.oBootS20220603.dao.hk.HKBasketDao;
import com.oracle.oBootS20220603.model.Basket;

@Service
public class HKBasketServiceImpl implements HKBasketService{
	
	@Autowired
	private HKBasketDao bd;

	@Override
	public List<Basket> selectAll(String id) {
		System.out.println("HKBasketServiceImpl selectAll Start...");
		List<Basket> b_list = bd.selectAll(id);
		
		return b_list;
	}
	
}
