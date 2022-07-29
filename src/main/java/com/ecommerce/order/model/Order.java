package com.ecommerce.order.model;

import java.time.ZonedDateTime;

import com.ecommerce.discount.model.Discount;

import lombok.Getter;

@Getter
public class Order {

	private Long orderId;
	private Long customerId;
	private Order.Status status;
	private Long orderAmount;
	private String currency;
	private Long taxAmount;
	private Long unitPrice;
	private Long shippingAmount;
	private Discount.Type discountType;
	private Long orderDiscount;
	private Long shippingDiscount;
	private Long subtotal;
	private Long total;
	private ZonedDateTime orderDate;
	private ZonedDateTime shipDate;
	
	public enum Status {
		ORDERED("ordered"), 
		PENDING("pending"), 
		PAID("paid"), 
		SHIPPING("shipping"), 
		SHIPPED("shipped"), 
		CANCELED("canceled"), 
		COMPLETE("complete")
		;
		
		private String value;
		
		Status(String value) {
			this.value = value;
		}
		
		public String getKey() {
			return name();
		}
		
		public String getValue() {
			return this.value;
		}

		@Override
		public String toString() {
			return ORDERED.getValue();
		}
		
	}
}
