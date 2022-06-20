package com.oracle.oBootS20220603.dao.hk;

import java.util.List;

import com.oracle.oBootS20220603.model.Basket;

public interface HKBasketDao {

	List<Basket> selectAll(String id);

}
