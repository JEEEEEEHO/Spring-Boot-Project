package com.oracle.oBootS20220603.dao.hk;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.oBootS20220603.model.PaymentDetail;

@Repository
public class HKPaymentDetailDaoImpl implements HKPaymentDetailDao {
	
	@Autowired
	private SqlSession session;

	@Override
	public int insertPaymentDetail(PaymentDetail pd) {
		System.out.println("HKPaymentDetailDaoImpl insertPaymentDetail Start...");
		int result = 0;
		
		try {
			result = session.insert("HKInsertPaymentDetail", pd);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
}
