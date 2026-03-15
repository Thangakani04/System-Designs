package com.lld.demo.dto.accounts;

import com.lld.demo.dto.ParkingLot;

public class Admin extends Account {
	
	//if we initialize here then its called hot start
	private ParkingLot parkingLot= ParkingLot.getInstance();

	public Admin(String name, String email, String password) {
		super(name, email, password);
	}

}
