package com.lld.demo.services;

import com.lld.demo.interfaces.PaymentService;
import com.lld.demo.paymentMethods.Cash;
import com.lld.demo.paymentMethods.CreditCard;
import com.lld.demo.paymentMethods.PaymentMethod;

public class PaymentServiceImpl implements PaymentService {

	@Override
	public void accepCash(int amount) {
		PaymentMethod cash = new Cash();
		cash.initiatePayment(amount);
		
	}

	@Override
	public void acceptCreditCrad(String cardNum, int cvv, int amount) {
		PaymentMethod card = new CreditCard(cardNum, cvv);
		card.initiatePayment(amount);
		
	}

}
