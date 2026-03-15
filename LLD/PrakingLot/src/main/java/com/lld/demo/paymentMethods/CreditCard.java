package com.lld.demo.paymentMethods;

public class CreditCard extends PaymentMethod {
	
	private String cardNum;
	private int cvv;

	@Override
	public boolean initiatePayment(int amount) {
		
		return false;
	}

	//constructor
	public CreditCard(String cardNum, int cvv) {
		this.cardNum = cardNum;
		this.cvv = cvv;
	}
	
	
	

}
