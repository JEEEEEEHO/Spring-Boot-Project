package com.oracle.oBootS20220603.service.hk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.oBootS20220603.dao.hk.HKCouponDao;
import com.oracle.oBootS20220603.model.Coupon;

@Service
public class HKCouponServiceImpl implements HKCouponService {
	
	@Autowired
	private HKCouponDao cd;

	@Override
	public List<Coupon> selectAll(String id) {
		System.out.println("HKCouponServiceImpl selectAll Start...");
		List<Coupon> coup_list = cd.selectAll(id);
		
		return coup_list;
	}

}
