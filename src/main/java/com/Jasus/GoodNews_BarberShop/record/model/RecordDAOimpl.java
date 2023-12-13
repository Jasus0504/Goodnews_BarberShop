package com.Jasus.GoodNews_BarberShop.record.model;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class RecordDAOimpl implements RecordDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List<RecordVO> r_selectAll() {
		log.info("RecordDAOimpl()...{}");
		return sqlSession.selectList("R_SELECTALL");
	}

	@Override
	public List<RecordVO> r_selectOne(RecordVO vo) {
		log.info("RecordDAOimpl()...{}",vo);
		return sqlSession.selectList("R_SELECTONE",vo);
	}

	@Override
	public List<RecordVO> r_searchList(String searchKey, String searchWord) {
		log.info("RecordDAOimpl()...{}");
		String newsearchWord = "%" + searchWord + "%";
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("searchKey", searchKey);
			parameters.put("searchWord", newsearchWord);
			log.info("Checking_parameters....{}", parameters);
			return sqlSession.selectList("R_SEARCH", parameters);
	
	}

	@Override
	public int r_delete(RecordVO vo) {
	    log.info("RecordDAOimpl()...{}", vo);	   
	    	sqlSession.update("R_REPLACE",vo);
	    	return sqlSession.delete("R_DELETE",vo);
	    }
	}


