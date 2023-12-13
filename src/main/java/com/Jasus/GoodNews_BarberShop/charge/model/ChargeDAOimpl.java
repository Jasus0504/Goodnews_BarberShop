package com.Jasus.GoodNews_BarberShop.charge.model;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ChargeDAOimpl implements ChargeDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public int c_charge(ChargeVO vo) {
		log.info("ChargeDAOimpl()...{}",vo);
		return sqlSession.insert("C_CHARGE",vo);
	}

	@Override
	public int c2_charge(ChargeVO vo) {
		log.info("ChargeDAOimpl()...{}",vo);
		return sqlSession.update("C2_CHARGE",vo);

	}
}
