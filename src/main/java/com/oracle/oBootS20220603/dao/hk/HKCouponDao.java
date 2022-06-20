package com.oracle.oBootS20220603.dao.hk;

import java.util.List;

import com.oracle.oBootS20220603.model.Coupon;

public interface HKCouponDao {

	List<Coupon> selectAll(String id);

}
