package com.ecommerce.shipment.model;

import com.ecommerce.discount.model.Discount;

import lombok.Getter;

@Getter
public class Shipment {

	private Long shipmentId;
	private Long orderId;
	private Long shipperId;
	private Long shippingAmount;
	private Long shippingDiscount;
	private Discount.Type discountType;
	private String currency;
	private String street1;
	private String street2;
	private String city;
	private String province;
	private String country;
	private String postalCode;
	private String postalCodeType;
}
