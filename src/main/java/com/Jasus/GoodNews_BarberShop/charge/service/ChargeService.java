package com.Jasus.GoodNews_BarberShop.charge.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jasus.GoodNews_BarberShop.charge.model.ChargeDAO;
import com.Jasus.GoodNews_BarberShop.charge.model.ChargeVO;
import com.Jasus.GoodNews_BarberShop.purchase.model.PurchaseDAO;
import com.Jasus.GoodNews_BarberShop.purchase.model.PurchaseVO;

import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Service

public class ChargeService {

	@Autowired
	ChargeDAO dao;
	
	public int c_charge(ChargeVO vo) {
		return dao.c_charge(vo);		
	}

	public int c2_charge(ChargeVO vo) {
		return dao.c2_charge(vo);		
	}

}
