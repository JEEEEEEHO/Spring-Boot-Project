package com.oracle.oBootS20220603.service.hk;

import java.util.List;

import com.oracle.oBootS20220603.model.Basket;

public interface HKBasketService {

	List<Basket> selectAll(String id);

}
