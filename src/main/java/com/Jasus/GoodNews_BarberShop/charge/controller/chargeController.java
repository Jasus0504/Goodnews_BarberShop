package com.Jasus.GoodNews_BarberShop.charge.controller;

import javax.servlet.ServletContext;     
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Jasus.GoodNews_BarberShop.charge.model.ChargeVO;
import com.Jasus.GoodNews_BarberShop.charge.service.ChargeService;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class chargeController {

	@Autowired
	HttpSession session;
	
	@Autowired
	ChargeService service;
	
	@Autowired
	ServletContext sContext;
	
	@RequestMapping (value="/c_charge.do", method = RequestMethod.GET)
	public String c_charge(ChargeVO vo) {
		
		log.info("/c_charge.do...{}");		
		
		return "charge/c_charge"; 
	}
	
	@RequestMapping (value="/c_chargeOK.do", method = RequestMethod.POST)
	public String c_chargeOK(ChargeVO vo) {
		
		log.info("/c_chargeOK.do...{}",vo);		
		
		service.c_charge(vo);	
		service.c2_charge(vo);	
		
		return "home"; 
	}
	
	
	
	
}
