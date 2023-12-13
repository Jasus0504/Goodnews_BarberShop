package com.Jasus.GoodNews_BarberShop.member.model;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberDAOimpl implements MemberDAO {

	@Autowired
	SqlSession sqlSession;
	@Override
	public int m_insert(MemberVO vo) {
		log.info("MeberDAOimpl()...{}",vo);
		return sqlSession.insert("M_INSERT",vo);
	}
	@Override
	public List<MemberVO> m_selectAll() {
		log.info("MeberDAOimpl()...{}");
		return sqlSession.selectList("M_SELECTALL");
	}
	@Override
	public MemberVO m_selectOne(MemberVO vo) {
		log.info("MeberDAOimpl()...{}",vo);
		return sqlSession.selectOne("M_SELECTONE",vo);
	}
	@Override
	public List<MemberVO> m_searchList(String searchKey, String searchWord) {
		log.info("MeberDAOimpl()...{}");
		String newsearchWord = "%" + searchWord + "%";
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("searchKey", searchKey);
			parameters.put("searchWord", newsearchWord);
			log.info("Checking_parameters....{}", parameters);
			return sqlSession.selectList("M_SEARCH", parameters);
	

	}
	@Override
	public int m_delete(MemberVO vo) {
		log.info("MeberDAOimpl()...{}",vo);
		return sqlSession.delete("M_DELETE",vo);
	}
}
