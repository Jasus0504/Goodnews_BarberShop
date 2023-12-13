package com.Jasus.GoodNews_BarberShop.purchase.model;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PurchaseDAOimpl implements PurchaseDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public int p_purchase(PurchaseVO vo) {
		log.info("PurchaseDAOimpl()...{}",vo);
		return sqlSession.insert("P_PURCHASE",vo);
	}

	@Override
	public int p2_purchase(PurchaseVO vo) {
		log.info("PurchaseDAOimpl()...{}",vo);
		return sqlSession.update("P2_PURCHASE",vo);
	}


}
