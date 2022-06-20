package com.oracle.oBootS20220603.dao.hk;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.oBootS20220603.model.Member;

@Repository
public class HKMemberDaoImpl implements HKMemberDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public Member selectOne(String id) {
		System.out.println("HKMemberDaoImpl selectOne Start...");
		Member member = null;
		
		try {
			member = session.selectOne("HKMemberSelectOne", id);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return member;
	}

}
