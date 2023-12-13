package com.Jasus.GoodNews_BarberShop.purchase.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jasus.GoodNews_BarberShop.purchase.model.PurchaseDAO;
import com.Jasus.GoodNews_BarberShop.purchase.model.PurchaseVO;

import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Service

public class PurchaseService {

	@Autowired
	PurchaseDAO dao;
	
	public int p_purchase(PurchaseVO vo) {
		return dao.p_purchase(vo);		
	}

	public int p2_purchase(PurchaseVO vo) {
		return dao.p2_purchase(vo);		
	}

}
