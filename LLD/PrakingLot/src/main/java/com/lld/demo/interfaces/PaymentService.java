package com.lld.demo.interfaces;

public interface PaymentService {
	
	// this will have methods to accept different kind of payments
	
	void accepCash(int amount);
	void acceptCreditCrad(String cardNum, int cvv, int amount);

}
