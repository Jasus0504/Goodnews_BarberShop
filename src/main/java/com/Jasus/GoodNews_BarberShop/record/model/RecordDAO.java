package com.Jasus.GoodNews_BarberShop.record.model;

import java.util.List;

import com.Jasus.GoodNews_BarberShop.purchase.model.PurchaseVO;

public interface RecordDAO {
	
	List<RecordVO> r_selectAll();

	List<RecordVO> r_selectOne(RecordVO vo);

	List<RecordVO> r_searchList(String searchKey, String searchWord);

	int r_delete(RecordVO vo);	



}
