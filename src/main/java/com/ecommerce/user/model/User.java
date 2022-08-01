package com.ecommerce.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class User {

	@Setter
	private Long id;
	
	private String firstName;
	private String lastName;
	private Integer age;
	private Character gender;
	private String cellphone;
	private String tel;
	private String email;
	private String street;
	private String city;
	private String zip;
	private String password;
	@Setter
	private User.Level level;
	
	private boolean active;
	private boolean edit;
	
	public User(String firstName, 
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
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.cellphone = cellphone;
		this.tel = tel;
		this.email = email;
		this.street = street;
		this.city = city;
		this.zip = zip;
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

	
	/**
	 * 사용자 별(고객, 직원) 코드값 목록
	 * @param label for view
	 * @param code for user type classification
	 * @param description
	 * @param candidate for validation
	 */
	@Getter
	public enum Level {
		
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
		
//		public static EnumSet<Level> customer = EnumSet.of(CUSTOMER_A, CUSTOMER_B);
//		public static EnumSet<Level> employee = EnumSet.of(EMPLOYEE_A, EMPLOYEE_B);
		
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
}
