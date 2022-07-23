package com.ecommerce.order.model;

import java.time.ZonedDateTime;

import lombok.Getter;

@Getter
public class Order {

	private Long orderNumber;
	private Long customerId;
	private String customerName;
	private String street;
	private String city;
	private String state;
	private String zip;
	private ZonedDateTime orderDate;
	private ZonedDateTime shipDate;
	
}
