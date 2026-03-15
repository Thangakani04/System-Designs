package com.lld.demo.paymentMethods;

public class Cash extends PaymentMethod {

	@Override
	public boolean initiatePayment(int amount) {

		System.out.println("Making payment with cash of Rs : " + amount);
		return true;
	}

}
