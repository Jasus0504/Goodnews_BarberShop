package com.Jasus.GoodNews_BarberShop.Admin.service;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jasus.GoodNews_BarberShop.Admin.model.adminDAO;
import com.Jasus.GoodNews_BarberShop.Admin.model.adminVO;
import com.Jasus.GoodNews_BarberShop.charge.model.ChargeDAO;
import com.Jasus.GoodNews_BarberShop.charge.model.ChargeVO;
import com.Jasus.GoodNews_BarberShop.purchase.model.PurchaseDAO;
import com.Jasus.GoodNews_BarberShop.purchase.model.PurchaseVO;

import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Service
public class adminService {
	
	@Autowired
	adminDAO dao;
	
	public adminVO selectRole(adminVO vo) {
		return dao.selectRole(vo);
	}

	public adminVO login(adminVO vo) {
		return dao.login(vo);
	}



}
