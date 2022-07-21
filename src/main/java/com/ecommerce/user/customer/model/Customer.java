package com.ecommerce.user.customer.model;

import com.ecommerce.user.UserLevel;
import com.ecommerce.user.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Customer extends User {

	@Setter
	private Long id;
	
	public Customer(String name
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

	@Override
	public Integer getAge() {
		return super.getAge();
	}

	@Override
	public String getCellphone() {
		return super.getCellphone();
	}

	@Override
	public String getEmail() {
		return super.getEmail();
	}

	@Override
	public Character getGender() {
		return super.getGender();
	}

	@Override
	public UserLevel getLevel() {
		return super.getLevel();
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getTel() {
		return super.getTel();
	}

	@Override
	public boolean isActive() {
		return super.isActive();
	}

	@Override
	public boolean isEdit() {
		return super.isEdit();
	}

	@Override
	public void setActiveTrue() {
		super.setActiveTrue();
	}

	@Override
	public void setActiveFalse() {
		super.setActiveFalse();
	}

	@Override
	public void setEditTrue() {
		super.setEditTrue();
	}

	@Override
	public void setEditFalse() {
		super.setEditFalse();
	}
	
}
