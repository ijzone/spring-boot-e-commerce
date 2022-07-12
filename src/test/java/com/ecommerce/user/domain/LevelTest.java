package com.ecommerce.user.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ecommerce.user.UserLevel;

class LevelTest {

	@Test
	void 사용자_분류별_코드호출_테스트() {
		//고객
		assertThat("C001").contains(UserLevel.CUSTOMER.getCustomerCode());
		assertThat("C002").contains(UserLevel.CUSTOMER_ONLY.getCustomerCode());
		assertThat("5").contains(UserLevel.FIVE.getCustomerLabel());
		
		//직원
		assertThat("E001").contains(UserLevel.EMPLOYEE.getEmployeeCode());
		assertThat("E002").contains(UserLevel.EMPLOYEE_ONLY.getEmployeeCode());
		assertThat("5").contains(UserLevel.FIVE.getEmployeeLabel());
		
		//Exception
		assertThatThrownBy(() -> UserLevel.CUSTOMER_ONLY.getEmployeeCode())
				.isInstanceOf(IllegalArgumentException.class);
		
		assertThatThrownBy(() -> UserLevel.EMPLOYEE_ONLY.getCustomerCode())
				.isInstanceOf(IllegalArgumentException.class);
	}

}
