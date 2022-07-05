package com.ecommerce.user.model;

import lombok.Getter;

@Getter
public class User {

	private String name;
	private Integer age;
	private Character gender;
	private boolean active;

	public User(String name, Integer age, Character gender, boolean active) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", gender=" + gender + ", active=" + active + "]";
	}
	
}
