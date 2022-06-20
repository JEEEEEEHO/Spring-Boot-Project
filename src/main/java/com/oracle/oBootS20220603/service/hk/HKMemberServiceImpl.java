package com.oracle.oBootS20220603.service.hk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.oBootS20220603.dao.hk.HKMemberDao;
import com.oracle.oBootS20220603.model.Member;

@Service
public class HKMemberServiceImpl implements HKMemberService {
	
	@Autowired
	private HKMemberDao md;

	@Override
	public Member selectOne(String id) {
		System.out.println("HKMemberServiceImpl selectOne Start...");
		Member member = md.selectOne(id);
		
		return member;
	}
	
}
