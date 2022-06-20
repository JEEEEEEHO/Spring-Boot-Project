package com.oracle.oBootS20220603.service.hk;

import java.util.List;

import com.oracle.oBootS20220603.model.Coupon;

public interface HKCouponService {

	List<Coupon> selectAll(String id);

}
