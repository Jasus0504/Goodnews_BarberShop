package com.Jasus.GoodNews_BarberShop.member.model;

import java.util.List;

import com.Jasus.GoodNews_BarberShop.purchase.model.PurchaseVO;

public interface MemberDAO {
	
	List<MemberVO> m_selectAll();

	int m_insert(MemberVO vo);

	MemberVO m_selectOne(MemberVO vo);

	List<MemberVO> m_searchList(String searchKey, String searchWord);

	int m_delete(MemberVO vo);


}
