package com.Jasus.GoodNews_BarberShop.record.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jasus.GoodNews_BarberShop.member.model.MemberDAO;
import com.Jasus.GoodNews_BarberShop.member.model.MemberVO;
import com.Jasus.GoodNews_BarberShop.record.model.RecordDAO;
import com.Jasus.GoodNews_BarberShop.record.model.RecordVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class RecordService {

	@Autowired
	RecordDAO dao;
	

	public List<RecordVO> r_selectAll() {
		return dao.r_selectAll();
	}


	public List<RecordVO> m_selectOne(RecordVO vo) {
		return dao.r_selectOne(vo);
	}


	public List<RecordVO> r_searchList(String searchKey, String searchWord) {
		log.info("RecordService()_searchList...{},{}",searchKey,searchWord);
		return dao.r_searchList(searchKey,searchWord);
	}


	public int r_delete(RecordVO vo) {
		return dao.r_delete(vo);
		
	}

}
