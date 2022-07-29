package com.ecommerce.user.admin.model;

import com.ecommerce.user.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Admin extends User {

	@Setter
	private Long id;
	
	public Admin(String firstName, 
				 String lastName, 
				 Integer age, 
				 Character gender, 
				 String cellphone, 
				 String tel, 
				 String email, 
				 String street, 
				 String city, 
				 String zip, 
				 String password, 
				 User.Level level, 
				 boolean active, 
				 boolean edit) {
		super(firstName, lastName, age, gender, cellphone, tel, email, street, city, zip, password, level, active, edit);
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
	public String getCity() {
		return super.getCity();
	}

	@Override
	public String getEmail() {
		return super.getEmail();
	}

	@Override
	public String getFirstName() {
		return super.getFirstName();
	}

	@Override
	public Character getGender() {
		return super.getGender();
	}

	@Override
	public String getLastName() {
		return super.getLastName();
	}

	@Override
	public User.Level getLevel() {
		return super.getLevel();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getStreet() {
		return super.getStreet();
	}

	@Override
	public String getTel() {
		return super.getTel();
	}

	@Override
	public String getZip() {
		return super.getZip();
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
