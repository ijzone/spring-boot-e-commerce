package com.ecommerce.user.model;

import com.ecommerce.user.UserLevel;

import lombok.Getter;

@Getter
public class User {

	private String name;
	private Integer age;
	private Character gender;
	private String cellphone;
	private String tel;
	private String email;
	private String password;
	private UserLevel level;
	
	private boolean active;
	private boolean edit;

	
	public User(String name, Integer age, Character gender, String cellphone, String tel, String email, String password,
			UserLevel level, boolean active, boolean edit) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.cellphone = cellphone;
		this.tel = tel;
		this.email = email;
		this.password = password;
		this.level = level;
		this.active = active;
		this.edit = edit;
	}
	
	protected void setActiveTrue() {
		this.active = true;
	}
	
	protected void setActiveFalse() {
		this.active = false;
	}
	
	protected void setEditTrue() {
		this.edit = true;
	}
	
	protected void setEditFalse() {
		this.edit = false;
	}

}
