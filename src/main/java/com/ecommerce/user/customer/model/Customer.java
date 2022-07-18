package com.ecommerce.user.customer.model;

import com.ecommerce.user.UserLevel;
import com.ecommerce.user.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Customer extends User {

	@Setter
	private Long id;
	private String cellphone;
	private String tel;
	private String email;
	private String password;
	private UserLevel level;
	private boolean edit;
	
	public Customer(String name
				  , Integer age
				  , Character gender
				  , boolean active
				  , String cellphone
				  , String tel
				  , String email
				  , String password
				  , UserLevel level) {
		
		super(name, age, gender, active);
		this.cellphone = cellphone;
		this.tel = tel;
		this.email = email;
		this.password = password;
		this.level = level;
		this.edit = false;
	}

	public void setEditTrue() {
		this.edit = true;
	}
	
	public void setEditFalse() {
		this.edit = false;
	}
	
	@Override
	public String toString() {
		return "Customer [cellphone=" + cellphone + ", tel=" + tel + ", email=" + email + ", password=" + password
				+ ", level=" + level + "]";
	}

	@Override
	public Integer getAge() {
		return super.getAge();
	}

	@Override
	public Character getGender() {
		return super.getGender();
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public boolean isActive() {
		return super.isActive();
	}

}