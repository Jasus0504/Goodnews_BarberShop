package com.Jasus.GoodNews_BarberShop.charge.model;

import lombok.Data;

@Data
public class ChargeVO {
	
	
	private int cost;
	private int remain;
	private String m_num;
	private String m_name;
	private int m_cash;
	private String m_date;
	private String m_info;
	private String r_type;
	
}
