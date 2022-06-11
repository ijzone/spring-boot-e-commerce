package com.ecommerce.user.domain;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public enum Level {
	  CUSTOMER("customer", "001", "customer", "customer")
	, EMPLOYEE("employee", "002", "employee", "employee")
	, ONE("1", "01", "one", "customer, employee")
	, TWO("2", "02", "two", "customer, employee")
	, THREE("3", "03", "three", "customer")
	, FOUR("4", "04", "four", "customer, employee")
	, FIVE("5", "05", "five", "customer, employee")
	, CUSTOMER_ONLY("-1", "-1", "CUSTOMER_ONLY", "customer")
	, EMPLOYEE_ONLY("-2", "-2", "EMPLOYEE_ONLY", "employee")
	;
	
//	public static EnumSet<Level> customer = EnumSet.of(CUSTOMER_A, CUSTOMER_B);
//	public static EnumSet<Level> employee = EnumSet.of(EMPLOYEE_A, EMPLOYEE_B);
	
	private String label;
	private String code;
	private String description;
	private String candidate;
	
	Level(String label, String code, String description, String candidate) {
		this.label = label;
		this.code = code;
		this.description = description;
		this.candidate = candidate;
	}
	
	
	public String getCustomerLabel() {
		this.isApplicable(CUSTOMER.getLabel());
		return this.label;
	}
	
	public String getCustomerCode() {
		this.isApplicable(CUSTOMER.getLabel());
		return this.code;
	}
	
	public String getEmployeeLabel() {
		this.isApplicable(EMPLOYEE.getLabel());
		return this.label;
	}
	
	public String getEmployeeCode() {
		this.isApplicable(EMPLOYEE.getLabel());
		return this.code;
	}
	
	private boolean isApplicable(String target) {
		if(this.candidate.trim().toLowerCase().contains(target)) {
			return true;
		}else {
			throw new IllegalArgumentException("해당코드는" + target + "에 적용할 수 없는 코드 입니다.");
		}
	}
	
	public void printInfo() {
		log.info("label: {}", this.label);
		log.info("code: {}", this.code);
		log.info("description: {}", this.description);
		log.info("candidate: {}", this.candidate);
	}
}
