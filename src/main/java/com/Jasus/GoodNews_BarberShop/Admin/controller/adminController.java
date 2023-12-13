package com.Jasus.GoodNews_BarberShop.Admin.controller;

import java.text.DateFormat; 

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Jasus.GoodNews_BarberShop.Admin.model.adminVO;
import com.Jasus.GoodNews_BarberShop.Admin.service.adminService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class adminController {
	
	private static final Logger logger = LoggerFactory.getLogger(adminController.class);
	
	//DI-Dependency Injection : IoC(Inversion of Controller)
	@Autowired
	adminService service;
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		logger.info("/login.do");
		
		return "admin/login";
	}//end login
	
	@RequestMapping(value = "/loginOK.do", method = RequestMethod.POST)
	public String loginOK(adminVO vo) {
		logger.info("/loginOK.do...{}",vo);
		
		adminVO vo2 = service.login(vo);
		
		if(vo2 == null) {
			return "redirect:login.do";
		}else {
			session.setAttribute("id", vo2.getId());
			return "redirect:home.do";
		}
		
	}//end loginOK
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout() {
		logger.info("/logout.do");
		
		session.invalidate();
		
		return "redirect:home.do";
	}//end logout
	
}//end class
