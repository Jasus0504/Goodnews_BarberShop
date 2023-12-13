package com.Jasus.GoodNews_BarberShop.member.controller;

import java.util.List;  

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Jasus.GoodNews_BarberShop.member.model.MemberVO;
import com.Jasus.GoodNews_BarberShop.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class memberRestController {

	@Autowired
	HttpSession session;
	
	@Autowired
	MemberService service;
	
	@Autowired
	ServletContext sContext;
	
	@ResponseBody
	@RequestMapping (value="/json_m_selectAll.do", method = RequestMethod.GET)
	public List<MemberVO> json_m_selectAll() {
		
		List<MemberVO> vos = service.m_selectAll();
		
		
		return vos; 
	}		
	
	@ResponseBody
	@RequestMapping (value="/json_m_selectOne.do", method = RequestMethod.GET)
	public MemberVO json_m_selectOne(MemberVO vo) {
		
		MemberVO vo2 = service.m_selectOne(vo);
		
		
		return vo2; 
	}
	
	@ResponseBody
	@RequestMapping(value = "/json_m_searchList.do", method = RequestMethod.GET)
	public List<MemberVO> p_searchList(Model model,
		String searchKey, String searchWord) {
		log.info("/b_searchList.do");
		log.info("searchKey:{}",searchKey);
		log.info("searchWord:{}",searchWord);
		
		List<MemberVO> vos = service.m_searchList(searchKey,searchWord);
		
		
		return vos;
	}
	
	
	
}
