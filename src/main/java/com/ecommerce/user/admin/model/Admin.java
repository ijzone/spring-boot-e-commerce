package com.ecommerce.user.admin.model;

import com.ecommerce.user.UserLevel;
import com.ecommerce.user.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Admin extends User {

	@Setter
	private Long id;
	
	public Admin(String name
			   , Integer age
			   , Character gender
			   , String cellphone
			   , String tel
			   , String email
			   , String password
			   , UserLevel level
			   , boolean active
			   , boolean edit) {
		super(name, age, gender, cellphone, tel, email, password, level, active, edit);
	}
	
	
}
