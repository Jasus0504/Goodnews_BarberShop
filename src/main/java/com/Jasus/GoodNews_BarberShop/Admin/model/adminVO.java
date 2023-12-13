package com.Jasus.GoodNews_BarberShop.Admin.model;



import com.Jasus.GoodNews_BarberShop.Intercepter.Role;

import lombok.Data;

@Data
public class adminVO {

	private String id;
	private String pw;
	private String role;
	private Role secured_role;

	
}
