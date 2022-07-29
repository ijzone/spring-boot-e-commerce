package com.ecommerce.discount.model;

public class Discount {

	public enum Type {
		RATE("rate"), PRICE("price");
		
		private String value;
		
		Type(String value) {
			this.value = value;
		}
		
		public String getKey() {
			return name();
		}
		
		public String getValue() {
			return this.value;
		}
	}
}
