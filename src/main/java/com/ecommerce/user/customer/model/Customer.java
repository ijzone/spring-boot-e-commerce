package com.ecommerce.user.customer.model;

import java.time.ZonedDateTime;

import com.ecommerce.user.model.User;

import lombok.Getter;

@Getter
public class Customer extends User {

	public Customer(String firstName, 
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
					boolean edit,
					ZonedDateTime regDate,
					ZonedDateTime modDate) {
		super(firstName, lastName, age, gender, cellphone, tel, email, street, city, zip, password, level, active, edit, regDate, modDate);
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

	@Override
	public String toString() {
		return "Customer [getAge()=" + getAge() + ", getCellphone()=" + getCellphone() + ", getCity()=" + getCity()
				+ ", getEmail()=" + getEmail() + ", getFirstName()=" + getFirstName() + ", getGender()=" + getGender()
				+ ", getLastName()=" + getLastName() + ", getLevel()=" + getLevel() + ", getPassword()=" + getPassword()
				+ ", getStreet()=" + getStreet() + ", getTel()=" + getTel() + ", getZip()=" + getZip() + ", isActive()="
				+ isActive() + ", isEdit()=" + isEdit() + "]";
	}
	
}
