package com.ecommerce.user.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ecommerce.user.UserLevel;

class LevelTest {

	@Test
	void 사용자_분류별_코드호출_테스트() {
		// 고객
		assertThat("-1").contains(UserLevel.CUSTOMER_ONLY.getEmployeeCode());
		
		// 직원
		assertThat("-2").contains(UserLevel.EMPLOYEE_ONLY.getEmployeeCode());
	}

}
