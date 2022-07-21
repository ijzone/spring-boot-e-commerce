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
	
	  CUSTOMER("customer", "C001", "customer", "customer")
	, CUSTOMER_ONLY("customer only", "C002", "CUSTOMER_ONLY", "customer")
	, ADMIN("admin", "E001", "admin", "admin")
	, ADMIN_ONLY("admin only", "E002", "ADMIN_ONLY", "admin")
	, ONE("1", "001", "one", "customer, admin")
	, TWO("2", "002", "two", "customer, admin")
	, THREE("3", "003", "three", "customer, admin")
	, FOUR("4", "004", "four", "customer, admin")
	, FIVE("5", "005", "five", "customer, admin")
	;
	
//	public static EnumSet<Level> customer = EnumSet.of(CUSTOMER_A, CUSTOMER_B);
//	public static EnumSet<Level> employee = EnumSet.of(EMPLOYEE_A, EMPLOYEE_B);
	
	private String label;
	private String code;
	private String description;
	private String candidate;
	
	UserLevel(String label, String code, String description, String candidate) {
		this.label = label;
		this.code = code;
		this.description = description;
		this.candidate = candidate;
	}
	
	
	public String getCustomerLabel() {
		this.isApplicable(CUSTOMER.getCandidate());
		return this.label;
	}
	
	public String getCustomerCode() {
		this.isApplicable(CUSTOMER.getCandidate());
		return this.code;
	}
	
	public String getAdminLabel() {
		this.isApplicable(ADMIN.getCandidate());
		return this.label;
	}
	
	public String getAdminCode() {
		this.isApplicable(ADMIN.getCandidate());
		return this.code;
	}
	
	private void isApplicable(String target) {
		if(!this.candidate.trim().toLowerCase().contains(target)) {
			throw new IllegalArgumentException("해당코드는" + target + "에 적용할 수 없는 코드 입니다.");
		}
	}
	
	public void printInfo() {
		log.info("UserLevel label: {}", this.label);
		log.info("UserLevel code: {}", this.code);
		log.info("UserLevel description: {}", this.description);
		log.info("UserLevel candidate: {}", this.candidate);
	}
}
