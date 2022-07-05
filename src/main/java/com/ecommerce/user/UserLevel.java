package com.ecommerce.user;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 사용자 별(고객, 직원) 코드값 목록
 * @author Ikjoo Lee
 * @param label for view
 * @param code for user type classification
 * @param description
 * @param candidate for validation
 */
@Slf4j
@Getter
public enum UserLevel {
	
	  CUSTOMER("customer", "001", "customer", "customer")
	, EMPLOYEE("employee", "002", "employee", "employee")
	, ONE("1", "01", "one", "customer, employee")
	, TWO("2", "02", "two", "customer, employee")
	, THREE("3", "03", "customer", "three")
	, FOUR("4", "04", "four", "customer, employee")
	, FIVE("5", "05", "five", "customer, employee")
	, CUSTOMER_ONLY("-1", "-1", "customer", "CUSTOMER_ONLY")
	, EMPLOYEE_ONLY("-2", "-2", "employee", "EMPLOYEE_ONLY")
	;
	
//	public static EnumSet<Level> customer = EnumSet.of(CUSTOMER_A, CUSTOMER_B);
//	public static EnumSet<Level> employee = EnumSet.of(EMPLOYEE_A, EMPLOYEE_B);
	
	private String label;
	private String code;
	private String candidate;
	private String description;
	
	UserLevel(String label, String code, String candidate, String description) {
		this.label = label;
		this.code = code;
		this.candidate = candidate;
		this.description = description;
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
	
	private void isApplicable(String target) {
		if(!this.candidate.trim().toLowerCase().contains(target)) {
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
