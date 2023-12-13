package com.Jasus.GoodNews_BarberShop.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jasus.GoodNews_BarberShop.member.model.MemberDAO;
import com.Jasus.GoodNews_BarberShop.member.model.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class MemberService {

	@Autowired
	MemberDAO dao;
	
	public int m_insert(MemberVO vo) {
		return dao.m_insert(vo);
	}

	public List<MemberVO> m_selectAll() {
		return dao.m_selectAll();
	}

	public MemberVO m_selectOne(MemberVO vo) {
		return dao.m_selectOne(vo);
	}

	public List<MemberVO> m_searchList(String searchKey, String searchWord) {
		log.info("MemberService()_searchList...{},{}",searchKey,searchWord);
		return dao.m_searchList(searchKey,searchWord);
	}

	public int m_delete(MemberVO vo) {
		return dao.m_delete(vo);
	}
}
