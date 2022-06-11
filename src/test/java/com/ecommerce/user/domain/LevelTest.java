package com.ecommerce.user.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LevelTest {

	@Test
	void 사용자_분류별_코드호출_테스트() {
		// 고객
		assertThat("-1").contains(Level.CUSTOMER_ONLY.getEmployeeCode());
		
		// 직원
		assertThat("-2").contains(Level.EMPLOYEE_ONLY.getEmployeeCode());
	}

}
