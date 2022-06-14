package com.ecommerce.user.customer.domain;

import com.ecommerce.user.domain.Level;
import com.ecommerce.user.domain.User;

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
	private Level level;
	private boolean edit;
	
	public Customer(String name
				  , Integer age
				  , Character gender
				  , boolean active
				  , String cellphone
				  , String tel
				  , String email
				  , String password
				  , Level level) {
		
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

}
