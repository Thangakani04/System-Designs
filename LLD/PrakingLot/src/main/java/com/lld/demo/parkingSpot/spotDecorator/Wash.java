package com.lld.demo.parkingSpot.spotDecorator;

import com.lld.demo.parkingSpot.ParkingSpot;

public class Wash extends SpotDecorator {

	public Wash(ParkingSpot parkingSpot) {
		super(parkingSpot);
	}

	@Override
	public int cost(int parkinghours) {
		return parkingSpot.cost(parkinghours) + 20;
	}

}
