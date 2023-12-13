package com.Jasus.GoodNews_BarberShop.record.controller;

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
import com.Jasus.GoodNews_BarberShop.record.model.RecordVO;
import com.Jasus.GoodNews_BarberShop.record.service.RecordService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class recordRestController {

	@Autowired
	HttpSession session;
	
	@Autowired
	RecordService service;
	
	@Autowired
	ServletContext sContext;
	
	@ResponseBody
	@RequestMapping (value="/json_r_selectAll.do", method = RequestMethod.GET)
	public List<RecordVO> json_r_selectAll() {
		
		List<RecordVO> vos = service.r_selectAll();
		
		
		return vos; 
	}		
	
	@ResponseBody
	@RequestMapping (value="/json_r_selectOne.do", method = RequestMethod.GET)
	public List<RecordVO>json_r_selectOne(RecordVO vo) {
		
		List<RecordVO>  vos = service.m_selectOne(vo);
		
		
		return vos; 
	}
	
	@ResponseBody
	@RequestMapping(value = "/json_r_searchList.do", method = RequestMethod.GET)
	public List<RecordVO> r_searchList(Model model,
		String searchKey, String searchWord) {
		log.info("/r_searchList.do");
		log.info("searchKey:{}",searchKey);
		log.info("searchWord:{}",searchWord);
		
		List<RecordVO> vos = service.r_searchList(searchKey,searchWord);
		
		
		return vos;
	}
	
	
	
}
