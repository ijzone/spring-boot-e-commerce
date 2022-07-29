package com.ecommerce.user.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.model.Product.Status;
import com.ecommerce.user.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class EnumTest {

	@Test
	@DisplayName("사용자 분류 별 코드 호출 테스트")
	void userLevelTest() {
		//고객
		assertThat("C001").contains(User.Level.CUSTOMER.getCustomerCode());
		assertThat("C002").contains(User.Level.CUSTOMER_ONLY.getCustomerCode());
		assertThat("5").contains(User.Level.FIVE.getCustomerLabel());
		
		//직원
		assertThat("E001").contains(User.Level.ADMIN.getAdminCode());
		assertThat("E002").contains(User.Level.ADMIN_ONLY.getAdminCode());
		assertThat("5").contains(User.Level.FIVE.getAdminLabel());
		
		//Exception
		assertThatThrownBy(() -> User.Level.CUSTOMER_ONLY.getAdminCode())
				.isInstanceOf(IllegalArgumentException.class);
		
		assertThatThrownBy(() -> User.Level.ADMIN_ONLY.getCustomerCode())
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("상품 카테고리 별 코드 호출 테스트")
	void productTypeTest() {
		//get product label
		assertThat("electronics").isEqualTo(Product.Category.ELECTRONICS.getElectronicsLabel());
		assertThat("P001").isEqualTo(Product.Category.ELECTRONICS.getElectronicsCode());
		
		assertThat("food").isEqualTo(Product.Category.FOOD.getFoodLabel());
		assertThat("P002").isEqualTo(Product.Category.FOOD.getFoodCode());
		
		assertThat("accessories").isEqualTo(Product.Category.ACCESSORIES.getAccessoriesLabel());
		assertThat("P003").isEqualTo(Product.Category.ACCESSORIES.getAccessoriesCode());
		
		assertThat("fashion").isEqualTo(Product.Category.FASHION.getFashionLabel());
		assertThat("P004").isEqualTo(Product.Category.FASHION.getFashionCode());
		
		assertThat("software").isEqualTo(Product.Category.SOFTWARE.getSoftwareLabel());
		assertThat("P005").isEqualTo(Product.Category.SOFTWARE.getSoftwareCode());
		
		assertThat("sports").isEqualTo(Product.Category.SPORTS.getSportsLabel());
		assertThat("P006").isEqualTo(Product.Category.SPORTS.getSportsCode());
		
		//Exception
		assertThatThrownBy(() -> Product.Category.ACCESSORIES.getElectronicsCode())
				.isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	void productStatusTest() {
//		log.info(Product.Status.CANCELED.getKey());
//		log.info(Product.Status.CANCELED.getValue());
		
		Status[] values = Product.Status.values();
		for (Status status : values) {
			log.info("Product.Status List: {}", status.getValue());
		}
	}
}
