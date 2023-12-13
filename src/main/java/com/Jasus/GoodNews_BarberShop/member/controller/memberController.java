package com.Jasus.GoodNews_BarberShop.member.controller;

import javax.servlet.ServletContext;     
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Jasus.GoodNews_BarberShop.Intercepter.MySecured;
import com.Jasus.GoodNews_BarberShop.Intercepter.Role;
import com.Jasus.GoodNews_BarberShop.member.model.MemberVO;
import com.Jasus.GoodNews_BarberShop.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class memberController {

	private static final Logger logger = LoggerFactory.getLogger(memberController.class);
	
	@Autowired
	HttpSession session;
	
	@Autowired
	MemberService service;
	
	@Autowired
	ServletContext sContext;
	
	@MySecured(secured_role = Role.ADMIN)
	@RequestMapping (value="/m_insert.do", method = RequestMethod.GET)
	public String m_insert() {
		
		
		return "member/m_insert"; 
	}
	
	@RequestMapping (value="/m_insertOK.do", method = RequestMethod.POST)
	public String m_insertOK(MemberVO vo) {
		
		service.m_insert(vo);	
		
		return "home"; 
	}
	
	@RequestMapping (value="/m_deleteOK.do", method = RequestMethod.GET)
	public String m_deleteOK(MemberVO vo) {
		
		service.m_delete(vo);	
		
		return "home"; 
	}
	
	@MySecured(secured_role = Role.ADMIN)
	@RequestMapping (value="/m_selectAll.do", method = RequestMethod.GET)
	public String m_selectAll() {
		
		
		return "member/m_selectAll"; 
	}
	
	@RequestMapping(value = "/m_selectOne.do", method = RequestMethod.GET)
	public String m_selectOne(MemberVO vo) {
		
		log.info("/m_selectOne.do...{}",vo);		
		
		return "member/m_selectOne";
	}
	
	
	@RequestMapping(value = "/m_searchList.do", method = RequestMethod.GET)
	public String m_searchList( ) {
			
		
		return "member/m_searchList";
	}
	
	@RequestMapping(value = "/m_update.do", method = RequestMethod.GET)
	public String m_update(MemberVO vo,Model model) {
		logger.info("/m_update.do...vo:{}",vo);
		
		MemberVO vo2 = service.m_selectOne(vo);
		logger.info(vo2.toString());
		
		model.addAttribute("vo2", vo2);
		
		return "member/m_update";
	}//end m_update



	
	
}
