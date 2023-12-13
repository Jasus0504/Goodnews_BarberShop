package com.Jasus.GoodNews_BarberShop.Admin.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class adminDAOimpl implements adminDAO{
	
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public adminVO selectRole(adminVO vo) {
		log.info("selectRole...{}",vo);
		return sqlSession.selectOne("SELECT_ROLE", vo);
	}

	@Override
	public adminVO login(adminVO vo) {
		log.info("login...{}",vo);
		return sqlSession.selectOne("LOGIN",vo);
	}

}
