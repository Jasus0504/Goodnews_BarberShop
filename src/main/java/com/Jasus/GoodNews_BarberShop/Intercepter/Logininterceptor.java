package com.Jasus.GoodNews_BarberShop.Intercepter;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.Jasus.GoodNews_BarberShop.Admin.model.adminVO;
import com.Jasus.GoodNews_BarberShop.Admin.service.adminService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Logininterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	adminService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle...");
		
        // handler 종류 확인 => HandlerMethod 타입인지 체크
        // HandlerMethod가 아니면 그대로 진행
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
		
        // 형 변환 하기
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        
        // @MySequred 받아오기
        MySecured mySecured = handlerMethod.getMethodAnnotation(MySecured.class);
        
        // method에 @MySequred가 없는 경우, 즉 인증이 필요 없는 요청
        if (mySecured == null) {
            return true;
        }
        
        // @MySequred가 있는 경우이므로, 세션이 있는지 체크
        HttpSession session = request.getSession();
        if (session == null) {        	
            response.sendRedirect("login.do");
            return false;
        }
        
        // 세션이 존재하면 유효한 유저인지 확인
        adminVO vo = new adminVO();
        log.info("session:{}",(String)session.getAttribute("id"));
        vo.setId((String)session.getAttribute("id"));
        log.info("m_id:{}",vo.getId());

        // USER가 아님
        if (vo.getId() == null) {
        	response.sendRedirect("login.do");
        	return false;
        }
        // USER임 > DB에서 회원의 role값 가져오기 > adminVO secured_role에 회원 role값 저장
        adminVO vo2 = new adminVO();
        if(vo.getId() != null) {
        	vo2 = service.selectRole(vo);
        	vo2.setSecured_role(Role.fromString(vo2.getRole()));
        	log.info("{}",vo2);
        }
        
        // ADMIN일 경우 secured_role값으로 권한 확인
        String role = mySecured.secured_role().toString();
        if(role != null) {
        	// ADMIN == ADMIN > 중첩 if문 실행
        	// ADMIN != USER > if문 종료 > return true USER 접근 허가
            if ("ADMIN".equals(role)) {
                if (vo2.getSecured_role() != Role.ADMIN) {
                    response.sendRedirect("login.do");
                    return false;
                }
            }
        }
        
		// 접근 허가
		return true;
	} // end preHadnle
	
}