package com.ecommerce.user.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.ecommerce.user.customer.model.Customer;
import com.ecommerce.user.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserTest {
	
	@Test
	void updateUserInfo() {
		// given
		Customer customer = new Customer("ij", "Lee", 23, 'M', null, null, null, null, null, null, null, User.Level.THREE, true, false);
		
		// when
		customer.setLevel(User.Level.FOUR);
		// then
		assertThat(customer.getLevel()).isEqualTo(User.Level.FOUR);
		
		// when
		customer.setActiveFalse();
		// then
		assertThat(customer.isActive()).isFalse();
	}
}
