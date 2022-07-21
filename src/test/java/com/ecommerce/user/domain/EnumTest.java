package com.ecommerce.user.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ecommerce.product.ProductType;
import com.ecommerce.user.UserLevel;

class EnumTest {

	@Test
	@DisplayName("사용자 분류 별 코드 호출 테스트")
	void userLevelTest() {
		//고객
		assertThat("C001").contains(UserLevel.CUSTOMER.getCustomerCode());
		assertThat("C002").contains(UserLevel.CUSTOMER_ONLY.getCustomerCode());
		assertThat("5").contains(UserLevel.FIVE.getCustomerLabel());
		
		//직원
		assertThat("E001").contains(UserLevel.ADMIN.getAdminCode());
		assertThat("E002").contains(UserLevel.ADMIN_ONLY.getAdminCode());
		assertThat("5").contains(UserLevel.FIVE.getAdminLabel());
		
		//Exception
		assertThatThrownBy(() -> UserLevel.CUSTOMER_ONLY.getAdminCode())
				.isInstanceOf(IllegalArgumentException.class);
		
		assertThatThrownBy(() -> UserLevel.ADMIN_ONLY.getCustomerCode())
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("상품 카테고리 별 코드 호출 테스트")
	void productTypeTest() {
		//get product label
		assertThat("electronics").isEqualTo(ProductType.ELECTRONICS.getElectronicsLabel());
		assertThat("P001").isEqualTo(ProductType.ELECTRONICS.getElectronicsCode());
		
		assertThat("food").isEqualTo(ProductType.FOOD.getFoodLabel());
		assertThat("P002").isEqualTo(ProductType.FOOD.getFoodCode());
		
		assertThat("accessories").isEqualTo(ProductType.ACCESSORIES.getAccessoriesLabel());
		assertThat("P003").isEqualTo(ProductType.ACCESSORIES.getAccessoriesCode());
		
		assertThat("fashion").isEqualTo(ProductType.FASHION.getFashionLabel());
		assertThat("P004").isEqualTo(ProductType.FASHION.getFashionCode());
		
		assertThat("software").isEqualTo(ProductType.SOFTWARE.getSoftwareLabel());
		assertThat("P005").isEqualTo(ProductType.SOFTWARE.getSoftwareCode());
		
		assertThat("sports").isEqualTo(ProductType.SPORTS.getSportsLabel());
		assertThat("P006").isEqualTo(ProductType.SPORTS.getSportsCode());
		
		//Exception
		assertThatThrownBy(() -> ProductType.ACCESSORIES.getElectronicsCode())
				.isInstanceOf(IllegalArgumentException.class);
	}
}
