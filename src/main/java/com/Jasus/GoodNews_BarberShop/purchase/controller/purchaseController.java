package com.Jasus.GoodNews_BarberShop.purchase.controller;

import javax.servlet.ServletContext;     
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Jasus.GoodNews_BarberShop.purchase.model.PurchaseVO;
import com.Jasus.GoodNews_BarberShop.purchase.service.PurchaseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class purchaseController {

	@Autowired
	HttpSession session;
	
	@Autowired
	PurchaseService service;
	
	@Autowired
	ServletContext sContext;
	
	@RequestMapping (value="/p_purchase.do", method = RequestMethod.GET)
	public String p_purchase(PurchaseVO vo) {
		
		log.info("/p_purcase.do...{}");		
		
		return "purchase/p_purchase"; 
	}
	
	@RequestMapping (value="/p_purchaseOK.do", method = RequestMethod.POST)
	public String p_purchaseOK(PurchaseVO vo) {
		
		log.info("/p_purcaseOK.do...{}",vo);		
		
		service.p_purchase(vo);	
		
		service.p2_purchase(vo);
		
		return "home"; 
	}
	
	
	
	
}
