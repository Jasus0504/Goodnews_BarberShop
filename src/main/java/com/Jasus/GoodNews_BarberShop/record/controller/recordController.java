package com.Jasus.GoodNews_BarberShop.record.controller;

import javax.servlet.ServletContext;   
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Jasus.GoodNews_BarberShop.Intercepter.MySecured;
import com.Jasus.GoodNews_BarberShop.Intercepter.Role;
import com.Jasus.GoodNews_BarberShop.member.model.MemberVO;
import com.Jasus.GoodNews_BarberShop.member.service.MemberService;
import com.Jasus.GoodNews_BarberShop.record.model.RecordVO;
import com.Jasus.GoodNews_BarberShop.record.service.RecordService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class recordController {

	@Autowired
	HttpSession session;
	
	@Autowired
	RecordService service;
	
	@Autowired
	ServletContext sContext;
	
	@MySecured(secured_role = Role.ADMIN)
	@RequestMapping (value="/r_selectAll.do", method = RequestMethod.GET)
	public String r_selectAll() {
		
		
		return "record/r_selectAll"; 
	}
	
	@RequestMapping (value="/r_selectOne.do", method = RequestMethod.GET)
	public String r_selectOne(RecordVO vo) {
		
		
		log.info("/r_selectOne.do...{}",vo);	
		
		return "record/r_selectOne"; 
	}
	
	@RequestMapping(value = "/r_searchList.do", method = RequestMethod.GET)
	public String r_searchList( ) {
			
		
		return "record/r_searchList";
	}
	
	@RequestMapping (value="/r_deleteOK.do", method = RequestMethod.GET)
	public String r_deleteOK(RecordVO vo) {
		
		service.r_delete(vo);	
		
		return "home"; 
	}



	
	
}
