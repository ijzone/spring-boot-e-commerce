package com.ecommerce.payment.model;

import java.time.ZonedDateTime;

import lombok.Getter;

@Getter
public class Payment {

	private Long paymentId;
	private Long orderId;
	private Long supplierId;
	private Long customerId;
	private Payment.Status status;
	private Payment.Method paymentMethod;
	private Long amount;
	private ZonedDateTime paymentDate;
	
	public enum Status {
		NOT_PAID, PENDING, PAID;
	}
	
	public enum Method {
		CASH, TRANSFER, WIRED, VIRTUAL_ACCOUNT, MOBILE;
	}
}
